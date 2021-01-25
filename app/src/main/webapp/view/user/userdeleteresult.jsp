<!-- userdeleteresult.jsp -->
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="userrecord" class="webapp.study.bean.user.UserRecordBean" scope="request" />
<html>
<head>
<title>ユーザー削除結果</title>
</head>
<body>
<h1>ユーザー削除結果</h1>
<p><jsp:getProperty name="userrecord" property="name"/> を削除しました。</p>
<a href="<%=request.getContextPath() %>/user/list">ユーザーリスト</a>
</body>
</html>