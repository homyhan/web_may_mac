<%-- Created by IntelliJ IDEA. User: nguyentrunghieu Date: 30/12/2023 Time: 23:54 To change this
template use File | Settings | File Templates. --%> <%@ page contentType="text/html;charset=UTF-8"
language="java" %>
<html>
  <head>
    <title>Title</title>
    <link rel="stylesheet" href="../themes/css1/dang-nhap.css" />
  </head>
  <body>
    <%@ include file="header.jsp" %>
    <div class="container-lg">
      <div class="row justify-content-center">
        <div class="col-md-5 left">
          <div class="carousel-inner-login">
            <img src="../images/logo-new.jpg" class="login" alt="First slide" />
          </div>
        </div>

        <div class="col-md-7 right">
          <p>
            Nếu bạn đang bị lộ private-key vui lòng cung cấp cho chúng tôi thời gian. Những đơn hàng
            sau thời gian này của bạn sẽ bị xóa khỏi hệ thống và key của bạn sẽ được cập nhập lại.
          </p>
          <div>
            <label>Nhập ngày bắt đầu lộ key:</label>
            <input
              type="datetime-local"
              id="leak-start-at"
              placeholder="Nhập thời gian bạn bị rò rĩ private-key"
              style="margin-bottom: 20px"
            />
          </div>
          <div>
            <input id="myCheckbox" type="checkbox" />
            <label>Có ngày kết thúc</label>
          </div>
          <div id="menu-end-at" style="display: none; margin-top: 20px">
            <label for="">Nhập ngày kết thúc:</label>
            <input type="datetime-local" id="leak-end-at" />
          </div>
          <br />
          <button onclick="handleLeakPrivateKey()" class="btn btn-success" style="width: 100%">
            Xác nhận
          </button>
        </div>
      </div>
    </div>
  </body>
  <script>
    const menuEndAt = document.getElementById("menu-end-at");
    const checkBox = document.getElementById("myCheckbox");
    checkBox.addEventListener("change", (event) => {
      if (event.currentTarget.checked) {
        menuEndAt.style.display = "block";
      } else {
        menuEndAt.style.display = "none";
      }
      console.log(checkBox.checked);
    });

    function handleLeakPrivateKey() {
      const startAt = document.getElementById("leak-start-at");
      if (!startAt.value) {
        window.alert("Bạn chưa nhập ngày bắt đầu.");
        return;
      }
      const endAt = document.getElementById("leak-end-at");
      var xhr = new XMLHttpRequest();
      if (checkBox.checked) {
        if (!endAt.value) {
          window.alert("Bạn chưa nhập đủ thông tin.");
          return;
        }
        if (endAt.value < startAt.value) {
          window.alert("Ngày kết thúc phải sau ngày bắt đầu");
          return;
        }
      }

      xhr.open(
        "POST",
        !endAt.value
          ? `/thanh-toan/leakPrivateKey?startAt=` + startAt.value + "&endAt="
          : `/thanh-toan/leakPrivateKey?startAt=` + startAt.value + "&endAt=" + endAt.value,
        true
      );
      xhr.onload = function () {
        if (xhr.status === 200) {
          // Cập nhật giá trị trong trang HTML
          console.log(xhr.responseText);
          window.alert("Chúng tôi đã xóa các đơn hàng của bạn thành công. Cảm ơn vì đã thông báo.");
          window.location.href = "/products";
        }
      };
      xhr.send();
    }
  </script>
</html>
