<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <%
        ResourceBundle bundle = ResourceBundle.getBundle("messages", (Locale) session.getAttribute("currentLocale"));
    %>

    <meta charset="UTF-8">
    <title><%= bundle.getString("authentication.title")%></title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        form {
            width: 350px;
            padding: 20px;
            background-color: #ffffff;
            box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
        }

        div {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"], input[type="password"] {
            width: 80%;
            padding: 10px;
            border: 1px solid #dddddd;
        }

        input[type="submit"] {
            width: 40%;
            padding: 10px;
            background-color: #007BFF;
            border: none;
            color: #ffffff;
            cursor: pointer;
        }

        .redir {
            width: 40%;
            padding: 10px;
            background-color: #007BFF;
            border: none;
            color: #ffffff;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .language-selector {
            position: absolute;
            top: 10px;
            right: 10px;
        }

        .hidden {
            display: none;
        }

    </style>
    <script>
        function changeLocale(locale) {
            var form = document.getElementById("localeForm");
            form.elements["locale"].value = locale;
            form.submit();
        }
    </script>
</head>
<body>
<form id="localeForm" action="/changeLocale" method="post" class="hidden" disabled>
    <input type="hidden" name="locale" value=""/>
</form>

<div class="language-selector">
    <button onclick="changeLocale('en')">English</button>
    <button onclick="changeLocale('de')">Deutsch</button>
</div>

<form action="/authentication" method="post">
    <div>
        <label><%= bundle.getString("authentication.username.label")%></label>
        <input type="text" name="username" required/>
    </div>
    <div>
        <label><%= bundle.getString("authentication.password.label")%></label>
        <input type="password" name="password" required/>
    </div>
    <div>
        <input type="submit" value="<%= bundle.getString("authentication.submit.label")%>"/>
        <button class="redir" onclick="redirectToRegistration()"><%= bundle.getString("registration.submit.label")%></button>
    </div>
</form>

<script>
    function redirectToRegistration() {
        window.location.href = "/register";
    }
</script>
</body>
</html>