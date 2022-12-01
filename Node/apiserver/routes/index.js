const express = require('express');

const {v4:uuidv4} = require('uuid');

const {User, Domain} = require('../models');
const {isLoggedIn} = require('./middlewares');


const router = express.Router();

router.get('/', async(req, res, next)=>{
    try{
        //로그인 한 유저가 있으면 유저의 모든 데이터를 찾아서
        //대입
        const user = await User.findOne({
            where:{id:req.user && req.user.id || null},
            include:{model:Domain},
        });
        //login 이라는 뷰에(views/login.html) user 라는 이름으로 user 객체의 내용을 전달하고 domains 라는 이름으로 user.Domains를 전달
        res.render('login', {
            user,
            domains:user && user.Domains})
    }catch(error){
        console.error(error);
        next(error);
    }
});
//도메인 등록 처리
router.post('/domain', isLoggedIn, async(req, res, next)=>{
    try{
        await Domain.create({
            UserId:req.user.id,
            host:req.body.host,
            type:req.body.type,
            clientSecret:uuidv4()
        });
        //삽입하고 메인 페이지로 이동
        res.redirect("/");
    }catch(error){
        console.error(error);
        next(error);
    }
})

module.exports = router;