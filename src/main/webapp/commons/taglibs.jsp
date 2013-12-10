<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%String basePath = request.getContextPath(); %>
<c:set var="random" value="<%=Math.random() %>"></c:set>
<c:set var="ctx" value="<%=basePath%>"></c:set>
