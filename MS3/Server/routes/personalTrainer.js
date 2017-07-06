exports.getPersonalTrainer = function (datenbank) {

	return function (req, res) {

		var wohnort = req.query.wohnort;
		var PersonalTrainer_IDS = [];

		if (req.query.PID){
			var PID = req.query.PID;
			datenbank.get(PID, function (err, reply) {
				if (err) {
					throw err;
				}
				if (!reply) {
					res.status(500).end();
				}
				else {
					var PersonalTrainer = JSON.parse(reply);
					var result = {
						typ:			PersonalTrainer.typ,
						uid: 			PersonalTrainer.uid,
						email: 			PersonalTrainer.email,
						password:		PersonalTrainer.password,
						username:		PersonalTrainer.username,
						nachname: 		PersonalTrainer.namename,
						vorname:     	PersonalTrainer.vorname,
						sportart: 	   PersonalTrainer.sportart,
						preise:			PersonalTrainer.preise,
						strassePrivat: 	PersonalTrainer.straßePrivat,
						plzPrivat:		PersonalTrainer.plzPrivat,
						wohnort:		PersonalTrainer.wohnortPrivat,
						telefonNr: 		PersonalTrainer.telefonNr
					};
					res.status(200).send(result).end();
				};
			});
		}
		else if (wohnort) {
			datenbank.smembers("PersonalTrainer_" + wohnort,
			function (err, replies) {
				if (!replies || replies.length==0){
					//Kein Personal Trainer im Wohnort
					res.status(401).end();
				}
				else {
					PersonalTrainer_IDS = replies;
					console.log('Das PersonalTrainer_IDS_Array :', PersonalTrainer_IDS);
					makePersonalTrainerJSON(PersonalTrainer_IDS, datenbank).then(function (json) {
						res.status(201).send(json).end();
					});
				}
			});
		}
	}
};

function makePersonalTrainerJSON(PersonalTrainer_IDS, datenbank) {
	var promises = [];
	var PersonalTrainer_JSONOBJECT = {"PersonalTrainer" : [], "Anzahl": "0"};
	PersonalTrainer_JSONOBJECT.Anzahl = PersonalTrainer_IDS.length;

	for (var i = 0; i < PersonalTrainer_IDS.length; i++) {
		promises.push(datenbank.getAsync(PersonalTrainer_IDS[i]));
	}

	return Promise.all(promises).then(function (arrayOfResults) {
		for (i = 0; i < arrayOfResults.length; i++) {
			var PersonalTrainer = JSON.parse(arrayOfResults[i]);
			console.log("PersonalTrainerJSON: ", PersonalTrainer);
			var result = {
        typ:			PersonalTrainer.typ,
        uid: 			PersonalTrainer.uid,
        email: 			PersonalTrainer.email,
        password:		PersonalTrainer.password,
        username:		PersonalTrainer.username,
        nachname: 		PersonalTrainer.namename,
        vorname:     	PersonalTrainer.vorname,
        sportart: 	   PersonalTrainer.sportart,
        preise:			PersonalTrainer.preise,
        strassePrivat: 	PersonalTrainer.straßePrivat,
        plzPrivat:		PersonalTrainer.plzPrivat,
        wohnort:		PersonalTrainer.wohnortPrivat,
        telefonNr: 		PersonalTrainer.telefonNr
			};
		PersonalTrainer_JSON_OBJECT.PersonalTrainer.push(result);
	}
	return PersonalTrainer_JSON_OBJECT;
	});
};
