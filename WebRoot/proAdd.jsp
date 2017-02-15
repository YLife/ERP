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
<form action="DoProAddServlet" method="post" name="form" target="sypost" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >项目添加录入</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">
		<tr align="center">
          <td class="TablePanel"></td>
		  </tr>
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>项目信息</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					  <tr>
					    <td nowrap align="right" width="15%">项目名称:</td>
					    <td width="35%"><input name='proName' type="text" class="text" style="width:154px" value="" />
				        <span class="red">*</span></td>
				        	
					    <td nowrap align="right" width="18%">所属单位:</td>
					    <td width="35%"><input name='clientComp' type="text" class="text" style="width:154px" value="" />
				        <span class="red">*</span></td>
					    </tr>
						
						<tr>
					    <td nowrap align="right" width="15%">项目金额:</td>
					    <td width="35%"><input name='proAmount' type="text" class="text" style="width:154px" value="" />				        </td>
				         <td nowrap align="right" width="18%">开发人数:</td>
					    <td width="35%"><input name='devNum' type="text" class="text" style="width:154px" value="" />				        </td>	
						</tr>
						<tr>	
							<td nowrap align="right" width="15%">项目经理:</td>
							<td width="35%">
								<input name='managerName' type="text" class="text" style="width:154px" value="" />						</td>
							<td nowrap align="right" width="18%">完成状态:</td>
							<td width="35%">
							<select id="select1" name="proStateId">
								<option value="">==请选择==</option>
								<option value="1">已完成</option>
								<option value="2">未完成</option>
							</select>							</td>
				        </tr>
						<tr>	
							<td nowrap align="right" width="15%">预算总成本:</td>
							<td width="35%"><input name='proCost' type="text" class="text" style="width:154px" value="" />							</td>
							<td nowrap="nowrap" align="right">计划开发日期:</td>
							<td><input name='startDate' type="text" class="text" style="width:154px" value="" />                            </td>
						</tr>
						<tr>
						  <td nowrap="nowrap" align="right">计划完成日期:</td>
						  <td><input name='endDate' type="text" class="text" style="width:154px" value="" />                          </td>	
							<td  align="right" >优先级:</td>
							<td ><select name="priorityId" >
                                <option  selected="selected">==请选择==</option>
                                <option value="1">不急</option>
                                <option value="2">一般</option>
                                <option value="3">急</option>
                            </select></td>
						</tr>
					  <tr>
					    <td  width="15%" nowrap align="right">备注:</td>
					    <td colspan="3"><textarea name="proRemark" cols="100" rows="10"></textarea></td>
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
