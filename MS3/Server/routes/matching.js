exports.match = function (datenbankm Promise) {

  return function (req, res) {
    var Verein_IDS = [];
    var Sportstudio_IDS = [];
    var PersonalTrainer_IDS = [];
    var UID = req.body.UID;
    var wohnort = req.body.sportzler.wohnort;
    var kurse = res.body.kurse;
    var
    var punktzahlen = [];
    var eingabeKurse = [];
    var eingabeGeraete = [];
    var eingabeWellness = [];
    var eingabeSportarten = [];

    switch (typ) {
      case sportstudio:
          console.log("Hier werden die Sportstudios gesucht");
          for(int i = 0; i < Sportstudio_IDS.lenth; i++ ){
            if (sportler.wohnort == sportstudio.wohnort) {
              console.log(sportstudio.username);
              punktzahlen

            //Hier wird überprüft ob ein Kurs in der Suche ist.
            for (int j = 0; ij< kurse.length; j++) {
                    if (eingebeKarse = kurs) {
                        switch (wichtigkeit) {
                            case 1:
                                punktzahlen[i] = 1 * 1;
                                break;
                            case 2
                                ;
                                punktzahlen[i] = 1 * 2;
                                break;
                            case 3:
                                punktzahlen[i] = 1 * 3;
                                break;
                            case 4:
                                punktzahlen[i] = 1 * 4;
                                break;
                            default:
                                console.log("Keine Uebereinstimmung");
                        }
                    }
              }

              for (j = 0; j = geraete.length;j++) {
                  if (eingebeGeraete = geraete){
                      switch (wichtigkeit) {
                          case 1:
                              punktzahlen[i] = 1 * 1;
                              break;
                          case 2
                              ;
                              punktzahlen[i] = 1 * 2;
                              break;
                          case 3:
                              punktzahlen[i] = 1 * 3;
                              break;
                          case 4:
                              punktzahlen[i] = 1 * 4;
                              break;
                          default:
                              console.log("Keine Uebereinstimmung");
                      }
                  }
              }

              for (j = 0; j = wellness.length;j++) {
                if (eingebewWellness = wellness){
                  switch (wichtigkeit) {
                      case 1:
                          punktzahlen[i] = 1 * 1;
                          break;
                      case 2
                          ;
                          punktzahlen[i] = 1 * 2;
                          break;
                      case 3:
                          punktzahlen[i] = 1 * 3;
                          break;
                      case 4:
                          punktzahlen[i] = 1 * 4;
                          break;
                      default:
                          console.log("Keine Uebereinstimmung");
                     }
                }
            }

            for (j = 0; j = sportarten.length;j++) {
                    if (eingebeSportarten = sportarten){
                        switch (wichtigkeit) {
                            case 1:
                                punktzahlen[i] = 1 * 1;
                                break;
                            case 2
                                ;
                                punktzahlen[i] = 1 * 2;
                                break;
                            case 3:
                                punktzahlen[i] = 1 * 3;
                                break;
                            case 4:
                                punktzahlen[i] = 1 * 4;
                                break;
                            default:
                                console.log("Keine Uebereinstimmung");
                        }
                    }
                }


          }

      break;
      case verein:
        for(i = 0; i < Verein_IDS.length; i++){
            if (sportler.verein != verein.wohnort) {
                console.log("Kein Verein vorhanden.");
            } else {
                console.log(verein.username);
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
        break;
        case verein:
          for(int i = 0; i < Sportstudio_IDS.lenth; i++){
            switch
          }
    }
    }
}
