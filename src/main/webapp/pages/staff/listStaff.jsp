<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="${pageContext.request.contextPath}/css/sys.css" type="text/css" rel="stylesheet"/>
    <script>
        //当点击查询按钮的时候会执行
        // 获取两个select选中时对应的value
        function condition() {

            var deptId = document.getElementById("deptId").value;
            var postId = document.getElementById("postId").value;
            var staffName = document.getElementById("staffName").value;
            var data = new FormData();

            data.append("model.post.dept.deptId", deptId);
            data.append("model.post.postId", postId);
            data.append("staffName", staffName);

            var xhr = new XMLHttpRequest();
            xhr.withCredentials = true;

            xhr.addEventListener("readystatechange", function () {
                if (this.readyState === 4) {
                    console.log(this.responseText);
                    json = eval('(' + this.responseText + ')');
                    var tableEle = document.getElementById("staffId");
                    var length = tableEle.rows.length
                    for (var j = 0; j < length - 1; j++) {
                        tableEle.deleteRow(1);
                    }

                    for (var j = 0; j < json.length; j++) {
                        var tr = document.createElement("tr");
                        getId = json[j];

                        tr.appendChild(createTD(json[j].staffName));
                        tr.appendChild(createTD(json[j].gender));
                        tr.appendChild(createTD(json[j].onDutyDate));
                        tr.appendChild(createTD(json[j].dept.deptName));
                        tr.appendChild(createTD(json[j].post.postName));


                        function createA() {

                            var get_Id = json[j].staffId;

                            var path = "${pageContext.request.contextPath}/editStaffs?staffId=" + get_Id + "&amp;post.dept.deptId";


                            var td = document.createElement("td");
                            td.setAttribute("align", "center");
                            var a = document.createElement("a");
                            a.setAttribute("href", path);
                            var textNode = document.createElement("img");
                            textNode.setAttribute("src", "${pageContext.request.contextPath}/images/button/modify.gif")
                            textNode.setAttribute("class", "img");
                            a.appendChild(textNode);
                            td.appendChild(a);
                            return td;
                        }


                        tr.append(createA());
                        tableEle.appendChild(tr)
                    }


                    function createTD(text) {
                        var td = document.createElement("td");
                        td.setAttribute("align", "center")
                        var textNode = document.createTextNode(text);
                        td.appendChild(textNode);
                        return td;
                    }


                }


            });

            xhr.open("POST", "${pageContext.request.contextPath}/getAllResult");

            xhr.send(data);

        }


        function onDeptSelect(value) {
            var data = new FormData();
            data.append("deptId", value);

            var xhr = new XMLHttpRequest();
            xhr.withCredentials = true;

            xhr.addEventListener("readystatechange", function () {
                if (this.readyState === 4) {
                    console.log(this.responseText);

                    // 对请求回来的数据进行解析
                    json = eval('(' + this.responseText + ')');
                    // 获取服务器的标签
                    serverSelect = document.getElementById("postId");
                    // 获取option标签
                    optionElement = serverSelect.getElementsByTagName("option")
                    // 获取option 的数量
                    length = optionElement.length;
                    // 使用循环清空所有的option标签
                    for (var i = 0; i < length; i++) {
                        serverSelect.removeChild(optionElement[0]);
                    }

                    serverSelect.innerHTML = "<option value = '-1'>--请选择职务--</option>";

                    // 将json 数据插入到option中
                    for (var i = 0; i < json.length; i++) {
                        // 创建一个option标签
                        option = document.createElement("option");
                        // 设置value属性
                        option.setAttribute("value", json[i].postId)
                        // 设置文本信息
                        text = document.createTextNode(json[i].postName)
                        // 把文本信息添加到option中
                        option.appendChild(text)

                        serverSelect.appendChild(option)
                    }

                }
            });

            xhr.open("POST", "${pageContext.request.contextPath}/getPostByDeptId");

            xhr.send(data);
        }
    </script>


</head>

<body>
<table border="0" cellspacing="0" cellpadding="0" width="100%">
    <tr>
        <td class="topg"></td>
    </tr>
</table>

<table border="0" cellspacing="0" cellpadding="0" class="wukuang" width="100%">
    <tr>
        <td width="1%"><img src="${pageContext.request.contextPath}/images/tleft.gif"/></td>
        <td width="39%" align="left">[员工管理]</td>

        <td width="57%" align="right">
            <%--高级查询 --%>
            <a href="javascript:void(0)" onclick="condition()">
                <img src="${pageContext.request.contextPath}/images/button/gaojichaxun.gif"/></a>
            <%--员工添加 --%>

            <%--点击添加后要查出部门和职位 生成二级联动--%>

            <a href="${pageContext.request.contextPath}/getAllDept.action">
                <img src="${pageContext.request.contextPath}/images/button/tianjia.gif"/>
            </a>


        </td>
        <td width="3%" align="right"><img src="${pageContext.request.contextPath}/images/tright.gif"/></td>
    </tr>


</table>

<!-- 查询条件：马上查询 -->
<form id="conditionFormId" action="${pageContext.request.contextPath}/staff/staffAction_findAll" method="post">
    <table width="88%" border="0" style="margin: 20px;">
        <tr>
            <td width="80px">部门：</td>
            <td width="200px">

                <select name="deptId" onchange="onDeptSelect(value)" id="deptId">
                    <option value="-1">--请选择部门--</option>
                    <s:iterator value="deptList" var="dep">
                        <option value="${dep.deptId}">${dep.deptName}</option>
                    </s:iterator>
                </select>

            </td>
            <td width="80px">职务：</td>
            <td width="200px">

                <select name="postId" id="postId">
                    <option value="-1">--请选择职务--</option>
                </select>

            </td>
            <td width="80px">姓名：</td>
            <td width="200px"><input type="text" name="staffName" size="12" id="staffName"/></td>
            <td></td>
        </tr>
    </table>
</form>


<table border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;">
    <tr>
        <td><img src="${pageContext.request.contextPath}/images/result.gif"/></td>
    </tr>
</table>

<table width="100%" border="1" id="staffId">
    <tr class="henglan" style="font-weight:bold;">
        <td width="10%" align="center">员工姓名</td>
        <td width="6%" align="center">性别</td>
        <td width="12%" align="center">入职时间</td>
        <td width="15%" align="center">所属部门</td>
        <td width="10%" align="center">职务</td>
        <td width="10%" align="center">编辑</td>
    </tr>

    <s:iterator value="listStaff" var="list">

        <tr class="tabtd1">
            <td align="center">${list.staffName}</td>
            <td align="center">${list.gender}</td>
            <td align="center">${list.onDutyDate}</td>
            <td align="center">${list.dept.deptName}</td>
            <td align="center">${list.post.postName}</td>


            <td width="7%" align="center">

                    <%--点击编辑把StaffID和deptID和postID传到Action中 最后跳转还是addStaff界面--%>
                <a href="${pageContext.request.contextPath}/editStaffs.action?staffId=${list.staffId}"><img
                        src="${pageContext.request.contextPath}/images/button/modify.gif" class="img"/></a>
            </td>
        </tr>
    </s:iterator>

</table>
<s:actionerror cssStyle="color: green"/>


<%--<table border="0" cellspacing="0" cellpadding="0" align="center">--%>
<tr>
    <td align="right">
        <span>第1/3页</span>
        <span>
        	<a href="#">[首页]</a>&nbsp;&nbsp;
            <a href="#">[上一页]</a>&nbsp;&nbsp;
            <a href="#">[下一页]</a>&nbsp;&nbsp;
            <a href="#">[尾页]</a>
        </span>
    </td>
</tr>
</table>
</body>
</html>
