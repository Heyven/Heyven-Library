package org.hrms.web.controller;

import org.hrms.common.context.VerificationCodeContext;
import org.hrms.common.response.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 验证码控制器
 * 
 * @author VIC
 *
 */
@Controller
@RequestMapping("/verification")
public class VerificationCodeController extends CommonController {
	
	/**
	 * 获取验证码
	 */
	@RequestMapping("/code")
	@ResponseBody
	public String code() {
		return VerificationCodeContext.generatorCodeImage();
	}

	/**
	 * 校验验证码
	 * 
	 * @param verificationCode
	 * @return
	 */
	@RequestMapping(path="/checkCode",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String checkCode(@RequestBody String verificationCode) {
		Response response = Response.getInstance();
		boolean exists = VerificationCodeContext.existsCode(verificationCode);
		response.setState(exists);
		if (!response.getState()) {
			response.setMessage(getMessage("verification.code.error"));
		}
		return response.toJson();
	}
}
