<%-- Created by IntelliJ IDEA. User By: Mr Chen 下午 12:31 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title><decorator:title default="欢迎使用用户管理系统" /></title>
<decorator:head />
</head>
<script type="text/javascript">
function logout(inparam) {
    if(confirm("确定退出系统？")){
        inparam.href = "<%=request.getContextPath()%>/logout";
    }
}
</script>
</javascript>
<body>
<table width="700" align="center" border="0">
    <tr>
        <td align="center" colspan="2"><h1><decorator:title /></h1></td>
    </tr>
    <c:if test="${not empty loginUser}">
        <tr><td colspan="2"><a href="<%=request.getContextPath()%>/user/add">添加用户</a></td></tr>
        <tr>
            <td><a href="<%=request.getContextPath()%>/user/users">用户列表</a></td>
            <td align="right"><a href="" onclick="logout(this)">退出系统</a></td>
        </tr>
    </c:if>
</table>
<hr style="border: 1px dotted #036;" />
<decorator:body />
<div align="center" style="width: 100%;border-top: 1px dotted #036;float: left;margin-top: 10px">
    CopyRight@2012-2015<br/>
    开发培训教学项目
</div>
</body>
</html>
