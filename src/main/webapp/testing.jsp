<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Выбор действия</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }

        h1 {
            text-align: center;
        }

        .button-container {
            text-align: center;
            margin-bottom: 20px;
        }

        .button-container button {
            margin: 10px;
            padding: 10px 20px;
            font-size: 16px;
        }

        .question-form {
            width: 400px;
            margin: 0 auto;
        }

        .question-form label {
            display: block;
            margin-bottom: 10px;
        }

        .question-form textarea,
        .question-form input[type="text"] {
            width: 100%;
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .question-form input[type="submit"] {
            width: 100%;
            margin-top: 10px;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<h1>Выбор действия</h1>

<div class="button-container">
    <button onclick="showTestList()">Пройти тест</button>
    <button onclick="showQuestionForm()">Написать тест</button>
</div>

<div id="testList" style="display: none;">
    <h2>Список тестов</h2>
    <button onclick="goToTest('Тест 1')">Тест 1</button>
    <button onclick="goToTest('Тест 2')">Тест 2</button>
    <button onclick="goToTest('Тест 3')">Тест 3</button>
</div>

<div id="questionForm" style="display: none;">
    <h2>Форма для заполнения вопросов</h2>
    <form action="/submitTest" method="post">
        <h2>Форма для написания теста</h2>

        <fieldset>
            <legend>Вопрос 1:</legend>
            <label for="question1">Вопрос:</label>
            <textarea id="question1" name="question1" rows="4" required></textarea><br>

            <label for="answer1_1">Вариант ответа 1:</label>
            <input type="text" id="answer1_1" name="answer1_1" required><br>

            <label for="answer1_2">Вариант ответа 2:</label>
            <input type="text" id="answer1_2" name="answer1_2" required><br>

            <label for="answer1_3">Вариант ответа 3:</label>
            <input type="text" id="answer1_3" name="answer1_3" required><br>
        </fieldset>

        <fieldset>
            <legend>Вопрос 2:</legend>
            <label for="question2">Вопрос:</label>
            <textarea id="question2" name="question2" rows="4" required></textarea><br>

            <label for="answer2_1">Вариант ответа 1:</label>
            <input type="text" id="answer2_1" name="answer2_1" required><br>

            <label for="answer2_2">Вариант ответа 2:</label>
            <input type="text" id="answer2_2" name="answer2_2" required><br>

            <label for="answer2_3">Вариант ответа 3:</label>
            <input type="text" id="answer2_3" name="answer2_3" required><br>
        </fieldset>

        <fieldset>
            <legend>Вопрос 3:</legend>
            <label for="question3">Вопрос:</label>
            <textarea id="question3" name="question3" rows="4" required></textarea><br>

            <label for="answer3_1">Вариант ответа 1:</label>
            <input type="text" id="answer3_1" name="answer3_1" required><br>

            <label for="answer3_2">Вариант ответа 2:</label>
            <input type="text" id="answer3_2" name="answer3_2" required><br>

            <label for="answer3_3">Вариант ответа 3:</label>
            <input type="text" id="answer3_3" name="answer3_3" required><br>
        </fieldset>

        <fieldset>
            <legend>Вопрос 4:</legend>
            <label for="question4">Вопрос:</label>
            <textarea id="question4" name="question4" rows="4" required></textarea><br>

            <label for="answer4_1">Вариант ответа 1:</label>
            <input type="text" id="answer4_1" name="answer4_1" required><br>

            <label for="answer4_2">Вариант ответа 2:</label>
            <input type="text" id="answer4_2" name="answer4_2" required><br>

            <label for="answer4_3">Вариант ответа 3:</label>
            <input type="text" id="answer4_3" name="answer4_3" required><br>
        </fieldset>

        <fieldset>
            <legend>Вопрос 5:</legend>
            <label for="question5">Вопрос:</label>
            <textarea id="question5" name="question5" rows="4" required></textarea><br>

            <label for="answer5_1">Вариант ответа 1:</label>
            <input type="text" id="answer5_1" name="answer5_1" required><br>

            <label for="answer5_2">Вариант ответа 2:</label>
            <input type="text" id="answer5_2" name="answer5_2" required><br>
                <label for="answer5_3">Вариант ответа 3:</label>
                <input type="text" id="answer5_3" name="answer5_3" required><br>
        </fieldset>

        <input type="submit" value="Отправить">
    </form>
</div>

<script>
    function showTestList() {
        document.getElementById("testList").style.display = "block";
    }

    function goToTest(testName) {
        // Здесь можно выполнить действия по переходу к выбранному тесту
        alert("Переход к тесту: " + testName);
    }

    function showQuestionForm() {
        document.getElementById("questionForm").style.display = "block";
    }

    window.onload = function() {
        var answer1 = document.getElementById("answer1");
        var answer2 = document.getElementById("answer2");
        var answer3 = document.getElementById("answer3");

        answer1.addEventListener("input", function() {
            if (answer1.value !== "") {
                answer2.disabled = true;
                answer3.disabled = true;
            } else {
                answer2.disabled = false;
                answer3.disabled = false;
            }
        });

        answer2.addEventListener("input", function() {
            if (answer2.value !== "") {
                answer1.disabled = true;
                answer3.disabled = true;
            } else {
                answer1.disabled = false;
                answer3.disabled = false;}
    });

    answer3.addEventListener("input", function() {
        if (answer3.value !== "") {
            answer1.disabled = true;
            answer2.disabled = true;
        } else {
            answer1.disabled = false;
            answer2.disabled = false;
        }
    });
    };
</script>
</body>
</html>