package xyz.starsoc.cloudojinfo.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.starsoc.cloudojinfo.pojo.Result;
import xyz.starsoc.cloudojinfo.pojo.ResultCode;


@Slf4j
@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(Exception.class)
    public Result<String> otherErrorHandler(Exception e) {
        // 处理其他异常的方法
        log.error(e.getClass().getName());
        log.error(e.getMessage());
        // 返回错误结果
        return Result.codeFailure(ResultCode.RC404);
    }

}
