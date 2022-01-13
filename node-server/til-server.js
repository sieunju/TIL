const express = require('express');
const session = require('express-session');
const fileStore = require('session-file-store')(session)
const utils = require('./utils/commonUtil')
const cors = require('cors')

const fs = require('fs')
const path = require('path')
const app = express()
const router = require('./router/index')

app.use(cors());
app.use(express.urlencoded({
    limit: "50mb",
    extended: true
}))
app.use(express.json({
    limit: "50mb"
})) // API Call 할때.  

app.use(function (req, res, next) {
    // 만료된 토큰인 경우 에러 뱉기
    if (utils.isExpiredToken(req)) {
        res.status(401).send({
            status: false
        }).end()
    } else {
        next();
    }
});
app.use('/', router)

const concat = require('concat-stream');
app.use(function (req, res, next) {
    req.pipe(concat(function (data) {
        req.body = data;
        next();
    }));
});
app.use(session({
    secret: 'keyboard cat',
    resave: false,
    saveUninitialized: true,
    store: new fileStore()
}));

// Handle Error Setting
// app.use(function (err, req, res, next) {
//     console.log('Handle Error\t' + err + '\n\turl\t' + req.url);
//     next(err);
// });
// app.use(function(req,res,next) {
//     console.log("Interceptor " + req.url)

//     next()
// })
// app.use(function (err, req, res, next) {
//     console.log("너얌!!! " + req.url)
//     res.status(err.status || 500);
//     res.send(err || 'Error!!');
// });

require('http').createServer(app).listen(50048, () => {
    console.log('Http Server Start, Port: ' + 50048);
})