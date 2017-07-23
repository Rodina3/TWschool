"use strict";

import {Class, Student} from '../../main/practice_10'

describe("OO入门", function () {
    it("对象之间的交互-4", function () {
        const c2 = new Class(2);
        const c3 = new Class(3);

        const sTom = new Student(100, 'Tom',21, c2);
        const sBob = new Student(101, 'Bob',21, c2);
        c2.assignLeader(sTom);
        expect(sTom.introduce()).toEqual('My name is Tom. I am 21 years old. I am a Student. I am Leader of Class 2.');
        expect(sBob.introduce()).toEqual('My name is Bob. I am 21 years old. I am a Student. I am at Class 2.');

        const sJerry = new Student(102, 'Jerry', 21,c3);
        expect(c2.assignLeader(sJerry)).toEqual('It is not one of us.');
        expect(sJerry.introduce()).toEqual('My name is Jerry. I am 21 years old. I am a Student. I am at Class 3.');

    });
});