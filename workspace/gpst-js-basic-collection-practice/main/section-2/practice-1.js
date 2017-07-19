'use strict';

module.exports = function countSameElements(collection) {
    var count_same_ele = [];

    for (var i = 0; i < collection.length; i++) {
        var index;
        index = IsExist(collection[i], count_same_ele);
        if (index == -1) {
            count_same_ele.push({key: collection[i], count: 1});
        }
        else {
            count_same_ele[index].count++;
        }
    }
    return count_same_ele;
}

function IsExist(ele, arr) {

    for (var j = 0; j < arr.length; j++) {
        if (ele == arr[j].key) {
            return j;
        }
    }
    return -1;
}
