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
<title>项目管理系统 by www.mycodes.net</title>
<link rel="stylesheet" rev="stylesheet" href="css/style.css" type="text/css" media="all" />


<script language="JavaScript" type="text/javascript">
function tishi()
{
  var a=confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
  if(a!=true)return false;
  window.open("冲突页.htm","","depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}

function check()
{
document.getElementById("aa").style.display="";
}


function link(){
alert('保存成功！');
    document.getElementById("fom").action="xuqiumingxi.htm";
   document.getElementById("fom").submit();
}



</script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">
<form action="DoTaskEditServlet" method="post" name="fom" id="fom" target="sypost" >
<div class="MainDiv">
<input type="hidden" name="taskId" value="${task.taskId }"/>
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >任务修改页面</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		

		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>修改任务</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					 
					  <tr>
					    <td nowrap align="right" width="13%">任务标题:</td>
					    <td width="41%"><input name="taskName" value="${task.taskName }" class="text" style="width:250px" type="text" size="40" />
				        <span class="red"> *</span></td>
					    <td nowrap align="right">所属项目/模块/功能:</td>
					    <td><select name="proId" >
					      <c:forEach items="${list3 }" var="pro">
                          	<option value="${pro.proId }" ${pro.proId == task.pro1.proId ? "selected" : "" }>${pro.proName }</option>
                          </c:forEach>
                        </select>
				<select name="modId" >
					<c:forEach items="${list4 }" var="mod1">
                    	<option value="${mod1.modId }" ${mod1.modId == task.mod1.modId ? "selected" : "" }>${mod1.modName }</option>
					</c:forEach>
                </select>
				<select name="funId" >
					<c:forEach items="${list5 }" var="fun">
                    	<option value="${fun.funId }" ${fun.funId == task.fun1.funId ? "selected" : "" }>${fun.funName }</option>
					</c:forEach>
                </select>
				</td>
					    </tr>
					  <tr>
					    <td nowrap align="right">计划开始时间:</td>
					    <td><input name="createDate" type="text" id="" class="text" style="width:154px" value="${task.createDate }"/></td>
					    <td align="right">计划结束时间:</td>
					    <td><input name="endDate" type="text" value="${task.endDate }" id="Input" class="text" style="width:154px" /></td>
					  </tr>
					   <tr>
					    <td nowrap align="right">任务执行人:</td>
					    <td><select name="empId" >
					      <c:forEach items="${list1 }" var="emp">
                          	<option value="${emp.empId }" ${emp.empId == task.emp1.empId ? "selected" : "" }>${emp.empName }</option>
					      </c:forEach>
                        </select></td>
					    <td align="right">优先级:</td>
					    <td><select name="priorityId" >
					      <c:forEach items="${list2 }" var="priority">
                          	<option value="${priority.priorityId }" ${priority.priorityId == task.priority.priorityId ? "selected" : "" }>${priority.priorityName }</option>
					      </c:forEach>
                        </select></td>
					  </tr>
					  <tr>
					    <td nowrap align="right" height="120px">任务说明:</td>
					    <td colspan="3"><textarea id="textarea" name="taskNote" rows="5" cols="80">${task.taskNote }</textarea></td>
					    </tr>
					  </table>
			 <br />
				</fieldset>			</TD>
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
