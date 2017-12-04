/**
 * 将数据插入数据库 以及 计算 bim 值
 */

function deletes(id) {
	$.ajax({
		type : "get",
		url : "${pageContext.request.contextPath}/showAction_deleteById",
		async : true,
		data : "id=" + id,
		success : function(result) {
			var result = JSON.parse(result);

			if (result == "true ") {

				location.reload();
			} else {
				alert("删除失败!")
			}
		}
	});

}




$.ajax({
	type : "get",
	url : "${pageContext.requset.contextPath}/showAction_showAll",
	async : true,
	success : function(result) {

		var parses = JSON.parse(result);
		var tbody = document.getElementById("tbody");
		for ( var parse in parses) {
			
			var tr = document.createElement("tr");
			tr.style.color = "#000000"
			tr.innerHTML = "<td>" + parses[parse].id + "</td> <td>"
					+ parses[parse].date + "</td> <td>" + parses[parse].high
					+ "</td> <td>" + parses[parse].weight + "</td> <td>"
					+ parses[parse].bmi + "</td> <td>"
					+ " <input type='button' onclick='deletes("
					+ parses[parse].id
					+ ")'  value='删除' style='width: 70px; height: 25px;'  "
					+ "</td>";
			tbody.appendChild(tr);		
		}
	}
});



function calculator() {

	var height = $("#height").val();
	var weight = $("#weight").val();
	var sex = $('input:radio[name="sex"]:checked').val();  
	 
		var message={
				height:$("#height").val(),
				weight:$("#weight").val()
		}
	  
		$.ajax({
			type : "get",
			url : "${pageContext.request.contextPath}/showAction_record",
			data : message,
			async : true,
			success : function(result) {	
				
				sex1(sex,height, weight);
				addLast();
			}
		});		
		
	
		
	
}

function addLast(){
	$.ajax({
		type : "get",
		url : "${pageContext.request.contextPath}/showAction_findLast",
		async : true,
		success : function(result) {	
		
			 var parse=JSON.parse(result);	
				var tbody = document.getElementById("tbody");
				
					var tr = document.createElement("tr");
					tr.style.color = "#000000"
					tr.innerHTML = "<td>" + parse.id + "</td> <td>"
							+ parse.date + "</td> <td>" + parse.high
							+ "</td> <td>" + parse.weight + "</td> <td>"
							+ parse.bmi + "</td> <td>"
							+ " <input type='button' onclick='deletes("
							+ parse.id
							+ ")'  value='删除' style='width: 70px; height: 25px;'  "
							+ "</td>";
					tbody.appendChild(tr);		
				}
	});		
	
}


function  sex1(sex,height, weight){

	
	var bmi=weight/((height/100) *(height/100));
	if (bmi<=18.4) {
	
	if(sex=="男"){
	
		$("#img_result").attr("src","img/male_01.jpg");
		
	}else{
		$("#img_result").attr("src","img/female_01.jpg");
	}

	$("#bmi_result").html("<p>BMI&nbsp;偏瘦</p>")
	$("#bmi_idealWeight").html("<p>偏瘦体重</p>")
	} else if(bmi<=23.9&&bmi>=18.5){
		
		
	if(sex=="男"){
	$("#img_result").attr("src","img/male_02.jpg");
	}else{
	$("#img_result").attr("src","img/female_02.jpg"); 
	}
	$("#bmi_result").html( "<p>BMI&nbsp;正常</p>");
	$("#bmi_idealWeight").html("<p>理想体重</p>") ;
	}else if(bmi>=24&&bmi<=27.9){
	
		if(sex=="男"){
	$("#img_result").attr("src","img/male_03.jpg");
	}else{
	$("#img_result").attr("src","img/female_03.jpg")
	}
	$("#bmi_result").html("<p>BMI&nbsp;过重</p>") 
	$("#bmi_idealWeight").html("<p>偏胖体重</p>") 
	}else{
	if(sex=="男"){
	$("#img_result").attr("src","img/male_04.jpg"); 
	}else{
	$("#img_result").attr("src","img/female_04.jpg"); 
	}
	$("#bmi_result").html("<p>BMI&nbsp;肥胖</p>")
	$("#bmi_idealWeight").html("<p>肥胖体重</p>")
	}
	
}
	

