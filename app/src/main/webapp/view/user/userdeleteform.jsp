<!-- userdeleteform.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="userrecord" class="webapp.study.bean.user.UserRecordBean" scope="request" />
<html>
<head>
<title>ユーザー削除フォーム</title>
</head>
<body>
<h1>ユーザー削除フォーム</h1>
下記の内容を削除します。
<div text-align="center">
<form method="POST" action="<%=request.getContextPath() %>/user/deleteresult">
<table border="1">
    <tr><th>id</th><th>Name</th><th>Email</th></tr>
    <tr>
      <td><jsp:getProperty name="userrecord" property="id"/></td>
      <td><jsp:getProperty name="userrecord" property="name"/></td>
      <td><jsp:getProperty name="userrecord" property="email"/></td>
    </tr>
</table>
<input type="hidden" name= "id" value="<jsp:getProperty name="userrecord" property="id"/>"/>
<input type="hidden" name= "name" value="<jsp:getProperty name="userrecord" property="name"/>"/>
<input type="submit" value="削除"/>
</form>
</div>
<a href="<%=request.getContextPath() %>/user/list">キャンセル</a>
</body>
</html>