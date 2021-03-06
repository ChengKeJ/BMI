<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>BMI身体质量指数</title>
<link rel="stylesheet" href="css/bmi.css" />
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>

</head>
<body>

	<div class="div_container">

		<!-- 左侧输入框div -->
		<div class="div_left">
			<!-- 上面的输入信息所在的表格 -->
			<table class="table_msg">
				<tbody>
					<tr>
						<!-- th:表头单元格,td:普通单元格 -->
						<th>BMI计算</th>
					</tr>
					<tr>
						<td class="title">身高:</td>
						<td>
							<!-- 包含一个输入框和一个p标签 -->
							<div class="input_box">
								<!--input height这样命名class具有特殊含义.-->
								<input type="number" class="input height" id="height" />
								<p class="input_unit">厘米</p>
							</div>
						</td>
					</tr>
					<tr>
						<td class="title">体重:</td>
						<td>
							<!-- 包含一个输入框和一个p标签 -->
							<div class="input_box">
								<!--input height这样命名class具有特殊含义.-->
								<input type="number" class="input weight" id="weight" />
								<p class="input_unit">千克</p>
							</div>
						</td>
					</tr>
					<tr>
						<td class="title">性别:</td>
						<td>
							<!-- 包含一个输入框和一个p标签 -->
							<div class="sex">
								<div class="male">
									<label for="male">男</label> <input type="radio" name="sex"
										id="male" checked="checked"  value="男"/>
								</div>
								<div class="female">
									<label for="female">女</label> <input type="radio" name="sex"
										id="female" value="女" />
								</div>
							</div>
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<button class="submit" onclick="calculator()">计算BMI</button>
						</td>
					</tr>
				</tbody>
			</table>
			<!-- 下面的BMI标准范围所在的表格 -->
			<table class="table_bmi">
				<tbody>
					<tr>
						<td>分类</td>
						<td>BMI范围</td>
					</tr>
					<tr>
						<td>偏瘦</td>
						<td><=18.4</td>
					</tr>
					<tr>
						<td>正常</td>
						<td>18.5~23.9</td>
					</tr>
					<tr>
						<td>过重</td>
						<td>24.0~27.9</td>
					</tr>
					<tr>
						<td>肥胖</td>
						<td>>=28.0</td>
					</tr>
				</tbody>
			</table>
		</div>

		<!-- 结果区域div -->
		<div class="div_result">
			<img src="img/male_01.jpg" id="img_result" />
			<p id="bmi_result">BMI&nbsp;正常</p>
			<p id="bmi_idealWeight">理想体重</p>
		</div>

		<!-- 历史记录div -->
		<div class="div_history">
			<table class="table_history" id="table_history">
				<tbody id="tbody">
					<tr class="table_head">
						<td>ID</td>
						<td>日期</td>
						<td>身高</td>
						<td>体重</td>
						<td>BMI</td>
						<td>删除</td>
					</tr>
					
				</tbody>
			</table>
		</div>

	</div>
</body>

<script type="text/javascript" src="js/bim.js"></script>





</html>