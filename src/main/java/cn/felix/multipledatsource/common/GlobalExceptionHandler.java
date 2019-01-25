package cn.felix.multipledatsource.common;


import cn.felix.multipledatsource.common.exception.BusinessException;
import cn.felix.multipledatsource.dto.ResultCode;
import cn.felix.multipledatsource.dto.ResultData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler
    public ResultData<String> exceptionHandler(Exception e) throws Exception {
        logger.error("", e);
        return ResultData.failed(ResultCode.SYSTEM_EX_CODE.getValue(), e.getMessage());
    }

    @ExceptionHandler
    public ResultData<String> businessExceptionHandler(BusinessException e) throws Exception {
        logger.error("", e);
        return ResultData.failed(ResultCode.BUSINESS_EX_CODE.getValue(), e.getBusinessExceptionMessage().getMessage());
    }

//
//	@ExceptionHandler(NullPointerException.class)
//	public Map<String, Object> nullpointerexceptionHandler() {
//		Map<String, Object> result = new HashMap<String, Object>();
//		result.put("code", 500);
//		result.put("message", "空指针引用异常！");
//		return result;
//	}
//
//	@ExceptionHandler(ClassCastException.class)
//	public Map<String, Object> classcastexceptionHandler() {
//		Map<String, Object> result = new HashMap<String, Object>();
//		result.put("code", 500);
//		result.put("message", "类型强制转换异常!");
//		return result;
//	}
//
//	@ExceptionHandler(IllegalArgumentException.class)
//	public Map<String, Object> illegalargumentexceptionHandler() {
//		Map<String, Object> result = new HashMap<String, Object>();
//		result.put("code", 500);
//		result.put("message", "传递非法参数异常!");
//		return result;
//	}
//
//	@ExceptionHandler(ArithmeticException.class)
//	public Map<String, Object> arithmeticexceptionHandler() {
//		Map<String, Object> result = new HashMap<String, Object>();
//		result.put("code", 500);
//		result.put("message", "算术运算异常！");
//		return result;
//	}
//
//	@ExceptionHandler(ArrayStoreException.class)
//	public Map<String, Object> arraystoreexceptionHandler() {
//		Map<String, Object> result = new HashMap<String, Object>();
//		result.put("code", 500);
//		result.put("message", "向数组中存放与声明类型不兼容对象异常！");
//		return result;
//	}
//
//	@ExceptionHandler(IndexOutOfBoundsException.class)
//	public Map<String, Object> indexoutofboundsexceptionHandler() {
//		Map<String, Object> result = new HashMap<String, Object>();
//		result.put("code", 500);
//		result.put("message", "下标越界异常！");
//		return result;
//	}
//
//	@ExceptionHandler(NegativeArraySizeException.class)
//	public Map<String, Object> negativearraysizeexceptionHandler() {
//		Map<String, Object> result = new HashMap<String, Object>();
//		result.put("code", 500);
//		result.put("message", "创建一个大小为负数的数组错误异常！");
//		return result;
//	}
//
//	@ExceptionHandler(NumberFormatException.class)
//	public Map<String, Object> numberformatexceptionHandler() {
//		Map<String, Object> result = new HashMap<String, Object>();
//		result.put("code", 500);
//		result.put("message", "数字格式异常！");
//		return result;
//	}
//
//	@ExceptionHandler(SecurityException.class)
//	public Map<String, Object> securityexceptionHandler() {
//		Map<String, Object> result = new HashMap<String, Object>();
//		result.put("code", 500);
//		result.put("message", "安全异常！");
//		return result;
//	}
//
//	@ExceptionHandler(UnsupportedOperationException.class)
//	public Map<String, Object> unsupportedoperationexceptionHandler() {
//		Map<String, Object> result = new HashMap<String, Object>();
//		result.put("code", 500);
//		result.put("message", "不支持的操作异常！");
//		return result;
//	}
//
//	@ExceptionHandler(RuntimeException.class)
//	public Map<String, Object> runtimeexceptionHandler() {
//		Map<String, Object> result = new HashMap<String, Object>();
//		result.put("code", 500);
//		result.put("message", "系统异常！");
//		return result;
//	}
}
