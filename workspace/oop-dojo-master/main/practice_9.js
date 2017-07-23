class Person {
    constructor(id, name, age) {
        this._id = id;
        this._name = name;
        this._age = age;
    }

    get id() {
        return this._id;
    }

    introduce() {
        return `My name is ${this._name}. I am ${this._age} years old.`
    }
}

class Class {
    constructor(num) {
        this._class = num;
    }

    get class() {
        return this._class;
    }

    assignLeader(student) {
        this._leader = student.id;
    }

    get leader()
    {
        return this._leader;
    }
}

class Student extends Person {
    constructor(id, name, age, myclass) {
        super(id, name, age);
        this._class = myclass;
    }

    introduce() {
        if(this._class.leader !== this._id)
        {        return super.introduce() + ` I am a Student. I am at Class ${this._class.class}.`;
        }
        else
        {
            return super.introduce() + ` I am a Student. I am Leader of Class ${this._class.class}.`;
        }
    }

    get name() {
        return this._name;
    }

    get class() {
        return this._class;
    }
}

class Teacher extends Person {
    constructor(id,name, age, myclass) {
        super(id,name, age);
        this._class = myclass;
    }

    introduce() {
        if (typeof this._class.class == 'undefined') {
            return super.introduce() + ' I am a Teacher. I teach No Class.';
        }
        else {
            return super.introduce() + ` I am a Teacher. I teach Class ${this._class.class}.`;
        }
    }

    introduceWith(student) {
        if (student.class.class == this._class.class)
            return super.introduce() + ` I am a Teacher. I teach Jerry.`;
        else
            return super.introduce() + ' I am a Teacher. I don\'t teach Jerry.';
    }
}

export {Student, Teacher, Class}