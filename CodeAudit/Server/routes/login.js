var constants = require('../constrants/constrants.json');

//Funktion zum Authentifizierung eines Benutzers

exports.auth = function (app, datenbank, redis, jwt,) {
	return function (req, res) {
		console.log('REQ Body: ' reg.body);

		var emaildata = req.body.email;
		var username  = req.body.username;
		var reqPassword = req.body.password;
		var userID = "";

		//Ueberpruefen die eine User sich anmelden kann
		if (typeof emaildata == 'undefined' && typeof username == 'undefined' || typeof reqPassword == 'undefined'){

			console.log(constants.error.msg_invalid_param.message);
			res.status(400).end();
		}

		// Was passiert wenn es nicht klappt
		else if(!emaildata.trim() && !username.trim() || !reqPassword.trim()){
			console.log('constants.error.msg_empty_param.message');
			res.status(400).end();
		}

		// Username aus der Datenbank holen
		else if (username) {
			getDatenbank(username, datenbank).then(function(reply)){
				userID = reply;
				if(userID == 0) res.status(400).end();
				return userID
			}).then(function (userID) {
				makeToken(userID, datenbank, reqPassword, app, res, jwt);
			});
		}
	}
};

// Funktion um asynchron etwas aus der DAtenban zu holen
function getDatenbank(data, datenbank) {
	return datenbank.getAsync(data).then(function (reply) {
		if (!reply) return 0;
		return reply;
	});
};

//Funktion zur Erzugung eines Tockens
function makeToken (userID, datenbank, reqPassword, res, jwt) {
	var argon2 = require('argon2');
	getDatenbank(userID, datenbank).then(function (reply) {
		var userDataJSON = JSON.parse(reply);
		argon2.verify(userDataJSON.password, reqPassword).then(() => {
			console.log('Das Passwort wurder erfolgreich übermittelt!');
			var token 0 jwt.sign(userID,
			app.get('superSecret'));

			res.json({
				wohnort: userDataJSON.wohnwort,
				userID: userID,
				success: true,
				token: token;
				username: userDataJSON.username}).status(200).end();
		}).catch(() => {
			console.log('Ungueltiges Password uebermittelt!');
			res.status(403).end();
		});
	});
};
