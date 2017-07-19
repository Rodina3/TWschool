'use strict';

module.exports = function createUpdatedCollection(collectionA, objectB) {

    let collectionC = [];

    collectionC = countSameEle(collectionA);
    //console.log('----3-4:1------');
    //console.log(collectionC);

    collectionC = subSameEle(collectionC, objectB);
    //console.log('----3-4:2------');
    //console.log(collectionC);

    return collectionC;
}


function countSameEle(collection) {
    let same_collection = [];
    // let index = 0;

    for (let i = 0; i < collection.length; i++) {
        /*index = Find(collection[i],same_collection);
         if(index == -1)
         {
         same_collection.push({key:collection[i],count:1});
         }
         else
         {
         same_collection[index].count++;
         }*/

        if (collection[i].length === 1)
            countSingleEle(collection[i], same_collection);
        else
            countLongEle(collection[i], same_collection);
    }

    return same_collection;

}

function countSingleEle(ele, same_arr) {
    let index;
    index = Find(ele, same_arr);
    if (index === -1) {
        same_arr.push({key: ele, count: 1});
    }
    else {
        same_arr[index].count++;
    }
    return same_arr;

}

function countLongEle(ele, same_arr) {
    let letter = ele.split('-')[0];
    let number = parseInt(ele.split('-')[1]);
    let index = Find(letter, same_arr);
    if (index !== -1) {
        same_arr[index].count += number;
    }
    else {
        same_arr.push({key: letter, count: number});
    }
    return same_arr;
}

function Find(ele, collection) {
    for (let i = 0; i < collection.length; i++) {
        if (ele == collection[i].key)
            return i;
    }

    return -1;
}

function subSameEle(arr1, arr2) {
    for (let i = 0; i < arr1.length; i++) {
        for (let j = 0; j < arr2.value.length; j++) {
            if (arr1[i].key === arr2.value[j]) {
                arr1[i].count = process3sub1(arr1[i].count);
                break;
            }
        }
    }
    return arr1;
}

function process3sub1(num) {
    return (num - parseInt(num / 3));
}

