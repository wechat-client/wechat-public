<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%@include file="/commons/taglibs.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<title>文章列表</title>
		 <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0,user-scalable=no">
	     <%@include file="/commons/script.jsp" %>
 	 	 <%@include file="/commons/css.jsp" %>
	</head>
	<body>
	   <!-- body -->
	   <div class="container-fulid " id="main">
	   	   <div class="row">
		   <ul class="media-list">
		   	  <c:forEach items="${articles}" var="article">
			  <li class="media">
			    <a class="pull-left" href="${ctx }/article/${article.articleId}">
			      <img class="media-object img-thumbnail" src="${ctx }/image/${article.articleImage}" alt="food">
			    </a>
			    <a href="${ctx }/article/${article.articleId}">
			    <div class="media-body">
			      <h4 class="media-heading">${article.articleTitle}</h4>
			      <c:choose>  
				    <c:when test="${fn:length(article.articleContent) > 30}">  
				        <c:out value="${fn:substring(article.articleContent, 0, 30)}..." />  
				    </c:when>  
				    <c:otherwise>  
				      <c:out value="${article.articleContent}" />  
				    </c:otherwise>  
				  </c:choose>  
			    </div>
			    </a>
			  </li>
			  </c:forEach>
		   </ul>
		   </div>
	   </div>
	   <!-- body end -->
	   <!-- footer -->
	   <%@include file="footer.jsp" %>
	   <!-- footer end -->
	</body>
</html>
