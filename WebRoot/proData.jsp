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
</head>
<SCRIPT language=JavaScript>
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
    document.getElementById("fom").action="xiangmu.htm";
   document.getElementById("fom").submit();
}

</SCRIPT>

<body>
<form name="fom" id="fom" method="post" action="">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
 
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="images/nav04.gif">
          
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="679" align="left"><a href="#" onclick="sousuo()"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </a></td>	
		  </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">

        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
	         
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">

					                  <tr>
                    <td height="20" colspan="9" align="center" bgcolor="#EEEEEE"class="tablestyle_title"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 项目明细列表 &nbsp;</td>
                    </tr>
                  <tr>
				    <td width="15%" height="20" align="right" bgcolor="#FFFFFF">项目名称:</td>
                    <td width="85%" align="left" bgcolor="#FFFFFF">${pro.proName }</td>
                    </tr>
					<tr>
				    <td height="20" align="right" bgcolor="#FFFFFF">客户名称:</td>
                    <td bgcolor="#FFFFFF">${pro.client.clientName }</td>
                    </tr>
                  <tr>
				    <td height="20" align="right" bgcolor="#FFFFFF">项目经理:</td>
                    <td bgcolor="#FFFFFF">${pro.emp.empName }</td>
                    </tr>
					<tr>
				    <td height="20" align="right" bgcolor="#FFFFFF">项目金额:</td>
                    <td bgcolor="#FFFFFF">${pro.proAmount }</td>
                    </tr>
                  <tr>
				   <td height="20" align="right" bgcolor="#FFFFFF">开发人数:</td>
                    <td bgcolor="#FFFFFF">${pro.devNum }</td>
                    </tr>
					<tr>
				    <td align="right" bgcolor="#FFFFFF">计划启动日期:</td>
                    <td bgcolor="#FFFFFF">${pro.startDate }</td>
                    </tr>
                  <tr>
				    <td align="right" bgcolor="#FFFFFF">计划完成日期:</td>
                    <td bgcolor="#FFFFFF">${pro.endDate }</td>
                    </tr>
					<tr>
				    <td align="right" bgcolor="#FFFFFF">实际启动日期:</td>
                    <td bgcolor="#FFFFFF">${pro.startDate }</td>
                    </tr>
                  <tr>
				    <td align="right" bgcolor="#FFFFFF">实际完成日期:</td>
                    <td bgcolor="#FFFFFF">${pro.endDate }</td>
                    </tr>
				<tr>
				    <td align="right" bgcolor="#FFFFFF">立项日期:</td>
                    <td bgcolor="#FFFFFF">${pro.createDate }</td>
                    </tr>
				<tr>
				    <td align="right" bgcolor="#FFFFFF">更新日期:</td>
                    <td bgcolor="#FFFFFF">${pro.createDate }</td>
                    </tr>
                  <tr>
				    <td align="right" bgcolor="#FFFFFF">优先级别:</td>
                    <td bgcolor="#FFFFFF">${pro.priority.priorityName }</td>
                    </tr>
					<tr>
				    <td align="right" bgcolor="#FFFFFF">是否超期:</td>
                    <td bgcolor="#FFFFFF">否</td>
                    </tr>
					<tr>
				    <td align="right" bgcolor="#FFFFFF">超期天数:</td>
                    <td bgcolor="#FFFFFF">0</td>
                    </tr>
                  <tr>
				    <td align="right" bgcolor="#FFFFFF">完成状态:</td>
                    <td bgcolor="#FFFFFF">${pro.proState.proState }</td>
                    </tr>
					<tr>
				    <td align="right" bgcolor="#FFFFFF">项目备注:</td>
                    <td bgcolor="#FFFFFF"><textarea  rows="8" cols="80" >${pro.remark }</textarea></td>
                    </tr>
                </table></td>
              </tr>
            </table></td>
        </tr>
      </table>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
	        <tr>
				<td align="center" height="50px">
					<input type="button" name="submit" id="submit" onclick="alert('打印成功');window.history.go(-1);" value="打印" />
					<input type="button" name="back" id="back" onclick="window.history.go(-1);" value="返回"/>
				</td>
			</tr>
          </table></td>
        </tr>
      </table></td>
  </tr>
</table>
</form>
</body>
</html>
