<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@include file="/commons/taglibs.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<title>蛋炒饭</title>
		 <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0,user-scalable=no">
	     <%@include file="/commons/script.jsp" %>
 	 	 <%@include file="/commons/css.jsp" %>
	</head>
	<body>
	<!-- body -->
	<div class="container-fulid " id="main">
		<h3>${article.articleTitle }</h3>
		<blockquote>
		  <small>${article.articleAbstract }</small>
		</blockquote>
		<p  class="text-left">
			${article.articleContent }
		</p>
	</div>
	<!-- footer -->
	<%@include file="footer.jsp" %>
	<!-- footer end -->
	</body>
</html>
	