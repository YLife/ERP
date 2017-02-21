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
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.tabfont01 {	
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}
.font051 {font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}
.font201 {font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}
.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}
html { overflow-x: auto; overflow-y: auto; border:0;} 
-->
</style>

<link href="css/css.css" rel="stylesheet" type="text/css" />
<script type="text/JavaScript">

</script>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<SCRIPT type="text/JavaScript">
function sousuo(){
	window.open("gaojisousuo.htm","","depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}
function selectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			obj[i].checked = true;
		}
	}
}

function unselectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "delid"){
			if (obj[i].checked==true) obj[i].checked = false;
			else obj[i].checked = true;
		}
	}
}

function link(){
    document.getElementById("fom").action="xuqiumingxi.html";
   document.getElementById("fom").submit();
}
</SCRIPT>
</head>

<body>
	<form name="fom" id="fom" method="post">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="30">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td height="62" style="background-image: url('images/nav04.gif');">
								<table width="98%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="21">&nbsp;</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td><table id="subtree1" style="DISPLAY: " width="100%"
						border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td><table width="95%" border="0" align="center"
									cellpadding="0" cellspacing="0">
									<tr>
										<td height="40" class="font42"><table width="100%"
												border="0" cellpadding="4" cellspacing="1" bgcolor="#464646"
												class="newfont03">

												<tr>
													<td height="20" colspan="2" align="center"
														bgcolor="#EEEEEE" class="tablestyle_title">
														&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
														客户详细内容</td>
												</tr>
												<tr>
													<td width="16%" height="20" align="right" bgcolor="#FFFFFF">公司名称:</td>
													<td width="84%" colspan="2" bgcolor="#FFFFFF">${client.clientComp }</td>
												</tr>
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">联系人:</td>
													<td colspan="2" bgcolor="#FFFFFF">${client.clientName }</td>
												</tr>
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">联系电话:</td>
													<td colspan="2" bgcolor="#FFFFFF">${client.clientPhone }</td>
												</tr>
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">联系地址:</td>
													<td colspan="2" bgcolor="#FFFFFF">${client.clientAdd }</td>
												</tr>
												<tr>
													<td height="20" align="right" bgcolor="#FFFFFF">添加日期:</td>
													<td colspan="2" bgcolor="#FFFFFF">${client.clientDate }</td>
												</tr>

												<tr>
													<td height="85" align="right" bgcolor="#FFFFFF">公司背景:</td>
													<td colspan="2" bgcolor="#FFFFFF">${client.clientBack }</td>
												</tr>
											</table></td>
									</tr>
								</table></td>
						</tr>
					</table>
					<table width="95%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td height="6"><img src="images/spacer.gif" width="1"
								height="1" /></td>
						</tr>
						<tr>
							<td align="center" height="50px">
								<input type="button" name="submit" id="submit" onclick="alert('打印成功')" value="打印" />
								<input type="button" name="back" id="back" onclick="window.history.go(-1);" value="返回"/>
							</td>
						</tr>
						
					</table></td>
			</tr>
		</table>
	</form>
</body>
</html>
