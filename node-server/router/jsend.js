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
            id: new Date().getTime()
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
                metaSize = 1
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
    res.status(200).send({
        status: true,
        data: {
            payload: [
                "aaa", "bbb"
            ],
            meta: {
                metaSize = 1
            }
        }
    }).end()
})

module.exports = router