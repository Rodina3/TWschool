class Person {
    constructor(name, age) {
        this._name = name;
        this._age = age;
    }


    introduce() {
        let str = `My name is ${this._name}. I am ${this._age} years old.`;
        return str;
    }

}

module.exports =Person;

