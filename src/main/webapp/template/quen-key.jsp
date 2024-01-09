<%--
  Created by IntelliJ IDEA.
  User: Cuong HQ
  Date: 1/6/2024
  Time: 10:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <title>G15 | Quên key</title>




    <link rel="stylesheet" href="../themes/css1/dang-nhap.css">

    <style>
        .hidden {
            display: none;
        }
    </style>
</head>

<body>
<!-- header -->


<%@ include file="header.jsp"%>


<main id="main">
    <section>

        <div class="container-lg">
            <div class="row justify-content-center">

                <!-- <div class="d-flex box"> -->

                <div class="col-md-5 left">
                    <div class="carousel-inner-login">
                        <img src="../images/logo-new.jpg" class="login" alt="First slide">
                    </div>


                </div>
                <div class="col-md-7 right">
                    <h1 class="text-center mb-3">Quên privatekey</h1>
                    <div class="content">
                        <form class="frm_login" validate
                              action="/tai-khoan/quen-key" method="POST">
                            <div class="row">


                                <div class="col-12">


                                    <%--							FORM KEY --%>

                                    <label>
                                        <input type="radio" name="keyStatus" id="hasKey" onclick="showKeyInputs()"> Có key
                                    </label>

                                    <label>
                                        <input type="radio" name="keyStatus" id="noKey" onclick="disableKeyInputs()"> Chưa có key
                                    </label>

                                    <div id="keyInputs">
                                        <div class="hidden" id="keyInput1">
                                            Public key: <input class="form-control" type="text" name="publicKeyReq" id="publicKey">
                                        </div>
                                        <div class="hidden" id="keyInput2">
                                            Private key: <input class="form-control" type="text" name="privateKeyReq" id="privateKey">
                                        </div>
                                    </div>

                                    <!-- Trong phần head của trang JSP -->
                                    <input type="hidden" name="publicKeyReq" id="hiddenPublicKey">
                                    <input type="hidden" name="privateKeyReq" id="hiddenPrivateKey">


                                    <!-- Thêm vào bên trong thẻ form -->
                                    <input type="hidden" id="selectedFolderPath" name="selectedFolderPath" value="">

                                    <%--							END --%>

                                </div>

                                <%--                                <%--%>
                                <%--                                    if (request.getAttribute("error") != null) {--%>
                                <%--                                %>--%>
                                <%--                                <label style="color: red"><%=request.getAttribute("error")%></label>--%>
                                <%--                                <%--%>
                                <%--                                    }--%>
                                <%--                                %>--%>

                                <%--                                <%--%>
                                <%--                                    if (request.getAttribute("message") != null) {--%>
                                <%--                                %>--%>
                                <%--                                <label style="color: green"><%=request.getAttribute("message")%></label>--%>
                                <%--                                <%--%>
                                <%--                                    }--%>
                                <%--                                %>--%>
                                <%--                            </div>--%>
                                <%--                            <hr>--%>
                                    <%
								if (request.getAttribute("error") != null) {
								%>
                                <%--								<label style="color: red"><%=request.getAttribute("error")%></label>--%>
                                <div class="alert alert-danger mt-3" role="alert">
                                    <%=request.getAttribute("error")%>
                                </div>
                                    <%
								}
								%>
                                <button  class="btn btn-success" type="submit">
                                    Submit</button>

                        </form>
                    </div>
                    <hr>

                    <%--                    <p class="d-flex text-center justify-content-center-login">--%>
                    <%--                        Bạn đã có sẵn một tài khoản G15? <a--%>
                    <%--                            href="/template/dang-nhap.jsp"> Đăng nhập</a>--%>
                    <%--                    </p>--%>
                    <%--                    <p class="d-flex text-center justify-content-center-login">--%>
                    <%--                        Chưa có tài khoản tại G15? <a href="/template/dang-ky.jsp">--%>
                    <%--                        Đăng ký</a>--%>
                    <%--                    </p>--%>
                </div>

            </div>

        </div>

    </section>
</main>

<!-- footer -->
<%@ include file="footer.jsp"%>

<%--	START KEY --%>
<script>
    function showKeyInputs() {
        document.getElementById('keyInput1').classList.remove('hidden');
        document.getElementById('keyInput2').classList.remove('hidden');
        document.getElementById('keyInput1').querySelector('input').disabled =false;
        document.getElementById('keyInput2').querySelector('input').disabled =false;
        document.getElementById('keyInput1').querySelector('input').value="";
        document.getElementById('keyInput2').querySelector('input').value="";
    }

    function disableKeyInputs() {
        document.getElementById('keyInput1').classList.remove('hidden');
        document.getElementById('keyInput2').classList.remove('hidden');
        document.getElementById('keyInput1').querySelector('input').disabled =true;
        document.getElementById('keyInput2').querySelector('input').disabled =true;
    }
</script>

<!-- Add this at the end of your JSP file, before </body> -->
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
    $(document).ready(function () {
        $("input[name='keyStatus']").change(function () {
            if ($("#noKey").prop("checked")) {
                // Make an AJAX request to the server-side endpoint
                $.ajax({
                    type: "GET",
                    url: "/template/generateKeys",// Update the URL to match your server-side endpoint
                    dataType: "json",
                    success: function (data) {
                        // Update the input fields with the generated keys
                        $("#publicKey").val(data.publicKey);
                        $("#privateKey").val(data.privateKey);

                        $("#hiddenPublicKey").val(data.publicKey);
                        $("#hiddenPrivateKey").val(data.privateKey);
                    },
                    error: function () {
                        alert("Error generating keys");
                    }
                });
            }
        });
    });
</script>
<%--END KEY--%>

</body>

</html>
