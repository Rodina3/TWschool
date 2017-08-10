/**
 * Created by rzhou on 03/08/2017.
 */
$(document).ready(function () {

    $("#student-score").validate({
        rules: {
            id: {
                required:true,
                digits:true
            },
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
            id: {
                required:"请输入学生学号",
                digits:"学号非法",
            },
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


    $('#score-submit').click(function () {
        $('#score-notice').text("");
    });

});

$.validator.setDefaults({
    submitHandler: function () {
        var scores = getStudentFromForm();
        putToRemote("http://localhost:8080/db/students/scores", scores);
    }
});

function getStudentFromForm() {
    var formObj = $('#student-score').serializeArray();
    var scores = formatStudentScores(formObj);
    return scores;
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
    studentScores.math = parseInt(studentScores.math);
    studentScores.chinese=parseInt(studentScores.chinese);
    studentScores.english=parseInt(studentScores.english);
    studentScores.coding=parseInt(studentScores.coding);

    return studentScores;
}
