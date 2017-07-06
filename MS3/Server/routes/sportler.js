//Funktion einbinden und Argon
var devicesFunction = require('../functions/devices');
var sendFunction = require('../functions/send-message');
var constrants = require('../constrants/constrants.json');
var argon2 = require('argon2');

//Funktion, die  die Daten des Benutzers aktualiersieren.

exports.updateUserdata = (function (datenbank) {
	return function (req, res) {
		console.log("Body: ", req.body);
		var typ 		 	= req.body.typ;
		var SID 		 	= req.body.uid;
		var email			= reg.body.email;
		var password		= req.body.password
		var username	 	= req.body.username
		var nachname 	    = req.body.namename;
		var vorname     	= req.body.vorname;
		var sportart 	    = req.body.sportart;
		var geburtsdatum    = reg.body.datum;
		var strassePrivat 	= req.body.straßePrivat;
		var plzPrivat		= req.body.plzPrivat;
		var wohnort			= req.body.wohnortPrivat;
		var strasseArbeit 	= req.body.straßeArbeit;
		var plzArbeit		= req.body.plzArbeit;
		var wohnortArbeit	= req.body.wohnortArbeit;

		if (typeof typ == 'undefined' && typeof uid == 'undefined' || typeof password == 'undefined') {
	        console.log(constants.error.msg_invalid_param.message);
			res.status(400).end();
		}

		else if (!typ.trim() && !SID.trim() || !password.trim()){
			console.log(constants.error.msg_empty_param.message);
			res.status(400).end();
		}

		else if (typ = 'sportler') {
			datenbank.get(SID, function (err, reply) {
				if (err) {
					throw err;
					res.status(400).end();
				}
				else {
					var sportler = JSON.parse(reply);
					argon2.verify(sportler.password, password).then(()=> {
						if (sportart) Sportler.Sportart = sportart;
						if (wohnort) Sportler.wohnort = wohnort;
						if (email) Sportler.emailadresse = emailadresse
						datenbank.set(SID, JSON.stringify(sportler));
						if (!wohnort) wohnort = Sportler.wohnort;
						devicesFunction.listDevices(wohnort, datenbank, function (result) {
							sendFunction.sendMassage(SID, result, function (callback) {
								console.log(callback);
							});
						});
					}).catch(() =>  {
						console.log('Ungueltiges Passwort angehen');
						res.status(403).end();
					});
				}
			});
		}
		else if (typ == 'Sportstudio') {
			//TODO
		}
		else {
			res.status(400).end;
		}
	}
});

/*
exports.deleteUserdata = function (datenbank) {
	return function (req, res) {
		//TODO
	}
}
*/
