exports.getSportstudio = function (datenbank) {

	return function (req, res) {

		var wohnort = req.query.wohnort;
		var Sportstudio_IDS = [];

		if (req.query.FID){
			var FID = req.query.FID;
			datenbank.get(FID, function (err, reply) {
				if (err) {
					throw err;
				}
				if (!reply) {
					res.status(500).end();
				}
				else {
					var Sportstudio = JSON.parse(reply);
					var result = {
						typ:			Sportstudio.typ,
						uid: 			Sportstudio.uid,
						email: 			Sportstudio.email,
						password:		Sportstudio.password,
						username:		Sportstudio.username,
						nachname: 		Sportstudio.namename,
						vorname:     	Sportstudio.vorname,
						sportart: 	    Sportstudio.sportart,
						kurse:			Sportstudio.kurse,
						geraete:		Sportstudio.geraete,
						wellnessangebot: Sportstudio.wellnessangebot,
						strassePrivat: 	Sportstudio.straßePrivat,
						plzPrivat:		Sportstudio.plzPrivat,
						wohnort:		Sportstudio.wohnortPrivat,
						telefonNr: 		Sportstudio.telefonNr
					};
					res.status(200).send(result).end();
				};
			});
		}
		else if (wohnort) {
			datenbank.smembers("Sportstudio_" + wohnort,
			function (err, replies) {
				if (!replies || replies.length==0){
					//Kein Studio im Wohnort
					res.status(401).end();
				}
				else {
					Sportstudio_IDS = replies;
					console.log('Das Sportstudio_IDS_Array :', Sportstudio_IDS);
					makeSportstudioJSON(Sportstudio_IDS, datenbank).then(function (json) {
						res.status(201).send(json).end();
					});
				}
			});
		}
	}
};

function makeSportstudioJSON(Sportstudio_IDS, datenbank) {
	var promises = [];
	var SportStudio_JSONOBJECT = {"Sportstudio" : [], "Anzahl": "0"};
	SportStudio_JSONOBJECT.Anzahl = SportStudio_IDS.length;

	for (var i = 0; i < Sportstudio_IDS.length; i++) {
		promises.push(datenbank.getAsync(Sportstudio_IDS[i]));
	}

	return Promise.all(promises).then(function (arrayOfResults) {
		for (i = 0; i < arrayOfResults.length; i++) {
			var Sportstudio = JSON.parse(arrayOfResults[i]);
			console.log("SportstudioJSON: ", Sportstudio);
			var result = {
				typ:			Sportstudio.typ,
				uid: 			Sportstudio.uid,
				email: 			Sportstudio.email,
				password:		Sportstudio.password,
				username:		Sportstudio.username,
				nachname: 		Sportstudio.namename,
				vorname:     	Sportstudio.vorname,
				sportart: 	    Sportstudio.sportart,
				kurse:			Sportstudio.kurse,
				geraete :		Sportstudio.geraete,
				wellnessangebot: Sportstudio.wellnessangebot,
				strassePrivat: 	Sportstudio.straßePrivat,
				plzPrivat:		Sportstudio.plzPrivat,
				wohnortPrivat:	Sportstudio.wohnortPrivat,
				telefonNr: 		Sportstudio.telefonNr
			};
		SportStudio_JSON_OBJECT.Sportstudio.push(result);
	}
	return SportStudio_JSON_OBJECT;
	});
};
