package top.guke.springboot.redis.hander;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.guke.springboot.redis.enums.ErrorCode;
import top.guke.springboot.redis.exception.ServerException;
import top.guke.springboot.redis.result.Result;


@Slf4j
@RestControllerAdvice
public class ServerExceptionHandler {
/*
* 处理自定义异常
* @param exception 异常
* @return Result<String>
*/
@ExceptionHandler(ServerException.class)
public Result<String> handleException(ServerException exception){
    return Result.error(exception.getCode(),exception.getMsg());
}

@ExceptionHandler(BindException.class)
public Result<String> bindException(BindException exception) {
    FieldError fieldError = exception.getFieldError();
    assert fieldError != null;
    return Result.error(fieldError.getDefaultMessage());
}
/*
* 其他异常情况
* @param ex 异常
* return Result<String>
*/

@ExceptionHandler(Exception.class)
public Result<String> handleException(Exception ex) {
    log.error(ex.getMessage(),ex);

    return Result.error(ErrorCode.INTERNAL_SERVER_ERROR);
}
}