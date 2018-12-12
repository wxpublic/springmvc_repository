<%-- Created by IntelliJ IDEA. User By: Mr Chen 下午 9:54 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
        <title>User Login Page</title>
    </head>
    <body>
        <form method="post">
            <table width="410" align="center" border="1px" style="border:solid 1px yellowgreen">
                <tr>
                    <td>登录名:</td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td>登录密码:</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Login User System">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
