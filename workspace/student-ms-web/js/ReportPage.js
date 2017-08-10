/**
 * Created by rzhou on 09/08/2017.
 */
$(document).ready(function () {
    getReportFromRemote("http://localhost:8080/db/report");
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
            for (let i = 0; i < data.studentScoreItem.length; i++) {
                var obj = data.studentScoreItem[i];
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
        "<td class='col-md-1'>${math}</td> " +
        "<td class='col-md-1'>${chinese}</td> " +
        "<td class='col-md-1'>${english}</td>" +
        "<td class='col-md-1'>${coding}</td>" +
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
