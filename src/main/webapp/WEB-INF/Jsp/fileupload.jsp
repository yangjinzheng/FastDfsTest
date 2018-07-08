<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2018/7/7
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
    <script type="text/javascript" src="js/jquery.form.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/fileinput.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body>
<form role="form" method="post"  action="/upload"  enctype="multipart/form-data" >
    <input  type="file" class="file" name="file">
    <button type="submit" class="btn btn-default col-sm-2 col-sm-offset-4">提交</button>
    <a href="/download?group=group1&&filename=M00/00/00/rBAuX1tBacWAP_TTAAA--vFfL_U30.docx">下载</a>
</form>
</body>
</html>
