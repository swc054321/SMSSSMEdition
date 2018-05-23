<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/22
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="downloadFile.action" method="post">
    <input type="text" name="filename">
    <input type="submit" value="下载">

</form>

<form enctype="multipart/form-data" method="post" id="form1">
    <ul>
        <li>
            用户名:<input type="text" name="username">
        </li>
        <li>
            <input type="file" name="file">
        </li>
        <li>
            <input type="file" name="file">
        </li>
        <li>
            <input type="file" name="file">
        </li>
        <li>
            <input type="button" value="ajax上传" id="ajaxbtn">
        </li>
    </ul>



</form>

<script src="js/jquery-1.12.4.js"></script>
<script>
    $(function () {
        $("#ajaxbtn").click(function () {
            var formData=new FormData($("#form1")[0]);
            $.ajax({
                url:'uploadFile.action',
                data:formData,
                contentType:false,
                processData:false,
                type:'post',
                dataType:'text',
                success:function (data) {
                    alert("成功")
                },
                error:function () {
                    alert("internalError")
                }


            })
        })
    })




</script>
</body>
</html>
