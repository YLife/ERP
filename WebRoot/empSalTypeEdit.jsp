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

<style type="text/css">
<!--
.atten {font-size:12px;font-weight:normal;color:#F00;}
-->
</style>
</head>

<body class="ContentBody">
<form action="DoEmpSalTypeEditServlet" method="post" name="form" target="sypost" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >工资分类录入</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		</TABLE>
	
	
	 </td>
  </tr>
  <TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>工资分类信息</legend>
					  <input type="hidden" value="${entity.salTypeId }" name="empSalTypeId"/>
					  <table border="0" cellpadding="5" cellspacing="1" style="width:100%">
					    
					  <tr>
                        <td nowrap="nowrap" align="right">工资类型:</td>
					    <td><span class="red">
					   	  <input name="empSalTypeName" type="text" class="text" style="width:154px" value="${entity.salTypeName }"/>
					      *</span></td>
					    <td align="right">工资金额范围:</td>
					    <td><span class="red">
					      <input name="empSalTypeAmount" type="text" class="text" style="width:154px" value="${entity.salTypeAmount }"/>
					    </span></td>
					    </tr>
					  <tr>
					    <td width="14%" align="right" nowrap>备注:</td>
					    <td width="86%" colspan="3"><textarea name="empSalTypeRemark" cols="105" rows="20">${entity.salTypeRemark }</textarea></td>
					  </tr>
					  </table>
			  <br />
				</fieldset>			</TD>
			
		</TR>

		
		
		
		
		
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
