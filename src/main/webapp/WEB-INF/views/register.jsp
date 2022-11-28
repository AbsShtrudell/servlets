<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <title>Title</title>
</head>
<body>
<div class ="container">
  <section id="content">
    <p><font color="red">${errorRegister}</font></p>

    <form action="RegisterServlet" method="POST">
      <h1> Регистрация нового пользователя </h1>
      <div>
        <input placeholder="Введите имя" required=""name="newLoginName" type="text" />
      </div>
      <div>
        <input placeholder="Введите пароль" id ="password" required="" name="newPassword" type="password" />
      </div>
      <div>
        <input type="submit" value="Зарегистрировать"/>
      </div>
    </form>
  </section>
</div>
</body>
</html>
