exports.match = function (datenbankm Promise) {
  return function (req, res) {
    var Verein_IDS = [];
    var Sportstudio_IDS = [];
    var PersonalTrainer_IDS = [];
    var UID = req.body.UID;
    var wohnort = req.body.wohnort;

    switch (typ) {
      case sportstudio:
          console.log("Hier werden die Sportstudios gesucht");
          for(int i = 0; i < Sportstudio_IDS.lenth; i++ ){
            if (sportler.wohnort == sportstudio.wohnort) {
              console.log(sportstudio.username);
            }
            else {
              console.log("Kein Studio vorhanden");
            }
          }
      break;
      case verein:
        for(i = 0; i < Verein_IDS.length; i++){
          if (sportler.verein == verein.wohnort) {
            console.log(verein.username);
          }
          else {
            console.log("Kein Verein vorhanden.");
          }
        }
      break;
      case personalTrainer:
        for(i = 0; i < PersonalTrainer_IDS.length; i++){
          if (sportler.wohnort == personalTrainer.wohnort) {
            console.log(personalTrainer.username);
          }
          else {
            console.log("Kein Personal Trainer vorhanden.");
          }
        }
      break;
      default:
        console.log("Konnte nicht gefunden werden.");
    }
  }
}
