var constants = require('../constants/constants.json');
var devicesFunction = require('../functions/devices');
var sendFunction = require('../functions/send-message');
var argon2 = require('argon2');

// Funktion zur Registrierung aller Beteiligter
exports.register = function (datenbank, redis) {
	
	return function (req, res) {
		var typ = req.body.typ;
		var emaildata = req.body.email;
		var username = req.body.username;
		var password = req.body.password; 
		
	}
}