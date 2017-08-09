/**
 * Created by rzhou on 09/08/2017.
 */
$(document).ready(function () {
    getReportFromRemote("http://localhost:8080/report");
});

function getReportFromRemote(url) {
    var result;
    $.ajax({
        url: url,
        type: "GET",
        contentType: "application/json",
        dataType: "json",
        success: function (data) {
            showReportTable();
            for (let i = 0; i < data.studentItem.length; i++) {
                var obj = data.studentItem[i];
                showReportItem(obj);
            }
            $("#totalAverage").text("总分平均分："+data.average);
            $("#totalScore").text("总分中位数："+data.median);
        },
        error: function () {
        }
    })
}

function showReportItem(obj) {
    var markup = "<tr> " +
        "<td class='col-md-1'>${name}</td> " +
        "<td class='col-md-1'>${id}</td> " +
        "<td class='col-md-1'>${scores.math}</td> " +
        "<td class='col-md-1'>${scores.chinese}</td> " +
        "<td class='col-md-1'>${scores.english}</td>" +
        "<td class='col-md-1'>${scores.coding}</td>" +
        "</tr>";
    $.template("reportTemplate", markup);
    $.tmpl("reportTemplate", obj).appendTo("#reportItem");
}
function showReportTable() {
    var markup = "<tr>" +
        "<td class='col-md-1'>姓名</td>" +
        "<td class='col-md-1'>学号</td>" +
        "<td class='col-md-1'>语文</td>" +
        "<td class='col-md-1'>数学</td>" +
        "<td class='col-md-1'>英语</td>" +
        "<td class='col-md-1'>编程</td>" +
        "</tr>";

    $("#reportItem").html(markup);
}
