/**
 * Created by rzhou on 02/08/2017.
 */
$(document).ready(function () {
    let stuStr = localStorage.getItem('Student');
    let student = JSON.parse(stuStr);

    //student info
    let name = $("<p></p>").text("name:" + student._name);
    let id = $("<p></p>").text("student number:" + student._id);
    let klass = $("<p></p>").text("class:" + student._klass);

    $("#info").append(name, id, klass);

    //fill in blank
    let str1=student._answer[0][0];
    let str2=student._answer[0][1]+', '+student._answer[0][2]+', '+student._answer[0][3];
    $("#ans-1-1").text(str1);
    $("#ans-1-2").text(str2);

});