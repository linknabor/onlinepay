package com.eshequ.onlinepay.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * 建行龙支付参数
 * @author davidhardson
 *
 */
public class CcbConstants {

	public static final String CCB_DEFAULT_CHARSET = "UTF-8";
	public static final String CCB_DEFAULT_LANGUAGE = "CN";
	public static final String CCB_XML_ENCODING = "GB2312";
	public static Map<String, String> respCodeMap;

	public static final String TX_CODE_FUND_QUERY = "5W1002";	//支付流水查询
	public static final String TX_CODE_REFUND_QUERY = "5W1003";	//退款流水查询
	public static final String TX_CODE_REFUND = "5W1004";
	
	public static final String CCB_ORDER_FAILED = "0";	//0:失败,1:成功,2:待银行确认,3:已部分退款,4:已全额退款,5:待银行确认
	public static final String CCB_ORDER_SUCCESS = "1";
	public static final String CCB_ORDER_NOT_COMFIRMED = "2";	
	public static final String CCB_ORDER_PART_REFUNDED = "3";
	public static final String CCB_ORDER_REFUNDED = "4";
	public static final String CCB_ORDER_NOT_COMFIRMED2 = "2";
	
	public static final String REQ_XML_HEAD = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?>";
	
	public class RespCode {
		
		public static final String SUCCESS = "000000";
		public static final String TIMEOUT = "0130Z0100001";		//系统忙，通讯超时。
		public static final String TIMEOUT2 = "0130Z0100002";		//成员行暂时无法处理或通讯错误
		public static final String INCORRECT_PASSWORD = "0130Z0100004";
		public static final String INVALID_USERNAME = "0130Z0100005";
		
		public static final String INCOMPLETE_REQINFO = "0130Z1101001";	//输入的交易要素不完整，请重新输入
		public static final String INVALID_REQINFO = "0130Z1101002";	//交易输入要素的格式或输入范围错误。
		public static final String INVALID_REQINFO2 = "0130Z1101003";	//您输入的信息不符合格式检查。例如，需要的输入数字的要素被输入了字符或输入超长。
		public static final String ACCOUNT_NOT_AUTH = "0130Z1101004";	//您所提交的账号尚未申请网上操作功能，不能进入交易。
		public static final String ACCOUNT_ABNORMAL = "0130Z1101007";	//账户状态异常，请与银行联系。
		public static final String INCORRECT_PASSWORD2 = "0130Z1101002";	//用户输入的密码错。
		
	}
	
	static {
		
		 respCodeMap = new HashMap<String, String>();
		 respCodeMap.put("000000", RespCode.SUCCESS);
		 respCodeMap.put("0130Z0100001", RespCode.TIMEOUT);
		 respCodeMap.put("0130Z0100002", RespCode.TIMEOUT2);
		 respCodeMap.put("0130Z0100004", RespCode.INCORRECT_PASSWORD);
		 respCodeMap.put("0130Z0100005", RespCode.INVALID_USERNAME);
		 respCodeMap.put("0130Z1101001", RespCode.INCOMPLETE_REQINFO);
		 respCodeMap.put("0130Z1101002", RespCode.INVALID_REQINFO);
		 respCodeMap.put("0130Z1101003", RespCode.INVALID_REQINFO2);
		 respCodeMap.put("0130Z1101004", RespCode.ACCOUNT_NOT_AUTH);
		 respCodeMap.put("0130Z1101007", RespCode.ACCOUNT_ABNORMAL);
		 respCodeMap.put("0130Z1101002", RespCode.INCORRECT_PASSWORD2);
		
	}
	
}
