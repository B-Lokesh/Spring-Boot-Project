<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<h1 style="color:green;text-align:center">Editing Details Form </h1>
<frm:form action="edit" method="POST" modelAttribute="Emp">
<table border="1" bgcolor="cyan" align="center">
<tr> <th>Name:</th>
	<td><frm:input path="empno" readonly="true"/> </td>
	</tr>
	<tr> <th>Name:</th>
	<td><frm:input path="empName"/> </td>
	</tr>
	<tr> <th>address:</th>
	<td><frm:input path="empAdd"/> </td>
	</tr>
	<tr> <th>Salary:</th>
	<td><frm:input path="empSal"/> </td>
	</tr>
	<tr> <th>Designation:</th>
	<td><frm:input path="empDesg"/> </td>
	</tr>
	<tr>
		<td><input type="submit" value="Editing"></td>
		<td><input type="reset" value="Cancel"></td>
	</tr>
</table>
</frm:form>