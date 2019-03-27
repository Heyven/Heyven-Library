package org.hrms.common.context;

import org.hrms.util.ImageUtil;
import org.hrms.util.VerificationCode;
import org.hrms.util.VerificationCodeUtil;
import org.hrms.util.VerificationConstant;

/**
 * 验证码上下文
 * 
 * @author VIC
 *
 */
public class VerificationCodeContext {
	
	/**
	 * 生成图形验证码(包括图形和验证码)
	 * 
	 * @return
	 */
	public static String generatorCodeImage() {
		VerificationCode verificationCode = VerificationCodeUtil.generateVerificationCode(140, 93);
		CacheContext.setCache(VerificationConstant.VERIFICATION_CODE_PREFIX + verificationCode.getCode(), verificationCode.getCode());
		return ImageUtil.encodeToBase64(verificationCode.getImage());
	}

	/**
	 * 检查验证码是否存在
	 * 
	 * @param code
	 * @return
	 */
	public static boolean existsCode(String code) {
		String key = VerificationConstant.VERIFICATION_CODE_PREFIX + code;
		String cacheVerificationCode = CacheContext.getCache(key, String.class);
		return code.equalsIgnoreCase(cacheVerificationCode);
	}
	
	/**
	 * 删除验证码
	 * 
	 * @return
	 */
	public static boolean removeCode(String code) {
		String key = VerificationConstant.VERIFICATION_CODE_PREFIX + code;
		return CacheContext.removeCache(key);
	}

}
