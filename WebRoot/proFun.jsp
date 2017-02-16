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
	window.location.href="ProFunAddServlet";
}

</SCRIPT>

<body>
<form name="fom" id="fom" method="post" action="">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  
  <tr>
    <td height="30">      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="images/nav04.gif">
            
		   <table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
		    <tr>
			  <td width="21"><img src="images/ico07.gif" width="20" height="18" /></td>
			  <td width="538">查看内容：
               按功能名称：
                <input type="text" name="funName"  value="${funName }"/>
                <input name="Submit4" type="submit" class="right-button02" value="查询" /></td>	
		    </tr>
          </table></td>
        </tr>
    </table></td></tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          	 <tr>
               <td height="20"><span class="newfont07">选择：<a href="#" class="right-font08" onclick="selectAll();"全选</a>-<a href="#" class="right-font08" onclick="unselectAll();">反选</a></span>
	              <input name="Submit" type="button" class="right-button08" value="删除所选功能" />
	              <input name="Submit2" type="button" class="right-button08" value="添加功能" onclick="link();"/></td>
          	 </tr>
              <tr>
                <td height="40" class="font42">
				<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
				 <tr class="CTitle" >
                    	<td height="22" colspan="8" align="center" style="font-size:16px">功能详细列表</td>
                  </tr>
                  <tr bgcolor="#EEEEEE">
				    <td width="4%" align="center" height="30">选择</td>
                    <td width="10%">功能名称</td>
					<td width="10%">创建时间</td>
                    <td width="10%">所属项目</td>
					<td width="10%">任务执行人</td>
					<td width="10%">所属模块</td>
					<td width="5%">优先级</td>
					<td width="12%">操作</td>
                  </tr>
                  <c:forEach items="${list }" var="proFun">
	                  <tr bgcolor="#FFFFFF">
					    <td height="20"><input type="checkbox" name="delid"/></td>
	                    <td>${proFun.funName }</td>
	                    <td bgcolor="#FFFFFF">${proFun.createDate }</td>
	                    <td bgcolor="#FFFFFF">${proFun.mod1.pro1.proName }</td>
	                    <td bgcolor="#FFFFFF">${proFun.emp1.empName }</td>
	                    <td bgcolor="#FFFFFF">${proFun.mod1.modName }</td>
	                    <td bgcolor="#FFFFFF">${proFun.funPriority.funPriorityName }</td>
	                    <td bgcolor="#FFFFFF"><a href="ProFunEditServlet?proFunId=${proFun.funId }">编辑|</a><a href="ProFunDataServlet?proFunId=${proFun.funId }">查看</a>
						</td>
	                  </tr>
                  </c:forEach>
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
          <td width="49%" align="right">[<a href="ProFunServlet?currentPage=1" class="right-font08">首页</a> | <c:if test="${currentPage <= 1 }">上一页</c:if><c:if test="${currentPage > 1 }"><a href="ProFunServlet?currentPage=${currentPage - 1 }" class="right-font08">上一页</a></c:if> | <c:if test="${currentPage < totalPage }"><a href="ProFunServlet?currentPage=${currentPage + 1 }" class="right-font08">下一页</a></c:if><c:if test="${currentPage >= totalPage }">下一页</c:if> | <a href="ProFunServlet?currentPage=${totalPage }" class="right-font08">末页</a>] 转至：</a></td>
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
</body>
</html>
