<!DOCTUPE html>
<html>
<head>
    <title>Data Ankets</title>
</head>
<body>
<h1>Data Ankets</h1><hr>
<h2>Картотека</h2>
<form action="/" method="get">
    Поиск по имени: <input type="text" name="firstName"/><br>
    <input type="submit" value="Поиск"/>
</form>
<#list ankets as anket>
    <div>
      <p><b>${anket.firstName} </b>${anket.lastName} | <a href="/anket/${anket.id}">Подробнее...</a></p>
    </div>
    <#else>
    <h4>Картотека пуста</h4>
</#list>
<hr>
<h3>Создать новую карточку</h3>
<form action="/anket/create" method="post">
    Имя: <input type="text" name="firstName"/><br><br>
    Фамилия: <input type="text" name="lastName"/><br><br>
    Страна: <input type="text" name="country"/><br><br>
    Город: <input type="text" name="city"/><br><br>
    Дата рождения: <input type="text" name="dateB"/><br><br>
    mail: <input type="text" name="mail"/><br><br>
    <input type="submit" value="Добавить карточку"/>
</form>
<hr>
<h3>Загрузить новую карточку в формате .csv</h3>
<form action="/anket/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="anketCsv"/><br><br>
    <input type="submit" value="Загрузить карточку"/>
</form>
</body>
</html>