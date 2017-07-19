'use strict';
//let fun = require('../test/fixtures');

//TODO: 请在该文件中实现练习要求并删除此注释
function printReceipt(tagArray) {
    let itemArray = tag2Item(tagArray);
    let itemList = gatherItem(itemArray);
    let itemAfterDiscount = promotion(itemList);

    let outputString = '';
    let str = '';
    let prefix = '***<没钱赚商店>收据***\n';
    outputString += prefix;

    let totalPrice = 0, totalDiscount = 0;
    for (let i = 0; i < itemAfterDiscount.length; i++) {
        str = itemDetailString(itemAfterDiscount[i]);
        outputString = outputString + str + '\n';
        totalDiscount += itemAfterDiscount[i].discount;
        totalPrice += itemAfterDiscount[i].sumPrice;
    }
    let suffix = '----------------------\n总计：' + totalPrice.toFixed(2) + '(元)\n' + '节省：' + totalDiscount.toFixed(2) + '(元)\n' + '**********************';
    outputString += suffix;
    console.log(outputString);
    // return string;*/
}


function tag2Item(tagsArray) {

    let itemInfo = loadAllItems();
    let item = [];
    let obj = {};
    for (let i = 0; i < tagsArray.length; i++) {
        if (tagsArray[i].length == 10) {
            obj = simpleTag(tagsArray[i]);
            item.push(obj);
        }
        else {
            obj = complexTag(tagsArray[i]);
            item.push(obj);
        }


    }
    return item;
}

function simpleTag(string) {
    let obj = {};
    let itemInfo = loadAllItems();

    for (let j = 0; j < itemInfo.length; j++) {

        if (string == itemInfo[j].barcode) {
            obj = itemInfo[j];
            obj.count = 1;
            return obj;
        }
    }
}

function complexTag(string) {
    let obj = {};
    let itemInfo = loadAllItems();

    let itemCode = '';
    let itemCount = '';
    itemCode = string.split('-')[0];
    itemCount = string.split('-')[1];

    for (let j = 0; j < itemInfo.length; j++) {


        if (itemCode == itemInfo[j].barcode) {
            obj = itemInfo[j];
            obj.count = parseFloat(itemCount);
            return obj;
        }
    }
}


function gatherItem(itemList) {
    let itemRecord = [];
    for (let i = 0; i < itemList.length; i++) {
        countItem(itemList[i], itemRecord);
    }

    for (let i = 0; i < itemList.length; i++) {
        itemList[i].sumPrice = itemList[i].count * itemList[i].price;
    }
    return itemRecord;

}

function countItem(obj, itemRecord) {
    for (let i = 0; i < itemRecord.length; i++) {
        if (obj.barcode == itemRecord[i].barcode) {
            itemRecord[i].count += obj.count;
            return;
        }
    }
    itemRecord.push(obj);
    return;
}

function promotion(itemBeforeDiscount) {
    let itemAfterDiscount = itemBeforeDiscount;
    let obj;
    for (let i = 0; i < itemBeforeDiscount.length; i++) {

        if (isPromtionItem(itemBeforeDiscount[i])) {

            obj = promotionRule(itemBeforeDiscount[i]);
            itemAfterDiscount[i].discount = obj.discount;
            itemAfterDiscount[i].sumPrice = obj.sumPrice;
        }
        else {
            itemAfterDiscount[i].discount = 0;
        }

    }

    return itemAfterDiscount;
}

function isPromtionItem(obj) {
    let promotionItem = loadPromotions();
    let promotionArr = promotionItem[0].barcodes;

    for (let i = 0; i < promotionArr.length; i++) {
        if (obj.barcode == promotionArr[i]) {
            return true;
        }
    }
    return false;
}

function promotionRule(obj) {

    let quantity = obj.count;
    if (quantity > 3) {
        quantity--;
    }
    obj.discount = obj.price;
    obj.sumPrice -= obj.discount;

    return obj;

}
function itemDetailString(obj) {
    let str = '';
    let strPrice = obj.price.toFixed(2);
    let strSumPrice = obj.sumPrice.toFixed(2);
    str = '名称：' + obj.name + '，数量：' + obj.count + obj.unit + '，单价：' + strPrice + '(元)，小计：' + strSumPrice + '(元)';
    return str;
}




