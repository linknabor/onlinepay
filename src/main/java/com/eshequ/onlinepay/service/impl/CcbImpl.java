package com.eshequ.onlinepay.service.impl;

import static org.junit.Assert.assertFalse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.eshequ.onlinepay.constant.CcbConstants;
import com.eshequ.onlinepay.constant.CcbConstants.RespCode;
import com.eshequ.onlinepay.constant.Constants;
import com.eshequ.onlinepay.exception.AppSysException;
import com.eshequ.onlinepay.exception.BusinessException;
import com.eshequ.onlinepay.http.HttpClientProxy;
import com.eshequ.onlinepay.http.HttpConfig;
import com.eshequ.onlinepay.service.OnlinepayChannel;
import com.eshequ.onlinepay.service.vo.ccb.CcbPayQueryResponse;
import com.eshequ.onlinepay.service.vo.ccb.CcbReqBody;
import com.eshequ.onlinepay.service.vo.ccb.CcbRequest;
import com.eshequ.onlinepay.service.vo.ccb.CcbRespBody;
import com.eshequ.onlinepay.service.vo.ccb.CcbWechatPayResponse;
import com.eshequ.onlinepay.service.vo.ccb.QueryReq;
import com.eshequ.onlinepay.service.vo.ccb.QueryResp;
import com.eshequ.onlinepay.service.vo.ccb.QueryRespDetail;
import com.eshequ.onlinepay.util.DateUtil;
import com.eshequ.onlinepay.util.MD5Util;
import com.eshequ.onlinepay.web.vo.JsApi;
import com.eshequ.onlinepay.web.vo.MchInfo;
import com.eshequ.onlinepay.web.vo.Order;
import com.eshequ.onlinepay.web.vo.PayResponse;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Service
public class CcbImpl extends OnlinepayChannel {
	
	private static Logger logger = LoggerFactory.getLogger(OnlinepayChannel.class);
	
	@Autowired
	private HttpClientProxy httpClientProxy;
	
