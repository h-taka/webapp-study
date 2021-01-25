<!-- userlist.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="webapp.study.bean.user.*"%>
<jsp:useBean id="userListBean" class="webapp.study.bean.user.UserListBean" scope="request" />
<html>
<head>
<meta charset="UTF-8">
<title>ユーザーリスト</title>
</head>
<body>
<h1>ユーザーリスト</h1>
<table border="1">
<tr><th>id</th><th>name</th><th>email</th><th>更新</th><th>削除</th></tr>

<%
    ArrayList<UserRecordBean> list = userListBean.getUserList();
    for(int i = 0; i < list.size(); i++ ) { 
        UserRecordBean record = list.get(i);
%>

<tr>
<td><%=record.getId() %></td>
<td><%=record.getName() %></td>
<td><%=record.getEmail() %></td>
<td><a href="<%=request.getContextPath() %>/user/updateform?id=<%=record.getId() %>">更新</a></td>
<td><a href="<%=request.getContextPath() %>/user/deleteform?id=<%=record.getId() %>">削除</a></td>
</tr>

<%
    }
%>
</table>
<a href="<%=request.getContextPath() %>/user/entryform">新規登録</a>
</body>
</html>