'use strict';

//TODO: 请在该文件中实现练习要求并删除此注释
const itemInfo = Item.all();
const promoteInfo = Promotion.all()[0].barcodes;

function printReceipt(tags) {
    let receipt = buildReceipt(tags);
    let receiptText = getReceiptText(receipt);

    console.log(receiptText);

}

function buildReceipt(tags) {
    let stdTags = formatTag(tags);
    let cartList = countCartItem(stdTags);
    let promotedCartList = promote(cartList);
    let receipt = getReceipt(promotedCartList);
    return receipt;
}

function getReceiptText(receipt) {
    let receiptText = '';
    let storeName = '***<没钱赚商店>收据***\n';
    let itemInfoText = '';
    let items = receipt.cart;
    for (let i = 0; i < items.length; i++) {
        itemInfoText += '名称：' + items[i].name + '，数量：' + items[i].count + items[i].unit +
            '，单价：' + items[i].price.toFixed(2) + '(元)，小计：' + items[i].subTotal.toFixed(2) + '(元)\n';
    }
    let priceText = '总计：' + receipt.totalPrice.toFixed(2) + '(元)\n';
    let savingText = '节省：' + receipt.totalSaving.toFixed(2) + '(元)\n';

    const dateDigitToString = num => (num < 10 ? `0${num}` : num);

    const currentDate = new Date(),
        year = dateDigitToString(currentDate.getFullYear()),
        month = dateDigitToString(currentDate.getMonth() + 1),
        date = dateDigitToString(currentDate.getDate()),
        hour = dateDigitToString(currentDate.getHours()),
        minute = dateDigitToString(currentDate.getMinutes()),
        second = dateDigitToString(currentDate.getSeconds()),
        formattedDateString = `${year}年${month}月${date}日 ${hour}:${minute}:${second}`;

    let printTime = `打印时间：${formattedDateString}\n`;

    receiptText = storeName
        + printTime
        + '----------------------\n'
        + itemInfoText
        + '----------------------\n'
        + priceText
        + savingText
        + '**********************';

    return receiptText;
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
    let cartList = [];
    for (let i = 0; i < stdTags.length; i++) {
        let barcode = stdTags[i].split('-')[0];
        let count = parseFloat(stdTags[i].split('-')[1]);

        find(barcode, count, cartList);
    }
    return cartList;
}

function find(barcode, count, cartList) {
    for (let i = 0; i < cartList.length; i++) {
        if (barcode === cartList[i].barcode) {
            cartList[i].count += count;
            cartList[i].subTotal = cartList[i].price * cartList[i].count;
            return;
        }
    }

    for (let i = 0; i < itemInfo.length; i++) {
        if (barcode === itemInfo[i].barcode) {
            let obj = {};
            obj.barcode = itemInfo[i].barcode;
            obj.name = itemInfo[i].name;
            obj.unit = itemInfo[i].unit;
            obj.price = itemInfo[i].price;
            obj.count = count;
            obj.subTotal = obj.price * obj.count;
            cartList.push(obj);
        }
    }

}

function promote(cartList) {
    for (let i = 0; i < cartList.length; i++) {
        if (isPromtionItem((cartList[i].barcode))) {
            let freeItemCount = (cartList[i].count > 2) ? 1 : 0;
            cartList[i].saving = cartList[i].price * freeItemCount;
        }
        else {
            cartList[i].saving = 0;
        }

        cartList[i].subTotal -= cartList[i].saving;
    }

    return cartList;
}

function isPromtionItem(barcode) {
    for (let i = 0; i < promoteInfo.length; i++) {
        if (barcode === promoteInfo[i])
            return true;
    }
    return false;
}

function getReceipt(promotedCart) {
    let totalPrice = 0, totalSaving = 0;
    for (let i = 0; i < promotedCart.length; i++) {
        totalPrice += promotedCart[i].subTotal;
        totalSaving += promotedCart[i].saving;
    }
    return {cart: promotedCart, totalPrice: totalPrice, totalSaving: totalSaving};

}



