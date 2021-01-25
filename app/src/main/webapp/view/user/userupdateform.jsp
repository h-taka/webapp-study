<!-- userupdateform.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="userrecord" class="webapp.study.bean.user.UserRecordBean" scope="request" />
<jsp:useBean id="errormessages" class="java.util.ArrayList" type="java.util.ArrayList<String>" scope="request" />
<html>
<head>
<title>ユーザー更新フォーム</title>
</head>
<body>
<h1>ユーザー更新フォーム</h1>
<div text-align="center">
<form method="POST" action="<%=request.getContextPath() %>/user/updateresult">
<table border="1">
    <tr><td>名前</td><td><input type="text" name="name" value="<jsp:getProperty name="userrecord" property="name"/>"></td></tr>
    <tr><td>Email</td><td><input type="text" name="email" value="<jsp:getProperty name="userrecord" property="email"/>"></td></tr>
</table>
<input type="hidden" name="id" value="<jsp:getProperty name="userrecord" property="id"/>" />
<input type="submit" value="更新" />
</form>
</div>
<% if (errormessages.size() > 0) { %>
<div>
<% for(String message : errormessages) { %>
<p><%=message %></p>
<% } %>
</div>
<% } %>
<a href="<%=request.getContextPath() %>/user/list">キャンセル</a>
</body>
</html>