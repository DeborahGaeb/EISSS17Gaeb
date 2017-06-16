//Funktion einbinden und Argon
var devicesFunction = require('../funktions/devices');
var sendFunction = require('../funktions/send-message');
var constants = require('../constants/constants.json');
var argon2 = require('argon2');

//Funktion, die  die Daten des Benutzers aktualiersieren.

exports.updateUserdata = (function (datenbank) {
	return function (req, res) {
		console.log("Body: ", req.body);
		var typ 		 	= req.body.typ;
		var uid 		 	= req.body.uid;
		var email			= reg.body.email;
		var password		= req.body.password
		var username	 	= req.body.username
		var nachname 	    = req.body.namename;
		var vorname     	= req.body.vorname;
		var sportart 	    = req.body.sportart;
		var geburtsdatum    = reg.body.datum;
		var strassePrivat 	= req.body.straßePrivat;
		var plzPrivat		= req.body.plzPrivat;
		var wohnortPrivat	= req.body.wohnortPrivat;
		var strasseArbeit 	= req.body.straßeArbeit;
		var plzArbeit		= req.body.plzArbeit;
		var wohnortArbeit	= req.body.wohnortArbeit;
		
		if (typeof typ == 'undefined' && typeof uid == 'undefined' || typeof password == 'undefined') {
			console.log(constants.error.msg_invalid_param.message);
			res.status(400).end();
		}
		
		else if (typ == 'sportstudio') {
			datenbank.get(uid, function (err, reply) {
				if(err){
					throw err;
					res.status(400).end();
				} 
				else {
					var sportstudio = JSON.parse(reply);
					argon2.verify(sportstudio.password, password).then(()=>
					if () {
						code
					})
				}
			})
		}
	}
})