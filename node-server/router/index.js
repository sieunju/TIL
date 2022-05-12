const express = require('express')
const router = express.Router()
const auth = require('./auth')
const goods = require('./goods')
const jsend = require('./jsend')
const errorhandling = require('./errorhandling')

router.use('/', auth)
router.use('/', goods)
router.use('/', jsend)
router.use('/', errorhandling)


module.exports = router