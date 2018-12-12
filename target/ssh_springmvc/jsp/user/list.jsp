<%-- Created by IntelliJ IDEA. User By: Mr Chen 下午 9:54 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>用户列表页面</title>
</head>
<body>
<table width="700" align="center" border="1px" style="border:solid 1px yellowgreen">
    <tr>
        <td>用户标识</td>
        <td>用户名</td>
        <td>用户昵称</td>
        <td>用户密码</td>
        <td>用户邮箱</td>
        <td>附件</td>
        <td align="center">操 作</td>
    </tr>
    <c:if test="${pagers.total le 0}">
        <tr>
            <td colspan="6">目前还没有用户数据O(∩_∩)O哈哈~</td>
        </tr>
    </c:if>
    <c:if test="${pagers.total gt 0}">
        <c:forEach items="${pagers.datas}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.username}</td>
                <td><a href="${u.id}">${u.nickname}</a></td>
                <td>${u.password}</td>
                <td>${u.email}</td>
                <td>
                    <c:choose>
                        <c:when test="${fn:length(u.attachs) > 10 }">
                            ${fn:substring(u.attachs,0,10)}...
                        </c:when>
                        <c:otherwise>
                            ${u.attachs}
                        </c:otherwise>
                    </c:choose>
                </td>
                <td align="center"><a href="${u.id}/update">更新</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${u.id}/delete">删除</a></td>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="6">
                <jsp:include page="/jsp/pager.jsp">
                    <jsp:param name="url" value="users" />
                    <jsp:param name="items" value="${pagers.total}" />
                </jsp:include>
            </td>
        </tr>
    </c:if>
</table>
</body>
</html>
