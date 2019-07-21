package com.yangbin1.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MyAuthenticationSuccessHandler
 * @Auther: yangbin1
 * @Date: 2019/7/21 14:46
 * @Description:
 */
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    // 对象转换为json字符串
    private ObjectMapper objectMapper = new ObjectMapper();

    /***
     *
     * @param request
     * @param response
     * @param authentication
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        Map result = new HashMap();
        result.put("success",true);

        String json = objectMapper.writeValueAsString(result);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(json);
    }
}
