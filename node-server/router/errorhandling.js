/**
 * 에러 관련 코드 라우터
 */
const express = require('express');
const router = express.Router();
const utils = require('../utils/commonUtil')

router.get('/api/error/505', (req, res) => {
    res.status(505).send({
        status: false,
        message: "505 Get 방식의 Error 입니다."
    }).end()
})

router.post('/api/error/505', (req, res) => {
    res.status(505).send({
        status: false,
        message: "505 Post 방식의 Error 입니다."
    }).end()
})

router.post('/api/error/404', (req, res) => {
    res.status(404).send({
        status: false,
        message: "404 Post 방식의 Error 입니다."
    }).end()
})

router.get('/api/error/404', (req, res) => {
    const erroMsg = {
        "name": "Hello",
        "contents": "Error Contents"
    }

    res.status(404).send({
        status: false,
        message: erroMsg
    }).end()
})

module.exports = router