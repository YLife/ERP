<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>项目 管理系统 by www.mycodes.net</title>
<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />


<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">
<form action="DoProFunAddServlet" method="post" name="form" target="sypost" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >项目功能添加页面</th>
  </tr>
  
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		</td>
		</tr>
		<tr align="center">
			<td class="TablePanel" height="30" style="font-size:16px"></td>
		</tr>
		<TR id="zdjh">
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>功能</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					 
					  <tr>
					    <td nowrap align="right" width="15%">功能名称:</td>
					    <td width="35%"><input name='funName' type="text" class="text" style="width:154px"/>
				        <span class="red">*</span></td>
					    <td align="right">任务执行人:</td>
					    <td><input name='empName' type="text" class="text" style="width:154px"/></td>
					  </tr>
					  <tr>
					    <td align="right">优先级:</td>
					    <td><select name="funPriorityId" >
                            <option  selected="selected">==请选择==</option>
                            <c:forEach items="${list1 }" var="pri">
                            	<option value="${pri.priorityId }">${pri.priorityName }</option>
                            </c:forEach>
                        </select></td>
					    <td width="15%"align="right">所属模块:</td>
					    <td width="35%"><span class="TablePanel" style="font-size:16px">
					      <select name="modId" >
                            <option  selected="selected">==请选择==</option>
                            <c:forEach items="${list }" var="proMod">
                            	<option value="${proMod.modId }">${proMod.modName }</option>
                            </c:forEach>
                          </select></td>
					  </tr>
					  <tr>
					    <td align="right">功能描述:</td>
					    <td colspan="3"><textarea name="funRemark" cols="80" rows="6"></textarea></td>
					    </tr>
					  </table>
			  <br />
				</fieldset>
				</TD>
		</TR>
		
		</TABLE>
	
	
	 </td>
  </tr>
  
  
		
	
		<TR>
			<TD colspan="2" align="center" height="50px">
			<input type="submit" name="Submit" value="保存" class="button"/>
			
			<input type="button" name="Submit2" value="返回" class="button" onclick="window.history.go(-1);"/></TD>
		</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  
  </table>

</div>
</form>
</body>
</html>
