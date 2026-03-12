<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1 style="color:green;text-align:center">Report Page</h1>

<c:choose>
		<c:when test="${!empty listEmps}" >
		<table align="center" bgcolor="cyan" border="1">
		<tr>
			<th>EmpNo</th><th>Name</th><th>Address</th><th>Salary</th><th>Designation</th><th>GrossSalary</th><th>NetSalary</th><th>Operations</th>
		</tr>
		<c:forEach var="emp" items="${listEmps}">
		<tr>
		<td>${emp.empno }</td>
		<td>${emp.empName }</td>
		<td>${emp.empAdd }</td>
		<td>${emp.empSal}</td>
		<td>${emp.empDesg}</td>
		<td>${emp.grossSalary}</td>
		<td>${emp.netSalary}</td>
		<td><a href="./edit?sno=${emp.empno}"><img src="images/edit.jpg" height="30px" width="40px"></a>
		&nbsp;&nbsp;&nbsp;
		<a href="./delete?sno=${emp.empno}" onclick="return confirm('Do you want to delete?')"><img src="images/delete.jpg" height="30px" width="40px"></a>
		</td>
		</tr>
		</c:forEach>
		</table>
		</c:when>
		<c:otherwise>
		<h1 style="color:blue;text-align:center">Records Not Found</h1>
		</c:otherwise>
</c:choose>
<br/><br/><br/>
<h1 style="color:green;text-align:center">${resultMsz}</h1>
<br/><br/><br/>
<h1 style="text-align:center"><a href="./add">Add New Report <img src="images/add.jpg" height="70px" width="90px"> </a></h1>
<h1 style="color:red;text-align:center"><a href="./">Go To HomePage<img src="images/home.jpg" height="70px" width="90px"></a></h1>
