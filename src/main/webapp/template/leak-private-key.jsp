<%--
  Created by IntelliJ IDEA.
  User: nguyentrunghieu
  Date: 30/12/2023
  Time: 23:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%@ include file="header.jsp" %>
    <p>Nếu bạn đang bị lộ private-key vui lòng cung cấp cho chúng tôi thời gian. Những đơn hàng trước đó của bạn sẽ bị xóa khỏi hệ thống và key của bạn sẽ được cập nhập lại. </p>
    <input type="date" id="leak-start-at" placeholder="Nhập thời gian bạn bị rò rĩ private-key"/>
<button onclick="handleLeakPrivateKey()">Xác nhận</button>

</body>
<script>
    function handleLeakPrivateKey(){
        const startAt = document.getElementById('leak-start-at');
        console.log(startAt.value)
        var xhr = new XMLHttpRequest();
        xhr.open('POST', '/thanh-toan/leakPrivateKey?startAt='+startAt.value, true);
        xhr.onload = function () {
            if (xhr.status === 200) {
                // Cập nhật giá trị trong trang HTML
                console.log(xhr.responseText)
            }
        };
        xhr.send();
    }
</script>
</html>