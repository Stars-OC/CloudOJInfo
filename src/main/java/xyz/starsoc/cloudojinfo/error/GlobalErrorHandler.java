package xyz.starsoc.cloudojinfo.error;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.starsoc.cloudojinfo.pojo.Result;
import xyz.starsoc.cloudojinfo.pojo.ResultCode;

import java.util.List;


@Slf4j
@RestControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(Exception.class)
    public Result<String> otherErrorHandler(Exception e) {

        log.error(e.getMessage());

        if (e instanceof MethodArgumentNotValidException || e instanceof ConstraintViolationException) {
            return Result.codeFailure(ResultCode.RC406);
        }

        // 返回统一错误结果
        return Result.codeFailure(ResultCode.RC404);
    }

}
