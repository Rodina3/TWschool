"use strict";
import {Student,Class,Teacher} from '../../main/practice_9'

describe("OO入门", function () {
    it("对象之间的交互-3", function () {
        const c = new Class(2);
        c.assignLeader(new Student(100,'Tom', 21));

        const s = new Student(100,'Tom', 21, c);
        expect(s.introduce()).toEqual('My name is Tom. I am 21 years old. I am a Student. I am Leader of Class 2.');

        const s2 = new Student(101,'Tom', 21, c);
        expect(s2.introduce()).toEqual('My name is Tom. I am 21 years old. I am a Student. I am at Class 2.');


        const jerry = new Student(102,'Jerry', 21, c);
        const tcher1 = new Teacher(200,'Tom', 21, c);
        expect(tcher1.introduceWith(jerry)).toEqual('My name is Tom. I am 21 years old. I am a Teacher. I teach Jerry.');

        const tcher2 = new Teacher(200,'Tom', 21, new Class(1));
        expect(tcher2.introduceWith(jerry)).toEqual('My name is Tom. I am 21 years old. I am a Teacher. I don\'t teach Jerry.');

    });
});