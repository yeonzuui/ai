// replaceAll('안녕00방가00하이', '00', 'x');
// 모든 [00]을 [x]로 교체 → '안녕x방가x하이'를 return
// var str = '안녕00방가00하이';
// console.log('원본: ' + str);

// [00] 기준으로 분리하여 배열 생성
// var splitStr = str.split('00');
// console.log(splitStr);

// index간 join
// var result = splitStr.join('x');
// console.log(result);

// replaceAll() 생성
const replaceAll = (str, oldStr, newStr) => {
    // var splitStr = str.split(oldStr);
    // var result = splitStr.join(newStr);
    return str.split(oldStr).join(newStr); 
};
console.log(replaceAll('테스트<br>합니다<br>진짜로', '<br>', 'x'));
console.log(replaceAll('테스트합니다 진짜로 테스트', ' ', ''));
