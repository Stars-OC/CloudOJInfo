package xyz.starsoc.cloudojinfo.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import xyz.starsoc.cloudojinfo.config.UserConfiguration;
import xyz.starsoc.cloudojinfo.pojo.Result;
import xyz.starsoc.cloudojinfo.pojo.ResultCode;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {

    private final static ObjectMapper mapper = new ObjectMapper();
    /**
     * 过滤器方法，用于处理请求和响应
     *
     * @param servletRequest  Servlet请求对象
     * @param servletResponse Servlet响应对象
     * @throws IOException      如果处理过程中发生I/O错误
     * @throws ServletException 如果处理过程中发生Servlet错误
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        // 将ServletRequest和ServletResponse转换为HttpServletRequest和HttpServletResponse
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 获取请求的URL
        String url = request.getRequestURL().toString();

        // 如果URL包含"/user/login"或"/user/register"，则不进行鉴权，直接放行
        if (url.contains("/login")) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 获取请求头中的token
        String token = request.getHeader("token");
        response.setContentType("text/plain; charset=utf-8");

        String result = "";
        // 如果token为空，则返回"token不存在，请登录"
        if (token == null || token == "") {
            result = mapper.writeValueAsString(Result.codeFailure(ResultCode.TOKEN_INVALID));
            response.getWriter().write(result);
            return;
        }


        // 使用JwtUtil工具类获取token中的claims信息
        boolean checkToken = UserConfiguration.checkToken(token);

        if (!checkToken) {
            result = mapper.writeValueAsString(Result.codeFailure(ResultCode.TOKEN_INVALID));
            response.getWriter().write(result);
            return;
        }

        // 放行请求，继续处理
        chain.doFilter(servletRequest, servletResponse);

    }
}
