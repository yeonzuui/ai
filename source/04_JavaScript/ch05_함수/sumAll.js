function sumAll(){
    let result = -999;
    if(arguments.length >= 1){
        result = 0;
        for(var i=0 ; i<arguments.length ; i++){
            result += arguments[i];
        }
    }
    return result;
}

// function sumAll{
//     var result = 0;
//     if(arguments.length == 0){
//         result = -999;
//     }else if(arguments.length >= 1){
//         for(let idx = 0 ; idx<arguments.length ; idx++){
//             result += arguments[idx];
//         }
//     }
//     return result;
// }
console.log('sumAll()= ', sumAll());
console.log('sumAll(1, 2, 3, 4, 5, 6)= ', sumAll(1, 2, 3, 4, 5, 6));
console.log('sumAll(10, 20)= ', sumAll(10, 20)); 