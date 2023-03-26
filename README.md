# webDataAnkets
## Test task web application
This program implements a test task to create a web application.

This web application accesses a list of **"Anket"** entities that contain brief information about people. The entities are stored in a local **MySql** database. 
Once the application is started, it is accessed via *"localhost:8080"*. 

On the application page, you can:
- View a list of available entities
- Get detailed information about them
- Add/delete an entity
- Search among all the entities by Name
- Upload a new entity via a *.csv* file

The .csv file should be in the following format (example is "ЮрийГагарин.csv" attached to the repository):
 - firstName;Юрий
 - lastName;Гагарин
 - country;СССР
 - city;Москва
 - dateB;09.03.1934
 - mail;temp@temp.ru

The application uses the following stack of frameworks and libraries:
- Apache Maven
- Spring Web
- Spring Data JPA
- Apache Freemarker
- MySQL Driver
- lombok

#

# webDataAnkets
## Test task web application
Данная программа реализует тестовое задание по созданию web приложения.

Это web приложение осуществляет доступ к списку сущностей **"Anket"**, которые содержат краткую информацию о людях. Сущности хранятся в локальной базе данных **MySql**. 
После запуска приложения, доступ к нему осуществляется через *"localhost:8080"*. 

На странице приложения можно:
- Просматривать список доступных сущностей
- Получить подробную информацию о них
- Добавить/удалить сущность
- Осуществить поиск среди всех сущностей по Имени
- Загрузить новую сущность через файл в формате *.csv*

Файл .csv должен быть следующего формата (образец - *"ЮрийГагарин.csv"*, приложен к репозиторию):
 - firstName;Юрий
 - lastName;Гагарин
 - country;СССР
 - city;Москва
 - dateB;09.03.1934
 - mail;temp@temp.ru

Приложение использует следующий стак фреймворков и библиотек:
- Apache Maven
- Spring Web
- Spring Data JPA
- Apache Freemarker
- MySQL Driver
- lombok
