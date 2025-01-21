//package org.example.productmanagement2.filter;
//
//import jakarta.servlet.Filter;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.ServletRequest;
//import jakarta.servlet.ServletResponse;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.Base64;
//
//@Component
//public class AuthorizationFilter implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        if (request instanceof HttpServletRequest httpRequest) {
//            String authHeader = httpRequest.getHeader("Authorization");
//
//            if (authHeader != null && authHeader.startsWith("Basic ")) {
//                String base64Credentials = authHeader.substring(6); // Bỏ "Basic "
//                String credentials = new String(Base64.getDecoder().decode(base64Credentials));
//                String[] values = credentials.split(":", 2);
//
//                if (values.length == 2) {
//                    // Gắn callerId (giả định là username) vào request attribute
//                    httpRequest.setAttribute("callerId", Long.valueOf(values[0]));
//                }
//            }
//        }
//
//        chain.doFilter(request, response);
//    }
//}
