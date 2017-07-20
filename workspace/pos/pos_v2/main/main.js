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
    for(let i=i;i<stdTags.length;i++)
    {
        let barcode = stdTags[i].split('-')[0];
        let count = parseFloat(stdTags[i].split('-')[1]);

        //find(stdTags,cartList);
    }
    return cartList;
}

function find(stdTags,cartList)
{

}

function promote() {

}

function getReceipt() {

}