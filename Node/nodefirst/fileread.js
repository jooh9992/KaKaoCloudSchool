//파일을 읽고 쓸 수 있는 모듈 가져오기
/*const fs = require("fs");

let data = fs.readFileSync("./test.txt");
// console.log(data.toString());

//Enter 단위로 분할해서 읽기
let ar = data.toString().split("\n");
console.log(ar[0]);

//비동기식 파일 읽기 - error 는 에러의 내용이고 data 가 Buffer
fs.readFile('./test1.txt', (error, data)=>{
    if(error){
        //에러가 발생했을 때
        console.log(error.message);
    }else{
        //에러가 발생하지 않았을 때
        console.log(data.toString());
    }
});
console.log("파일 읽기 종료?");*/

/*//promises 사용
const fs = require("fs").promises;
fs.readFile('./test1.txt')
    .then((data) => {console.log(data.toString());})
    .catch((error)=>{console.log(error.message)})*/

    
//스트림을 이용한 읽기
/*const fs = require("fs");

//읽기 전용 스트림 생성
const readStream = fs.createReadStream(
    "./test.txt", {highWaterMark:16});
//데이터를 저장하기 위한 객체를 생성
const data = [];
//읽는 동안 발생하는 이벤트를 처리
readStream.on("data", (chunk)=>{
    //읽는 동안에는 읽어온 데이터를 추가
    data.push(chunk);
});
//읽기가 끝나면 발생하는 이벤트를 처리
readStream.on("end", ()=>{
    //지금까지 읽은 내용을 하나로 만들기
    let result = Buffer.concat(data);
    console.log(result.toString());
});
//에러가 발생하면 발생하는 이벤트를 처리
readStream.on("error", (error)=>{
    console.log(error.message);
});*/
/*//용량이 큰 파일 생성
const fs = require("fs");

const file = fs.createWriteStream('./data.txt');
for(let i=0; i<10000000; i++){
    file.write("용량이 큰 파일 만들기\n");
}
file.end();*/
/*//스트림을 사용하지 않고 읽어서 쓰기
const fs = require("fs");
console.log('복사하기 전 메모리 사용량:' + process.memoryUsage().rss);

const data1 = fs.readFileSync('./data.txt');
fs.writeFileSync('./nostreamdata.txt', data1);

console.log('복사한 후 메모리 사용량:' + process.memoryUsage().rss); */

/*const fs = require("fs");
console.log('복사하기 전 메모리 사용량:' + process.memoryUsage().rss);

//읽기와 쓰기 스트림 생성
const readStream = fs.createReadStream("./data.txt");
const writeStream = fs.createWriteStream("./streamdata.txt");

//읽고 쓰기
readStream.pipe(writeStream);
readStream.on('end', ()=>{
    console.log('복사한 후 메모리 사용량: ' +process.memoryUsage().rss);
})*/
//오늘 날짜로 된 디렉토리(20221116)가 없으면 생성
let today = new Date();
console.log(today);
console.log(today.getFullYear());
console.log(today.getMonth()+1);
console.log(today.getDate());

let day = today.getFullYear()+"" + (today.getMonth()+1)+"" + today.getDate() +"";

const fs = require("fs");

fs.access(day, (error)=>{
    if(error){
        console.log("디렉토리 없음");
        fs.mkdir(day, (error)=>{
            if(error){console.log("디렉토리 만들기 실패");}
            else{console.log("디렉토리 만들기 성공");}
        })
    }else{
        console.log("디렉토리 존재");
    }
})
