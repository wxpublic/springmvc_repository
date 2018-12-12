<%-- Created by IntelliJ IDEA. User By: Mr Chen 上午 10:54 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>用户添加页面</title>
</head>
<body>
<sf:form method="post" modelAttribute="user" enctype="multipart/form-data">
    <table width="700" align="center" border="1px" style="border:solid 1px yellowgreen">
        <tr>
            <td>用户名</td>
            <td><sf:input path="username" /><sf:errors path="username"/></td>
        </tr>
        <tr>
            <td>用户密码</td>
            <td><sf:password path="password" /><sf:errors path="password"/></td>
        </tr>
        <tr>
            <td>用户昵称</td>
            <td><sf:input path="nickname" /></td>
        </tr>
        <tr>
            <td>用户邮箱</td>
            <td><sf:input path="email" /><sf:errors path="email"/></td>
        </tr>
        <tr>
            <td>上传附件</td>
            <td>请选择:<input type="file" name="attach"></td>
        </tr>
        <tr><td colspan="2" align="center"><input type="submit" value="User Info Add"></td></tr>
    </table>
</sf:form>
</body>
</html>
