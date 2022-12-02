const express = require('express');
const axios = require('axios');
const { Router } = require('express');

const router = express.Router();

router.get('/test', async(req, res, next)=>{
    try{
        if(!req.session.jwt){
            const tokenResult = await axios.post('http://localhost:8000/v1/token',{
                clientSecret:process.env.CLIENT_SECRET
            })
            if(tokenResult.data && tokenResult.data.code === 200){
                req.session.jwt = tokenResult.data.token;
            }else{
                //토큰 발급 실패
                return res.json(tokenResult.data);
            }
        }
        //토큰 내용 확인
        const result = await axios.get('http://localhost:8000/v1/test',{
            headers:{authorization:req.session.jwt}
        })
        return res.json(result.data);
    }catch(error){
        console.error(error);
        return next(error);

    }
})

module.exports = router;