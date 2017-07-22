"use strict";
import {Person, Student, Teacher} from '../../main/practice_7'

describe("OO入门", function () {
    it("对象之间的交互-1", function () {
        const p = new Person('Tom', 21);
        const s = new Student('Tom', 21, 2);
        const t1 = new Teacher('Tom', 21, 2);
        const t2 = new Teacher('Tom', 21);

        expect(p.introduce()).toEqual('My name is Tom. I am 21 years old.');
        expect(s.introduce()).toEqual('My name is Tom. I am 21 years old. I am a Student. I am at Class 2.');
        expect(t1.introduce()).toEqual('My name is Tom. I am 21 years old. I am a Teacher. I teach Class 2.');
        expect(t2.introduce()).toEqual('My name is Tom. I am 21 years old. I am a Teacher. I teach No Class.');
    });
});