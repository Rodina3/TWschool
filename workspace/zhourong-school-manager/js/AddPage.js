/**
 * Created by rzhou on 03/08/2017.
 */
$(document).ready(function () {
    $('#add-submit').click(function () {
        saveStudentInfo();
        alert("添加学生成功！");
    });
});

function saveStudentInfo() {
    var obj = $('#student-info').serializeArray();
    var str = JSON.stringify(obj);
    localStorage.setItem('studentInfo', str);

}