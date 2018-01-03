<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改图书类型</title>
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>
</head>
<BODY>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/Category_update"
		>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：图书类型管理 &gt; 修改图书类型</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
						  
							<TR>
								<td>图书类型名称：</td>
								<td>
								<input type="hidden" value="${ca.id }" name="category.id">
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="category.name" value="${ca.name}">
								</td>
								<td>描述：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="category.description" value="${ca.description }">
								</td>
							</TR>
							
	
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value=" 修改" name=sButton2>
								</td>
							</tr>
						</TABLE>
						
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</html>