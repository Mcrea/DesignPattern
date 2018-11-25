<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>voice on cloud</title>
<script type="text/javascript" src="js/jquery-2.2.4.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript">
    function synthesize(){
    	$.ajax({
    		  type : 'POST',
    		  url : "word2Voice",
    		  data : {"text" : "你好，Alex"},
    		  success : function(data){
    			  debugger;
    			  alert(data);
    		  },
    		  error : function(data){
    			  debugger;
    			  alert(data);
    		  },
    		  dataType: "json"
    		});
    }
</script>
<link rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body>
<div class="container"> 
  		    <div class="row"  > 
  	                 <div class="text-center ">
  	                   <h1>山东省济南市王大壮文本语音合成系统  </h1>
  	                 </div>
  		    </div>
</div>
<div class="container" style="height:400px"> 
  	<div class="row" style="margin-top:200px" > 
  	    <div class="">
  	        <div class="input-group col-md-6" style="margin : auto">
                <input type="text" class="form-control" placeholder="请输入播放内容">
                <span class="input-group-btn">
                    <button class="btn btn-default" type="button" onclick="synthesize()">合成</button>
                </span>
            </div>
  	    </div>
  	</div>
</div>
</body>
</html>