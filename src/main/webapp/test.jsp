<%@ page import="com.example.yadaun.entity.Test" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %>
<%@ page import="static com.mysql.cj.MysqlType.JSON" %>
<%@ page import="com.example.yadaun.testServlet.TestSerializer" %>
<%@ page import="com.example.yadaun.entity.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <%
        ResourceBundle bundle = ResourceBundle.getBundle("messages", (Locale) session.getAttribute("currentLocale"));
    %>

    <title><%= bundle.getString("list.test")%></title>
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
        input[type="submit"] {
            padding: 10px 20px;
            background-color: #007BFF;
            border: none;
            color: #ffffff;
            text-decoration: none;
            text-align: center;
            cursor: pointer;
        }

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

        .test-container h3 {
            margin: 0;
        }

        .question {
            margin-bottom: 10px;
        }

        .options {
            display: flex;
            flex-wrap: wrap;
        }

        .option {
            margin-right: 10px;
            margin-bottom: 5px;
        }

        .option input[type="checkbox"] {
            margin-right: 5px;
        }

        .hidden {
            display: none;
        }

        /* Остальные стили */
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

<% List<Test> tests = (List<Test>) request.getAttribute("tests"); %>
<% if (tests != null && !tests.isEmpty()) { %>
<% for (Test test : tests) { %>
<form action="/test" method="post" id="testForm<%= test.getTestId() %>">
    <div class="test-container">
        <h3>Test <%= test.getName() %></h3>
        <div class="question"><%= test.getQuestion1() %></div>
        <input type="hidden" name="serializedTest" value="<%= test.getTestId()%>">

        <div class="options">
            <div class="option">
                <input type="checkbox" id="question1Option1" name="question1Options" value="1">
                <label for="question1Option1"><%= test.getQuestion1Option1() %></label>
            </div>
            <div class="option">
                <input type="checkbox" id="question1Option2" name="question1Options" value="2">
                <label for="question1Option2"><%= test.getQuestion1Option2() %></label>
            </div>
            <div class="option">
                <input type="checkbox" id="question1Option3" name="question1Options" value="3">
                <label for="question1Option3"><%= test.getQuestion1Option3() %></label>
            </div>
        </div>
        <div id="details-<%= test.getTestId() %>" class="hidden">
            <div class="question"><%= test.getQuestion2() %></div>
            <div class="options">
                <div class="option">
                    <input type="checkbox" id="question2Option1" name="question2Options" value="1">
                    <label for="question2Option1"><%= test.getQuestion2Option1() %></label>
                </div>
                <div class="option">
                    <input type="checkbox" id="question2Option2" name="question2Options" value="2">
                    <label for="question2Option2"><%= test.getQuestion2Option2() %></label>
                </div>
                <div class="option">
                    <input type="checkbox" id="question2Option3" name="question2Options" value="3">
                    <label for="question2Option3"><%= test.getQuestion2Option3() %></label>
                </div>
            </div>
            <div class="question"><%= test.getQuestion3() %></div>
            <div class="options">
                <div class="option">
                    <input type="checkbox" id="question3Option1" name="question3Options" value="1">
                    <label for="question3Option1"><%= test.getQuestion3Option1() %></label>
                </div>
                <div class="option">
                    <input type="checkbox" id="question3Option2" name="question3Options" value="2">
                    <label for="question3Option2"><%= test.getQuestion3Option2() %></label>
                </div>
                <div class="option">
                    <input type="checkbox" id="question3Option3" name="question3Options" value="3">
                    <label for="question3Option3"><%= test.getQuestion3Option3() %></label>
                </div>
            </div>
            <div class="question"><%= test.getQuestion4() %></div>
            <div class="options">
                <div class="option">
                    <input type="checkbox" id="question4Option1" name="question4Options" value="1">
                    <label for="question4Option1"><%= test.getQuestion4Option1() %></label>
                </div>
                <div class="option">
                    <input type="checkbox" id="question4Option2" name="question4Options" value="2">
                    <label for="question4Option2"><%= test.getQuestion4Option2() %></label>
                </div>
                <div class="option">
                    <input type="checkbox" id="question4Option3" name="question4Options" value="3">
                    <label for="question4Option3"><%= test.getQuestion4Option3() %></label>
                </div>
            </div>
            <div class="question"><%= test.getQuestion5()%></div>
            <div class="options">
                <div class="option">
                    <input type="checkbox" id="question5Option1" name="question5Options" value="1">
                    <label for="question5Option1"><%= test.getQuestion5Option1() %></label>
                </div>
                <div class="option">
                    <input type="checkbox" id="question5Option2" name="question5Options" value="2">
                    <label for="question5Option2"><%= test.getQuestion5Option2() %></label>
                </div>
                <div class="option">
                    <input type="checkbox" id="question5Option3" name="question5Options" value="3">
                    <label for="question5Option3"><%= test.getQuestion5Option3() %></label>
                </div>
            </div>
        </div>
        <button type="button" onclick="toggleDetails(<%= test.getTestId() %>)">Show Details</button>
        <input type="submit" name="submitBtn" value="Submit">

        <% User user = (User) session.getAttribute("user");
            if (user != null && user.getRole().equals("admin")) {
        %>
        <button type="button" onclick="deleteTest(<%= test.getTestId() %>)">Delete</button>
        <button type="button" onclick="editTest(<%= test.getTestId() %>)">Edit</button>

        <%
            }
        %>

    </div>
</form>
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