"use strict";

import {Class, Teacher, Student} from '../../main/practice_12'

describe("OO入门", function () {
    it("对象之间的交互-6", function () {
        const c2 = new Class(2);
        const c3 = new Class(3);

        const sTom = new Student(100, 'Tom', 21, c2);
        const sBob = new Student(101, 'Bob', 21, c2);

        c2.assignLeader(sTom);
        expect(sTom.introduce()).toEqual('My name is Tom. I am 21 years old. I am a Student. I am Leader of Class 2.');
        expect(sBob.introduce()).toEqual('My name is Bob. I am 21 years old. I am a Student. I am at Class 2.');


        const sLinda = new Student(102, 'Linda', 21, c3);
        expect(c2.assignLeader(sLinda)).toEqual('It is not one of us.');
        expect(sLinda.introduce()).toEqual('My name is Linda. I am 21 years old. I am a Student. I am at Class 3.');


        const t1 = new Teacher(200, 'Tom', 21, [c2, c3]);
        expect(t1.introduce()).toEqual('My name is Tom. I am 21 years old. I am a Teacher. I teach Class 2, 3.');


        const t2 = new Teacher(201, 'Tom', 21);
        expect(t2.introduce()).toEqual('My name is Tom. I am 21 years old. I am a Teacher. I teach No Class.');


        const t3 = new Teacher(202, 'Tom', 21, c3)
        expect(t1.isTeaching(sTom)).toEqual(true);
        expect(t2.isTeaching(sTom)).toEqual(false);
        expect(t3.isTeaching(sTom)).toEqual(false);

        const sJerry = new Student(104, 'Jerry', 21);
        expect(c2.appendMember(sJerry, t1)).toEqual('I am Tom. I know Jerry has joined Class 2.');
        expect(c2.assignLeader(sJerry, t1)).toEqual('I am Tom. I know Jerry become Leader of Class 2.');

    });
});
