/**
 * 랜덤 상품 데이터 호출 라우터
 */
const express = require('express');
const router = express.Router();
const utils = require('../utils/commonUtil')

router.get('/api/goods', (req, res) => {
    const pageNo = req.query.pageNo
    const pageSize = req.query.pageSize
    // 강제로 페이지 제한 처리
    if (pageNo == 5) {
        res.status(200).send({
            status: true,
            data: {
                payload: []
            }
        }).end()
    } else {
        var limitPageNo = null
        if (pageNo == 1) {
            limitPageNo = Math.floor((Math.random() * 10) + 4)
        }

        const list = []

        // 걍... 25 부터 처리 귀찮다..
        var startIdx = pageNo * pageSize
        for (var idx = 0; idx < pageSize; idx++) {
            list.push({
                id: startIdx,
                title: utils.randomTitle(),
                message: utils.randomMessage(),
                imagePath: utils.randomImage()
            })
            startIdx++
        }

        res.status(200).send({
            status: true,
            data: {
                payload: list,
                meta: {
                    limitSize: limitPageNo
                }
            }
        }).end()
    }
})

router.post('/api/like', (req, res) => {
    res.status(200).send({
        status: true,
        data: {
            id: req.body.id
        }
    }).end()
})

router.delete('/api/like/:id', (req, res) => {
    res.status(200).send({
        status: true,
        data: {
            id: req.params.id
        }
    }).end()
})

module.exports = router