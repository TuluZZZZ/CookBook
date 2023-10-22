<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>CategoryOfDish</title>

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
        img {
            height: 220px;
            width: 330px;
        }
        button {
            font-size: 20px;
        }
        li {
            display: inline-block;
            vertical-align: middle;
            margin-right: 25px;
        }
        header {
            display: flex;
            justify-content: center;
            color: #cfc6b2;
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
        /*    */
        .dropbtn {
            background-color: #faf0e6;
            color: rgba(134, 134, 200, 1);
            padding: 16px;
            font-size: 16px;
            border: none;
            font-family: times new roman;
        }

                .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f1f1f1;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
        }

        .dropdown-content a {
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
        }

        .dropdown-content a:hover {background-color: #ddd;}


        .dropdown:hover .dropdown-content {display: block;}
    </style>

</head>
<body>

<div align="center">

    <h1>Кулинарные рецепты</h1>
    <table>
        <thead>
        <tr>
            <th>Наименование категории</th>
            <th>Количество рецептов</th>
            <th>Просмотреть</th>
            <th>Добавить</th>

        </tr>
        </thead>
        <tbody>
        <#list categories as category>
        <tr>
            <th>${category.name}</th>
            <th>${category.countDishes}</th>
            <th>
                <a href="/api/v1/admin/${category.id}">Просмотреть</a>
            </th>
            <th>
                <a href="/api/v1/admin/addDish/${category.id}">Добавить</a>
            </th>
                    </tr>
        </#list>
        </tbody>
    </table>

</div>

<br>
<p align="center">
<h2 align="center"> <a href="/api/v1/admin/createIngredient">Добавить ингредиент</a> </h2>

</p>

</body>
</html>