package com.eshequ.onlinepay.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.eshequ.onlinepay.constant.Constants;
import com.eshequ.onlinepay.exception.AppSysException;
import com.eshequ.onlinepay.exception.BusinessException;
import com.eshequ.onlinepay.service.OnlinepayChannel;
import com.eshequ.onlinepay.util.HttpUtil;
import com.eshequ.onlinepay.util.MD5Util;
import com.eshequ.onlinepay.web.dto.PayResponse;
import com.eshequ.onlinepay.web.vo.MchInfo;
import com.eshequ.onlinepay.web.vo.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CcbImpl extends OnlinepayChannel {
	
	private static Logger logger = LoggerFactory.getLogger(OnlinepayChannel.class);
	
	private static final String CCB_DEFAULT_CHARSET = "UTF-8";
	
	@Autowired
	private HttpUtil httpUtil;
	

	@Override
	public PayResponse wechatpay(Order order) {
		
		Map<String, String> requestMap = createOrderRequest(order);
		String requestUrl = "https://ibsbjstar.ccb.com.cn/CCBIS/ccbMain";	//TODO	Get from db;
		
		ObjectMapper mapper = new ObjectMapper();
		String requestStr = "";
		try {
			requestStr = mapper.writeValueAsString(requestMap);
		} catch (JsonProcessingException e) {
			throw new AppSysException(e);
		}
		
		String resposne = httpUtil.doPost(requestUrl, requestStr, CCB_DEFAULT_CHARSET);
		logger.info("response is : " + resposne);
		
		Map<String, Object> retMap = new HashMap<String, Object>();
		
		Map<String, String> responseMap = formatResp2WechatResp(resposne);
		String return_code = responseMap.get("return_code");
		String result_code = responseMap.get("result_code");
		
		/*status与result_code都为SUCCESS的情况下，返回预付ID，等 以下字段 */
		if (Constants.CCB_WECHAT_SUCCESS.equals(return_code)&&
				Constants.CCB_WECHAT_SUCCESS.equals(result_code)){
			
			//下面这个MAP是返回给手机端的，将会转成JSON
			Map<String,String>jsApiMap = new HashMap<String, String>();
			jsApiMap.put("trade_water_id", order.getOrderId());
			jsApiMap.put("pay_url", responseMap.get("pay_url"));
			retMap.put("jsApiMap", jsApiMap);
			logger.info("jsApiMap : " + jsApiMap);
			
		}
		
		return null;

	}

	/**
	 * @param order
	 * @return
	 */
	private static Map<String, String> createOrderRequest(Order order) {
		
		MchInfo mchInfo = order.getMchInfo();
		String mch_id = mchInfo.getMch_id();
		String key = mchInfo.getSecret();
		
		String branchId = "442000000";	//由建行统一分配	//TODO
		String posId = "100000415";	//由建行统一分配	//TODO
		String orderId = (String) order.getTransactionId();	//15位商户ID + 15位自定义,对应paymentOrder中的transactionId，因为这里要求15位，而paymentOrder中的orderId是18位的，这里用不了。
		String total_fee = (String) order.getTotalFee();
		if (StringUtils.isEmpty(total_fee)) {
			throw new BusinessException("交易金额不能为空。");
		}
		
        String curcode = "01";	//币种，人民币
        String txcode = "530550";	//建行统一分配
				
		Map<String, String>map = new LinkedHashMap<String, String>();
		map.put("CCB_IBSVersion", "V6");	//必输项
        map.put("MERCHANTID", mch_id);
        map.put("BRANCHID", branchId);
        map.put("POSID", posId);
        map.put("ORDERID", orderId);
        map.put("PAYMENT", total_fee);
        map.put("CURCODE", curcode);	//
        map.put("TXCODE", txcode);
        map.put("REMARK1", order.getBody());
        /*
         * 0或空：返回页面二维码
         *	1：返回JSON格式【二维码信息串】
         *	2：返回聚合扫码页面二维码
         *	3：返回聚合扫码JSON格式【二维码信息串】
         */
        map.put("RETURNTYPE", "3");	
        
        String sign = createSign(map, key, "");
        map.put("MAC", sign);
		map.remove("PUB");
		logger.info("UnifiedUrl created... params :" + map.toString());
		return map;
	
	}
	
	/**
	 * 格式化为微信格式
	 * @param json
	 * @return
	 */
	public static Map<String, String> formatResp2WechatResp(String respJson){
		
//		JSONObject json = null;
//		String return_code = "";
//		String result_code = "";
//		String return_msg = "";
//		String err_code = "";
//		String err_code_des = "";
//		
//		try {
//			json = JSONObject.fromObject(respJson);
//		} catch (Exception e) {
//			return_code = WechatConfig.FAIL;
//			return_msg = "您输入的交易要素不完整，请重新输入。";
//		}
//		
//		Map <String, String>retMap = new HashMap<String, String>();
//		String isSuccess = (String)json.get("SUCCESS");
//		if (String.valueOf(true).equals(isSuccess)) {	//SUCCESS 为true时，表成功
//			return_code = WechatConfig.SUCCESS;
//			result_code = WechatConfig.SUCCESS;
//			retMap.put("pay_url", (String) json.get("PAYURL"));
//		}else {
//			return_code = WechatConfig.FAIL;
//		}
//		retMap.put("err_code", err_code);
//		retMap.put("err_code_des", err_code_des);
//		retMap.put("return_code", return_code);
//		retMap.put("return_msg", return_msg);
//		retMap.put("result_code", result_code);
//		return retMap;
		return null;
	}
	

	/**
	 * 创建ccb签名
	 * @param map
	 * @param secret
	 * @return
	 */
	public static String createSign(Map<String, String> map, String secret, String charset){
		
		if (StringUtils.isEmpty(charset)) {
			charset = CCB_DEFAULT_CHARSET;
		}
		
		Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
		
		StringBuffer bf = new StringBuffer();
		while (it.hasNext()) {
		
			Map.Entry<String, String> entry = it.next();
			String key = entry.getKey();
			String value = entry.getValue();
			if (!"CCB_IBSVersion".equals(key)) {
				bf.append(key).append("=").append(value).append("&");
			}
		}
		bf.append("PUB=").append(secret);
		MD5Util.MD5Encode(bf.toString(), charset).toUpperCase();
		return MD5Util.MD5Encode(bf.toString(), charset).toUpperCase();
		
	}

	@Override
	public PayResponse micropay(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void query(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refund(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void refundQuery(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reverse(Order order) {
		// TODO Auto-generated method stub
		
	}
	
	

}
