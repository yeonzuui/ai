/* array함수: 매개변수 0개 - length가 0인 배열 return
 *            매개변수 1개 - 매개변수만큼의 크기를 가지는 배열 return
 *            매개변수 2개 이상 - 매개변수로 배열을 생성하여 return */
function array(){
    // arguments(매개변수 배열)에 실행 시 매개변수가 들어와 
    let result = [];
    if(arguments.length == 1){
        // ex.array(3) 
        // 매개변수 수 만큼 result.push(null) 빈배열 생성
        for(var cnt=0 ; cnt<arguments[0] ; cnt++){
            result.push(null);
        }
    }else if(arguments.length >= 2){
        // ex. array(1, 2, 3)
        // 매개변수들 이용한 배열을 result([1,2,3])로 만들기
        for(var idx=0 ; idx<arguments.length ; idx++){
            result.push(arguments[idx]);
        }
        // 시스템이 자동생성한 배열 arguments는 forEach() 사용불가(일반 for문, for-in, for-of)
    }
    return result; // 매개변수 없으면 빈배열 return
}
var arr = array();
console.log('array()= ' + array());
console.log('array(5)= ' + array(4));
console.log('array(1, 2, 13)= ' + array(1, 2, 13));
console.log('array(1, 2, 3, "hello")= ' + array(1, 2, 3, "hello"));