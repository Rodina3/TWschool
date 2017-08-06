/**
 * Created by rzhou on 03/08/2017.
 */
$(document).ready(function () {

    $('#search-id-bn').click(function () {
        $("#name-searched").val(" ");
        if (findStudentById() !== null) {
            $('#search-notice').text("找到1项。");
            showReportHeadder();
            showStudentItem(findStudentById());
        }
        else {
            $('#search-notice').text("无结果，显示所有学生信息。");
            onShow();
        }
    });

    $('#search-name-bn').click(function () {
        $('#id-searched').val(" ");
        var studentList = [];
        studentList = findStudentByName();
        if (studentList.length !== 0) {

            $('#search-notice').text("找到").append(studentList.length).append("项。");
            // $('#search-notice').append(studentList.length);
            // $('#search-notice').append("项。");

            showReportHeadder();
            for (let i = 0; i < studentList.length; i++) {
                showStudentItem(studentList[i]);
            }

        }
        else {
            $('#search-notice').text("无结果，显示所有学生信息。");
            onShow();
        }
    })

});

function findStudentByName() {
    var studentList = [];
    var inputName = $('#name-searched').val();
    for (let i = 0; i < localStorage.length; i++) {
        var stuStr = localStorage.getItem('studentInfo' + i);
        if (stuStr !== null) {
            var student = JSON.parse(stuStr);
            if (student.name == inputName) {
                studentList.push(student);
            }
        }
        else
            break;
    }
    return studentList;
}


function findStudentById() {
    var inputId = $('#id-searched').val();

    for (let i = 0; i < localStorage.length; i++) {
        var stuStr = localStorage.getItem('studentInfo' + i);
        if (stuStr !== null) {
            var student = JSON.parse(stuStr);
            if (student.id == inputId) {
                return student;
            }
        }
        else
            return null;
    }
}


function showReportHeadder() {
    var markup = "<tr> " +
        "<td class='col-md-2'>姓名</td> " +
        "<td class='col-md-1'>学号</td> " +
        "<td class='col-md-1'>班级</td> " +
        "<td class='col-md-4'>邮箱</td> " +
        "<td class='col-md-4'>电话</td>" +
        "</tr>";
    $("#student-inquire").html(markup);
}

function showStudentItem(obj) {

    var markup = "<tr> " +
        "<td class='col-md-2'>${name}</td> " +
        "<td class='col-md-1'>${id}</td> " +
        "<td class='col-md-1'>${klass}</td> " +
        "<td class='col-md-4'>${email}</td> " +
        "<td class='col-md-4'>${phone}</td>" +
        "</tr>";
    $.template("studentTemplate", markup);
    $.tmpl("studentTemplate", obj).appendTo("#student-inquire");
}


function onShow() {
    showReportHeadder();
    for (let i = 0; i < localStorage.length; i++) {
        var stuStr = localStorage.getItem('studentInfo' + i);
        if (stuStr == null) break;
        var student = JSON.parse(stuStr);
        showStudentItem(student);
    }

}