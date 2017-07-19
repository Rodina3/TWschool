'use strict';

module.exports = function countSameElements(collection) {
    var count_same_ele = [];

    for (var i = 0; i < collection.length; i++) {
        var index;
        if (collection[i].length == 1) {
            index = Find(collection[i], count_same_ele);
            if (index == -1) {
                count_same_ele.push({name: collection[i], summary: 1});
            }
            else {
                count_same_ele[index].summary++;
            }
        }
        else {
            var letter, number = 0;
            letter = LetterInStr(collection[i]);
            number = NumInStr(collection[i]);
            index = Find(letter, count_same_ele);
            console.log('2------');
            console.log(letter, number);
            if (index == -1) {
                count_same_ele.push({name: letter, summary: number});
            }
            else {
                count_same_ele[index].summary += number;
            }
        }
    }
    console.log('--------');
    console.log(count_same_ele);

    return count_same_ele;
}

function Find(ele, arr) {

    for (var j = 0; j < arr.length; j++) {
        if (ele == arr[j].name) {
            return j;
        }
    }
    return -1;
}

function LetterInStr(str) {
    for (let i = 0; i < str.length; i++) {
        if ((str[i] >= 'a' && str[i] <= 'z') || (str[i] >= 'A') && (str[i] <= 'Z')) {
            return str[i];
        }
    }
    return false;
}
function NumInStr(str) {
    var number = 0
    for (let i = 0; i < str.length; i++) {
        if (IsNumber(str[i])) {
            number = str[i] - '0';
            console.log('3----------');
            console.log(number);
            for (let j = i + 1; i < str.length; j++) {
                if (IsNumber(str[j])) {
                    number = number * 10 + (str[j] - '0')
                    console.log('3----------');
                    console.log(number);
                }
                else
                    break;
            }
            break;
        }
    }
    return number;
}

function IsNumber(character) {
    if ((character >= '0') && (character <= '9'))
        return true;

    return false;
}
