<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form:form action="login" method="post" modelAttribute="login">
        <h1>Login</h1>
        <table>
            <tr>
                <td><h3>Account:</h3></td>
                <td><form:input path="account"/></td>
            </tr>
            <tr>
                <td><h3>Password:</h3></td>
                <td><form:input path="password"/></td>
            </tr>
            <tr>
                <td>
                    <form:button>Login</form:button>
                </td>
            </tr>
        </table>
    </form:form>

    <h3>${message}</h3>

</body>
</html>
