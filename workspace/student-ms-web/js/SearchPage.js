/**
 * Created by rzhou on 03/08/2017.
 */
$(document).ready(function () {
    getAllStudentsInfo("http://localhost:8080/db/students");
    $('#search-id-bn').click(function () {
        getStudentByIdInService();
    });

    $('#search-name-bn').click(function () {
        getStudentByNameInService();
    });

});

function getStudentByIdInService() {
    $('#name-searched').val("");
    var inputId = $('#id-searched').val();
    if (isLegalId(inputId)) {
        getStudentById("http://localhost:8080/db/students/" + inputId);
    }
}

function getStudentByNameInService() {
    $('#id-searched').val("");
    var inputName = $('#name-searched').val();
    getStudentByName("http://localhost:8080/db/students/name/" + inputName);
}

function isLegalId(id) {
    var re = /^[1-9]+[0-9]*]*$/;
    return re.test(id);
}


function showTableHeader() {

    var markup = "<tr> " +
        "<td class='col-md-2'>姓名</td> " +
        "<td class='col-md-1'>学号</td> " +
        "<td class='col-md-4'>邮箱</td> " +
        "<td class='col-md-4'>电话</td>" +
        "<td class = 'col-md-1'>修改成绩</td>" +
        "</tr>";
    $("#student-inquire").html(markup);
}

function showStudentItem(obj) {

    var markup = "<tr> " +
        "<td class='col-md-2'>${name}</td> " +
        "<td class='col-md-1'>${id}</td> " +
        "<td class='col-md-4'>${email}</td> " +
        "<td class='col-md-4'>${phone}</td>" +
        "<td class='col-md-1'><a href='./ScorePage.html?name=${name}&id=${id}'>修改</a>" +
        "</tr>";
    $.template("studentTemplate", markup);
    $.tmpl("studentTemplate", obj).appendTo("#student-inquire");
}


function getStudentById(url) {
    $.ajax({
        url: url,
        type: "GET",
        contentType: "application/json",
        dataType: "json",
        success: function (data) {
            $('#search-notice').text("获取学生成功");
            showTableHeader();
            showStudentItem(data);
        },
        error: function () {
            $('#search-notice').text("获取学生失败");
            showTableHeader();
        }
    })
}

function getStudentByName(url) {
    $.ajax({
        url: url,
        type: "GET",
        contentType: "application/json",
        dataType: "json",
        success: function (data) {
            $('#search-notice').text("获取学生成功");
            showTableHeader();
            for (let i = 0; i < data.length; i++) {
                showStudentItem(data[i]);
            }

        },
        error: function () {
            $('#search-notice').text("获取学生失败");
            showTableHeader();
        }
    })
}

function getAllStudentsInfo(url) {
    $.ajax({
        url: url,
        type: "GET",
        contentType: "application/json",
        dataType: "json",
        success: function (data) {
            $('#s').text("显示全部学生信息");
            showTableHeader();
            for (let i = 0; i < data.length; i++) {
                var student = data[i];
                showStudentItem(student);
            }
        },
        error: function () {
            $('#search-notice').text("获取学生失败");
        }
    })
}
