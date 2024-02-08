<%@ page import="com.example.yadaun.entity.Test" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %>
<%@ page import="static com.mysql.cj.MysqlType.JSON" %>
<%@ page import="com.example.yadaun.testServlet.TestSerializer" %>
<%@ page import="com.example.yadaun.entity.User" %>
<%@ page import="com.example.yadaun.entity.TestResult" %>
<%@ page import="com.example.yadaun.dao.daoImpl.TestDaoImpl" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <%
        ResourceBundle bundle = ResourceBundle.getBundle("messages", (Locale) session.getAttribute("currentLocale"));
    %>

    <title><%= bundle.getString("result.test")%></title>
    <style>
        body {
            display: flex;
            flex-direction: column;
            align-items: center;
            margin-top: 50px;
            font-family: Arial, sans-serif;
        }

        .sidebar {
            display: flex;
            justify-content: center;
            margin-bottom: 20px;
        }

        .sidebar .sidebar-button {
            margin: 0 10px;
            padding: 5px 10px;
            background-color: #007BFF;
            border: none;
            color: #ffffff;
            text-decoration: none;
            text-align: center;
        }

        .sidebar .sidebar-button:hover {
            background-color: #0056b3;
        }

        /* Остальные стили */

        .test-container {
            margin-bottom: 20px;
            padding: 10px;
            background-color: #f0f0f0;
            width: 600px;
        }

        /* Стили для кнопок */
        button {
            padding: 10px 20px;
            background-color: #007BFF;
            border: none;
            color: #ffffff;
            text-decoration: none;
            text-align: center;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }

        /* Стили для блоков-карт */
        .test-container {
            margin-bottom: 20px;
            padding: 10px;
            background-color: #f0f0f0;
            width: 600px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        /* Стили для контейнера таблицы */
        .table-container {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 200px ;
        }

        /* Стили для таблицы */
        table {
            width: 400px;
            border-collapse: collapse;
            background-color: #f0f0f0;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #007BFF;
            color: #ffffff;
        }

        tr:nth-child(even) {
            background-color: #ffffff;
        }

        tr:nth-child(odd) {
            background-color: #f0f0f0;
        }




    </style>
    <script>
        function toggleDetails(testId) {
            var details = document.getElementById("details-" + testId);
            details.classList.toggle("hidden");

            var button = document.getElementById("button-" + testId);
            if (details.classList.contains("hidden")) {
                button.innerText = "Показать детали";
            } else {
                button.innerText = "Скрыть детали";
            }
        }

        function startTest(testId) {
            window.location.href = "/startTest?id=" + testId; // Перенаправление на страницу с прохождением теста
        }
    </script>
    <script>
        /* Остальной JavaScript-код */

        // Функции для перенаправления на /test и /createTest
        function goToTest() {
            window.location.href = "/test";
        }

        function goToCreateTest() {
            window.location.href = "/createTest";
        }

        function goTestResult() {
            window.location.href = "/showTestResult";
        }

    </script>
</head>
<body>
<!-- Боковое меню -->
<div class="sidebar">
    <a class="sidebar-button" href="#" onclick="goToTest()"><%= bundle.getString("list.test")%></a>
    <a class="sidebar-button" href="#" onclick="goToCreateTest()"><%= bundle.getString("create.test")%></a>
    <a class="sidebar-button" href="#" onclick="goTestResult()"><%= bundle.getString("result.test")%></a>
</div>


<% List<TestResult> testsRes = (List<TestResult>) request.getAttribute("testsRes"); %>
<% if (testsRes != null && !testsRes.isEmpty()) { %>
<% for (TestResult testRes : testsRes) { %>
<div class="table-container">
    <table>
    <tr>
        <th>Test Name</th>
        <th>Result</th>
    </tr>
    <tr>
        <td><%= testRes.isFirst_answer() %></td>
        <td><%= testRes.isSecond_answer() %></td>
        <td><%= testRes.isThreeth_answer() %></td>
        <td><%= testRes.isFourth_answer() %></td>
        <td><%= testRes.isFifth_answer() %></td>
    </tr>
        <tr>
            <td><%= testRes.getAll_answer()%></td>
        </tr>
</table>
</div>

<% } %>
<% } else { %>
<p>No tests available.</p>
<% } %>
</body>
<script>



    function deleteTest(id){
        var url = "/test?id=" + id;

        var xhr = new XMLHttpRequest();
        xhr.open("DELETE", url, true);
        xhr.send();
        window.location.href = "/test";
    }

    function editTest(id){
        window.location.href = "/edit?id=" + id;
    }

</script>
</html>