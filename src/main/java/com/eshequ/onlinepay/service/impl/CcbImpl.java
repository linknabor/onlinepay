package com.eshequ.onlinepay.service.impl;

import java.lang.reflect.Type;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.eshequ.onlinepay.service.OnlinepayChannel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

@Service
public class CcbImpl extends OnlinepayChannel {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Override
	public void wechatpay(Map<String, Object> order) {
		
		Object obj  = order.get("mchInfo");
		Gson gson = new Gson();
		
		
//		Map<String, String> requestMap = createOrderRequest(order);
//		
//		String requestUrl = "https://ibsbjstar.ccb.com.cn/CCBIS/ccbMain";	//TODO	Get from db;
//		String resposne = HttpUtil.doPost(requestUrl, map, CcbCfg.CCB_DEFAULT_CHARSET);
//		logger.info("response is : " + resposne);
//		
//		Map<String, Object> retMap = new HashMap<String, Object>();
//		
//		Map<String, String> responseMap = CcbUtil.formatResp2WechatResp(resposne);
//		String return_code = responseMap.get("return_code");
//		String result_code = responseMap.get("result_code");
//		
//		/*status与result_code都为SUCCESS的情况下，返回预付ID，等 以下字段 */
//		if (WechatConfig.SUCCESS.equals(return_code)&&
//				WechatConfig.SUCCESS.equals(result_code)){
//			
//			//下面这个MAP是返回给手机端的，将会转成JSON
//			Map<String,String>jsApiMap = new HashMap<String, String>();
//			jsApiMap.put("trade_water_id", order.getOrderId());
//			jsApiMap.put("pay_url", responseMap.get("pay_url"));
//			retMap.put("jsApiMap", jsApiMap);
//			logger.info("jsApiMap : " + jsApiMap);
//			
//		}
		
//		return retMap;

	}

	@Override
	public void micropay(Map<String, Object> map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void query(Map<String, Object> map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void refund(Map<String, Object> map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void refundQuery(Map<String, Object> map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reverse(Map<String, Object> map) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * @param order
	 * @return
	 */
	private static Map<String, String> createOrderRequest(Map<String, Object> order) {
		
//		MchInfo mchInfo = order.getMchInfo();
//		String mch_id = mchInfo.getMch_id();
//		String key = mchInfo.getSecret();
//		
//		String branchId = "442000000";	//由建行统一分配	//TODO
//		String posId = "100000415";	//由建行统一分配	//TODO
//		String orderId = order.getTransactionId();	//15位商户ID + 15位自定义,对应paymentOrder中的transactionId，因为这里要求15位，而paymentOrder中的orderId是18位的，这里用不了。
//		String total_fee = order.getTotalFee();
//		if (ObjectUtil.isEmpty(total_fee)) {
//			throw new BusinessException("交易金额不能为空。");
//		}
//		
//        String curcode = "01";	//币种，人民币
//        String txcode = "530550";	//建行统一分配
//				
//		Map<String, String>map = new LinkedHashMap<String, String>();
//		map.put("CCB_IBSVersion", "V6");	//必输项
//        map.put("MERCHANTID", mch_id);
//        map.put("BRANCHID", branchId);
//        map.put("POSID", posId);
//        map.put("ORDERID", orderId);
//        map.put("PAYMENT", total_fee);
//        map.put("CURCODE", curcode);	//
//        map.put("TXCODE", txcode);
//        map.put("REMARK1", order.getBody());
//        /*
//         * 0或空：返回页面二维码
//         *	1：返回JSON格式【二维码信息串】
//         *	2：返回聚合扫码页面二维码
//         *	3：返回聚合扫码JSON格式【二维码信息串】
//         */
//        map.put("RETURNTYPE", "3");	
//        
//        String sign = CcbSignUtil.createSign(map, key);
//        map.put("MAC", sign);
//		map.remove("PUB");
//		logger.info("UnifiedUrl created... params :" + map.toString());
//		return map;
		return null;
	}
	

}
