'use strict';

describe('pos', () => {

  it('should print text', () => {

    const tags = [
      'ITEM000001',
      'ITEM000001',
      'ITEM000001',
      'ITEM000001',
      'ITEM000001',
      'ITEM000003-2.5',
      'ITEM000005',
      'ITEM000005-2',
    ];

    const dateDigitToString = num => (num < 10 ? `0${num}` : num);

    spyOn(console, 'log');

    printReceipt(tags);

    const currentDate = new Date(),
      year = dateDigitToString(currentDate.getFullYear()),
      month = dateDigitToString(currentDate.getMonth() + 1),
      date = dateDigitToString(currentDate.getDate()),
      hour = dateDigitToString(currentDate.getHours()),
      minute = dateDigitToString(currentDate.getMinutes()),
      second = dateDigitToString(currentDate.getSeconds()),
      formattedDateString = `${year}年${month}月${date}日 ${hour}:${minute}:${second}`;

    const expectText = `***<没钱赚商店>收据***
打印时间：${formattedDateString}
----------------------
名称：雪碧，数量：5瓶，单价：3.00(元)，小计：12.00(元)
名称：荔枝，数量：2.5斤，单价：15.00(元)，小计：37.50(元)
名称：方便面，数量：3袋，单价：4.50(元)，小计：9.00(元)
----------------------
总计：58.50(元)
节省：7.50(元)
**********************`;

    expect(console.log).toHaveBeenCalledWith(expectText);
  });

    it('unit test:formatTags()',() => {
        const tags =[
            'ITEM000003',
            'ITEM000003-2.5',
            'ITEM000005-2',
        ];
        const result=[
            'ITEM000003-1',
            'ITEM000003-2.5',
            'ITEM000005-2',
        ];
        expect(formatTag(tags)).toEqual(result);
    })

    it('should count cart Items',() => {
        const stdTags =[
            'ITEM000001-1',
            'ITEM000001-1',
            'ITEM000001-1',
            'ITEM000001-1',
            'ITEM000001-1',
            'ITEM000003-2.5',
            'ITEM000005-1',
            'ITEM000005-2',
            ];
        const result=[
            { barcode: 'ITEM000001', name: '雪碧', unit: '瓶', price: 3, count: 5,subTotal:15 },
            { barcode: 'ITEM000003', name: '荔枝', unit: '斤', price: 15, count: 2.5,subTotal:37.5 },
            { barcode: 'ITEM000005', name: '方便面', unit: '袋', price: 4.5, count: 3 ,subTotal:13.5}
        ];
        expect(countCartItem(stdTags)).toEqual(result);
    })


    it('unit test:isPromotionItem',() => {

        expect(isPromtionItem('ITEM000005')).toEqual(true);
        expect(isPromtionItem('ITEM000003')).toEqual(false);

    })

    it('should promote',() => {
        const beforePromtion =[
            { barcode: 'ITEM000001', name: '雪碧', unit: '瓶', price: 3, count: 5,subTotal:15 },
            { barcode: 'ITEM000003', name: '荔枝', unit: '斤', price: 15, count: 2.5,subTotal:37.5 },
            { barcode: 'ITEM000005', name: '方便面', unit: '袋', price: 4.5, count: 3 ,subTotal:13.5}
        ];
        const result=[
            { barcode: 'ITEM000001', name: '雪碧', unit: '瓶', price: 3, count: 5,subTotal:12 ,saving:3},
            { barcode: 'ITEM000003', name: '荔枝', unit: '斤', price: 15, count: 2.5,subTotal:37.5,saving:0},
            { barcode: 'ITEM000005', name: '方便面', unit: '袋', price: 4.5, count: 3 ,subTotal:9,saving:4.5}
        ];
        expect(promote(beforePromtion)).toEqual(result);
    })

    it('unit test:getReceipt',() => {
        const cart =[
            { barcode: 'ITEM000001', name: '雪碧', unit: '瓶', price: 3, count: 5,subTotal:12 ,saving:3},
            { barcode: 'ITEM000003', name: '荔枝', unit: '斤', price: 15, count: 2.5,subTotal:37.5,saving:0},
            { barcode: 'ITEM000005', name: '方便面', unit: '袋', price: 4.5, count: 3 ,subTotal:9,saving:4.5}
        ];
        const result= {
            cart: [{barcode: 'ITEM000001', name: '雪碧', unit: '瓶', price: 3, count: 5, subTotal: 12, saving: 3},
                {barcode: 'ITEM000003', name: '荔枝', unit: '斤', price: 15, count: 2.5, subTotal: 37.5, saving: 0},
                {barcode: 'ITEM000005', name: '方便面', unit: '袋', price: 4.5, count: 3, subTotal: 9, saving: 4.5}],
            totalPrice:58.5,
            totalSaving:7.5
        }
        expect(getReceipt(cart)).toEqual(result);
    })

    it('change tags to receipt',() => {
        const tags = [
            'ITEM000001',
            'ITEM000001',
            'ITEM000001',
            'ITEM000001',
            'ITEM000001',
            'ITEM000003-2.5',
            'ITEM000005',
            'ITEM000005-2',
        ];
        const result= {
            cart: [{barcode: 'ITEM000001', name: '雪碧', unit: '瓶', price: 3, count: 5, subTotal: 12, saving: 3},
                {barcode: 'ITEM000003', name: '荔枝', unit: '斤', price: 15, count: 2.5, subTotal: 37.5, saving: 0},
                {barcode: 'ITEM000005', name: '方便面', unit: '袋', price: 4.5, count: 3, subTotal: 9, saving: 4.5}],
            totalPrice:58.5,
            totalSaving:7.5
        }
        expect(buildCart(tags)).toEqual(result);
    })

});
