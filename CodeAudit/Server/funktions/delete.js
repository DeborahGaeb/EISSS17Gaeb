var constants = require('../constants/constants.json');
 
exports.removeDevice = function(registrationId, wohnort, datenbank, callback){
	console.log("DELETE DEVICE:  " + registrationId);
	var result = datenbank.SREM(wohnort + "regids", registrationId);
	var result2 = datenbank.DEL(registrationId);
		if (result == 1) {
			callback(constants.success.msg_del_success);
		} else {
			callback(constants.error.msg_del_failure);
		}
}