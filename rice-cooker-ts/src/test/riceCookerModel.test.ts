import RiceCookerModel from '../model';

describe('RiceCookerModel', () => {
    let riceCooker = new RiceCookerModel();
    let outputStream = "";

    beforeEach(() => {
        riceCooker = new RiceCookerModel();
        outputStream = '';
        console.log = jest.fn((message) => {
            outputStream += message + '\n';
        });
    });

    test('initial status should be powered off', () => {
        expect(riceCooker.isCooking()).toBeFalsy();
        expect(riceCooker.getStatus()).toBe('ÉTEINT');
    });

    test('power on and off the rice cooker', () => {
        riceCooker.powerOn();
        expect(riceCooker.getStatus()).toBe('ALLUMÉ');

        riceCooker.powerOff();
        expect(riceCooker.getStatus()).toBe('ÉTEINT');
    });

    test('add water to the cooker', () => {
        riceCooker.powerOn();
        riceCooker.addWater(3);
        expect(outputStream.trim()).toBe("Le cuiseur de riz est allumé\nAjout de 3 litres d'eau. Niveau d'eau actuel : 3 litres");
    });

    test('cooking functionality', () => {
        riceCooker.powerOn();
        riceCooker.addRice(200);
        riceCooker.cook('10');
        expect(outputStream.trim()).toBe("Le cuiseur de riz est allumé\nAjout de 200 grammes de riz. Quantité de riz actuelle : 200 grammes\nCuisson pendant 10 minutes");
    });

    test('boil functionality', () => {
        riceCooker.powerOn();
        riceCooker.addWater(4);
        riceCooker.boil('5');
        expect(outputStream.trim()).toBe("Le cuiseur de riz est allumé\nAjout de 4 litres d'eau. Niveau d'eau actuel : 4 litres\nÉbullition pendant 5 minutes");
    });

    test('keeping warm functionality', () => {
        riceCooker.keepWarm();
        expect(outputStream.trim()).toBe("Garder le riz au chaud");
    });

    test('stopping warm functionality', () => {
        riceCooker.stopWarm();
        expect(outputStream.trim()).toBe("Arrêt de la fonction de maintien au chaud");
    });
});