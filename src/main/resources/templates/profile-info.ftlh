<!DOCTYPE html>
<html>
<head>
    <title>Data Profiles</title>
</head>
<body>
<a href="/">На главную</a><br><br>
<h1>Profile info</h1>
<hr>
<h3>Подробная информация из карточки</h3>
<table border="0">
    <tr>
        <td>Имя:</td>
        <td>${profile.firstName!""}</td>
    </tr>
    <tr>
        <td>Фамилия:</td>
        <td>${profile.lastName!""}</td>
    </tr>
    <tr>
        <td>Страна:</td>
        <td>${profile.country!""}</td>
    </tr>
    <tr>
        <td>Город:</td>
        <td>${profile.city!""}</td>
    </tr>
    <tr>
        <td>Дата рождения:</td>
        <td>${profile.dateB!""}</td>
    </tr>
    <tr>
        <td>mail:</td>
        <td>${profile.mail!""}</td>
    </tr>
</table>
<hr>
<form action="/profile/${profile.id}/delete/" method="post">
    <input type="submit" value="Удалить карточку"/>
</form>
<form action="/profile/${profile.id}/edit" method="get">
    <input type="submit" value="Редактировать карточку"/>
</form>
</body>
<hr><br>
</html>