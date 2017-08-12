/**
 * Created by rzhou on 03/08/2017.
 */
$(document).ready(function () {
    getAllStudentsFromRemote("http://localhost:8080/db/students");
    $('#search-id-bn').click(function () {
        $("#name-searched").val(" ");
        getStudentByIdInService();
    });

    $('#search-name-bn').click(function () {
    });

});

function getStudentByIdInService() {
    $('#name-searched').val(" ");
    var inputId = $('#id-searched').val();
    if (isLegalId(inputId)) {
        var student = getStudentFromRemote("http://localhost:8080/db/students/" + inputId);
        showStudentItem(student);
    }

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
        // "<td class = 'col-md-1'>添加成绩</td>" +
        "</tr>";
    $("#student-inquire").html(markup);
}

function showStudentItem(obj) {

    var markup = "<tr> " +
        "<td class='col-md-2'>${name}</td> " +
        "<td class='col-md-1'>${id}</td> " +
        "<td class='col-md-4'>${email}</td> " +
        "<td class='col-md-4'>${phone}</td>" +
        //"<td class='col-md-1'><a href='./ScorePage.html?id=${id}'>添加</a>" +
        "</tr>";
    $.template("studentTemplate", markup);
    $.tmpl("studentTemplate", obj).appendTo("#student-inquire");
}


function getStudentFromRemote(url) {
    var result;
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

function getAllStudentsFromRemote(url) {
    var result;
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
