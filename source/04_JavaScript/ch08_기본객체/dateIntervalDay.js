// now.getIntervalDay(limitDay) → 100 return
// now → this, limiitDay가 otherDay
Date.prototype.getIntervalDay = function(otherDay){
    // if(otherDay > this){    
    //     var intervalMilliSec = otherDay.getTime() - this.getTime();
    // }else{
    //     var intervalMilliSec = this.getTime() - otherDay.getTime();
    // }
    var intervalMilliSec = Math.abs(this.getTime() - otherDay.getTime());
    return Math.trunc(intervalMilliSec / (1000*60*60*24));
}

var today = new Date();
var thatDay = new Date(2024, 9, 11, 14, 0, 0); // 시스템 month은 0부터 시작
console.log(today.getIntervalDay(thatDay));
console.log(thatDay.getIntervalDay(today));