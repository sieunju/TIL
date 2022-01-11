
/**
 * 사용자 인증 라우터
 */
const express = require('express');
const router = express.Router();
const utils = require('../utils/commonUtil')

router.post('/api/auth/refresh', (req, res) => {
    // Refresh Token..
    var token = req.header('Token')
    console.log("TOKEEE " + token)
    var refreshToken = "Token Migane Koda Dewdy"
    res.status(200).send({
        status: true,
        data: {
            token: refreshToken
        }
    }).end()
})

/**
 * 만료되는 토큰 발급 받기
 */
router.post('/api/auth/expired', (req, res) => {
    var expiredToken = 'Token Expired ' + new Date().getTime()
    console.log('Expired Token ' + expiredToken)
    res.status(200).send({
        status: true,
        data: {
            token: expiredToken
        }
    }).end()
})

module.exports = router