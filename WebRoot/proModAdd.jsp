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
  window.open("��ͻҳ.htm","","depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
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
  <form action="DoProModAddServlet" method="post" name="fom" id="fom" target="sypost" >
<div class="MainDiv">
<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
  <tr>
      <th class="tablestyle_title" >项目模块添加页面</th>
  </tr>
  <tr>
    <td class="CPanel">
		
		<table border="0" cellpadding="0" cellspacing="0" style="width:100%">	
		
		<tr align="center">
          <td class="TablePanel"><select name="select5">
          	  <option>==请选择==</option>
          	  <c:forEach items="${list1 }" var="pro1">
	              <option>${pro1.proName }</option>         	  
          	  </c:forEach>
          </select></td>
		  </tr>
		<TR>
			<TD width="100%">
				<fieldset style="height:100%;">
				<legend>模块</legend>
					  <table border="0" cellpadding="2" cellspacing="1" style="width:100%">
					 
					  <tr>
					    <td nowrap align="right" width="13%">模块名字:</td>
					    <td width="46%"><input name="text" class="text" style="width:300px" type="text" size="40" />
				        <span class="red"> *</span></td>
					    <td align="right" width="9%"></td>
					    <td width="32%">&nbsp;</td>
					    </tr>
					  <tr>
					    
					    <td align="right">所属项目:</td>
					    <td><select name="select7" >
                          <option>==请选择==</option>
			          	  <c:forEach items="${list1 }" var="pro1">
				              <option>${pro1.proName }</option>         	  
			          	  </c:forEach>
                        </select></td>
					  </tr>
					   <tr>
					    <td nowrap align="right">����ִ����:</td>
					    <td><select name="select2" >
                          <option  selected="selected">==��ѡ��==</option>
                          <option>ĳĳĳ</option>
                          <option>һ��</option>
                          <option>��Ҫ</option>
                          <option>��</option>
                          <option>�ܼ�</option>
                        </select></td>
					    <td align="right">���ȼ�:</td>
					    <td><select name="select" >
                          <option  selected="selected">==��ѡ��==</option>
                          <option>�ݲ�</option>
                          <option>һ��</option>
                          <option>��Ҫ</option>
                          <option>��</option>
                          <option>�ܼ�</option>
                        </select></td>
					  </tr>
					  <tr>
					    <td nowrap align="right" height="120px">ģ������:</td>
					    <td colspan="3"><textarea id="textarea" name="textarea" rows="5" cols="80"></textarea></td>
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
			<input type="button" name="Submit" value="����" class="button" onclick="link();"/>��
			
			<input type="button" name="Submit2" value="����" class="button" onclick="window.history.go(-1);"/></TD>
		</TR>
		</TABLE>
	
	
	 </td>
  </tr>
  
  
  
  
  </table>

</div>
</form>
</body>
</html>
