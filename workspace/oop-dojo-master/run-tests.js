const Jasmine = require('jasmine');
const jasmine = new Jasmine();
const JasmineConsoleReporter = require('jasmine-console-reporter');


jasmine.loadConfigFile('spec/support/jasmine.json');


var reporter = new JasmineConsoleReporter({
    colors: 1,           // (0|false)|(1|true)|2 
    cleanStack: 1,       // (0|false)|(1|true)|2|3 
    verbosity: 4,        // (0|false)|1|2|(3|true)|4 
    listStyle: 'indent', // "flat"|"indent" 
    activity: false
});

jasmine.jasmine.getEnv().addReporter(reporter);
jasmine.execute();