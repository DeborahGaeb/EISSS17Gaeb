exports.getVerein = function (datenbank) {

	return function (req, res) {

		var wohnort = req.query.wohnort;
		var Verein_IDS = [];

		if (req.query.VID){
			var VID = req.query.VID;
			datenbank.get(VID, function (err, reply) {
				if (err) {
					throw err;
				}
				if (!reply) {
					res.status(500).end();
				}
				else {
					var Verein = JSON.parse(reply);
					var result = {
						typ:							Verein.typ,
						uid: 							Verein.uid,
						email:			 			Verein.email,
						password:					Verein.password,
						username:					Verein.username,
						nachname: 				Verein.namename,
						vorname:     			Verein.vorname,
						sportart: 	  	  Verein.sportart,
						Liega:						Verein.kurse,
						strasse:				 	Verein.straßePrivat,
						plz:							Verein.plzPrivat,
						wohnort:					Verein.wohnortPrivat,
						telefonNr: 				Verein.telefonNr
					};
					res.status(200).send(result).end();
				};
			});
		}
		else if (wohnort) {
			datenbank.smembers("Verein_" + wohnort,
			function (err, replies) {
				if (!replies || replies.length==0){
					//Kein Verein im Wohnort
					res.status(401).end();
				}
				else {
					Verein_IDS = replies;
					console.log('Das Sportstudio_IDS_Array :', SVerein_IDS);
					makeVereinJSON(Verein_IDS, datenbank).then(function (json) {
						res.status(201).send(json).end();
					});
				}
			});
		}
	}
};

function makeVereinJSON(Vereino_IDS, datenbank) {
	var promises = [];
	var Verein_JSONOBJECT = {"Verein" : [], "Anzahl": "0"};
	Verein_JSONOBJECT.Anzahl = Verein_IDS.length;

	for (var i = 0; i < Verein_IDS.length; i++) {
		promises.push(datenbank.getAsync(Verein_IDS[i]));
	}

	return Promise.all(promises).then(function (arrayOfResults) {
		for (i = 0; i < arrayOfResults.length; i++) {
			var Verein = JSON.parse(arrayOfResults[i]);
			console.log("VereinJSON: ", Verein);
			var result = {
				typ:							Verein.typ,
				uid: 							Verein.uid,
				email:			 			Verein.email,
				password:					Verein.password,
				username:					Verein.username,
				nachname: 				Verein.namename,
				vorname:     			Verein.vorname,
				sportart: 	  	  Verein.sportart,
				Liega:						Verein.kurse,
				strasse:				 	Verein.straßePrivat,
				plz:							Verein.plzPrivat,
				wohnort:					Verein.wohnortPrivat,
				telefonNr: 				Verein.telefonNr
			};
		SportStudio_JSON_OBJECT.Sportstudio.push(result);
	}
	return SportStudio_JSON_OBJECT;
	});
};
