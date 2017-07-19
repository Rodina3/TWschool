'use strict';

module.exports = function createUpdatedCollection(collectionA, objectB) {

    let collectionC = [];

    collectionC = countSameEle(collectionA);

    console.log("--debug3-3:1------------------")
    console.log(collectionC);

    for (let i = 0; i < collectionC.length; i++) {
        for (let j = 0; j < objectB.value.length; j++) {
            if (collectionC[i].key == objectB.value[j]) {
                collectionC[i].count = process3sub1(collectionC[i].count);
                break;
            }
        }
    }

    return collectionC;
}

function countSameEle(collection) {
    let same_collection = [];
    var index = 0;

    for (let i = 0; i < collection.length; i++) {
        index = Find(collection[i], same_collection);
        if (index == -1) {
            same_collection.push({key: collection[i], count: 1});
        }
        else {
            same_collection[index].count++;
        }
    }

    return same_collection;

}

function Find(ele, collection) {
    for (let i = 0; i < collection.length; i++) {
        if (ele == collection[i].key)
            return i;
    }

    return -1;
}


function process3sub1(num) {
    var loop_count = num;
    for (let i = 1; i <= loop_count; i++) {
        if (i % 3 == 0) {
            num--;
        }
    }
    return num;
}
