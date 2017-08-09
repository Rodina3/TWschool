/**
 * Created by rzhou on 03/08/2017.
 */
$(document).ready(function () {

    $("#student-info").validate({
        rules: {
            name: "required",
            phone: {
                required: true,
                minlength: 11,
            },
            email: {
                required: true,
                email: true,
            },
        },
        messages: {
            name: "请输入学生名字",
            //klass: "请输入学生班级",
            phone: {
                required: "请输入学生电话",
                minlength: "电话号码非法，必须为11位",
            },
            email: "请输入学生邮箱",
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


    $('#add-submit').click(function () {
        $('#add-notice').text("");
    });

});

$.validator.setDefaults({
    submitHandler: function () {
        postToRemote("http://localhost:8080/students", getStudentFromForm());
    }
});

function getStudentFromForm() {
    var formObj = $('#student-info').serializeArray();
    var student = formatStudent(formObj);
    var studentAPI = {};
    studentAPI.name = student.name;
    studentAPI.id = student.id;
    studentAPI.email = student.email;
    studentAPI.phone = student.phone;
    studentAPI.scores = {};
    studentAPI.scores.math = 0;
    studentAPI.scores.chinese = 0;
    studentAPI.scores.english = 0;
    studentAPI.scores.coding = 0;

    return studentAPI;
}


function postToRemote(url, student) {
    $.ajax({
        url: url,
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify(student),
        dataType: "json",
        success: function () {
            $('#add-success-notice').text("添加学生成功");
        },
        error: function () {
            $('#add-success-notice').text("添加学生失败");
        }
    })
}

function formatStudent(obj) {
    var student = {};
    for (let i = 0; i < obj.length; i++) {
        student[obj[i].name] = obj[i].value;
    }
    student.id = 0;
    return student;
}