<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/commons/taglibs.jsp" %>
<!DOCTYPE html>
<html>
    <head>
       <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0,user-scalable=no">
       <%@include file="/commons/css.jsp" %>
       <%@include file="/commons/script.jsp" %>
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
				<a href="http://wd.koudai.com/vshop/1/H5/index.html?userid=378166&from=singlemessage&isappinstalled=0">
				<div class="col-sm-3 col-md-3 col-xs-4 short-block" style="background:#0066FF;">
					<p><i class="fa fa-shopping-cart fa-4x"></i></p>
					<p>微商城</p>
				</div>
				</a>
				<div class="col-sm-6 col-md-6 col-xs-8" style="background:#333333;padding: 0 15px 0 17px;">
					<div class="row">
						<a href="http://shop106322402.m.taobao.com">
						<div class="col-xs-12 col-sm-12 col-md-12 long-block" style="background:#009933;">
							<i class="fa fa fa-credit-card fa-4x"></i>&nbsp;&nbsp;淘宝小店
						</div>
						</a>
					</div>
				</div>
			</div>

			<!-- second row -->
			<div class="row main" style="margin:5px 0;">
			<a href="${ctx }/article/list/01">
			<div class="col-sm-4 col-md-4 col-xs-4 short-block" style="background:#339900;">
				<p><i class="fa fa-coffee fa-4x"></i></p>
				<p>非姐小厨</p>
			</div>
			</a>
			<div class="col-sm-4 col-md-4 col-xs-4" style="background:#333333;padding: 0 15px 0 17px;">
				<div class="row">
					<a href="${ctx }/article/list/02">
					<div class="col-xs-12 col-sm-12 col-md-12 short-block" style="background:#666633;">
						<p><i class="fa fa-pagelines fa-4x"></i></p>
						<p>养生堂</p>
					</div>
					</a>
				</div>
			</div>
			<div class="col-sm-4 col-md-4 col-xs-4" style="background:#333333;padding: 0 15px 0 17px;">
				<div class="row">
					<a href="${ctx }/article/list/03">
						<div class="col-xs-12 col-sm-12 col-md-12 short-block" style="background:#6666CC;">
							<p><i class="fa fa-thumbs-up fa-4x"></i></p>
							<p>案例分享</p>
						</div>
					</a>
				</div>
			</div>
			</div>	
			<!-- third row -->
			<div class="row main" style="margin:5px 0 67px 0;">
				<a href="http://www.baidu.com">
				<div class="col-sm-8 col-md-8 col-xs-7 long-block"  style="background:#dd6633;">
					<i class="fa fa fa-file-text fa-4x"></i>&nbsp;&nbsp;订单查询
				</div>
				</a>
				
				<div class="col-sm-4 col-md-4 col-xs-5" style="background:#333333;padding: 0 15px 0 17px;">
					<div class="row">
						<a href="http://www.baidu.com">
						<div class="col-xs-12 col-sm-12 col-md-12 short-block" style="background:#FF0033;">
							<p><i class="fa fa-comments-o fa-4x"></i></p>
							<p>微预约</p>
						</div>
						</a>
					</div>
				</div>
			</div>	
		</div>
		<%@include file="footer.jsp" %>
    </body>
 
</html>