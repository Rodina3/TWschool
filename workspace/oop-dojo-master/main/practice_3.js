class Person {
    constructor(name, age) {
        this._name = name;
        this._age = age;
    }

    introduce() {
        return `My name is ${this._name}. I am ${this._age} years old.`;
    }
}


class Student extends Person{
    constructor(name,age,cl) {
        super(name, age);
        this._class= cl;
    }

    introduce()
    {
        return `I am a Student. I am at Class ${this._class}.`;
    }
}


export {Person,Student}