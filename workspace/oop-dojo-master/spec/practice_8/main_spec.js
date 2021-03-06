"use strict";

import {Student,Teacher,Class} from '../../main/practice_8'

describe("OO入门", function(){
    it("对象之间的交互-2", function(){
        const c =new Class(2);
        const jerry = new Student('Jerry',21,c);
        const tcher1 =new Teacher('Tom',21,c);
        const tcher2 = new Teacher('Tom',21,new Class(1));

        expect(tcher1.introduceWith(jerry)).toEqual('My name is Tom. I am 21 years old. I am a Teacher. I teach Jerry.');
        expect(tcher2.introduceWith(jerry)).toEqual('My name is Tom. I am 21 years old. I am a Teacher. I don\'t teach Jerry.');

    });
});