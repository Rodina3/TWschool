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

    spyOn(console, 'log');

    printReceipt(tags);

    const expectText = `***<没钱赚商店>收据***
名称：雪碧，数量：5瓶，单价：3.00(元)，小计：12.00(元)
名称：荔枝，数量：2.5斤，单价：15.00(元)，小计：37.50(元)
名称：方便面，数量：3袋，单价：4.50(元)，小计：9.00(元)
----------------------
总计：58.50(元)
节省：7.50(元)
**********************`;

    expect(console.log).toHaveBeenCalledWith(expectText);
  });



    it('should change single tag to item',() => {
        const tags =[
            'ITEM000001',
            'ITEM000001',
            'ITEM000005',
        ];
        const result=[{barcode:'ITEM000001',name:'雪碧',unit:'瓶',price:3,count:1},
            {barcode:'ITEM000001',name:'雪碧',unit:'瓶',price:3,count:1},
            {barcode:'ITEM000005',name:'方便面',unit:'袋',price:4.5,count:1}];
        expect(tag2Item(tags)).toEqual(result);
    })


    it('should change complex tag to item',() => {
        const tags =[
            'ITEM000003-2.5',
            'ITEM000005-2',
        ];
        const result=[{barcode:'ITEM000003',name:'荔枝',unit:'斤',price:15,count:2.5},
            {barcode:'ITEM000005',name:'方便面',unit:'袋',price:4.5,count:2}];
        expect(tag2Item(tags)).toEqual(result);
    })

    it('should change all kinds of tags to item',() => {
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
        const result=[
            {barcode:'ITEM000001',name:'雪碧',unit:'瓶',price:3,count:1},
            {barcode:'ITEM000001',name:'雪碧',unit:'瓶',price:3,count:1},
            {barcode:'ITEM000001',name:'雪碧',unit:'瓶',price:3,count:1},
            {barcode:'ITEM000001',name:'雪碧',unit:'瓶',price:3,count:1},
            {barcode:'ITEM000001',name:'雪碧',unit:'瓶',price:3,count:1},
            {barcode:'ITEM000003',name:'荔枝',unit:'斤',price:15,count:2.5},
            {barcode:'ITEM000005',name:'方便面',unit:'袋',price:4.5,count:1},
            {barcode:'ITEM000005',name:'方便面',unit:'袋',price:4.5,count:2}];
        expect(tag2Item(tags)).toEqual(result);
    })


    /*it('should clarify items',() => {
        const itemList = [
            {barcode:'ITEM000001',name:'雪碧',unit:'瓶',price:3,count:1},
            {barcode:'ITEM000001',name:'雪碧',unit:'瓶',price:3,count:1},
            {barcode:'ITEM000001',name:'雪碧',unit:'瓶',price:3,count:1},
            {barcode:'ITEM000001',name:'雪碧',unit:'瓶',price:3,count:1},
            {barcode:'ITEM000001',name:'雪碧',unit:'瓶',price:3,count:1},
            {barcode:'ITEM000003',name:'荔枝',unit:'斤',price:15,count:2.5},
            {barcode:'ITEM000005',name:'方便面',unit:'袋',price:4.5,count:1},
            {barcode:'ITEM000005',name:'方便面',unit:'袋',price:4.5,count:2}];

        const result=[
            {barcode:'ITEM000001',name:'雪碧',unit:'瓶',price:3,count:5},
            {barcode:'ITEM000003',name:'荔枝',unit:'斤',price:15,count:2.5},
            {barcode:'ITEM000005',name:'方便面',unit:'袋',price:4.5,count:3}];
        expect((gatherItem(itemList))).toEqual(result);
    })*/

    it('should gather items',() => {
        const itemList = [
            {barcode:'ITEM000001',name:'雪碧',unit:'瓶',price:3,count:5},
            {barcode:'ITEM000003',name:'荔枝',unit:'斤',price:15,count:2.5},
            {barcode:'ITEM000005',name:'方便面',unit:'袋',price:4.5,count:3}];

        const result=[
            {barcode:'ITEM000001',name:'雪碧',unit:'瓶',price:3,count:5,sumPrice:15},
            {barcode:'ITEM000003',name:'荔枝',unit:'斤',price:15,count:2.5,sumPrice:37.5},
            {barcode:'ITEM000005',name:'方便面',unit:'袋',price:4.5,count:3,sumPrice:13.5}];
        expect((gatherItem(itemList))).toEqual(result);
    })

    it('judge whether is a promotional item',() => {
        const obj = {barcode:'ITEM000001',name:'雪碧',unit:'瓶',price:3,count:5,sumPrice:15};
        const result= true;
        expect((isPromtionItem(obj))).toEqual(result);
    })



    it('process with promotion',() => {
        const obj = {barcode:'ITEM000001',name:'雪碧',unit:'瓶',price:3,count:5,sumPrice:15};
        const result= {barcode:'ITEM000001',name:'雪碧',unit:'瓶',price:3,count:5,sumPrice:12,discount:3};
        expect((promotionRule(obj))).toEqual(result);
    })

    it('process with promotion',() => {
        const itemBeforePromotion = [
            {barcode:'ITEM000001',name:'雪碧',unit:'瓶',price:3,count:5,sumPrice:15},
            {barcode:'ITEM000003',name:'荔枝',unit:'斤',price:15,count:2.5,sumPrice:37.5},
            {barcode:'ITEM000005',name:'方便面',unit:'袋',price:4.5,count:3,sumPrice:13.5}];

        const result=[
            {barcode:'ITEM000001',name:'雪碧',unit:'瓶',price:3,count:5,sumPrice:12,discount:3},
            {barcode:'ITEM000003',name:'荔枝',unit:'斤',price:15,count:2.5,sumPrice:37.5,discount:0},
            {barcode:'ITEM000005',name:'方便面',unit:'袋',price:4.5,count:3,sumPrice:9,discount:4.5}];
        expect((promotion(itemBeforePromotion))).toEqual(result);
    })

});
