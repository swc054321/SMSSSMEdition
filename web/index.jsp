<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/14
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
<%--  <form action="selectByPrimaryKey.action" method="post">
    <ul>
      <li>
        ID:<input type="text" name="id">
      </li>
      <li>
        <input type="submit" value="查询">
      </li>
    </ul>
  </form>
  <form action="jumpTo.action">
    <input type="submit" value="跳转">
  </form>

  <form>
    <ul>
      <li>
        ID:<input type="text" name="id" id="id">
      </li>
      <li>
        <input type="button" value="查询" id="btn">
      </li>
    </ul>
  </form>

  <form>
    <ul>
      <li>
        ID:<input type="text" name="id" id="betterid">
      </li>
      <li>
        <input type="button" value="更好的查询" id="betterbutton">
      </li>
    </ul>
  </form>

  <form action="deleteById.action" method="post">
    <ul>
      <li>
        ID:<input type="text" name="deleteid" id="deleteid">
      </li>
      <li>
        <input type="submit" value="删除" id="deletebtn">
      </li>
    </ul>
  </form>

  <form action="insertMember.action" method="post">
    <ul>
      <li>
        ID:<input type="text" name="id" id="insertId">
      </li>
      <li>
        姓名:<input type="text" name="name" id="insertName">
      </li>
      <li>
        性别:<input type="radio" name="sex" value="男">男
        <input type="radio" name="sex" value="女">女
      </li>
      <li>
        薪水:<input type="text" name="salary">
      </li>
      <li>
        <select name="department">
          <option value="生产部">生产部</option>
          <option value="财务部">财务部</option>
          <option value="市场部">市场部</option>
          <option value="人力部">人力部</option>
          <option value="总务部">总务部</option>
        </select>
      </li>
      <li>
        <input type="submit" value="新增" id="insert">
      </li>
    </ul>
  </form>--%>

  <form action="selectMembers.action" method="post">
    <ul>
      <li>
        ID:<input type="text" name="id">
      </li>
      <li>
        Name:<input type="text" name="name">
      </li>
      <li>
        姓名:<input type="radio" name="sex" value="男">男
        <input type="radio" name="sex" value="女">女
      </li>
      <li>
        <input type="submit" value="查询">
      </li>
    </ul>
  </form>

<form action="selectMembersByIds.action" method="post">
  <ul>
    <li>
      ID:<input type="text" name="ids">
    </li>
    <li>
      ID:<input type="text" name="ids">
    </li>
    <li>
      ID:<input type="text" name="ids">
    </li>
    <li>
      <input type="submit" value="查询">
    </li>
  </ul>
</form>

<form>
  <ul>
    <li>
      ID:<input type="text" name="idz">
    </li>
    <li>
      ID:<input type="text" name="idz">
    </li>
    <li>
      ID:<input type="text" name="idz">
    </li>
    <li>
      <input type="button" value="查询" id="btn">
    </li>
  </ul>
</form>

  <script src="js/jquery-1.12.4.js"></script>
  <script>
    $(function () {
        $("#btn").click(function () {
            var idz=[];
            idz=$("input[name='idz']").val();
           $.ajax({
               url:"selectByIdsAjax",
               type:"post",
               data:{ids:idz},
               dataType:"json",
               success:function (data) {
                   console.log(data);
               },
               error:function () {
                   console.log("错误")
               }
           })
        });

        $("#betterbutton").click(function () {
            $.ajax({
                url:"selectByAjaxAdvanced.action",
                type:"post",
                data:{id:$("#betterid").val()},
                dataType:"json",
                success:function (data) {
                    if(data==null){
                        console.log("无结果");
                    }else{
                        console.log(data.result);
                    }

                },
                error:function () {
                    console.log("error");
                }
            })
        })

        $("#btn").click(function () {
            $.ajax({
                url:"selectByAjax.action",
                type:"post",
                data:{id:$("#id").val()},
                dataType:"json",
                success:function (data) {
                    console.log(data);
                },
                error:function () {
                    console.log("error");
                }
            })
        })

    })







  </script>
  </body>
</html>

