package com.easyfestival.www.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyfestival.www.repository.OrderDTO;
import com.easyfestival.www.repository.PayDTO;
import com.easyfestival.www.security.UserVO;
import com.easyfestival.www.service.OrderService;
import com.easyfestival.www.service.PayService;
import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/peyment/*")
public class PeymentController {

	@Value("7820725586500628")
	private String apiKey;

	@Value("8kJzA2A8JvcuCEVuWlXENjqli35CyLVev2gY4grQLmxfnj2DZvvqPZu4sDlrLLjjdmDpKaUiEkDEyCJM")
	private String secretKey;

	private IamportClient api = new IamportClient(apiKey, secretKey);

	@Autowired
	private PayService payService;

	@Autowired
	private OrderService orderService;

	public PeymentController() {
		// REST API 키와 REST API secret 를 아래처럼 순서대로 입력한다.
		this.api = new IamportClient("7820725586500628",
				"8kJzA2A8JvcuCEVuWlXENjqli35CyLVev2gY4grQLmxfnj2DZvvqPZu4sDlrLLjjdmDpKaUiEkDEyCJM");
	}

	@RequestMapping(value = "/peverifyIamport/{imp_uid}")
	@ResponseBody
	//검증구간
	public IamportResponse<Payment> paymentByImpUid(Model model, Locale locale, HttpSession session,
			@PathVariable(value = "imp_uid") String imp_uid) throws IamportResponseException, IOException {
		return api.paymentByImpUid(imp_uid);
	}
	
	@PostMapping("orderCancle")
	@ResponseBody
	public int orderCancle(OrderDTO orderDTO, PayDTO payDTO) throws Exception {
//		userId == 0 비회원
		System.out.println("1 : "+orderDTO);
		System.out.println("1 : "+orderDTO.getImpUid());
		System.out.println("1 : "+orderDTO.getOrderNum());
		
		
		
		orderDTO = orderService.adminList(orderDTO); 
		
		System.out.println("2 : "+orderDTO);
		System.out.println("2 : "+orderDTO.getImpUid());
		System.out.println("2 : "+orderDTO.getOrderNum());
		
		int result1 = orderService.payMentCancle(payDTO);
		System.out.println("rrr");
		
		int result = orderService.orderCancle(orderDTO);

		if(result>0) {
			System.out.println("DB 삭제성공");
		}
		if(result1>0) {
			System.out.println("Pay DB 삭제성공");
		}
		
		return result;
	}
	
	
	
	

	@RequestMapping(value = "/complete", method = RequestMethod.POST)
	@ResponseBody
	public int paymentComplete(HttpSession session, String imp_uid, String merchant_uid, String totalPrice,
			@RequestBody OrderDTO orderDTO) throws Exception {
		//DB저장 구간

		log.info(" orderDTO >>>> {}", orderDTO);
		String token = payService.getToken();
		log.info(" tocen >>>> {}", token);

		// 결제 완료된 금액
		String amount = payService.paymentInfo(orderDTO.getImpUid(), token);
		log.info(" amount >>>> {}", amount);

		int res = 1;

		if (orderDTO.getTotalPrice() != Long.parseLong(amount)) {
			System.out.println(orderDTO.getTotalPrice());
			res = 0;
			// 결제 취소
			payService.payMentCancle(token, orderDTO.getImpUid(), amount, "결제 금액 오류");
			return res;
		}

		orderService.insert_pay(orderDTO);
		return res;

	}
	
	@GetMapping("/complete")
	public String getOrderComplete(@RequestParam long payNum, OrderDTO orderDTO, Model model) throws Exception {
		System.out.println("404에러 ");
		PayDTO payDTO = orderService.getPay(payNum);
		
		model.addAttribute("payDTO", payDTO);
		
		return "/package/complete";
	}

	
	@RequestMapping(value = "pay_info", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Long> payInfoPOST(Model model, HttpServletRequest request, HttpServletResponse response,
			@RequestParam String imp_uid, HttpSession session) throws Exception {
		IamportResponse<Payment> result = api.paymentByImpUid(imp_uid);
		PayDTO payDTO = new PayDTO();
		
		
		System.out.println(((UserVO) session.getAttribute("uvo")).getId());
		payDTO.setId(((UserVO) session.getAttribute("uvo")).getId());
		payDTO.setOrderNum(Long.parseLong(result.getResponse().getMerchantUid()));
		payDTO.setPayMethod(result.getResponse().getPayMethod());
		payDTO.setPayName(result.getResponse().getName());
		payDTO.setPayAmount(result.getResponse().getAmount().longValue());
		orderService.insert_payinfo(payDTO);

		payDTO = orderService.getLastPay(payDTO);
		System.out.println("이건" + payDTO);
		model.addAttribute("payDTO", payDTO);

		return new ResponseEntity<Long>(payDTO.getPayNum(), HttpStatus.OK);
	}
	
	
	
	@PostMapping("payMentCancel")
	@ResponseBody
	public int payMentCancle(OrderDTO orderDTO) throws Exception{
		int result = 0;
		System.out.println("payMentCancel" + orderDTO);
		System.out.println("1 : " + orderDTO.getOrderNum());
		if(orderDTO.getOrderNum() != null) {
			result = 1;
		}
		return result;
	}
	
}
	
	
/*
 * @GetMapping(value = "myOrderList") public String myOrder(OrderDTO
 * orderDTO,HttpSession session, Model model,
 * 
 * @RequestParam(value = "pagingNum", required = false, defaultValue = "1")
 * String pagingNum) throws Exception{
 * 
 * System.out.println("myorderList"); Long svNum =
 * (Long)(session.getAttribute("saveNum"));
 * 
 * String saveNUM = String.valueOf(svNum); List<Long> codeList =
 * orderService.MyOrderCount(saveNUM);
 * 
 * System.out.println("saveNum : " + saveNUM); System.out.println("codeList : "
 * +codeList);
 * 
 * 
 * List<Long> limitList = new ArrayList<Long>(); try { limitList =
 * codeList.subList(cri.getPageStart(), cri.getPageStart()+3); } catch
 * (Exception e) { limitList = codeList.subList(cri.getPageStart(),
 * codeList.size()); } Map<Long, List> orderMap =
 * orderService.getMyOrderList(saveNUM, limitList);
 * 
 * UserPageMaker pm = new UserPageMaker(); pm.setCri(cri);
 * pm.setTotalCount(codeList.size());
 * 
 * model.addAttribute("orderMap", orderMap); model.addAttribute("pagingNum",
 * pagingNum); model.addAttribute("pm", pm); return "order/myOrderList"; }
 * 
 * }
 */