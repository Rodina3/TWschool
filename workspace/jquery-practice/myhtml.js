/**
 * Created by rzhou on 02/08/2017.
 */
class Student {
    constructor() {
        this._klass = 0;
        this._name = "";
        this._id = 0;
        this._answer = [];
    }

    set klass(value) {
        this._klass = value;
    }

    set id(value) {
        this._id = value;
    }

    set name(value) {
        this._name = value;
    }


    set answer(value) {
        this._answer.push(value);
    }
}

$(document).ready(function () {
    $("button").click(function () {
        const student = new Student();
        getAllContent(student);
        let stuString = JSON.stringify(student);
        localStorage.setItem('Student',stuString);
        $(location).attr('href', 'newhtml.html');
    });
});


function getAllContent(obj) {

    // var flag;
    getStudentInof(obj);
    getFillInBlank(obj);
    getRadioChoice(obj);
    getMultipleChoice(obj);
    getTrueOrFalse(obj);
    getEasyQuestion(obj);

}


function getStudentInof(obj) {


    obj.klass = $('#klass').val();


    // var reg = new RegExp("^[0-9]*$");
    // if(!reg.test(id)){
    //     alert("学号不是数字!");
    //     return false;
    // }
    obj.id = $('#id').val();
    obj.name = $('#name').val();
}

function getFillInBlank(obj) {
    const ans = [];
    ans.push($('.fill-in-blank-1').val());

    let par = $(".fill-in-blank-2");
    for (i = 0; i < par.length; i++) {
        ans.push(par[i].value);
    }
    obj.answer = ans;
}


function getRadioChoice(obj) {
    const ans = [];
    ans.push($("#ratio-choice-1").find("input:checked")[0].value);
    ans.push($("#ratio-choice-2").find("input:checked")[0].value);
    obj.answer = ans;
}


function getMultipleChoice(obj) {
    let answer3_2 = "";
    let answer3_1 = "";
    let len = $("#multiple-choice-1").find("input:checked");
    for (i = 0; i < len.length; i++) {
        answer3_1 += (len[i].value);
    }
    len = $("#multiple-choice-2").find("input:checked");
    for (i = 0; i < len.length; i++) {
        answer3_2 += (len[i].value);
    }
    const ans = [];
    ans.push(answer3_1);
    ans.push(answer3_2);
    obj.answer = ans;
}


function getTrueOrFalse(obj) {
    const ans = [];
    ans.push($("#true-or-false-1").find("input:checked")[0].value);
    ans.push($("#true-or-false-2").find("input:checked")[0].value);
    obj.answer = ans;
}

function getEasyQuestion(obj) {
    obj.answer = $("#easy-question").find("textarea").val();
}

