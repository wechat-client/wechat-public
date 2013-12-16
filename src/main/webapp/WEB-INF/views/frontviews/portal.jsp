<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/commons/taglibs.jsp" %>
<!DOCTYPE html>
<html>
    <head>
     <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0,user-scalable=no">
     <link href="${ctx}/css/bootstrap-c.css" rel="stylesheet">
     <link href="${ctx }/css/font-awesome-4.0.3/css/font-awesome.min.css" rel="stylesheet">
     <link href="${ctx}/css/custom.css" rel="stylesheet">
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
			<div class="row main" style="margin:10px 0 0 0;">
				<div class="col-sm-3 col-md-3 col-xs-4 short-block" style="background:#0066FF;">
					<p><i class="fa fa-shopping-cart fa-4x"></i></p>
					<p>微商城</p>
				</div>
				<div class="col-sm-6 col-md-6 col-xs-8" style="background:#333333;padding: 0 15px 0 17px;">
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 long-block" style="background:#009933;">
							<i class="fa fa fa-credit-card fa-4x"></i>&nbsp;&nbsp;淘宝小店
						</div>
					</div>
				</div>
			</div>

			<!-- second row -->
			<div class="row main" style="margin:5px 0;">
			<div class="col-sm-4 col-md-4 col-xs-4 short-block" style="background:#339900;">
				<p><i class="fa fa-coffee fa-4x"></i></p>
				<p>非姐小厨</p>
			</div>
			<div class="col-sm-4 col-md-4 col-xs-4" style="background:#333333;padding: 0 15px 0 17px;">
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-12 short-block" style="background:#666633;">
						<p><i class="fa fa-pagelines fa-4x"></i></p>
						<p>温灸养生</p>
					</div>
				</div>
			</div>
			<div class="col-sm-4 col-md-4 col-xs-4" style="background:#333333;padding: 0 15px 0 17px;">
				<div class="row">
					<a href="http://www.baidu.com">
						<div class="col-xs-12 col-sm-12 col-md-12 short-block" style="background:#6666CC;">
							<p><i class="fa fa-thumbs-up fa-4x"></i></p>
							<p>非推荐</p>
						</div>
					</a>
				</div>
			</div>
			</div>	
			<!-- third row -->
			<div class="row main" style="margin:5px 0 65px 0;">
				<div class="col-sm-8 col-md-8 col-xs-7 long-block"  style="background:#dd6633;">
					<i class="fa fa fa-file-text fa-4x"></i>&nbsp;&nbsp;订单查询
				</div>
				<div class="col-sm-4 col-md-4 col-xs-5" style="background:#333333;padding: 0 15px 0 17px;">
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 short-block" style="background:#FF0033;">
							<p><i class="fa fa-comments-o fa-4x"></i></p>
							<p>微预约</p>
						</div>
					</div>
				</div>
			</div>	
		</div>
		<div class="container-fulid">
			<div class="row">
				<nav class="navbar navbar-custom navbar-fixed-bottom" role="navigation" >
				   <div class="navbar-header">
				     <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				       <span class="sr-only">Toggle navigation</span>
				       <span class="icon-bar"></span>
				       <span class="icon-bar"></span>
				       <span class="icon-bar"></span>
				     </button> 	
				    <!--  
				    <a class="navbar-brand" href="#"><i class="fa fa-pagelines fa-1x"></i></a>
				  	-->	
				   </div>
				   <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				      <ul class="nav navbar-nav">
				      	 <li><a href="#"><i class="fa fa-home"></i>&nbsp;&nbsp;首页</a></li>
				      </ul>
				    </div>
				</nav>
			</div>		
		</div>
    </body>
 
</html>