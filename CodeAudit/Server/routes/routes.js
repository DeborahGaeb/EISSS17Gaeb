var constants 			 = require('../constrants/constrants.json');
var registerFunction = require('../functions/register');
var devicesFunction  = require('../functions/devices');
var deleteFunction 	 = require('../functions/delete');
var sendFunction 		 = require('../functions/send-message');
var fs 					  	 = require('fs');

//Setting up Routes
var login       				= require('./login');
var register						= require('./register');
var sportler						= require('./sportler');
var sportstudio					= require('./sportstudio');
var verein 							= require('./verein');
var personalTrainer     = require('./personalTrainer');


module.exports = function(app, io, datenbank, redis, jwt, Promise, apiRoutes) {

	//Einbinden von Socket.io
	io.on('connection', function(socket){
		console.log("Client Connected");
		socket.emit('update', { message: 'Hello Client',update:false });
	 	socket.on('update', function (msg) {
	 		console.log(msg);
		});
	});

	//Routen ohne login
	app.post('/login', login.auth(app, datenbank, redis, jwt));
	app.post('/register', register.register(datenbank, redis));
	app.post('/sportler', sportler.updateUserdata(datenbank));
	app.post('/sportstudio', sportstudio.getSportstuido(datenbank));
	app.post('/personalTrainer', personalTrainer.getPersonalTrainer(datenbank));
	app.post('/verein', verein.getVerein(datenbank));

	apiRoutes.use(function (req, res, next) {
		var token = req.body.token || req.query.token || req.headers['x-access-token'];
		if (token) {
			jwt.verify(token, app.get('superSecret'), function(err, decoded){
				if (err) {
					return res.json({success: false, massage: 'Fehlerhafte Autoricierungs Token'});
				}
				else {
					req.decoded = decoded;
					next();
				}
			});
		}
		else {
			return res.status(403).send({
				success: false,
				massage: 'Kein Token unterstützt.'
			});
		}
	});

	//Route mit Login
	app.use('/', apiRoutes);
	app.post('/matching', matching.match(datenbank, Promis));
	app.put('/sportler', sportlerroutes.updateUserdata(datenbank));
	app.delete('/sportler', sportlerroutes.updateUserdata(datenbank));

	//Firebase Could Massageing
	/*
		app.post('/device', function (req, res) {
			console.log('REGISTRAIONSBODY', req.body);
			var wohnort = req.body.wohnort;
			var uid = req.body.uid;
			var registrationsID = req.body.registrationsID;

			if (typeof uid == 'undefined' || typeof registrationsID == 'undefined' || typeof wohnort == 'undefined') {
				console.log(constants.error.msg_invalid_param.massage);
				res.json(constants.error.msg_empty_param);
			}
			else {
				registerFunction.register(uidm registrationsID, wohnort,datenbank, function (result){
					res.json(result);
					if (result.result != 'error') {
						io.emit('update', {massage: 'Neues Device hinzugefüg', update: true});
					}
				});
			}
		});
*/

	//EIn Gerät wird aus der Liste des wohnort einfernt
	/*
	app.delete('/devices/:device', function(req, res){
		var registrationsID = req.param.wohnort;
		var wohnort = req.body.wohnort;
		deleteFunction.removeDevice(registrationsID, wohnort, datenbank, function(req, res) {
			res.json(result).end();
		});
	});
	*/

	//Upload eines Profilbild
	/*
	app.post('/upload/:wohnort:uid', function(req, res) {
		var wohnort = req.params.wohnort;
		var uid = req.params.uid;
		var path = "../uploads/" + wohnort + "/" +uid + "/" +req.files.image.originalFilename ;
		fs.readFile(req.files.image.path, function (err, data){
			fs.writeFile(path, data, function (err) {
				if(err){
					res.json({'response':"Error"});
				}else {
					res.json({'response':"Saved"});
				}
			});
		});
	});
	*/
}
