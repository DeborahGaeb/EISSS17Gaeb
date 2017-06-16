//Gibt alle RegistrationsIDs des Wohnort zurück
exports.listDevices = function(wohnort, datenbank, callback){
	datenbank.smembers(wohnort + "regids", function(err, replies){
		if( !replies || replies.length==0){
			console.log("KEINE RegistrationsIDs im Wohnort");
		}else{
			callback(replies);
		}	
	});
}