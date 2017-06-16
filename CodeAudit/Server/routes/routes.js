var constants = require('../constants/constants.json');
var registerFunction = require('../functions/register');    
var devicesFunction = require('../functions/devices');
var deleteFunction = require('../functions/delete');
var sendFunction = require('../functions/send-message');
var fs = require('fs');

//Setting up Routes
var login       		= require('./login');
var personaltraniner    = require('./personaltraniner');
var register	= require('./register');
var sportler			= require('./sportler');
var verein 				= require('./verein');

module.exports = function(app,io, datenbank, redis, jwt, Promise, apiRoutes) {
	
	io.on('connection', function(socket){
		console.log("Client Connected");
		socket.emit('update', { message: 'Hello Client',update:false });
	 	socket.on('update', function(msg){
	 		console.log(msg);
		});
	});
	
	//Routen ohne login
	app.post('/login', login.auth(app, datenbank, redis, jwt));
	app.post('/register', register.register(datenbank, redis));
	app.post('/sportler', sportler.updateUserdata);
	app.post('/',);
	app.post('/',);
	app.post('/',);
	
	