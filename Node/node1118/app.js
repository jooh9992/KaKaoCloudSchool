//웹 서버 모듈 가져오기
const express = require('express');

//필요한 모듈 가져오기
//.env 파일의 내용을 읽어서 process.env에 저장해주는 모듈
const dotenv = require('dotenv');
const app = express();

//로그 출력
const morgan = require('morgan');
app.use(morgan('dev'));


//쿠키 사용이 가능하도록 설정
const cookieParser = require("cookie-parser");
app.use(cookieParser(process.env.COOKIE_SECRET));


//.env 읽어오기
dotenv.config();

//웹 서버 객체 생성과 포트 설정
//const app = express();
app.set('port', process.env.PORT);

//사용자의 요청 처리
//요청처리 메서드는 get, post, put(patch), delete, options
/*app.요청처리메서드(url, (req, res) =>{
    //처리

    //응답
    //send(직접 출력 내용 작성)
    //sendFile(html 파일 경로) - 여기까지는 서버랜더링을 하겠다는 얘기

    //json(JSON 데이터) - 서버 랜덩링을 하지 않음
}); */

const path = require('path'); //절대 경로 생성을 위해서 사용
//세션 사용을 위한 모듈을 가져오기
const session = require('express-session');
const { urlencoded } = require('express');
//const cookieParser = require('cookie-parser');
//세션을 파일에 저장하기 위한 모듈 가져오기
const FileStore = require('session-file-store')(session);

//poost 방식의 파라미터를 읽을 수 있도록 설정
app.use(express.json());
app.use(express.urlencoded({extended:false}));

//세션 사용을 위한 미들웨어 장착
//req.session 으로 세션 객체 사용이 가능
app.use(session({
    secret:"keyboard cat",
    resave:false,
    saveUninitialized:true,
    store:new FileStore()
}));

//파일을 업로드하기 위한 디렉토리를 생성
const fs = require('fs');

try{
    //디렉토리를 읽는데 디렉토리가 없으면 예외가 발생
    fs.readdirSync('uploads');
}catch(error){
    //디렉토리 생성
    fs.mkdirSync('uploads');
}
//파일 업로드 설정
const multer = require('multer');
const upload = multer({
    storage:multer.diskStorage({
        destination(req, file, done){
            done(null, 'uploads/');
        },
        filename(req, file, done){
            file.originalname = Buffer.from(file.originalname, 'latin1').toString('utf8');
            const ext = path.extname(file.originalname);
            done(null, path.basename(
                file.originalname, ext) +
                Date.now() + ext);
	}
	}), limits:{fileSize: 1024*1024*10}
});
//포트번호(Localhost:3000 -> ContextPath) 까지 요청 처리
// app.get('', (req, res) =>{
//     res.sendFile(path.join(__dirname, './express.html'));
// })

//라우팅 관련 파일 가져오기
const indexRouter = require('./index');
const userRouter = require('./user');
const boardRouter = require('./board');

//url 과 매핑
//app.use('/', indexRouter);
//pug 설정
//res.render로 출력할 때 사용할 디렉토리를 설정
app.set('views', path.join(__dirname, 'views'));
//템플릿 엔진은 pug를 사용하겠다고 설정
app.set('view engine', 'pug');

app.use("/", (req, res)=>{
    //템플릿 엔진으로 출력
    //views/index.html로 출력
    res.render('index', {'title':'pug', 'aespa':['카리나', '지젤', '윈터', '닝닝']})
})

app.use('/user', userRouter);
app.use('/board', boardRouter);



//하나의 파일 업로드 처리
app.get('/multi', (req, res)=>{
    res.sendFile(path.join(__dirname, './multi.html'));
});

app.post('/multi', upload.array('image'), (req, res)=>{
    //title 파라미터 읽기
    //post 방식에서의 파라미터는 req.body.파라미터이름
    // console.log(req.body.title);
    // console.log(req.file.originalname);
    // res.send('성공');

    //node에서 json 전송
    let result = {'result':"success"};
    res.json(result);
});

//웹 서버 실행
app.listen(process.env.PORT, ()=>{
    console.log(process.env.PORT, '번 포트에서 서버 대기 중');
});