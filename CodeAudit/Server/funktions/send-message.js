var gcm = require('node-gcm');
var constants = require('../constants/constants.json');

//Sendet für jede RegistrationsID aus dem Array RegistrationsIDs eine Benachrichtigung

exports.sendMassage = function (message, registrationIDs, callback) {
	var message = new gcm.Message({data: {message: message}});
	
	for (i = 0; i < registrationIDs.length; i++){
		var regTokens = [registrationIDs[i]];
		console.log("reqtoken", reqTokens);
		
		var sender = new gcm.Sender(contants.gcm_api_key);
		sender.send(message{registrationIDs: regTokens}, function (err, res) {
			if (err) {
				console.error(err);
				callback(constants.error.msg_send_failure);
			}
			else {
				console.log(res);
				callback(constants.success.msg_send_success)
			}
		});
	}
} 