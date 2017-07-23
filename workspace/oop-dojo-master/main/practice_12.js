class Person {
    constructor(id, name, age) {
        this._id = id;
        this._name = name;
        this._age = age;
    }

    introduce() {
        return `My name is ${this._name}. I am ${this._age} years old.`
    }
}

class Class {
    constructor(num) {
        this._class = num;
        this._stuInClass = [];
    }

    get class() {
        return this._class;
    }

    assignLeader(student, teacher) {
        for (let i = 0; i < this._stuInClass.length; i++) {

            if (student.id === this._stuInClass[i]) {
                this._leader = student.id;

                if (typeof teacher !== 'undefined') {
                    return `I am ${teacher.name}. I know ${student.name} become Leader of Class ${this._class}.`
                }
            }
        }
        return 'It is not one of us.';
    }

    get leader() {
        return this._leader;
    }

    appendMember(student, teacher) {
        this._stuInClass.push(student.id);
        if (typeof teacher !== 'undefined') {
            return `I am ${teacher.name}. I know ${student.name} has joined Class ${this._class}.`
        }
    }

    isIn(student) {
        for (let i = 0; i < this._stuInClass.length; i++) {
            if (this._stuInClass[i] === student.id) {
                return true;
            }
        }
        return false;
    }
}

class Student extends Person {
    constructor(id, name, age, myclass) {
        super(id, name, age);
        if (typeof myclass === 'undefined') {

        }
        else {
            this._class = myclass;
            myclass.appendMember(this);
        }
    }

    introduce() {
        if (this._class.leader !== this._id) {
            return super.introduce() + ` I am a Student. I am at Class ${this._class.class}.`;
        }
        else {
            return super.introduce() + ` I am a Student. I am Leader of Class ${this._class.class}.`;
        }
    }

    get id() {
        return this._id;
    }

    get class() {
        return this._class;
    }

    get name() {
        return this._name;
    }
}

class Teacher extends Person {
    constructor(id, name, age, teachClasses) {
        super(id, name, age);
        this._classes = [];

        if (typeof teachClasses !== 'undefined') {

            for (let i = 0; i < teachClasses.length; i++) {
                this._classes.push(teachClasses[i]);
            }
        }
    }

    introduce() {
        if (this._classes.length === 0) {
            return super.introduce() + ' I am a Teacher. I teach No Class.';
        }
        else {
            let myIntroduce = super.introduce() + ' I am a Teacher. I teach Class';
            for (let i = 0; i < this._classes.length; i++) {

                myIntroduce += ` ${this._classes[i].class}`;

                if (i !== this._classes.length - 1) {
                    myIntroduce += ','
                }
                else {
                    myIntroduce += '.';
                }
            }
            return myIntroduce;
        }

    }

    isTeaching(student) {
        for (let i = 0; i < this._classes.length; i++) {
            if (this._classes[i].isIn(student) === true) {
                return true;
            }
        }
        return false;
    }

    get name() {
        return this._name
    };

}

export {Student, Teacher, Class}
