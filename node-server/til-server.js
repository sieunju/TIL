const express = require('express');
const session = require('express-session');
const fileStore = require('session-file-store')(session)
const utils = require('./utils/commonUtil')
const cors = require('cors')

const fs = require('fs')
const path = require('path')
const app = express()

const api = require('./router/index')
app.use(express.urlencoded({
    limit: "50mb",
    extended: true
}))
app.use(express.json({
    limit: "50mb"
})) // API Call 할때.                            
app.use('/', api)

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

app.use(cors());

// Handle Error Setting
app.use(function (err, req, res, next) {
    console.log('Handle Error\t' + err + '\n\turl\t' + req.url);
    next(err);
  });
  app.use(function (err, req, res, next) {
    res.status(err.status || 500);
    res.send(err || 'Error!!');
  });

require('http').createServer(app).listen(50057, () => {
    console.log('Http Server Start, Port: ' + 50057);
})