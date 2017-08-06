/**
 * Created by rzhou on 03/08/2017.
 */
$(document).ready(function () {

    $('#search-id-bn').click(function () {

        if (findStudentById() !== null) {
            $('#search-notice').text("已找到。");
            showReportHeadder();
            showStudentItem(findStudentById());
        }
        else {
            $('#search-notice').text("无结果，显示所有学生信息。");
            onShow();
        }
    });


});



function findStudentById() {
    var formId = $('#id-searched').val();

    for (let i = 0; i < localStorage.length; i++) {
        var stuStr = localStorage.getItem('studentInfo' + i);
        if (stuStr !== null) {
            var student = JSON.parse(stuStr);
            if (student.id == formId) {
                return student;
            }
        }
        else
            return null;
    }
}


function showReportHeadder() {
    var markup = "<tr> " +
        "<td>姓名</td> " +
        "<td>学号</td> " +
        "<td>班级</td> " +
        "<td>邮箱</td> " +
        "<td>电话</td>" +
        "</tr>";
    $("#student-inquire").html(markup);
}

function showStudentItem(obj) {

    var markup = "<tr> " +
        "<td>${name}</td> " +
        "<td>${id}</td> " +
        "<td>${klass}</td> " +
        "<td>${email}</td> " +
        "<td>${phone}</td>" +
        "</tr>";
    $.template("studentTemplate", markup);
    $.tmpl("studentTemplate", obj).appendTo("#student-inquire");
}


function onShow() {
    showReportHeadder();
    for (let i = 0; i < localStorage.length; i++) {
        var stuStr = localStorage.getItem('studentInfo' + i);
        var student = JSON.parse(stuStr);
        showStudentItem(student);
    }

}