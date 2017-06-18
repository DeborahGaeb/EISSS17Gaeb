var constants 			= require('../constrants/constrants.json');
var devicesFunction = require('../functions/devices');
var sendFunction 		= require('../functions/send-message');
var argon2 					= require('argon2');

// Funktion zur Registrierung aller Beteiligter
exports.register = function (datenbank, redis) {
  return function (req, res) {
    var typ = req.body.typ;
		var emailadresse = req.body.email;
		var username = req.body.username;
		var password = req.body.password;
		var wohnort = req.body.wohnort;

    //Checke ob ein Parameter voanden ist.
    if (typeof emailadresse == 'undefined' || typeof username == 'undefined' || typeof typ == 'undefined' || typeof password == 'undefined' || typeof wohnort == 'undefined') {
      console.log(constrants.error.msg_invalid_param.message);
      res.status(403).json(constrants.error.msg_invalid_param).end();
    }

    // überprüfung von doppelten Eintragen
    else if (!emailadresse.trim() || !username.trim() || !password.trim() || !typ.trim() || !wohnort.trim()) {
			console.log("Die E-Mail ist bereits im Set");
			res.status(403).json(constants.error.msg_invalid_param.end());
		}

    //überprüfen, ob eine Mailadresse in der Datenbank vorhanden ist,
    else if (emailadresse) {
      checkSET("user", username).then(function(check){
        if (check ==1) {
          console.log("Die E-Mail ist schon im SET", emailadresse);
					res.status(409).end();
        }
        else {
          //ueberprüfe ob eine User bereits vergeben ist.
					checkSET("user", username).then(function(check2){
            //Username ist bereits vorhanden
            if (check2 == 1) {
              console.log("Der User ist bereits in der Datenbann vorhanden");
							res.status(409).end();
            }

            //Das Passwort überprüfen
            else {
              argon2.generateSalt().then(salt => {argon2.hast(req.body.password.salt).then(hash =>{
                console.log("Es wurde ein erfolgreiches Hash erstellt: ", hash);
  							var pwhash = hash;

  							//Wenn der Typ ein Sportler ist.
  							if (typ = sportler){
                  var sportler = {
  									username: req.body.username,
  									password: pwhash,
  									wohnort: req.body.wohnort,
  									email: req.body.emailadresse,
  									SID: ""
  								};

                  var Client_JSON = {
                    Client_ID: ""
                  };
                  //Letze ID des Spotlers
                  datenbank.get('last_Sportler_ID', function(err, reply){
                    if (err) {
                      throw err;
                    }
                    if (!reply || reply == "SID_NaN") {
                      last_Sportler_ID = SID_1;
                    }
                    else {
                      last_Sportler_ID = reply.toString();
                    }
                    //Letze SID zur vorlezten machen
                    var old_SID = last_Sportler_ID.substring(4);
  									var old_SID_INT = parseInt(old_SID);
  									var new_SID = old_SID_INT + 1;
  									var new_Sportler_ID = "SID_" + new_SID.toString();
  									console.log("Die neue Sportler ID ist: ", new_Sportler_ID);
  									Sportler.SID = new_Sportler_ID;

                    //Sportler in der Redis speichern
  									datenbank.set(new_Sportler_ID, JSON.stringify(Sportler));

  									//Die E-Mailadresse zum SET hinzufügen
  									datenbank.SADD("email", emailadresse);
  									datenbank.SAAD("user", username);
  									datenbank.set(emailadresse, new_Sportler_ID);
  									datenbank.set(username, new_Sportler_ID);

  									//Die last_Sportler_ID wird aktualiersiert
  									datenbank.set('last_Sportler_ID', new_Sportler_ID);
                    Client_JSON.Client_ID = new_Sportler_IDM
                    datenbank.incr(wohnort + "_anzahlSportstudio", function (err, reply) {
                        console.log("Die Anzahl der Sportler im Wohnort: " + wohnort +" ist: " + reply);
                    });
                    res.status(201).send(Client_JSON).end();
                  });
                }

                //Typ Sportstiod
                if (typ == "Sportstudio"){
                  var new_Sportstudio_ID;
    							var Sportstudio = {
    								username: req.body.username,
    								password: pwhash,
    								wohnort: req.body.wohnort,
    								FID: "",
    								email: req.body.email,
    								strasse: req.body.strasse
    								//geraete: req.body.geraete,
    								//kurse: req.body.kurse,
    								//wellnessangebot: req.body.wellnessangebot,
    								//preise: req.body.preise,
    								//ich
    								//oeffnungszeiten: req.body.oeffnungszeiten,
    							};

    							var Client_JSON = {
    								Client_ID: ""
    							};

                  //Letze ID für Sportstudio bzw. Fintnessttuido
                  datenbank.get('last_Sportstudio_ID', function(err, reply){
                    if (err) {
                      throw err;
                    }
                    if (!reply || reply == "FID_NaN") {
                      last_Sportstudio_ID = FID_1;
                    }
                    else {
                      last_Sportstudio_ID = reply.toString();
                    }

                    var old_FID = last_Sportstudio_ID.substring(4);
    								var old_FID_INT = parseInt(old_FID);
    								var new_FID = old_FID_INT + 1;
    								var new_Sportstudio_ID = "SID_" + new_FID.toString();
    								console.log("Die neue Sportstudio ID ist: ", new_Sportstudio_ID);
    								Sportstudio.SID = new_Sportstudio_ID;

    								//Sportler in der Redis speichern
                    datenbank.set(new_Sportstudio_ID, JSON.stringify(Sportstudio));

                    //Die E-Mailadresse zum SET hinzufügen
    								datenbank.SADD("email", emailadresse);
    								datenbank.SAAD("user", username);
    								datenbank.set(emailadresse, new_Sportstudio_ID);
    								datenbank.set(username, new_Sportstudio_ID);

                    //Die last_Sportstudio_ID wird aktualiersiert
                    datenbank.set('last_Sportstudio_ID', new_Sportstudio_ID);
                    Client_JSON.Client_ID = new_Sportstudio_ID;
                    datenbank.incr(wohnort + "_anzahlSportstudio", function(err, reply){
                      console.log("Die Anzahl der Sportstudio in diesem " + wohnort + " ist: " +reply);
                    });

                    if (typ = verein) {
                      var Verein = {
      									username: req.body.username,
      									password: pwhash,
      									wohnort: req.body.wohnort,
      									email: req.body.emailadresse,
      									VID: ""
      								};

                      var Client_JSON = {
      									Client_ID: ""
      								};
                      datenbank.get('last_Verein_ID', function(err, reply) {
                        if (err) {
                          throw err;
                        }
                        if (!reply || reply == "VID_NaN"){
                          last_Verein_ID = VID_1;
                        }
                        else {
                          last_Verein_ID = reply.toString();
                        }

                        var old_VID = last_Verein_ID.substring(4);
        								var old_VID_INT = parseInt(old_VID);
        								var new_VID = old_VID_INT + 1;
        								var new_Verein_ID = "VID_" + new_VID.toString();
        								console.log("Die neue Vereins ID ist: ", new_Verein_ID);
        								Verein.VID = new_Verein_ID;

                        //Sportler in der Redis speichern
        								datenbank.set(new_Verein_ID, JSON.stringify(Verein));

                        //Die E-Mailadresse zum SET hinzufügen
        								datenbank.SADD("email", emailadresse);
        								datenbank.SAAD("user", username);
        								datenbank.set(emailadresse, new_Verein_ID);
        								datenbank.set(username, new_Verein_ID);

                        //Die last_Verein_ID wird aktualiersiert.
                        datenbank.set('last_Verein_ID', new_Verein_ID);
                        Client_JSON.Client_ID = new_Verein_ID;
                        datenbank.incr(wohnort + "_anzahlVerein", function (err, reply) {
                          console.log("Die Anzahl der Vereine in diesem" + wohnort + "ist: " + reply);
                        });
                        res.status(201).send(Client_JSON).end();
                      });
                    }
                    devicesFunction.listDevices(wohnort, datenbank, function (result) {
                      sendFunction.sendMessage(new_Sportstudio_ID, result, function (callback) {
                        console.log(callback);
                      });
                    });
                  }); //123
                } //101
              });
            });
            }
          });
        }
      });
    }
  }
  function checkSET (set, data) {
    var promises = [];
    promises.push(datenbank.all.SISMEMBERAsync (set, data));

    return Promis.all(promises).then( function (arrayOfResults) {
        return arrayOfResults[0];
    });
  }
//Klammerfunktion
}
