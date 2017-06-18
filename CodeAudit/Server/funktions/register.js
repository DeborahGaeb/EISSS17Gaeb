var constants = require('../constrants/constrants.json');

//Speichert die ID in der Liste

exports.register = function (uid, registreationsID, wohnort, datenbank, callback) {
	var newDevice = {
		UID: uid,
		registreationsID: registreationsID,
		wohnort: wohnort
	};

	checkSET(wohnort + "regids", registreationsID).then(function (check) {
		if (check == 1){
			console.log("Die Registration ist im Set", registreationsID);
			callback(constants.error.msg_reg_exists);
		}
		else {
			datenbank.SADD(wohnort + "rgids", registreationsID);
			datenbank.set(registreationsID, JSON.stringify(newDevice));
			callback(constants.success.msg_reg_success);
		}
	});

	function checkSET (set, data) {
		var  [];
		promises.push(db.SISMENBERAsync(setm data));

		return Promise.all(promises).then(function(arrayOfResults){
			return arrayOfResult[0];
		});
	}
}
