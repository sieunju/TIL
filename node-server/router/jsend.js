/**
 * JSON jsend 규칙 관련 라우터
 */
const express = require('express');
const router = express.Router();
const utils = require('../utils/commonUtil')

router.get('/api/jsend', (req, res) => {
    res.status(200).send({
        status: true,
        data: {
            payload: {
                id: new Date().getTime()
            }
        }
    }).end()
})

router.get('/api/jsend/meta', (req, res) => {
    res.status(200).send({
        status: true,
        data: {
            payload: {
                id: new Date().getTime()
            },
            meta: {
                metaSize: utils.randomInt()
            }
        }
    }).end()
})

router.get('/api/jsend/list', (req, res) => {
    res.status(200).send({
        status: true,
        data: {
            payload: [
                "aaa", "bbb"
            ]
        }
    }).end()
})

router.get('/api/jsend/list/meta', (req, res) => {
    const ran = Math.random() < 0.5
    if(ran == true) {
        res.status(200).send({
            status: true,
            data: {
                payload: [
                    "aaa", "bbb"
                ],
                meta: {
                    metaSize: utils.randomInt()
                }
            }
        }).end()
    } else {
        res.status(404).end();
    }
})

router.get('/api/error/test',(req, res) => {
    const ran = Math.random()
    if(ran < 0.3) {
        res.status(200).send({
            status: true,
            message: "Data is Null"
        }).end()
    } else if (ran < 0.7) {
        res.status(404).send({
            status: false,
            message: "에러 헨들링 테스트 입니다."
        }).end()
    } else {
        res.status(500).send({
            status: false,
            data : {
                meta: {
                    notice: "서버가 꺼져 있습니다."
                }
            }
        }).end()
   } 
})

module.exports = router