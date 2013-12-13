<%@include file="/commons/taglibs.jsp" %>

<!DOCTYPE html>
<html>
    <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <link href="${ctx}/css/bootstrap.css" rel="stylesheet">
     <link href="${ctx}/css/metro-bootstrap.css" rel="stylesheet">
     <script src="${ctx}/scripts/jquery-1.10.2.min.js"></script>
     <script src="${ctx}/scripts/bootstrap.min.js"></script>
    </head>
    <body>
    	<div class="container">
    		<div class="row" style="margin-bottom:10px">
  				<div class="col-xs-12 col-md-12 ">
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
					      <img src="${ctx}/image/wj1.jpeg" alt="...">
					      <div class="carousel-caption">
					      </div>
					    </div>
					  </div>

				 	 <!-- Controls -->
					  <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
					    <span class="glyphicon glyphicon-chevron-left"></span>
					  </a>
					  <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
					    <span class="glyphicon glyphicon-chevron-right"></span>
					  </a>
					</div>		
  				</div>
			</div>

<!-- first row -->			
<div class="row" style="margin-bottom:10px">
<div class="col-sm-3 col-md-3 col-xs-3"><div class="thumbnail tile tile-teal"><a href="#" ><h1>微商城</h1></a></div>
</div>

<div class="col-sm-6 col-md-6 col-xs-3"><div class="thumbnail tile tile-double tile-orange"><a href="#" ><h1 class="tile-text">非姐养生</h1></a></div>
</div>
</div>

<!-- second row -->
<div class="row" style="margin-bottom:10px">
<div class="col-sm-6 col-md-6"><div class="thumbnail tile tile-double tile-orange"><a href="#" ><h1 class="tile-text"></h1></a></div>
</div>
<div class="col-sm-6 col-md-3"><div class="thumbnail tile tile-teal"><a href="#" ><h1>微商城</h1></a></div>
</div>
<div class="col-sm-6 col-md-3 "><div class="thumbnail tile"><a href="#" ><img src="docs/twittertile.png"><h2>Tweet</h2></a></div>
</div>
</div>			
			<!--  
			
    		<div class="row" style="margin-bottom:10px">
				 <div class="col-sm-4 col-md-4 col-xs-4 "><a href="#" class="btn btn-primary btn-lg btn-block active" role="button">Primary link</a></div>
				 <div class="col-sm-8 col-md-8 col-xs-8 "><a href="#" class="btn btn-primary btn-lg btn-block active" role="button">Primary link</a></div>
			</div>
    		<div class="row" style="margin-bottom:10px">
      					<div class="col-sm-8 col-md-8 col-xs-8"><a href="#" class="btn btn-primary btn-lg btn-block active" role="button">Primary link</a></div>
      					<div class="col-sm-4 col-md-4 col-xs-4"><a href="#" class="btn btn-primary btn-lg btn-block active" role="button">Primary link</a></div>
    		</div>
  		</div>
			-->
			</div>
    </body>
 
</html>