


class Person{
    constructor(name,age)
    {
        this._name = name;
        this._age =age;
    }

    introduce()
    {
        return 'My name is '+ this._name + '. I am '+this._age+' years old.'
    }
}

module.exports = Person;
