"use strict";

import {Person, Student, Worker} from '../../main/practice_4'

describe("OO入门", function(){
    it("覆盖父类的方法-2", function(){
        const p=new Person('Tom',21);
        const s=new Student('Tom',21,2);
        const w=new Worker('Tom',21);

        const r1 = 'My name is Tom. I am 21 years old.';
        const r2 = 'I am a Student. I am at Class 2.';
        const r3 = 'I am a Worker. I have a job.';

        expect(p.introduce()).toEqual(r1);
        expect(s.introduce()).toEqual(r2);
        expect(w.introduce()).toEqual(r3);
    });
});