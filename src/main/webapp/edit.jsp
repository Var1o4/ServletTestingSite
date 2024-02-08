<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %>
<%@ page import="com.example.yadaun.entity.Test" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <%
        ResourceBundle bundle = ResourceBundle.getBundle("messages", (Locale) session.getAttribute("currentLocale"));
    %>
    <title></title>
    <style>
        /* Глобальные стили */
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 20px;
        }

        /* Стили для контейнера формы */
        form {
            max-width: 500px;
            margin: 0 auto;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        /* Стили для заголовков */
        label {
            font-weight: bold;
        }

        /* Стили для текстовых полей ввода */
        input[type="text"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        /* Стили для кнопки отправки */
        button[type="submit"] {
            padding: 10px 20px;
            background-color: #007BFF;
            border: none;
            color: #ffffff;
            text-decoration: none;
            text-align: center;
            cursor: pointer;
            border-radius: 4px;
        }

        button[type="submit"]:hover {
            background-color: #0056b3;
        }

        /* Стили для группы формы */
        .form-group {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<h2></h2>
<%
    Test test = (Test) request.getAttribute("test");
%>
<form action="/edit" method="post">
    <div class="form-group">
        <label for="name_test">Name:</label>
        <input type="text" id="name_test" name="name_test" value="<%= test.getName() %>" required>
    </div>

    <%-- Repeat the following block for each question --%>
    <% for (int i = 1; i <= 5; i++) { %>
    <div class="form-group">
        <label for="question<%= i %>"><%= bundle.getString("question.label")%> <%= i %>:</label>
        <input type="text" id="question<%= i %>" name="question<%= i %>" value="<%= getQuestionValue(test, i) %>" required>
    </div>
    <div class="form-group">
        <label for="option<%= i %>_1"><%= bundle.getString("option.label")%> 1:</label>
        <input type="text" id="option<%= i %>_1" name="option<%= i %>_1" value="<%= getOptionValue(test, i, 1) %>" required>
    </div>
    <div class="form-group">
        <label for="option<%= i %>_2"><%= bundle.getString("option.label")%> 2:</label>
        <input type="text" id="option<%= i %>_2" name="option<%= i %>_2" value="<%= getOptionValue(test, i, 2) %>" required>
    </div>
    <div class="form-group">
        <label for="option<%= i %>_3"><%= bundle.getString("option.label")%> 3:</label>
        <input type="text" id="option<%= i %>_3" name="option<%= i %>_3" value="<%= getOptionValue(test, i, 3) %>" required>
    </div>
    <label for="answer<%= i %>"><%= bundle.getString("answer.label")%> <%= i %>:</label>
    <select id="answer<%= i %>" name="answer<%= i %>" required>
        <option value="1" >1</option>
        <option value="2" >2</option>
        <option value="3">3</option>
    </select>
    <% } %>

    <div class="form-group">
        <button type="submit">Ananas</button>
    </div>
</form>
</body>
</html>

<%-- Add the following utility methods to access the test attributes --%>
<%!
    private String getQuestionValue(Test test, int questionNumber) {
        switch (questionNumber) {
            case 1:
                return test.getQuestion1();
            case 2:
                return test.getQuestion2();
            case 3:
                return test.getQuestion3();
            case 4:
                return test.getQuestion4();
            case 5:
                return test.getQuestion5();
            default:
                return "";
        }
    }

    private String getOptionValue(Test test,int questionNumber, int optionNumber) {
        switch (questionNumber) {
            case 1:
                switch (optionNumber) {
                    case 1:
                        return test.getQuestion1Option1();
                    case 2:
                        return test.getQuestion1Option2();
                    case 3:
                        return test.getQuestion1Option3();
                    default:
                        return "";
                }
            case 2:
                switch (optionNumber) {
                    case 1:
                        return test.getQuestion2Option1();
                    case 2:
                        return test.getQuestion2Option2();
                    case 3:
                        return test.getQuestion2Option3();
                    default:
                        return "";
                }
            case 3:
                switch (optionNumber) {
                    case 1:
                        return test.getQuestion3Option1();
                    case 2:
                        return test.getQuestion3Option2();
                    case 3:
                        return test.getQuestion3Option3();
                    default:
                        return "";
                }
            case 4:
                switch (optionNumber) {
                    case 1:
                        return test.getQuestion4Option1();
                    case 2:
                        return test.getQuestion4Option2();
                    case 3:
                        return test.getQuestion4Option2();
                    default:
                        return "";
                }
            case 5:
                switch (optionNumber) {
                    case 1:
                        return test.getQuestion5Option1();
                    case 2:
                        return test.getQuestion5Option2();
                    case 3:
                        return test.getQuestion5Option3();
                    default:
                        return "";
                }
            default:
                return "";
        }
    }

    private int getAnswerValue(Test test, int questionNumber) {
        switch (questionNumber) {
            case 1:
                return test.getAnswer1();
            case 2:
                return test.getAnswer2();
            case 3:
                return test.getAnswer3();
            case 4:
                return test.getAnswer4();
            case 5:
                return test.getAnswer5();
            default:
                return 1;
        }
    }
%>