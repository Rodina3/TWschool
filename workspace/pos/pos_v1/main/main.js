'use strict';
//let fun = require('../test/fixtures');

//TODO: 请在该文件中实现练习要求并删除此注释
function printReceipt(tagArray) {
    /*let items = tag2Item(tagArray);
     let itemList = clarifyItem(items);
     let itemDiscount  = getPromotion(itemList);
     let itemsReceipt=getReceipt(itemDiscount);

     let prefix = '***<没钱赚商店>收据***';
     let sum=0;
     console.log(prefix);
     for(let i=0;i<itemsReceipt.length;i++)
     {
     console('名称：'+itemsReceipt[i].name + '，数量：'+itemsReceipt[i].count+'，单价：'+itemsReceipt[i].price+'(元)'+itemsReceipt[i].unit+'，小计：'+itemsReceipt.sum+'（元）')
     sum += itemsReceipt[i].sum;
     }
     console.log('----------------------\n总计：'+sum+'(元)\n'+'节省：'+'(元)\n'+ '**********************');

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

            obj=promotionRule(itemBeforeDiscount[i]);
            itemAfterDiscount[i].discount = obj.discount;
            itemAfterDiscount[i].sumPrice=obj.sumPrice;
        }
        else {
            itemAfterDiscount[i].discount = 0;
        }

    }

    return itemAfterDiscount;
}

function isPromtionItem(obj) {
    let promotionItem = loadPromotions();
    let promotionArr =promotionItem[0].barcodes;

    for (let i = 0; i < promotionArr.length; i++) {
        if (obj.barcode == promotionArr[i]) {
            return true;
        }
    }
    return false;
}

function promotionRule(obj) {

    let quantity = obj.count;
    if(quantity>3)
    {
        quantity--;
    }
    obj.discount = obj.price;
    obj.sumPrice -= obj.discount;

    return obj;

}




