'use strict';

//TODO: 请在该文件中实现练习要求并删除此注释

const allItemInfo = loadAllItems();
const allPromtionItem = loadPromotions();

function printReceipt(tags) {

    let receipt = buildCart(tags);
    let receiptText = buildReceiptText(receipt);
    console.log(receiptText);
}

function buildCart(tags) {
    let formatedTags = formatTag(tags);
    let cartItem = countCartItem(formatedTags);
    let receiptItem = calculateItemPrice(cartItem);
    let receiptWithPromotion = promote(receiptItem);
    let receipt = calculateReceipt(receiptItem);

    return receipt;

}

function buildReceiptText(obj) {

}

function formatTag(tags)
{
    for(let i=0;i<tags.length;i++)
    {
        if (tags[i].length === 10)
        {
            tags[i]= tags[i]+'-1';
        }
    }
    return formatedTags;
}

function countCartItem(obj)
{
    return cartItem;
}

function calculateItemPrice()
{
    return receiptItem;
}

function promote()
{
    return receiptWithPromotion;
}

function calculateReceipt()
{
    return receipt;
}