	@Override
	public PayResponse wechatpay(Order order) {
		
		Map<String, String> requestMap = createOrderRequest(order);
		logger.info("wechatpay order : " + order.toString());
		String requestUrl = "https://ibsbjstar.ccb.com.cn/CCBIS/ccbMain";	//TODO	Get from db;
		String resposne = httpClientProxy.doPost(requestUrl, requestMap, CcbConstants.DEFAULT_CHARSET);
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
		String orderId = mch_id + order.getOrderId().substring(0, 15); 
//				order.getTransactionId();	//15位商户ID + 15位自定义,对应paymentOrder中的transactionId，因为这里要求15位，而paymentOrder中的orderId是18位的，这里用不了。
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
	private String createSign(Map<String, String> map, String secret, String charset){
		
		if (StringUtils.isEmpty(charset)) {
			charset = CcbConstants.DEFAULT_CHARSET;
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
		
		String transactionId = order.getTransactionId();	//交易号
		MchInfo mchInfo = order.getMchInfo();	//商户信息
		assertFalse("transactionId不能为空", StringUtils.isEmpty(transactionId));
		assertFalse("商户信息不能为空", mchInfo == null);
		logger.info("mchInfo is : " + mchInfo.toString());
		
		String requestXml = createQueryRequest(transactionId, mchInfo);
		Map<String, String> requestMap = new HashMap<String, String>();
		requestMap.put("requestXml", requestXml);
		String requestUrl = "http://localhost:12345/";	//TODO
		HttpConfig httpConfig = new HttpConfig(CcbConstants.DEFAULT_CHARSET, CcbConstants.XML_ENCODING);
		String response = httpClientProxy.doPost(requestUrl, requestMap, httpConfig);
		System.out.println(response);
		CcbPayQueryResponse ccbPayQueryResponse = formatQueryResponse(response);
		
	}

	/**
	 * 创建查询请求，XML格式
	 * @param transactionId
	 * @param mchInfo
	 * @return
	 */
	private String createQueryRequest(String transactionId, MchInfo mchInfo) {
		
		CcbReqBody<QueryReq> reqBody = initializeReqBodyCommon(CcbConstants.TX_CODE_FUND_QUERY, mchInfo);
		QueryReq reqDetail = new QueryReq();
		reqDetail.setKind("0");	//0:未结流水,1:已结流水
		reqDetail.setOrder(transactionId);	//不是orderId,不要弄错
		reqDetail.setDexcel("1");	//默认为“1”，1:不压缩,2.压缩成zip文件
		reqDetail.setNorderby("2");	//1:交易日期,2:订单号
		reqDetail.setStatus("3");	//0:交易失败,1:交易成功,2:待银行确认(针对未结流水查询);3:全部
		reqBody.setTx_info(reqDetail);
		
		/*请求的bean转xml */
		CcbRequest<QueryReq> request = new CcbRequest<QueryReq>(reqBody);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);//空字段不序列化
		String requestXml = "";
		try {
			String requestJsonStr = mapper.writeValueAsString(request);
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode root = objectMapper.readTree(requestJsonStr);
			XmlMapper xmlMapper = new XmlMapper();
			xmlMapper.setSerializationInclusion(Include.NON_NULL);
			requestXml = xmlMapper.writer().withoutRootName().writeValueAsString(root);
			requestXml = requestXml.replace("<>", "").replace("</>", "");	//去除empty root
			requestXml = CcbConstants.REQ_XML_HEAD.concat(requestXml);
			logger.info("request xml is : " + requestXml);
			
		} catch (Exception e) {
			throw new AppSysException(e);
		}
		return requestXml;
		
	}
	
	private CcbPayQueryResponse formatQueryResponse(String responseStr) {
		
		assertFalse("返回结果为空。", StringUtils.isEmpty(responseStr));
		
		try {
			XmlMapper xmlMapper = new XmlMapper();
			@SuppressWarnings("unchecked")
			CcbRespBody<QueryResp> ccbResp = xmlMapper.readValue(responseStr, CcbRespBody.class);
			String return_code = ccbResp.getReturn_code();	//请求成功或失败
			String return_msg = ccbResp.getReturn_msg();
			
			String result_code = "";
			String err_code = "";
			String err_code_des = "";
			String trade_state = "";
			
			CcbPayQueryResponse ccbPayQueryResponse = new CcbPayQueryResponse();
			if (RespCode.SUCCESS.equals(return_code)) {
				
				QueryResp queryResp = ccbResp.getTx_info();
				List<QueryRespDetail> list = queryResp.getList();
				String transactionId = list.get(0).getOrder();
				String tranAmt = list.get(0).getPayment_money();
				String orderStatus = list.get(0).getOrder_status();	//订单状态
				
				result_code = Constants.WECHAT_SUCCESS;
				
				if (CcbConstants.ORDER_SUCCESS.equals(orderStatus)) {
					trade_state = Constants.WECHAT_SUCCESS;
				}else if (CcbConstants.ORDER_NOT_COMFIRMED.equals(orderStatus)||CcbConstants.ORDER_NOT_COMFIRMED2.equals(orderStatus)) {
					trade_state = Constants.WECHAT_PAYING;
				}else {
					trade_state = Constants.WECHAT_FAIL;
				}
				
				ccbPayQueryResponse.setTrade_state(trade_state);
				ccbPayQueryResponse.setTrade_stat_desc(trade_state);
				ccbPayQueryResponse.setTotal_fee(tranAmt);
				ccbPayQueryResponse.setOther_payId(transactionId);
				ccbPayQueryResponse.setTransaction_id(transactionId);
				ccbPayQueryResponse.setResult_code(result_code);
				ccbPayQueryResponse.setReturn_code(Constants.WECHAT_SUCCESS);
				ccbPayQueryResponse.setReturn_msg(return_msg);
				
			}else {
				
				err_code = return_code;	//错误代码
				err_code_des = return_msg;
				if (StringUtils.isEmpty(err_code_des)) {
					err_code_des = ccbResp.getTx_info().getNotice();
				}
				ccbPayQueryResponse.setResult_code(err_code);
				ccbPayQueryResponse.setReturn_code(err_code);
				ccbPayQueryResponse.setReturn_msg(err_code_des);
			
			}
			return ccbPayQueryResponse;
			
		} catch (Exception e) {
			
			throw new AppSysException(e);
			
		}
		
	}
	
	/**
	 * 组建报文头（各报文通用）
	 * @param mchInfo
	 * @return
	 */
	private <T> CcbReqBody<T> initializeReqBodyCommon(String requestType, MchInfo mchInfo){
		
		CcbReqBody<T> reqBody = new CcbReqBody<T>();
		reqBody.setCust_id(mchInfo.getMch_id());
		reqBody.setLanguage(CcbConstants.DEFAULT_LANGUAGE);
		reqBody.setPassword(CcbConstants.USER_PASSWD);
		reqBody.setRequest_sn(getSnNum());	//16位数字
		reqBody.setTx_code(requestType);
		reqBody.setUser_id(CcbConstants.USER_ID); 
		return reqBody;
	
	}
	
	/**
	 * 获取sn号
	 * @return
	 */
	private String getSnNum() {
	
		String sn = DateUtil.getSysDateTime();
		int r = (int)(Math.random()*90+10);
		return sn.concat(String.valueOf(r));
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
		
		try {
			String jsonStr = "{\"tx\":{\"request_sn\":\"\",\"cust_id\":\"105584073990033\",\"user_id\":\"\",\"password\":\"bd0f9a0658b5640c37378787020111\",\"tx_code\":\"5W1002\",\"language\":\"CN\",\"tx_info\":{\"start\":null,\"starthour\":null,\"startmin\":null,\"end\":null,\"endhour\":null,\"endmin\":null,\"kind\":\"0\",\"order\":\"105584073990033180529164058975\",\"account\":null,\"dexcel\":\"1\",\"money\":null,\"norderby\":\"2\",\"page\":null,\"pos_code\":null,\"status\":\"3\"}}}";
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode root = objectMapper.readTree(jsonStr);
			XmlMapper xmlMapper = new XmlMapper();
			String xml = xmlMapper.writer().withRootName("xml").writeValueAsString(root);
			System.out.println(xml);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	

}
