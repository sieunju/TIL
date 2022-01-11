const express = require('express')
const router = express.Router()
const auth = require('./auth')
const goods = require('./goods')

router.use('/',auth)
router.use('/',goods)

module.exports = router