/**
 * Created by rzhou on 03/08/2017.
 */
$(document).ready(function () {
    $('#search-button').click(function () {
        // $('#student-inquire').html("");
        // for (let i = 0; i < localStorage.length; i++) {
        //     var stuStr = localStorage.getItem('studentInfo' + i);
        //     var student = JSON.parse(stuStr);
        //     //showReportHeader();
        //     showStudentItem(student);
        // }
        showStudentItem();
    });
});


function showStudentItem(obj) {


    var markup = "<tr> " +
        "<td>${name}</td> " +
        "<td>${id}</td> " +
        "<td>${klass}</td> " +
        "<td>${email}</td> " +
        "<td>${phone}</td>" +
        "</tr>";

    // /* Compile the markup as a named template */
    // $.template("studentTemplate", markup);
    // /* Render the template with the movies data and insert
    //  the rendered HTML under the "movieList" element */
    // $.tmpl("studentTemplate", obj).appendTo("#student-inquire");

    $("#myTemplate").tmpl(obj).appendTo("markup");
}


function onShow() {
    for (let i = 0; i < localStorage.length; i++) {
        var stuStr = localStorage.getItem('studentInfo' + i);
        var student = JSON.parse(stuStr);
        //showReportHeader();
        //showStudentItem(student);
    }

}