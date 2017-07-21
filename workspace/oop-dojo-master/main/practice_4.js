class Person {
    constructor(name, age) {
        this._name = name;
        this._age = age;
    }

    introduce() {
        return `My name is ${this._name}. I am ${this._age} years old.`;
    }
}
class Student extends Person {
    constructor(name, age, cl) {
        super(name, age);
        this._class = cl;
    }

    introduce() {
        return `I am a Student. I am at Class ${this._class}.`;
    }
}


class Worker extends Person {
    constructor(name, age) {
        super(name, age);
    }

    introduce() {
        return `I am a Worker. I have a job.`;
    }
}

export {Person, Student, Worker}