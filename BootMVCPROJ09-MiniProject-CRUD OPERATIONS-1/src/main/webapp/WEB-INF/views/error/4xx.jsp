<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h2 style="color :red;text-align :center">Error Page(4xx.jsp)</h2>
<table bgcolor:"cyan" border="1" align="center">
<tr>
<td>Status : </td>
<td>${status} </td>
</tr>
<tr>
<td>Error  : </td>
<td>${error} </td>
</tr>
<tr>
<td>Message:</td>
<td> ${message} </td>
</tr>
<tr>
<td>Path   :</td>
<td> ${path} </td>
</tr>
<tr>
<td>TimeStamp  : </td>
<td>${timestamp} </td>
</tr>
</table>
    