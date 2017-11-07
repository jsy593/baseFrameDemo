package com.jsy.cn.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class BaseInterceptor implements HandlerInterceptor{
	private Log logger =  LogFactory.getLog(BaseInterceptor.class);

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		logger.info("进入FrameworkInterceptor拦截器preHandle方法,当前线程：" + Thread.currentThread() + ",时间："
				+ System.currentTimeMillis());
		logger.info("请求url路径为：" + request.getRequestURL());
		request.setAttribute("css", request.getContextPath() + "/statics/css");
		request.setAttribute("js", request.getContextPath() + "/statics/js");
		request.setAttribute("img", request.getContextPath() + "/statics/img");
		request.setAttribute("fonts", request.getContextPath() + "/statics/fonts");
		request.setAttribute("bootstrap", request.getContextPath() + "/statics/bootstrap");
		request.setAttribute("projectName", request.getContextPath());
		request.setAttribute("ctx", request.getContextPath());
		String requestUrl = request.getRequestURL().toString();
		HttpSession session = request.getSession(true);
		Object user = session.getAttribute("User");
		return true;
		/*if (requestUrl.endsWith("/login")) {
			return true;
		}
		if (user == null) {
			if(request.getHeader("x-requested-with") != null && 
					"XMLHttpRequest".equals(request.getHeader("x-requested-with"))){//ajax请求
				response.setHeader("sessionstatus", "timeout");  
			}else{
				response.sendRedirect(request.getContextPath() + "/login");
			}
			return false;
		}else{
			return true;
		}*/
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2,ModelAndView arg3) throws Exception {
	}
	
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}
}
