import RiceCookerModel from "./model";
import * as readline from 'readline';

const reset = "\u001B[0m";
const bold = "\u001B[1m";
const green = "\u001B[32m";

const banner = `
    ${bold}${green}
     ██╗    ██╗ ██████╗ ██████╗ ███████╗██████╗  █████╗ ██╗   ██╗██╗  ██╗
     ██║    ██║██╔═══██╗██╔══██╗██╔════╝██╔══██╗██╔══██╗██║   ██║╚██╗██╔╝
     ██║ █╗ ██║██║   ██║██║  ██║█████╗  ██████╔╝███████║██║   ██║ ╚███╔╝
     ██║███╗██║██║   ██║██║  ██║██╔══╝  ██╔══██╗██╔══██║██║   ██║ ██╔██╗
     ╚███╔███╔╝╚██████╔╝██████╔╝███████╗██║  ██║██║  ██║╚██████╔╝██╔╝ ██╗
      ╚══╝╚══╝  ╚═════╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝ ╚═╝  ╚═╝
${reset}`;

console.log(banner);

const riceCooker = new RiceCookerModel();
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function menu() {
    console.log(
        "Programme du cuiseur de riz, voici les fonctionnalités : \n" +
        "1. Allumer\n" +
        "2. Éteindre\n" +
        "3. Garder au chaud\n" +
        "4. Arrêter de maintenir au chaud\n" +
        "5. Ajouter du riz\n" +
        "6. Ajouter de l'eau\n" +
        "7. Ébullition\n" +
        "8. Cuisson\n" +
        "9. Éteindre\n"
    );
}

function main() {
    rl.on('line', (input: string) => {
        console.log(`État actuel : ${riceCooker.getStatus()}`);
        menu();

        const choice = parseInt(input);
        try {
            switch (choice) {
                case 1:
                    riceCooker.powerOn();
                    break;
                case 2:
                    riceCooker.powerOff();
                    break;
                case 3:
                    riceCooker.keepWarm();
                    break;
                case 4:
                    riceCooker.stopWarm();
                    break;
                case 5:
                    if (!riceCooker.isPowerOn) {
                        console.log("Veuillez allumer le cuiseur de riz d'abord.");
                    } else {
                        console.log("Entrez les grammes de riz à ajouter :");
                        rl.prompt();
                        rl.on('line', (riceInput: string) => {
                            const riceToAdd = parseInt(riceInput);
                            riceCooker.addRice(riceToAdd);
                        });
                    }
                    break;
                case 6:
                    if (!riceCooker.isPowerOn) {
                        console.log("Veuillez allumer le cuiseur de riz d'abord.");
                    } else {
                        console.log("Entrez les litres d'eau à ajouter :");
                        rl.prompt();
                        rl.on('line', (waterInput: string) => {
                            const waterToAdd = parseInt(waterInput);
                            riceCooker.addWater(waterToAdd);
                        });
                    }
                    break;
                case 7:
                    if (!riceCooker.isPowerOn) {
                        console.log("Veuillez allumer le cuiseur de riz d'abord.");
                    } else {
                        riceCooker.boil("10");
                    }
                    break;
                case 8:
                    if (!riceCooker.isPowerOn) {
                        console.log("Veuillez allumer le cuiseur de riz d'abord.");
                    } else {
                        riceCooker.cook("15");
                    }
                    break;
                case 9:
                    console.log("Programme terminé");
                    process.exit(0);
                    break
                default:
                    console.log("Entrée invalide. Veuillez entrer une option valide.");
                    break;
            }
        } catch (e) {
            console.log("Format d'entrée invalide. Veuillez entrer une option valide.");
            rl.prompt();
        }
    });
}

main();