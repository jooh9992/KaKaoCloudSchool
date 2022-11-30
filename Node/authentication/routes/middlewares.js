//로그인 여부 판단
exports.isLoggedIn = (req, res, next) => {
    //로그인 여부 판단 - req.session.user가 존재하는지 확인
    if(req.isAuthenticated()){
        next();
    }else{
        res.status(403).send('로그인 필요');
    }
}
exports.isNotLoggedIn = (req, res, next) => {
    if(!req.isAuthenticated()){
        next();
    }else{
        //메시지를 생성하는 query string(parameter)로
        //사용할 것이라서 encoding을 해주어야 함
        const message = encodeURIComponent("로그인 한 상태입니다.");
        //이전 request 객체의 내용을 모두 삭제하고
        //새로운 요청 흐름을 만드는 것으로 새로 고침을 하면
        //결과 화면만 새로고침 됨
        res.redirect(`/?error=${message}`);
        
    }
}