/**
 * Created by rzhou on 03/08/2017.
 */
$(document).ready(function () {
    getFromRemote("http://localhost:8080/students");

    $('#search-id-bn').click(function () {
        $("#name-searched").val(" ");
        if (findStudentByIdInLocalStorage() !== null) {
            $('#search-notice').text("找到1项。");
            showReportHeader();
            showStudentItem(findStudentByIdInLocalStorage());
        }
        else {
            $('#search-notice').text("无结果，显示所有学生信息。");

        }
    });

    $('#search-name-bn').click(function () {
        //localStorage
        // $('#id-searched').val(" ");
        // var studentList = [];
        // studentList = findStudentByNameInLocalStorage();
        // if (studentList.length !== 0) {
        //
        //     $('#search-notice').text("找到").append(studentList.length).append("项。");
        //     // $('#search-notice').append(studentList.length);
        //     // $('#search-notice').append("项。");
        //
        //     showReportHeader();
        //     for (let i = 0; i < studentList.length; i++) {
        //         showStudentItem(studentList[i]);
        //     }
        //
        // }
        // else {
        //     $('#search-notice').text("无结果，显示所有学生信息。");
        //     //onShow();
        // }
    })

});

function findStudentByIdInService() {
    $('#id-searched').val(" ");
    var inputId = $('#id-searched').val();
    if(isLegalId(inputId))
    {
        getFromRemote("http://localhost:8080/students/"+inputId);
    }

}

function isLegalId(){
    return true;

}



function findStudentByNameInLocalStorage() {
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


function findStudentByIdInLocalStorage() {
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


function showReportHeader() {
    var markup = "<tr> " +
        "<td class='col-md-2'>姓名</td> " +
        "<td class='col-md-1'>学号</td> " +
        //"<td class='col-md-1'>班级</td> " +
        "<td class='col-md-4'>邮箱</td> " +
        "<td class='col-md-4'>电话</td>" +
        "</tr>";
    $("#student-inquire").html(markup);
}

function showStudentItem(obj) {

    var markup = "<tr> " +
        "<td class='col-md-2'>${name}</td> " +
        "<td class='col-md-1'>${id}</td> " +
        //"<td class='col-md-1'>${klass}</td> " +
        "<td class='col-md-4'>${email}</td> " +
        "<td class='col-md-4'>${phone}</td>" +
        "</tr>";
    $.template("studentTemplate", markup);
    $.tmpl("studentTemplate", obj).appendTo("#student-inquire");
}
//
// function onShow() {
//     showReportHeader();
//     var student = getStudentFromRemote("http://localhost:8080/students");
//
//     for (let i = 0; i < localStorage.length; i++) {
//         var stuStr = localStorage.getItem('studentInfo' + i);
//         if (stuStr == null) break;
//         var student = JSON.parse(stuStr);
//         showStudentItem(student);
//     }
// }

function getFromRemote(url) {
    $.ajax({
        url: url,
        type: "GET",
        contentType: "application/json",
        dataType: "json",
        success: function (data) {
            $('#s').text("获取学生成功");
            showReportHeader();
            for (let i = 0; i < data.studentList.length; i++) {
                var student = data.studentList[i];
                showStudentItem(student);
            }
        },
        error: function () {
            $('#add-success-notice').text("获取学生失败");
        }
    })
}