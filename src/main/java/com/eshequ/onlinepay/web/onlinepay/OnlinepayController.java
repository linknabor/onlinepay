/**
 * 
 */
package com.eshequ.onlinepay.web.onlinepay;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eshequ.onlinepay.exception.BusinessException;
import com.eshequ.onlinepay.factory.PaymentFactory;
import com.eshequ.onlinepay.web.BaseController;
import com.eshequ.onlinepay.web.dto.PayResponse;
import com.eshequ.onlinepay.web.vo.Order;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author huym
 *
 */
@RestController
public class OnlinepayController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(OnlinepayController.class);
	
	@Autowired
	private PaymentFactory paymentFactory;
	
	/**
	 * 支付交易
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/wechatpay", method = RequestMethod.POST)
	public String wechatpay(@RequestBody Map<String, Object> map) throws Exception{
		
		ObjectMapper mapper = new ObjectMapper();
		String requestJsonStr = mapper.writeValueAsString(map);	//map 转json
		
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);	//设置map中多余的字段不转换到实体
		Order order = mapper.readValue(requestJsonStr, Order.class);	//map中的字段比实体多。Order实体只参与支付，其余数据的记录用map中的数据

		PayResponse payResponse = paymentFactory.getOnlinepayInstance(order.getPlatChannel()).wechatpay(order);
		return mapper.writeValueAsString(payResponse);
        
    }
	
	/**
	 * 支付交易
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/micropay", method = RequestMethod.POST)
	public String micropay(@RequestBody Map<String, Object> map) {
		
		System.out.println(map.toString());
        return "test RESTful";
        
    }
	
	/**
	 * 支付交易查询
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public String queryPay(@RequestBody Map<String, Object> map) {
		
		System.out.println(map.toString());
        return "test RESTful";
        
    }
	
	/**
	 * 退款
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/refund", method = RequestMethod.POST)
	public String refund(@RequestBody Map<String, Object> map) {
		
		System.out.println(map.toString());
        return "test RESTful";
        
    }
	
	/**
	 * 退款查询
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/queryRefund", method = RequestMethod.POST)
	public String queryRefund(@RequestBody Map<String, Object> map) {
		
		System.out.println(map.toString());
        return "test RESTful";
        
    }
	
	/**
	 * 撤单
	 * @param map
	 * @return
	 */
	@RequestMapping(value = "/reverse", method = RequestMethod.POST)
	public String reverse(@RequestBody Map<String, Object> map) {
		
		System.out.println(map.toString());
        return "test RESTful";
        
    }
	
	/**
	 * 异常处理
	 * @param e
	 * @return
	 */
	@ExceptionHandler(BusinessException.class)
	public String handleException(BusinessException e){
		
		logger.info("provider controller : " + e.getMessage(), e);
		return e.getMessage();
	}
	
	public static void main(String[] args) {
		
		
	}
	
	
	
}
