<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registration User</title>


</head>

<body>
<div align="center">
    <h2>Registration User</h2>
    <br>
    <br>
    <br>

    <#if userDTO?? && noErrors??>
    Your submitted data<br>
    Login: ${userDTO.login}<br>
    Password: ${userDTO.password}<br>
    ConfirmPassword: ${userDTO.confirmPassword}

    <div>
        <#else>
            <form action="/registration" method="post">
                Enter Login:<br>
                <@spring.formInput "userDTO.login"/>
                <@spring.showErrors "<br>"/>
                <br><br>
                Enter password:<br>
                <@spring.formPasswordInput "userDTO.password"/>
                <@spring.showErrors "<br>"/>
                <br><br>
                Enter password:<br>
                <@spring.formPasswordInput "userDTO.confirmPassword"/>
                <@spring.showErrors "<br>"/>
                <br>
                <br>
                <br>

                <input type="submit" value="Register">
            </form>
        </#if>
    </div>

</div>

</body>
</html>
