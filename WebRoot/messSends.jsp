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
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/xiangmu.js"></script>
</head>
<SCRIPT language=JavaScript>
function sousuo(){
	window.open("gaojisousuo.htm","","depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
}
function selectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "choose"){
			obj[i].checked = true;
		}
	}
}

function unselectAll(){
	var obj = document.fom.elements;
	for (var i=0;i<obj.length;i++){
		if (obj[i].name == "choose"){
			if (obj[i].checked==true) obj[i].checked = false;
			else obj[i].checked = true;
		}
	}
}

function link(){
    window.location.href="MessSendServlet";
}

function on_load(){
	var loadingmsg=document.getElementById("loadingmsg");
	var mainpage=document.getElementById("mainpage");
	loadingmsg.style.display="";
	mainpage.style.display="none";
	
	loadingmsg.style.display="none";
	mainpage.style.display="";
}
function del() {
	 var fom = document.getElementById("fom");
	 fom.action = "MessSendsDelServlet";
	 fom.submit();
}
</SCRIPT>

<body onload="on_load()">
<form name="fom" id="fom" method="post" action="MessSendsServlet">
<table id="mainpage" width="100%" border="0" cellspacing="0" cellpadding="0">

  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="62" background="images/nav04.gif">
          
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
			<td width="21"><img src="images/ico07.gif" width="20" height="18" /></td>
			<td width="550">查看内容：按时间
			 <input name="begin" type="text" size="12" value="${begin }"/><span class="newfont06">至</span>
			 <input name="end" type="text" size="12" value="${end }"/>	
			 <input name="Submit" type="submit" class="right-button02" value="查询" />
			 </td>
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
               <td height="20"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();">全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
                 <input name="Submit3" type="button" class="right-button08" value="删除所选信息" onclick="del()"/>
                 <input name="Submit2" type="button" class="right-button08" value="添加信息" onclick="link();"/></td>
          	 </tr>
              <tr>
                <td height="40" class="font42"><table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
                  <tr>
                    <td height="20" colspan="14" align="center" bgcolor="#EEEEEE"class="tablestyle_title">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 接收信息列表 &nbsp;</td>
                  </tr>
                  <tr>
                    <td width="14%" align="center" bgcolor="#EEEEEE">选择</td>
                    <td width="19%" height="20" align="center" bgcolor="#EEEEEE">标题</td>
                    <td width="20%" align="center" bgcolor="#EEEEEE">收件人</td>
                    <td width="21%" align="center" bgcolor="#EEEEEE">查看时间</td>
                    <td width="26%" align="center" bgcolor="#EEEEEE">操作</td>
                  </tr>
                  <c:forEach items="${list }" var="mess">
	                  <tr align="center">
	                    <td bgcolor="#FFFFFF"><input type="checkbox" name="choose" value="${mess.messId }"/></td>
	                    <td height="20" bgcolor="#FFFFFF">${mess.messTitle }</td>
	                    <td bgcolor="#FFFFFF">${mess.getName }</td>
	                    <td bgcolor="#FFFFFF">${mess.sendDate }</td>
	                    <td bgcolor="#FFFFFF"><a href="MessSendsDataServlet?messId=${mess.messId }">查看</a></td>
	                  </tr>
                  </c:forEach>
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
                <td width="50%">共 <span class="right-text09">${totalPage }</span> 页 | 第<span class="right-text09">${currentPage }</span> 页</td>
                <td width="49%" align="right">[<a href="MessGetServlet?currentPage=1" class="right-font08">首页</a> | <c:if test="${currentPage <= 1 }">上一页</c:if><c:if test="${currentPage > 1 }"><a href="MessGetServlet?currentPage=${currentPage - 1 }" class="right-font08">上一页</a></c:if> | <c:if test="${currentPage < totalPage }"><a href="MessGetServlet?currentPage=${currentPage + 1 }" class="right-font08">下一页</a></c:if><c:if test="${currentPage >= totalPage }">下一页</c:if> | <a href="MessGetServlet?currentPage=${totalPage }" class="right-font08">末页</a>] 转至：</a></td>
                <td width="1%"><table width="20" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="1%"><input name="jumpPage" type="text" class="right-textfield03" size="1" value="${jumpPage }"/></td>
                      <td width="87%"><input name="Submit23222" type="submit" class="right-button06" value=" " />
                      </td>
                    </tr>
                </table></td>
              </tr>
          </table></td>
        </tr>
      </table></td>
  </tr>
</table>
</form>

<div id="loadingmsg" style="width:100px; height:18px; top:0px; display:none;">
	<img src="file:///F|/��Ŀ�����������/��Ŀ����ϵͳҳ��/images/loadon.gif" />
</div>

</body>
</html>
