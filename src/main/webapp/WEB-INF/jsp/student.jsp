<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.Date, model.Student"%>

<%
//リクエストスコープからインスタンスを取得
Student student = (Student) request.getAttribute("student");
String noStudent = (String) request.getAttribute("noStudent");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/color.css">
<title>教習所システム</title>
</head>
<body>
	<h1>教習所システム</h1>
	<br>
	<h2>生徒入力名簿</h2>

	<form id="search" method="post">
		<table class="form_table">
			<tr>
				<td><input class="form" type="text" name="student_id"
					placeholder="生徒ID" required form="search del"></td>
			</tr>
			<%
			if (noStudent != null) {
			%>
			<tr>
				<td><%=noStudent%></td>
			</tr>
			<%
			}
			%>
			<tr>
				<td><span class="button_wrapper">
						<button type="submit" id="gradual" name="submit" form="search"
							value="search" formaction="/driving_school/StudentServlet">問合せ</button>
					</span>
				<span class="button_wrapper">
						<button type="submit" id="gradual" name="submit" value="del" form="del"
						formaction="/driving_school/StudentServlet">削除</button>
				</span>
				
				</td>
			</tr>			
		</table>
	</form>

	<form id="add" action="/driving_school/StudentServlet"
		method="post">
		<table class="form_table">
			<tr>
				<td>生年月日(例 1999/01/01)<input class="form" type="text"
					id="birthday" name="birth_year" placeholder="年" required
					pattern="19[0-9][0-9]|20[0-2][0-9]" title="半角数字"
					form="add mod"
					<%if (student.getBirthday() != null) {%>
					value=<%=student.getBirthday().substring(0, 2)%> <%}%>>/<input
					class="form" type="text" id="birthday" name="birth_manth"
					placeholder="月" <%if (student.getBirthday() != null) {%>
					value=<%=student.getBirthday().substring(2, 4)%> <%}%> required
					pattern="0[1-9]|1[0-2]" title="半角数字" form="add mod">/<input
					class="form" type="text" id="birthday" name="birth_day"
					placeholder="日" <%if (student.getBirthday() != null) {%>
					value=<%=student.getBirthday().substring(4, 6)%> <%}%> required
					pattern="0[1-9]|[12][0-9]|3[01]" title="半角数字"
					form="add mod"></td>
			</tr>


			<tr>
				<td><input class="form" type="text" name="address"
					placeholder="住所" <%if (student.getAddress() != null) {%>
					value=<%=student.getAddress()%> <%}%> required
					form="add mod"></td>
			</tr>
			<tr>
				<td>性別<br> <input type="radio" name="gender" value=1
					<%if (1 == student.getGender()) {%> checked <%}%> required
					form="add mod"> 男性 <input type="radio"
					name="gender" value=2 <%if (2 == student.getGender()) {%> checked
					<%}%> form="add mod"> 女性
				</td>
			</tr>
			<tr>
				<td><input class="form" type="text" name="phone_number1"
					placeholder="連絡先１" required
					<%if (student.getPhone_number1() != null) {%>
					value=<%=student.getPhone_number1()%> <%}%>
					form="add mod"></td>
			</tr>
			<tr>
				<td><input class="form" type="text" name="phone_number2"
					placeholder="連絡先２" required
					<%if (student.getPhone_number2() != null) {%>
					value=<%=student.getPhone_number2()%> <%}%>
					form="add mod"></td>
			</tr>
		</table>
		<div class="cp_ipselect">
			<select name="request_course" class="cp_sl06" required
				form="add mod">
				<option value="" hidden disabled selected></option>
				<option value="01"
					<%if ("01".equals(student.getRequest_course())) {%> selected <%}%>>普通車MT
					原付・二輪免許無し</option>
				<option value="02"
					<%if ("02".equals(student.getRequest_course())) {%> selected <%}%>>普通車MT
					原付・二輪免許有り</option>
				<option value="03"
					<%if ("03".equals(student.getRequest_course())) {%> selected <%}%>>普通車AT
					原付・二輪免許無し</option>
				<option value="04"
					<%if ("04".equals(student.getRequest_course())) {%> selected <%}%>>普通車AT
					原付・二輪免許有り</option>
				<option value="05"
					<%if ("05".equals(student.getRequest_course())) {%> selected <%}%>>普通車MT
					仮免許有り</option>
				<option value="06"
					<%if ("06".equals(student.getRequest_course())) {%> selected <%}%>>普通車AT
					仮免許有り</option>
				<option value="07"
					<%if ("07".equals(student.getRequest_course())) {%> selected <%}%>>普通車MT
					AT限定免許有り</option>
			</select> <span class="cp_sl06_highlight"></span> <span
				class="cp_sl06_selectbar"></span> <label class="cp_sl06_selectlabel">希望コース</label>
		</div>
		<p>
			眼鏡<br> <input type="radio" name="glasses" value=0
				<%if (0 == student.getGlasses()) {%> checked <%}%> required
				form="add mod"> 有り <input type="radio"
				name="glasses" value=1 <%if (1 == student.getGlasses()) {%> checked
				<%}%> form="add mod"> 無し
		</p>
		<table class="form_table">
			<tr>
				<td><input class="form" type="date" name="starting_date"
					placeholder="開始日" <%if (student.getStarting_date() != null) {%>
					value=<%=student.getStarting_date()%> <%}%> required
					pattern="^[0-9]+$" title="半角数字" form="add mod"></td>
			</tr>
			<tr>
				<td><input class="form" type="date" name="reception_date"
					placeholder="受付日" <%if ((student.getReception_date() != null)) {%>
					value=<%=student.getReception_date()%> <%}%> required
					pattern="^[0-9]+$" title="半角数字" form="add mod"></td>
			</tr>
			<tr>
				<td><input class="form" type="text" placeholder="受付担当者ID"
					name="reception_employee" maxlength="8"
					<%if ((student.getReception_employee() != null)) {%>
					value=<%=student.getReception_employee()%> <%}%> required
					pattern="^[0-9]+$" title="半角数字" form="add mod"></td>
			</tr>
			<tr>
				<td>受付担当者名称：</td>
			</tr>
			<tr>
				<th></th>
			</tr>
		</table>
		<pre>
		</pre>

		<span class="button_wrapper" style="display: inline">
			<button type="submit" id="gradual" name="submit" value="add">登録</button>
		</span>
	</form>
	<form name="mod" action="/driving_school/StudentServlet" method="post">
		<span class="button_wrapper">
			<button type="submit" id="gradual" name="submit" value="mod">修正</button>
		</span>
	</form>

	<form name="del" action="/driving_school/StudentServlet" method="post"
		onSubmit="return check()">
	</form>

	<br>

	<div class="button_wrapper">
		<button type="button" id="gradual" onclick="history.back()">終了</button>
	</div>

	<!-- 	<script>
	
	//buttonタグごとに送信先のコントローラを指定するための関数
    function submitForm(action)
    {
        document.getElementById('columnarForm').action = action;
        document.getElementById('columnarForm').submit();
    }
	</script>  

	<script type="text/javascript">
		function searchTextSubmit() {
			document.searchForm.mode.value = "searchText";
			document.searchForm.submit();
		}

		function registerTextSubmit() {
			document.registerForm.mode.value = "registerText";
			document.registerForm.submit();
		}
	</script >-->
</body>
</html>