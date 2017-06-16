//Modulle 
//Modul https und http
var http	= require('http');
var https	= require('https');
var fs		= require('fs');

const express 		= require('express');
const bodyParser	= require('body-parser');
const jsonParser	= bodyParser.json();

//Datenbank
const redis 		= require('redis');
const datenbank		= redis.createClient();

const jwt			= require('jsonwebtoken');
const app			= express();
var io				= require('socket.io');
var apiRoutes		= express.Router();

//Ports für http und https 
const portHTTP		= 3000
//const portHTTPs		= 3001

/*
var options = {
	key:  fs.readFileSync('./https/server.key'),
	cert: fs.readFileSync('/https/server.crt')
};
*/
// Konfigution der Datenbank Redis
var Promise	= require('bluebird');
	Promise.promisifyAll(redis.RedisClient.prototype);
	Promise.promisifyAll(redis.Multi.prototype);
	Promise.promisifyAll(datenbank);

var config = require('./config');

// Konfiguartion des Server
app.use(bodyParser.json());
app.disable('x-powered-by');
app.set('superSecret', config.secret);

var env = process.env.NODE_ENV || 'devolopment';
if ('development' == env){
	app.use(express.static(__dirname + '/public'));
	
	app.use(function (err, req, res, next) {
		console.error(err.stack);
		res.end(err.status + '' + err.message);
	});
}

// Verbindung mit dem Redis Server
datenbank.on('connect', function (){
	console.log("Verbunden mit dem Redisserver")
});

datenbank.on("error", function(err) {
	console.log("Fehler: " + err);

});

//Sende ein Server Log mit with Zeitstemopel
app.use(function (req, res, next) {
	console.log('Time: %d ' + 'Request-Pfad: ' + req.path, Date,now());
});


// Den Server fertig konfiguieren
var listen = app.listen(portHTTP, function () {
	console.log('Der Server lauft auf http://${host}:${port}/');
});
var socket = io.listen(listen);

//Die Router werden festgelegt.
require('.(routes/routes')(app, socket, datenbank, redis, jwt, Promise, apiRoutes);