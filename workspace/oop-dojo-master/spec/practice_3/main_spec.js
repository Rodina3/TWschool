"use strict";

import {Person,Student} from '../../main/practice_3'

describe("OO入门", function(){
    it("覆盖父类的方法-1", function(){
        const person = new Person('Tom',21);
        const student = new Student('Tom',21,2);
        const result1 = 'My name is Tom. I am 21 years old.'
        const result2 = 'I am a Student. I am at Class 2.';

        expect(person.introduce()).toEqual(result1);
        expect(student.introduce()).toEqual(result2);
    });
});