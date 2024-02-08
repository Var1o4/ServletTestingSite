<%@ page import="java.util.ResourceBundle" %>
<%@ page import="java.util.Locale" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <%
        ResourceBundle bundle = ResourceBundle.getBundle("messages", (Locale) session.getAttribute("currentLocale"));
    %>
    <title><%= bundle.getString("page.title") %></title>
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
<h2><%= bundle.getString("page.title") %></h2>
<form action="/createTest" method="post">
    <div class="form-group">
        <label for="name_test"><%= bundle.getString("name.test")%>:</label>
        <input type="text" id="name_test" name="name_test" required>
    </div>
    <div class="form-group">
        <label for="question1"><%= bundle.getString("question.label") %> 1:</label>
        <input type="text" id="question1" name="question1" required>
    </div>
    <div class="form-group">
        <label for="option1_1"><%= bundle.getString("option.label") %> 1:</label>
        <input type="text" id="option1_1" name="option1_1" required>
    </div>
    <div class="form-group">
        <label for="option1_2"><%= bundle.getString("option.label") %> 2:</label>
        <input type="text" id="option1_2" name="option1_2" required>
    </div>
    <div class="form-group">
        <label for="option1_3"><%= bundle.getString("option.label") %> 3:</label>
        <input type="text" id="option1_3" name="option1_3" required>
    </div>
    <label for="answer1"><%= bundle.getString("answer.label") %> 1:</label>
    <select id="answer1" name="answer1" required>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
    </select>
    <div class="form-group">
        <label for="question2"><%= bundle.getString("question.label") %> 2:</label>
        <input type="text" id="question2" name="question2" required>
    </div>
    <div class="form-group">
        <label for="option2_1"><%= bundle.getString("option.label") %> 1:</label>
        <input type="text" id="option2_1" name="option2_1" required>
    </div>
    <div class="form-group">
        <label for="option2_2"><%= bundle.getString("option.label") %> 2:</label>
        <input type="text" id="option2_2" name="option2_2" required>
    </div>
    <div class="form-group">
        <label for="option2_3"><%= bundle.getString("option.label") %> 3:</label>
        <input type="text" id="option2_3" name="option2_3" required>
    </div>
    <label for="answer2"><%= bundle.getString("answer.label") %> 2:</label>
    <select id="answer2" name="answer2" required>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
    </select>
    <div class="form-group">
        <label for="question3"><%= bundle.getString("question.label") %> 3:</label>
        <input type="text" id="question3" name="question3" required>
    </div>
    <div class="form-group">
        <label for="option3_1"><%= bundle.getString("option.label") %> 1:</label>
        <input type="text" id="option3_1" name="option3_1" required>
    </div>
    <div class="form-group">
        <label for="option3_2"><%= bundle.getString("option.label") %> 2:</label>
        <input type="text" id="option3_2" name="option3_2" required>
    </div>
    <div class="form-group">
        <label for="option3_3"><%= bundle.getString("option.label") %> 3:</label>
        <input type="text" id="option3_3" name="option3_3" required>
    </div>
    <label for="answer3"><%= bundle.getString("answer.label") %> 3:</label>
    <select id="answer3" name="answer3" required>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
    </select>
    <div class="form-group">
        <label for="question4"><%= bundle.getString("question.label") %> 4:</label>
        <input type="text" id="question4" name="question4" required>
    </div>
    <div class="form-group">
        <label for="option4_1"><%= bundle.getString("option.label") %> 1:</label>
        <input type="text" id="option4_1" name="option4_1" required>
    </div>
    <div class="form-group">
        <label for="option4_2"><%= bundle.getString("option.label") %> 2:</label>
        <input type="text" id="option4_2" name="option4_2" required>
    </div>
    <div class="form-group">
        <label for="option4_3"><%= bundle.getString("option.label") %> 3:</label>
        <input type="text" id="option4_3" name="option4_3" required>
    </div>
    <label for="answer4"><%= bundle.getString("answer.label") %> 4:</label>
    <select id="answer4" name="answer4" required>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
    </select>
    <div class="form-group">
        <label for="question5"><%= bundle.getString("question.label") %> 5:</label>
        <input type="text" id="question5" name="question5" required>
    </div>
    <div class="form-group">
        <label for="option5_1"><%= bundle.getString("option.label") %> 1:</label>
        <input type="text" id="option5_1" name="option5_1" required>
    </div>
    <div class="form-group">
        <label for="option5_2"><%= bundle.getString("option.label") %> 2:</label>
        <input type="text" id="option5_2" name="option5_2" required>
    </div>
    <div class="form-group">
        <label for="option5_3"><%= bundle.getString("option.label") %> 3:</label>
        <input type="text" id="option5_3" name="option5_3" required>
    </div>
    <label for="answer5"><%= bundle.getString("answer.label") %> 5:</label>
    <select id="answer5" name="answer5" required>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
    </select>

    <div class="form-group">
        <button type="submit"><%= bundle.getString("createTest.button") %></button>
    </div>

</form>
</body>
</html>