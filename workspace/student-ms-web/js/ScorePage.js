/**
 * Created by rzhou on 03/08/2017.
 */
$(document).ready(function () {

    const id = getURLParameter("id");
    const name = getURLParameter("name");
    $('#name').text(name);
    $('#id').text(id);

    getFromRemote("http://localhost:8080/db/students/scores/" + id);

    $("#student-score").validate({
        rules: {
            math: {
                required: true,
                digits: true,
                range: [0, 100]
            },
            chinese: {
                required: true,
                digits: true,
                range: [0, 100]
            },
            english: {
                required: true,
                digits: true,
                range: [0, 100]
            },
            coding: {
                required: true,
                digits: true,
                range: [0, 100]
            },

        },
        messages: {
            math: {
                required: "请输入数学成绩",
                digits: "请输入整数",
                range: "非法，成绩必须为0-100",
            },
            chinese: {
                required: "请输入语文成绩",
                digits: "请输入整数",
                range: "非法，成绩必须为0-100",
            },
            english: {
                required: "请输入英语成绩",
                digits: "请输入整数",
                range: "非法，成绩必须为0-100",
            },
            coding: {
                required: "请输入编程成绩",
                digits: "请输入整数",
                range: "非法，成绩必须为0-100",
            },

        },

        errorElement: "em",
        errorPlacement: function (error, element) {
            // Add the `help-block` class to the error element
            error.addClass("help-block");

            if (element.prop("type") === "checkbox") {
                error.insertAfter(element.parent("label"));
            } else {
                error.insertAfter(element);
            }
        }
    });
});

$('#score-submit').click(function () {
    $('#score-notice').text("");
});

$.validator.setDefaults({
    submitHandler: function () {
        var scores = getStudentFromForm();
        putToRemote("http://localhost:8080/db/students/scores", scores);
    }
});

function getURLParameter(name) {
    return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search) || [null, ''])[1].replace(/\+/g, '%20')) || null;
}

function getStudentFromForm() {
    var formObj = $('#student-score').serializeArray();
    var scores = formatStudentScores(formObj);
    return scores;
}

function getFromRemote(url) {
    $.ajax({
        url: url,
        type: "GET",
        success: function (data) {
            showStudentScores(data);
        }
    })
}


function putToRemote(url, scores) {
    $.ajax({
        url: url,
        type: "PUT",
        contentType: "application/json",
        data: JSON.stringify(scores),
        dataType: "json",
        success: function () {
            $('#score-notice').text("修改成绩成功");
        },
        error: function () {
            $('#score-notice').text("查无此人，修改成绩失败");
        }
    })
}

function formatStudentScores(obj) {
    var studentScores = {};
    for (let i = 0; i < obj.length; i++) {
        studentScores[obj[i].name] = obj[i].value;
    }
    studentScores.id = $("#id").text();
    studentScores.math = parseInt(studentScores.math);
    studentScores.chinese = parseInt(studentScores.chinese);
    studentScores.english = parseInt(studentScores.english);
    studentScores.coding = parseInt(studentScores.coding);

    return studentScores;
}

$("#return").click(function () {
    window.location.href = "./SearchPage.html";
});

function showStudentScores(obj) {
    $("#student-scores").html("");
    var markup =
        "<p>数学：<label><input value=${math} name='math'></label></p>" +
        "<p>语文：<label><input value=${chinese} name='chinese'></label></p>" +
        "<p>英语：<label><input value=${english} name='english'></label></p>" +
        "<p>编程：<label><input value=${coding} name='coding'></label></p>" +
        "<p><input id='score-submit' type='submit' value='提交'></p>";


    $.template("studentTemplate", markup);
    $.tmpl("studentTemplate", obj).appendTo("#student-score");
}
