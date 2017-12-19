<!DOCTYPE HTML>
<html>
<head>
<script type="text/javascript">
window.onload = function () {
var n=document.getElementById("lab").innerHTML;
alert(n);
var chart = new CanvasJS.Chart("chartContainer", {
	theme: "light4", // "light2", "dark1", "dark2"
	animationEnabled: false, // change to true		
	title:{
		text: "Basic Column Chart"
	},
	data: [
	{
		// Change type to "bar", "area", "spline", "pie",etc.
		type: "area",
		dataPoints: [
			{ label: n.toString() ,  y: 10  },
			{ label: "answer1", y: <%out.print (Integer.parseInt( request.getAttribute("a1").toString())); %>  },
			{ label: "answer2", y: <%out.print (Integer.parseInt( request.getAttribute("a2").toString()));%>  },
			{ label: "answer3",  y: <%out.print (Integer.parseInt( request.getAttribute("a3").toString())); %>  },
			{ label: "answer4",  y: <%out.print (Integer.parseInt( request.getAttribute("a4").toString())); %>  }
		]
	}
	]
});
chart.render();

}
</script>
</head>
<body>
    

    
    <label id='lab' value=''>hello</label>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"> </script>
</body>
</html>