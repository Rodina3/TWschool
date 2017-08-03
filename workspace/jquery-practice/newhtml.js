/**
 * Created by rzhou on 02/08/2017.
 */
$(document).ready(function () {
    let stuStr = localStorage.getItem('Student');
    let student = JSON.parse(stuStr);

    //student info
    let name = $("<p></p>").text("姓名：" + student._name);
    let id = $("<p></p>").text("学号：" + student._id);
    let klass = $("<p></p>").text("班级：" + student._klass);

    $("#info").append(name, id, klass);


    let idTemplate = "(\"#ans-{0})\")";
    let answerTemplate = "<p> {0}:{1}</p>";

    // //fill in blank -- id
    // let str1 = student._answer[0][0];
    // let str2 = student._answer[0][1] + ', ' + student._answer[0][2] + ', ' + student._answer[0][3];
    // $("#ans-1-1").text(str1);
    // $("#ans-1-2").text(str2);

    //ratio -- customize template

    for (let i = 0; i < student._answer.length; i++) {
        let htmlElemID = idTemplate.replace("{0}", i + 1);

        for (let j = 0; j < student._answer[i].length; j++) {
            let str = answerTemplate.replace("{0}", j + 1);
            str = str.replace("{1}", student._answer[i][j]);

            htmlElemID.append(str);
        }
    }


});



