<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New dish</title>
</head>
<body>

<form method="POST" action="/api/v1/admin/addNewDish" enctype="multipart/form-data">
    <p>
        <label for="name">Название блюда</label>
        <input type="text" name="name" id="name"/>
    </p>
    <p>
        <label for="description">Рецепт</label>
        <textarea name="description" id="description"></textarea>
    </p>
    <p>
        <label for="cooking_time_minute">Время приготовления в минутах</label>
        <input type="number" name="cooking_time_minute" id="cooking_time_minute" min="1"/>
    </p>
    <p>
        <input type="hidden" name="categoryId" id="price" value="${categoryId}" />
    </p>


    <p>
        <label for="file">Изображение</label>
        <input type="file" name="file" id="file"/>
    </p>
    <p>
        <input type="submit" value="Создать">
    </p>

</form>

</body>
</html>