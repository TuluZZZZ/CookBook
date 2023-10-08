<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New ingredient</title>
</head>
<body>

<form method="POST" action="/api/v1/admin/createIngredient">
    <p>
        <label for="ingredientName">Enter name</label>
        <input type="text" name="ingredientName" id="name"/>
    </p>



    <p>
        <label for="measurementId">Enter measurement</label>
        <select name="measurementId" id="measurementId">
            <#list measurements as measurement>
                <option value="${measurement.id}">${measurement.name}</option>
            </#list>
        </select>
    </p>

    <p>
        <input type="submit" value="Create!">
    </p>

</form>

</body>
</html>
