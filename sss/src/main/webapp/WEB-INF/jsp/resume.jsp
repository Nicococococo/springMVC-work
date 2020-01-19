<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Insert title here</title>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
</head>
<body>
    <button onclick="add()">新增</button>
    <table border="1px solid #ccc" cellspacing="0" cellpadding="0">
        <tr>
            <td>id</td>
            <td>姓名</td>
            <td>地址</td>
            <td>联系方式</td>
            <td>操作</td>
        </tr>
        <tbody id="tbody_resume">

        </tbody>
    </table>

    <div id="div_model">
        <form id="resumeData">
            <input type="hidden" name="id">
            姓名：<input type="text" name="name">
            地址：<input type="text" name="address">
            联系方式：<input type="text" name="phone">
            <a href='javascript:void(0)' onclick="saveOrUpdateResume()" id="btn_save">保存</a>
        </form>
    </div>

</body>

<script>

    $(function () {
        $("#div_model").hide();
        queryAll();
    })

    function queryAll() {
        $.ajax({
            url: '/resume/queryAll',
            type: 'POST',
            contentType: 'application/json;charset=utf-8',
            dataType: 'json',
            success: function (data) {
                var tbodyHtml = "";
                for (var i = 0;i<data.length;i++){
                    tbodyHtml +="<tr>"
                                +"<td>"+data[i].id+"</td>"
                                +"<td>"+data[i].name+"</td>"
                                +"<td>"+data[i].address+"</td>"
                                +"<td>"+data[i].phone+"</td>"
                                +"<td><a href='javascript:void(0)' onclick='edit("+data[i].id+")'>编辑</a>|<a href='javascript:void(0)' onclick='deleteResume("+data[i].id+")'>删除</a></td>"
                                +"</tr>";
                }
                $("#tbody_resume").html(tbodyHtml);
            }
        })
    }

    /**
     * 删除
     * @param id
     */
    function deleteResume(id) {
        $.ajax({
            url: '/resume/'+id,
            type: 'delete',
            contentType: 'application/json;charset=utf-8',
            dataType: 'json',
            success: function (data) {
                queryAll();
            }
        })
    }

    /**
     * 查看
     * @param id
     */
    function getResume(id) {
        $.ajax({
            url: '/resume/'+id,
            type: 'get',
            contentType: 'application/json;charset=utf-8',
            dataType: 'json',
            success: function (data) {
                $("input[name='id']").val(data.id);
                $("input[name='name']").val(data.name);
                $("input[name='address']").val(data.address);
                $("input[name='phone']").val(data.phone);
            }
        })
    }

    /**
     * 保存和修改
     * @param id
     */
    function saveOrUpdateResume() {
        $.ajax({
            url: '/resume/saveOrUpdateResume',
            type: 'post',
            contentType: 'application/json;charset=utf-8',
            data:JSON.stringify({id:$("input[name='id']").val(),name:$("input[name='name']").val(),address:$("input[name='address']").val(),phone:$("input[name='phone']").val()}),
            dataType: 'json',
            success: function (data) {
                queryAll();
                $("#div_model").hide();
            }
        })
    }

    function add() {
        $('#resumeData')[0].reset();
        $("#div_model").show();
    }

    function edit(id) {
        $('#resumeData')[0].reset();
        $("#div_model").show();
        getResume(id);
    }
</script>
</html>