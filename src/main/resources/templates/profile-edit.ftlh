<!DOCTYPE html>
<html>
<head>
    <title>Data Profiles</title>
</head>
<body>
<a href="/">На главную</a><br><br>
<h1><#if add>Создание новой карточки<#else>Редактирование карточки</#if></h1>
<hr>
<#if add>
    <#assign urlAction>/profile/add</#assign>
    <#assign submitTitle>Создать</#assign>
    <#else>
    <#assign urlAction>/profile/${profile.id}/edit</#assign>
    <#assign submitTitle>Изменить</#assign>
</#if>
<form action="${urlAction}" name="profile" method="post">
    <table border="0">
        <#if profile.id??>
            <tr>
                <td>ID:</td>
                <td>${profile.id}</td>
            </tr>
        </#if>
        <tr>
            <td>Имя:</td>
            <td><input type="text" name="firstName" required value="${(profile.firstName)!''}"/>
        </tr>
        <tr>
            <td>Фамилия:</td>
            <td><input type="text" name="lastName" required value="${(profile.lastName)!''}"/></td>
        </tr>
        <tr>
            <td>Страна:</td>
            <td><input type="text" name="country" value="${(profile.country)!''}"/></td>
        </tr>
        <tr>
            <td>Город:</td>
            <td><input type="text" name="city" value="${(profile.city)!''}"/></td>
        </tr>
        <tr>
            <td>Дата рождения:</td>
            <td><input type="text" name="dateB" value="${(profile.dateB)!''}"/></td>
        </tr>
        <tr>
            <td>@mail:</td>
            <td><input type="text" name="mail" value="${(profile.mail)!''}"/></td>
        </tr>
    </table>
    <input type="submit" value="${submitTitle}" formmethod="post"/>
</form>
<hr><br>
</body>
</html>