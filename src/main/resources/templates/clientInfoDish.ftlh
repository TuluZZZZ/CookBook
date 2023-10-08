<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dish</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <style>
        table {
            border-collapse: collapse;
            margin: 20px 0;
            margin: auto;
        }
        th, td {
            padding: 10px;
            border: 1px solid #5b5959;
        }
        th {
            font-weight: bold;
            text-align: center;
        }
        td:last-child {
            text-align: center;
        }
        body {
            background-color: #faf0e6;
            margin: auto;
        }
        .button {
            height:75px;
            width: 210px;
            border-radius: 10px;
            background:#DCDCDC;
            cursor:pointer;
            font-size:21px;
        }
        li {
            display: inline-block;
            vertical-align: middle;
            margin-right: 35px;
        }
        header {
            display: flex;
            justify-content: center;
            color: #cfc6b2;
            font-family: times new roman;
            font-size: 1.1rem;
        }
        a {
            text-decoration: none;
            color: rgba(134, 134, 200, 1);
        }
        a:hover {
            color: #dd4192;
        }
        thead {
            font-size: 1.4rem;
        }
        tbody {
            font-size: 1.2rem;
        }
        .fig {
            text-align: center;
        }
        img {
            height: 400px;
            width: 600px;
        }
        /*    */
        .dropbtn {
            background-color: #faf0e6;
            color: rgba(134, 134, 200, 1);
            padding: 16px;
            font-size: 16px;
            border: none;
            font-family: times new roman;
        }

        /* Контейнер <div> - необходим для размещения выпадающего содержимого */
        .dropdown {
            position: relative;
            display: inline-block;
        }

        /* Выпадающее содержимое (скрыто по умолчанию) */
        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f1f1f1;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
        }

        /* Ссылки внутри выпадающего списка */
        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }
        /* Изменение цвета выпадающих ссылок при наведении курсора */
        .dropdown-content a:hover {background-color: #ddd;}

        /* Показать выпадающее меню при наведении курсора */
        .dropdown:hover .dropdown-content {display: block;}
    </style>
</head>
<body>
<header style="margin: 0; padding: 0; ">
    <div id="menu">
        <ul>

            <li><a href="/api/v1/clients">Главная</a></li>


        </ul>
    </div>
</header>
<br>
<br>

<div align="center">
    <#if imageId??>
        <p class="fig">
            <img src="/images/${imageId}">
        </p>
    </#if>

    <h1 align="center">${dish.name}</h1>



    <b>Рецепт:</b> ${dish.description} <br>
    <b>Время приготовления:</b> ${dish.cooking_time_minute} мин.<br>
    <h2>Ингредиенты</h2>
    <table>
        <thead>
        <tr>
            <th>Наименование</th>
            <th>Ед. изм.</th>
            <th>Количество</th>

        </tr>
        </thead>
        <tbody>
        <#list ingredients as ingredient>
        <tr>
            <th>${ingredient.ingredientName}</th>
            <th>${ingredient.measurementName}</th>
            <th>${ingredient.quantity}</th>

            </#list>
        </tr>
        </tbody>
    </table>
    <br>
</div>

</body>
</html>