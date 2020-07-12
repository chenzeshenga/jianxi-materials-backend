package com.jianxi.materials.expo.filter;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** @author chenzeshenga */
@WebFilter(filterName = "corsFilter", urlPatterns = "/*")
@Configuration
public class CorsFilter implements Filter {

  @Override
  public void doFilter(
      ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
      throws IOException, ServletException {
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
    String currentOrigin = httpServletRequest.getHeader("Origin");
    httpServletResponse.setHeader("Access-Control-Allow-Origin", currentOrigin);
    httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
    filterChain.doFilter(servletRequest, servletResponse);
  }
}
