//var 에서 내보낸 내용 가져오기
const {odd, even} = require('./var');

const checkOddorEven = (num) =>{
    if(num %2){
        return odd;
    } else{
        return even;
    }
}
//이렇게 내보내면 가져올 떄는 아무이름이나 사용해서 받으면 됨
module.exports = checkOddorEven;