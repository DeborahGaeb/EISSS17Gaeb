var express = require('express');
var bodyParser = require('body-parser');
var jsonParser = bodyParser.json();
var redis = require('redis');
var PORT = 2702

var db = redis.createClient();
var app = express();

app.use(bodyParser.json());

db.on('error', function (err) {});

//Ein Verein anlegen unvollständig!
app.post('/verein', function (request, response) {
	var newVerein = request.body;
	db.incr('nextUserID', function (error, response) {
		newVerein.id = request;
		newVerein.vereinsname = "";
		newVerein.plz = ""; //plz = postleizahl
		newVerein.sportarten = [];
		newVerein.trainingsort = [];
		newVerein.jahresbeitrag = []
		db.set('verein: ' + newVerein.id, JSON.stringify(newVerein), function (error, reponse) {
			response.json(newVerein);
		});
	});
});

//
app.post('/sportler', function (request, response) {
	var newSportler = request.body;
	db.incr('nextUserID', function (error, response) {
		newSportler.id = request;
		newSportler.name = "";
		newSportler.plz = "";
		newSportler.sportarten = [];
		db.set('Sportler: ' + newSportler.id, JSON.stringify(newSportler), function (error, response) {
				response.json(newSportler);
		});
	});
});
//Alleinstellungsmerkmal und PoC
app.post('/matching', function (request, response) {
	
	return function (db, Promise) {
		console.log('REQ BODY: ', request.body);
			var sportVereinIDS = [];
			var sportlerIDS = [];
			var ort = [];
			var sportart =[];
			var typ = [];		
	}
	
	/*Überprüfung ob ein wert eingeben wurde. Tabelle 13 Proof of Concep: Keine Kriterien bei der Sucheingabe*/

	if (ort.isEmpty() && sportart.isEmpty || typ.isEmpty ) {
		console.log("Fehler! Bitte geben Sie einen Ort an.")
	};
	
});

app.listen(PORT, function () {
	console.log('Dienstanbieter läuft über Port' + PORT);
});