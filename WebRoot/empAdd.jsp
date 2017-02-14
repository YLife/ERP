<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

</script>
<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">
<form action="DoEmpAddServlet" method="post" name="form" target="sypost" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >员工基本信息录入</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr><td align="left">
		</td></tr>
				<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>员工信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					 
					  <tr>
					    <td nowrap="nowrap" align="right" width="15%">员工唯一编号:</td>
					    <td width="35%"><input name="empId" type="text" class="text" style="width:154px"/>
				        <span class="red">*</span></td>
					    <td width="16%" align="right" nowrap="nowrap">密码:</td>
					    <td width="34%"><input class="text" type="password" name="empPwd" style="width:154px"/></td>
					  </tr>
					    
					    
					  <tr>
					    <td nowrap="nowrap" align="right">真实姓名:</td>
					    <td><input class="text" type="text" name="empName" style="width:154px"/></td>
					    <td align="right">性别:</td>
					    <td><select name="empSex" >
                            <option selected="selected">==请选择==</option>
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select></td>
					  </tr>
					  
					  
					  <tr>
					    <td align="right">出生日期:</td>
					    <td><input class="text" type="text" name="empBorn" style="width:154px"/></td>
					    <td align="right">身份证号码:</td>
					    <td><input class="text" type="text" name="empNo" style="width:154px"/></td>
					  </tr>
					  <tr>
					    <td align="right">电话号码:</td>
					    <td><input class="text" type="text" name="empPhone" style="width:154px"/></td>
					     <td align="right">入职时间:</td>
					    <td><input class="text" type="text" name="empDate" style="width:154px"/></td>
					  </tr>
					  <tr>
					    <td align="right">职位:</td>
					    <td><select name="jobId" >
                          <option  value="0">==请选择==</option>
                          <option value="1">程序员</option>
                          <option value="2">项目经理</option>
                          <option value="3">经理</option>
                        </select></td>
                        <td align="right">奖金:</td>
					    <td><input class="text" type="text" name="bonus" style="width:154px"/></td>
					  </tr>
					  <tr>
					    
					  </tr>
					  <tr>
					   	<td align="right">员工类型:</td>
					    <td>
						    <select name="typeId" >
	                            <option  value="0">==请选择==</option>
	                            <option value="1">实习</option>
	                            <option value="2">试用</option>
	                            <option value="3">正式员工</option>
	                        </select>
                        </td>
					    <td align="right">其他补助金:</td>
					    <td><input class="text" type="text" name="other" style="width:154px"/></td>
                        
                      </tr>
              		  <tr>
              		  	<td align="right">角色:</td>
					    <td>
						    <select name="roleId" >
	                            <option  value="0">==请选择==</option>
	                            <option value="1">员工</option>
	                            <option value="2">管理员</option>
	                            <option value="3">超级管理员</option>
	                        </select>
                        </td>
					    <td align="right">基本工资:</td>
					    <td><input class="text" type="text" name='baseSal' style="width:154px"/></td>
					  </tr>
					 
					 
					  <tr>
					    <td align="right">描述:</td>
					    <td colspan="3"><textarea name="remark" cols="100" rows="8"></textarea></td>
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
