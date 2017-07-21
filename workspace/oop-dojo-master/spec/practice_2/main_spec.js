"use strict";

import Person from '../../main/practice_2'

describe("OO入门", function(){
    it("写一个类-2", function(){
        const Tom = new Person('Tom','21');
        const result = 'My name is Tom. I am 21 years old.';

        expect(Tom.introduce()).toEqual(result);
    });
});