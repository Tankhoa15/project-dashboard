<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <a href="userManager.jsp">
        <button class="btn btn-primary">User manager</button>
    </a>
    <h3 class="text-center">Add new User</h3>
    <form action="AddUser" method="post">
        <input type="hidden" name="action" value="add">
        <div class="form-group">
            <label for="fullName">Full Name</label>
            <input class="form-control" type="text"
                   placeholder="Enter full name" id="fullName" name="fullName" required>
            <div class="form-group">
                <label for="email">Email</label>
                <input class="form-control" type="email" placeholder="Enter email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input class="form-control" type="text" id="password" name="password" required>
            </div>
            <button class="btn btn-success" type="submit">Tạo tài khoản</button>
            <p class="text-primary">${requestScope.status}</p>
        </div>
    </form>
</div>
</body>
</html>
