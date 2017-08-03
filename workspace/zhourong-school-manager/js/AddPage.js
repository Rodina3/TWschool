/**
 * Created by rzhou on 03/08/2017.
 */
$(document).ready(function () {

    $("#student-info").validate({
        rules: {
            name: "required",
            klass: "required",
            phone: {
                required: true,
                minlength: 11
            },
            email: {
                required: true,
                email: true
            }
        },
        messages: {
            name: "请输入学生名字",
            klass: "请输入学生班级",
            phone: {
                required: "请输入学生电话",
                minlength: "电话号码非法，必须为11位"
            },
            email: "请输入学生邮箱"
        },

        errorElement: "em",
        errorPlacement: function (error, element) {
            // Add the `help-block` class to the error element
            error.addClass("help-block");

            if (element.prop("type") === "checkbox") {
                error.insertAfter(element.parent("label"));
            } else {
                error.insertAfter(element);
            }
        },
        highlight: function (element, errorClass, validClass) {
            $(element).parents(".col-sm-5").addClass("has-error").removeClass("has-success");
        },
        unhighlight: function (element, errorClass, validClass) {
            $(element).parents(".col-sm-5").addClass("has-success").removeClass("has-error");
        }
    });


});

function saveStudentInfo() {
    var obj = $('#student-info').serializeArray();
    var str = JSON.stringify(obj);
    localStorage.setItem('studentInfo', str);

}


$.validator.setDefaults({
    submitHandler: function () {
        saveStudentInfo();
        $('#add-success-notice').text("添加学生成功");
        //刷新表单
        //添加不成功的时候，去掉这句话
    }
});

