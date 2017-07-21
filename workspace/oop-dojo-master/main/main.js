// Write your cade below:
function caclRemaindar(num1, num2) {
    return num1 % num2;
};

function caclSum(numArray) {
    let sum = 0
    for (let i = 0; i < numArray.length; i++) {
        sum += numArray[i];
    }
    return sum;
};

function caclSumInConditon(numArray, indicatedNum) {
    let sum = 0
    for (let i = 0; i < numArray.length; i++) {
        let num = numArray[i];
        if (num < indicatedNum) {
            sum += num;
        }
    }
    return sum;
}

module.exports = {
    caclRemaindar,
    caclSum,
    caclSumInConditon
}