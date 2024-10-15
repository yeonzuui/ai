// , 
i = parseInt("");
console.log('i타입은 ', typeof(i), ', 값은', i);
a = 10/0; // 10/0.00000000000000000000...
console.log('a타입은 ', typeof(a), ', 값은', a);
console.log('i가 NaN인지 여부: ', isNaN(i));
console.log('a가 NaN인지 여부: ', isNaN(a));
console.log('a가 유한한 수인지 여부: ', isFinite(a));