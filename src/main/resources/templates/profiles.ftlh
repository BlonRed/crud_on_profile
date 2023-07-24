<!DOCTYPE html>
<html>

<head>
    <title>Data Profiles</title>
</head>

<body>
<h1>Data Profiles</h1>
<hr>
<h2>Картотека</h2>
<form action="/" method="get">
    Поиск по имени: <input type="text" name="firstName"/><br>
    <input type="submit" value="Поиск"/>
</form>
<#list profiles as profile>
<div>
    <p><b>${profile.firstName!"Not a first name"} </b>${profile.lastName!"Not a last name"} | <a href="/profile/${profile.id}">Подробнее...</a></p>
</div>
<#else>
<h4>Картотека пуста</h4>
</#list>
<hr>
<p><a href="/add">Создать новую карточку</a></p>
<hr>
<h3>Загрузить новую карточку в формате ".csv"</h3>
<form action="/profile/upload" method="post" enctype="multipart/form-data">
    <input type="file" required name="profileCsv"/><br><br>
    <input type="submit" value="Загрузить карточку"/>
</form>
</body>
<hr><br>
<#if message?has_content>
    <div class="error">${message}</div>
</#if>
</html>