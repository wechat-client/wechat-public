<%@include file="/commons/taglibs.jsp" %>

<!DOCTYPE html>
<html>
    <head>
    <link href="${ctx}/css/metro-bootstrap.css" rel="stylesheet">
    <link href="${ctx}/css/metro-bootstrap-responsive.css" rel="stylesheet">
    
    <script src="${ctx}/scripts/jquery10/jquery.min.js"></script>
    <script src="${ctx}/scripts/jquery10/jquery.widget.min.js"></script>
    <script src="${ctx}/scripts/metro/metro-live-tile.js"></script>
    <script src="${ctx}/scripts/metro/metro-loader.js"></script>
    
    </head>
    <body class="metro">
    
    <div class="container">

 
    
    <div class="tile live" data-role="live-tile" data-effect="slideRight">
    		<div class="tile-content"><img alt="" src="${ctx}/image/yutou.jpg"></div>
    		<div class="tile-content"><img alt="" src="${ctx}/image/wenjiu.jpg"></div>
	</div>
	
	
	<div class="col-sm-6 col-md-3">
		<div class="thumbnail tile tile-green">
	        <a href="#" class="fa-links">
	            <h1>Home</h1>
	                <i class="fa fa-3x fa-home"></i>
			</a>
	    </div>
	</div>
	
	<div class="col-sm-6 col-md-3">
		<div class="thumbnail tile tile-orange">
	        <a href="#" class="fa-links">
	            <h1>RSS</h1>
	                <i class="fa fa-3x fa-rss-square"></i>
			</a>
		</div>
	</div>
	
	 </div>
 
    </body>
</html>