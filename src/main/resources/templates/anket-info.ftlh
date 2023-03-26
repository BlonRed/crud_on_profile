<!DOCTUPE html>
<html>
<head>
    <title>Data Ankets</title>
</head>
<body>
<h1>Data Ankets</h1><hr>
<h4>Подробная информация из карточки</h4>
<b>Имя: </b>${anket.firstName}<br>
<b>Фамилия: </b>${anket.lastName}<br>
<b>Страна: </b>${anket.country}<br>
<b>Город: </b>${anket.city}<br>
<b>Дата рождения: </b>${anket.dateB}<br>
<b>mail: </b>${anket.mail}<br>
<hr>
<form action="/anket/delete/${anket.id}" method="post">
    <input type="submit" value="Удалить карточку"/>
</form>
</body>
</html>