const express = require('express');
const {verifyToken} = require('./middlewares');



const router = express.Router();

router.post('/token', async(req, res)=>{
    const {clientSecret} = req.body;
    try{
        //도메인 찾아오기
        const domain = await Domain.findOne({
            where:{clientSecret},
            include:{
                model:URLSearchParams,
                attribute:['nick', 'id']
            }
        });
        if(!domain){
            return res.status(401).json({
                code:401,
                message:"등록되지 않은 도메인입니다."
            })
        }
        //토큰 생성
        const token = jwt.sign({
            id:domain.USer.id,
            nick:domain.User.nick
        }, process.env.JWT_SECRET, {
            expiresIn: '1m', //유효시간
            issuer: 'adam' //발급자
        });

        return res.json({
            code:200,
            message:"토큰이 발급되었습니다.",
            token
        })

    }catch(error){
        console.error(error);
        return res.status(500).json({
            code:500,
            message:'서버에러'
        })
    }
})

//토큰을 확인하기 위한 처리
router.get('/test', verifyToken, (req, res)=>{
    res.json(req.decoded);
})

module.exports = router;