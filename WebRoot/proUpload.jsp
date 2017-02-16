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
    document.getElementById("fom").action="xiangmuwenjian.htm";
   document.getElementById("fom").submit();
}

</SCRIPT>

<body>
<form name="fom" id="fom" method="post" action="">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  
  <tr>
    <td height="30">      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td height="62" background="../images/nav04.gif"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
              <td width="21"><img src="../images/ico07.gif" width="20" height="18" /></td>
              <td width="538">�ļ����ѯ��
                <input name="textfield" type="text" size="12" readonly="readonly"/>
                  <input name="Submit4" type="button" class="right-button02" value="�� ѯ" /></td>
              <td width="144" align="left"><a href="#" onclick="sousuo()">
                <input name="Submit3" type="button" class="right-button07" value="�߼�����" />
              </a></td>
            </tr>
          </table></td>
        </tr>
    </table></td></tr>
  <tr>
    <td><table id="subtree1" style="DISPLAY: " width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
          	 <tr>
               <td height="20"><span class="newfont07">ѡ��<a href="#" class="right-font08" onclick="selectAll();">ȫѡ</a>-<a href="#" class="right-font08" onclick="unselectAll();">��ѡ</a></span>
	              <input name="Submit" type="button" class="right-button08" value="ɾ����ѡ�ļ�" />
	              <input name="Submit2" type="button" class="right-button08" value="�ϴ��ļ�" onclick="link();"/></td>
          	 </tr>
              <tr>
                <td height="40" class="font42">
				<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
				 <tr class="CTitle" >
                    	<td height="22" colspan="6" align="center" style="font-size:16px">�ļ���ϸ�б�</td>
                  </tr>
                  <tr bgcolor="#EEEEEE">
				    <td width="4%" align="center" height="30">ѡ��</td>
                    <td width="10%">�ϴ����</td>
					<td width="10%">�ϴ���</td>
					<td width="10%">�ϴ�ʱ��</td>
                    <td width="10%">������Ŀ</td>
					<td width="8%">����</td>
                  </tr>
                  <tr bgcolor="#FFFFFF">
				    <td height="20"><input type="checkbox" name="delid"/></td>
                    <td><a href="listshangchuanmingxi.htm" onclick="">�ϴ�XX</a></td>
					<td>XXXX</td>
                    <td>XX��XX��</td>
                    <td>XXXXϵͳ</td>
                    <td><a href="#" onclick="">����</a>|<a href="#" onclick="">ɾ��</a></td>
                  </tr>
				  <tr bgcolor="#FFFFFF">
				    <td height="20"><input type="checkbox" name="delid"/></td>
                    <td><a href="listshangchuanmingxi.htm" onclick="">�ϴ�XX</a></td>
					<td>XXXX</td>
                    <td>XX��XX��</td>
                    <td>XXXXϵͳ</td>
                    <td><a href="#" onclick="">����</a>|<a href="#" onclick="">ɾ��</a></td>
                  </tr>
				  <tr bgcolor="#FFFFFF">
				    <td height="20"><input type="checkbox" name="delid"/></td>
                    <td><a href="listshangchuanmingxi.htm" onclick="">�ϴ�XX</a></td>
					<td>XXXX</td>
                    <td>XX��XX��</td>
                    <td>XXXXϵͳ</td>
                    <td><a href="#" onclick="">����</a>|<a href="#" onclick="">ɾ��</a></td>
                  </tr>
				  <tr bgcolor="#FFFFFF">
				    <td height="20"><input type="checkbox" name="delid"/></td>
                    <td><a href="listshangchuanmingxi.htm" onclick="">�ϴ�XX</a></td>
					<td>XXXX</td>
                    <td>XX��XX��</td>
                    <td>XXXXϵͳ</td>
                    <td><a href="#" onclick="">����</a>|<a href="#" onclick="">ɾ��</a></td>
                  </tr>
				  <tr bgcolor="#FFFFFF">
				    <td height="20"><input type="checkbox" name="delid"/></td>
                    <td><a href="listshangchuanmingxi.htm" onclick="">�ϴ�XX</a></td>
					<td>XXXX</td>
                    <td>XX��XX��</td>
                    <td>XXXXϵͳ</td>
                    <td><a href="#" onclick="">����</a>|<a href="#" onclick="">ɾ��</a></td>
                  </tr>
				  <tr bgcolor="#FFFFFF">
				    <td height="20"><input type="checkbox" name="delid"/></td>
                    <td><a href="listshangchuanmingxi.htm" onclick="">�ϴ�XX</a></td>
					<td>XXXX</td>
                    <td>XX��XX��</td>
                    <td>XXXXϵͳ</td>
                    <td><a href="#" onclick="">����</a>|<a href="#" onclick="">ɾ��</a></td>
                  </tr>
            </table></td>
        </tr>
      </table>
      <table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td height="6"><img src="../images/spacer.gif" width="1" height="1" /></td>
        </tr>
        <tr>
          <td height="33"><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
              <tr>
                <td width="50%">�� <span class="right-text09">5</span> ҳ | �� <span class="right-text09">1</span> ҳ</td>
                <td width="49%" align="right">[<a href="#" class="right-font08">��ҳ</a> | <a href="#" class="right-font08">��һҳ</a> | <a href="#" class="right-font08">��һҳ</a> | <a href="#" class="right-font08">ĩҳ</a>] ת����</td>
                <td width="1%"><table width="20" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                      <td width="1%"><input name="textfield3" type="text" class="right-textfield03" size="1" /></td>
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
