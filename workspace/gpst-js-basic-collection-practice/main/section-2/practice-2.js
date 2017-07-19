'use strict';

module.exports = function countSameElements(collection) {
    var count_same_ele = [];

    for (var i = 0; i < collection.length; i++) {
        var index;
        if (collection[i].length == 1) {
            index = Find(collection[i], count_same_ele);
            if (index == -1) {
                count_same_ele.push({key: collection[i], count: 1});
            }
            else {
                count_same_ele[index].count++;
            }
        }
        else {
            var letter, number = 0;
            letter = LetterInStr(collection[i]);
            number = NumInStr(collection[i]) - '0';
            index = Find(letter, count_same_ele);
            if (index == -1) {
                count_same_ele.push({key: letter, count: number});
            }
            else {
                count_same_ele[index].count += number;
            }
        }
    }
    return count_same_ele;
}

function Find(ele, arr) {

    for (var j = 0; j < arr.length; j++) {
        if (ele == arr[j].key) {
            return j;
        }
    }
    return -1;
}

function LetterInStr(str) {
    for (let i = 0; i < str.length; i++) {
        if ((str[i] > 'a' && str[i] < 'z') || (str[i] > 'A') && (str[i] < 'Z')) {
            return str[i];
        }
    }
    return false;
}
function NumInStr(str) {
    var str1 = '';
    for (let i = 0; i < str.length; i++) {
        if ((str[i] >= '0') && (str[i] <= '9')) {
            str1 += str[i];
        }
    }
    return str1;
}