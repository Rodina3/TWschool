'use strict';

//TODO: 请在该文件中实现练习要求并删除此注释
const itemInfo = Item.all();
const promoteInfo = Promotion.all();

function printReceipt(tags) {
    buildCart();
    buildReceiptText();
    console.log('');

}

function buildCart(tags) {
    let stdTags = formatTag(tags);
    countCartItem();
    promote();
    getReceipt();
}

function buildReceiptText(tags) {

}

function formatTag(tags) {
    let tag = '';
    for (let i = 0; i < tags.length; i++) {
        if (tags[i].length === 10) {
            tags[i] = tags[i] + '-1';
        }
    }
    return tags;
}

function countCartItem(stdTags) {
    let  cartList = [];
    for(let i=0;i<stdTags.length;i++)
    {
        let barcode = stdTags[i].split('-')[0];
        let count = parseFloat(stdTags[i].split('-')[1]);

        find(barcode,count,cartList);
    }
    return cartList;
}

function find(barcode,count,cartList)
{
    for(let i=0;i<cartList.length;i++)
    {
        if(barcode === cartList[i].barcode)
        {
            cartList[i].count += count;
            cartList[i].subTotal = cartList[i].price * cartList[i].count;
            return;
        }
    }

    for(let i=0;i<itemInfo.length;i++)
    {
        if(barcode === itemInfo[i].barcode)
        {
            let obj = {};
            obj.barcode =itemInfo[i].barcode;
            obj.name =itemInfo[i].name;
            obj.unit=itemInfo[i].unit;
            obj.price =itemInfo[i].price;
            obj.count=count;
            obj.subTotal = obj.price * obj.count;
            cartList.push(obj);
        }
    }

}

function promote() {

}

function getReceipt() {

}