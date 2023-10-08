<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>New ingredient</title>
</head>
<body>
<form method="POST" action="/api/v1/admin/addIngredient">
    <p>
        <label for="id">Enter ingredient</label>
        <select name="id" id="id">
            <#list ingredients as ingredient>
                <option value="${ingredient.id}">${ingredient.ingredientName} ед.изм.- ${ingredient.measurementName}</option>
            </#list>
        </select>
    </p>
    <#--    <p>-->
    <#--        <label>Ед. изм.:  ${}</label>-->
    <#--        <label for="measurementId">Enter measurement</label>-->
    <#--        <select name="measurementId" id="measurementId">-->
    <#--            <#list measurements as measurement>-->
    <#--                <option value="${measurement.id}">${measurement.name}</option>-->
    <#--            </#list>-->
    <#--        </select>-->
    <#--    </p>-->
    <p>
        <label for="quantity">Enter quantity</label>
        <input type="number" name="quantity" id="quantity" min="1"/>
    </p>
    <p>
        <input type="hidden" name="dishId" value="${dishId}"/>
    </p>
    <p>
        <input type="submit" value="Добавить">
    </p>

</form>

</body>
</html>
