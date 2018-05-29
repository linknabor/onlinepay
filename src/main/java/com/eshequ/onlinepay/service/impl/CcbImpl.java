package com.eshequ.onlinepay.service.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.eshequ.onlinepay.constant.Constants;
import com.eshequ.onlinepay.exception.BusinessException;
import com.eshequ.onlinepay.service.OnlinepayChannel;
import com.eshequ.onlinepay.service.vo.CcbWechatPayResponse;
import com.eshequ.onlinepay.util.HttpUtil;
import com.eshequ.onlinepay.util.MD5Util;
import com.eshequ.onlinepay.web.vo.JsApi;
import com.eshequ.onlinepay.web.vo.MchInfo;
import com.eshequ.onlinepay.web.vo.Order;
import com.eshequ.onlinepay.web.vo.PayResponse;
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
		String resposne = httpUtil.doPost(requestUrl, requestMap, CCB_DEFAULT_CHARSET);
		logger.info("response is : " + resposne);
		PayResponse payResponse = formatResponse(resposne);
		return payResponse;

	}

	/**
	 * @param order
	 * @return
	 */
	private Map<String, String> createOrderRequest(Order order) {
		
		MchInfo mchInfo = order.getMchInfo();
		String mch_id = mchInfo.getMch_id();
		String key = mchInfo.getSecret();
		
		String branchId = "442000000";	//由建行统一分配	//TODO
		String posId = "100000415";	//由建行统一分配	//TODO
		String orderId = order.getTransactionId();	//15位商户ID + 15位自定义,对应paymentOrder中的transactionId，因为这里要求15位，而paymentOrder中的orderId是18位的，这里用不了。
		String total_fee = order.getTotalFee();
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
        map.put("REMARK1", "");
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
	public PayResponse formatResponse(String respJson){
		
		CcbWechatPayResponse ccbWechatPayResponse = new CcbWechatPayResponse();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			ccbWechatPayResponse = objectMapper.readValue(respJson, CcbWechatPayResponse.class);
		} catch (Exception e) {
			ccbWechatPayResponse.setSuccess(String.valueOf(false));
			logger.info(e.toString());
		}
		
		PayResponse payResponse = new PayResponse();
		String isSuccess = ccbWechatPayResponse.getSuccess();
		if (String.valueOf(true).equals(isSuccess)) {	//SUCCESS 为true时，表成功
			payResponse.setReturn_code(Constants.WECHAT_SUCCESS);
			payResponse.setResult_code(Constants.WECHAT_SUCCESS);
			JsApi jsApi = new JsApi();
			jsApi.setPay_url(ccbWechatPayResponse.getPayurl());
			payResponse.setJsApi(jsApi);
			
		}else {
			payResponse.setReturn_code(Constants.WECHAT_FAIL);
			payResponse.setReturn_msg("获取prepay_id失败。");
		}

		return payResponse;
	}
	

	/**
	 * 创建ccb签名
	 * @param map
	 * @param secret
	 * @return
	 */
	public String createSign(Map<String, String> map, String secret, String charset){
		
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
	
	public static void main(String[] args) {
		
//		Map<String, String>map = new LinkedHashMap<String, String>();
//		map.put("first", "1");
//		map.put("third", "3");
//		map.put("second", "2");
//		System.out.println(map.toString());
//		String sign = createSign(map, "2222", "UTF-8");
//		System.out.println(sign);
		
		String str = "MERCHANTID=105584073990033&BRANCHID=442000000&POSID=100000415&ORDERID=105584073990033180529115415930&PAYMENT=0.01&CURCODE=01&TXCODE=530550&REMARK1=测试物业缴费&RETURNTYPE=3&PUB=bd0f9a0658b5640c37378787020111";
		String sign = MD5Util.MD5Encode(str, "utf-8");
		System.out.println(sign);
		
	}
	

}
