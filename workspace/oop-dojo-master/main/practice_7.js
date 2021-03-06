class Person {
    constructor(name, age) {
        this._name = name;
        this._age = age;
    }

    introduce() {
        return `My name is ${this._name}. I am ${this._age} years old.`
    }
}

class Student extends Person {
    constructor(name, age, myclass) {
        super(name, age);
        this._class = myclass;
    }

    introduce() {
        return super.introduce() + ` I am a Student. I am at Class ${this._class}.`;
    }
}

class Teacher extends Person {
    constructor(name, age,myclass) {
        super(name, age);
        this._class = myclass;
    }

    introduce() {
        if (typeof this._class == 'undefined') {
            return super.introduce() + ' I am a Teacher. I teach No Class.';
        }
        else {
            return super.introduce() + ` I am a Teacher. I teach Class ${this._class}.`;
        }
    }
}

export {Person, Student, Teacher}