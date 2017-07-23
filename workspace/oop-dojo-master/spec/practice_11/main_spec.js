"use strict";
import {Student,Teacher,Class} from '../../main/practice_11'

describe("OO入门", function(){
    it("对象之间的交互-5", function(){
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

        const t1 = new Teacher(200,'Tom',21,[c2,c3]);
        expect(t1.introduce()).toEqual('My name is Tom. I am 21 years old. I am a Teacher. I teach Class 2, 3.');

        const t2=new Teacher(201,'Tom',21);
        expect(t2.introduce()).toEqual('My name is Tom. I am 21 years old. I am a Teacher. I teach No Class.');

        const t3=new Teacher(202,'Tom',21,c3)
        expect(t1.isTeaching(sTom)).toEqual(true);
        expect(t2.isTeaching(sTom)).toEqual(false);
        expect(t3.isTeaching(sTom)).toEqual(false);

    });
});