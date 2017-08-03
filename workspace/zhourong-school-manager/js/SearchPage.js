/**
 * Created by rzhou on 03/08/2017.
 */
$(document).ready(function () {
    $('#search-button').click(function () {
        var stuStr = localStorage.getItem('studentInfo');
        var studentInfo = JSON.parse(stuStr);
        for(var i=0;i<studentInfo.length;i++)
        {
            console.log("key:"+studentInfo[i].name+"value:"+studentInfo[i].value);
        }

    });
});