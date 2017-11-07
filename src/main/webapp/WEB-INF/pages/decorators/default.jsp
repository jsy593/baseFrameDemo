<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
  <html>
  <head>
     <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	 <title>
	     测试平台
	 </title>
 </head>
 <body>
	<%@ include file="header.jsp"%>
	     <hr />
     test.jsp的title将被填充到这儿：
     <sitemesh:write property='title' /><br />
     test.jsp的body将被填充到这儿：
     <sitemesh:write property='body' />
     <hr />
     <%@ include file="footer.jsp"%>
 </body>
 </html>