<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login page</title>
</head>
<body>
    <c:if test="${param.incorrectAccount != null}">
        <div class="alert alert-danger">
            Tên đăng nhập hoặc mật khẩu sai!
        </div>
    </c:if>
    <h1>Login page</h1>
    <form action="j_spring_security_check" method="POST">
        <input type="text" class="form-control" id="username" name="j_username" required />
        <input type="password" class="form-control" id="password" name="j_password" required />

        <button class="btn-submit-form" type="submit">
            Đăng nhập
        </button>
    </form>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

    <script>
        $('.btn-submit-form').on("click", function(e){
            //e.preventDefault();
            let data = {
                userName: $('#username').val(),
                password: $('#password').val()
            };
            $.ajax({
                url: '/api/authentication',
                type: 'POST',
                contentType: "application/json; charset=utf-8",
                dataType: "JSON",
                data: JSON.stringify(data),
                success: function (result) {
                    console.log(result);
                },
                error: function (error) {
                    alert("Error");
                }
            });
        });
    </script>
</body>
</html>
