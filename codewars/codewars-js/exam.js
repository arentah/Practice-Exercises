function countDup(numbers){

    var result = 0;
    var arr = [];

    for(let i = 0; i < numbers.length; i++){
        if (arr.indexOf(numbers[i]) >= 0) {
            console.log("count",i,"numbers:", numbers[i]);
            console.log(result);
            result++;
            console.log(result);
        } else {
            arr.push(numbers[i]);
        }
    }
    console.log(arr);
    return result;
}

//console.log(countDup([8,1,3,1,4,5,6,3,2]));
//console.log(countDup([5,1,1,2,2,3]));
//console.log(countDup([10,1,2,3,4,5,6,7,8,9,10]));
console.log(countDup([6,1,1,2,2,2,3,5,6,7,8,9,10,11,12,14,15,100,200,100,99]));

var test = [1,2,3];