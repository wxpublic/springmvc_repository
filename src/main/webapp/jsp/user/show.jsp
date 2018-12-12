<%-- Created by IntelliJ IDEA. User By: Mr Chen 上午 10:54 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>用户:<${user.nickname}>详细信息页面</title>
</head>
<body>
    <table width="700" align="center" border="1px" style="border:solid 1px yellowgreen">
        <tr>
            <td>用户标识</td>
            <td>${user.id }</td>
        </tr>
        <tr>
            <td>用户名</td>
            <td>${user.username }</td>
        </tr>
        <tr>
            <td>用户密码</td>
            <td>********</td>
        </tr>
        <tr>
            <td>用户昵称</td>
            <td>${user.nickname }</td>
        </tr>
        <tr>
            <td>用户邮箱</td>
            <td>${user.email }</td>
        </tr>
        <tr>
            <td>附件</td>
            <td><a href="download/${user.id }">${user.attachs }</a></td>
        </tr>
    </table>
</body>
</html>
