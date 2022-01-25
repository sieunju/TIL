const express = require('express')
const router = express.Router()
const auth = require('./auth')
const goods = require('./goods')
const jsend = require('./jsend')

router.use('/', auth)
router.use('/', goods)
router.use('/', jsend)


module.exports = router