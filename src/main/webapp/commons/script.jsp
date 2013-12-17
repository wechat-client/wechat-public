<%String scriptBasePath=request.getContextPath();%>
<script src="<%=scriptBasePath %>/scripts/jquery-1.10.2.min.js"></script>
<script src="<%=scriptBasePath %>/scripts/bootstrap.min.js"></script>
<script type="text/javascript">
document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
	WeixinJSBridge.call('hideToolbar');
});
</script>