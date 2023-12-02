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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyfestival.www.domain.OrderDTO;
import com.easyfestival.www.domain.PayDTO;
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

	@RequestMapping(value = "/complete", method = RequestMethod.POST)
	@ResponseBody
	public int paymentComplete(HttpSession session, String imp_uid, String merchant_uid, String totalPrice,
			@RequestBody OrderDTO orderDTO) throws Exception {
		//DB저장 구간

		log.info(" orderDTO >>>> {}", orderDTO);
		String token = payService.getToken();
		log.info(" tocen >>>> {}", token);

		// 결제 완료된 금액
		String amount = payService.paymentInfo(orderDTO.getImp_uid(), token);
		log.info(" amount >>>> {}", amount);

		int res = 1;

		if (orderDTO.getTotalPrice() != Long.parseLong(amount)) {
			System.out.println(orderDTO.getTotalPrice());
			res = 0;
			// 결제 취소
			payService.payMentCancle(token, orderDTO.getImp_uid(), amount, "결제 금액 오류");
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
		
		System.out.println("포인트야 ?"+ result.getResponse().getPayMethod());
		
		System.out.println((Long) session.getAttribute("saveNum"));
		payDTO.setNum((Long) session.getAttribute("saveNum"));
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
	


}
