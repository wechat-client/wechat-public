<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/commons/taglibs.jsp" %>
<!DOCTYPE html>
<html>
    <head>
     <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0,user-scalable=no">
     <link href="${ctx}/css/bootstrap.css" rel="stylesheet">
     <link href="${ctx}/css/metro-bootstrap.css" rel="stylesheet">
     <script src="${ctx}/scripts/jquery-1.10.2.min.js"></script>
     <script src="${ctx}/scripts/bootstrap.min.js"></script>
 	 <script type="text/javascript">
 		document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
 			WeixinJSBridge.call('hideToolbar');
 		});
 	 </script>
    </head>
    <body style="background:#333333">
    	<div class="container-fulid ">
    		 <div class="row" style="margin:0;">
  				<div class="col-xs-12 col-md-12" style="padding:0">
    				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					  <!-- Indicators -->
					  <ol class="carousel-indicators">
					    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
					    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
					    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
					  </ol>

					  <!-- Wrapper for slides -->
					  <div class="carousel-inner">
					    <div class="item active">
					      <img src="${ctx}/image/slider.jpg" alt="...">
					      <div class="carousel-caption">
					      </div>
					    </div>
					    <div class="item">
					      <img src="${ctx}/image/slider.jpg" alt="...">
					      <div class="carousel-caption">
					      </div>
					    </div>
					    <div class="item">
					      <img src="${ctx}/image/slider.jpg" alt="...">
					      <div class="carousel-caption">
					      </div>
					    </div>
					  </div>
					</div>		
  				</div>
			</div>

			<!-- first row -->			
			<div class="row" style="margin:10px 0;">
				<div class="col-sm-3 col-md-3 col-xs-4" style="background:#ddfe23;height:100px">
					微商城
				</div>
				<div class="col-sm-6 col-md-6 col-xs-8" style="background:#333333;padding: 0 15px 0 17px;">
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12" style="background:#663333;height:100px;">
							淘宝小店
						</div>
					</div>
				</div>
			</div>

			<!-- second row -->
			<div class="row" style="margin:10px 0;">
			<div class="col-sm-4 col-md-4 col-xs-4" style="background:#668899;height:100px">
				非姐小厨
			</div>
			<div class="col-sm-4 col-md-4 col-xs-4" style="background:#333333;padding: 0 15px 0 17px;">
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12" style="background:#66ffee;height:100px;">
					温灸养生
					</div>
				</div>
			</div>
			<div class="col-sm-4 col-md-4 col-xs-4" style="background:#333333;padding: 0 15px 0 17px;">
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12" style="background:#ff3333;height:100px;">
						非推荐
					</div>
				</div>
			</div>
			</div>	
			<!-- third row -->
			<div class="row" style="margin:10px 0;">
				<div class="col-sm-8 col-md-8 col-xs-7"  style="background:#dd6633;height:100px">
					订单查询
				</div>
				<div class="col-sm-4 col-md-4 col-xs-5" style="background:#333333;padding: 0 15px 0 17px;">
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12" style="background:#ff3333;height:100px;">
							微预约
						</div>
					</div>
				</div>
			</div>	
		</div>
		<div class="container">
			<div class="row">
				<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
		
				</nav>
			</div>		
		</div>
    </body>
 
</html>