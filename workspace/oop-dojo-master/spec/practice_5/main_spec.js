"use strict";

import {Person,Student,Worker} from '../../main/practice_5'

describe("OO入门", function () {
    it("覆盖同时复用父类的方法", function () {
        const p = new Person('Tom',21);
        const s = new Student('Tom',21,2);
        const w = new Worker('Tom',21,2);

        expect(p.basic_introduce()).toEqual('My name is Tom. I am 21 years old.');
        expect(s.introduce()).toEqual('My name is Tom. I am 21 years old. I am a Student. I am at Class 2.');
        expect(w.introduce()).toEqual('My name is Tom. I am 21 years old. I am a Worker. I have a job.');
    });
});