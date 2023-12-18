interface IRiceCooker {
    cook(minutes: string): void;
    boil(minutes: string): void;
    powerOn(): void;
    powerOff(): void;
    keepWarm(): void;
    stopWarm(): void;
    getStatus(): string;
    addWater(liters: number): void;
    addRice(grams: number): void;
    isCooking(): boolean;
}

class RiceCookerModel implements IRiceCooker {
    isPowerOn: boolean = false;
    private waterLevelLiters: number = 0;
    private riceAmountGrams: number = 0;
    private isCurrentlyCooking: boolean = false;

    private readonly MAX_WATER_CAPACITY: number = 5;
    private readonly MAX_RICE_CAPACITY: number = 500;

    cook(minutes: string): void {
        if (this.riceAmountGrams > 0) {
            if (this.isCurrentlyCooking) {
                console.log("Impossible d'ajouter autre chose pendant la cuisson.");
            } else {
                console.log(`Cuisson pendant ${minutes} minutes`);
                this.isCurrentlyCooking = true;
            }
        } else {
            console.log("Impossible de commencer la cuisson. Ajoutez du riz d'abord.");
        }
    }

    boil(minutes: string): void {
        if (this.waterLevelLiters > 0) {
            console.log(`Ébullition pendant ${minutes} minutes`);
        } else {
            console.log("Impossible de commencer l'ébullition. Ajoutez de l'eau d'abord.");
        }
    }

    powerOn(): void {
        this.isPowerOn = true;
        console.log("Le cuiseur de riz est allumé");
    }

    powerOff(): void {
        this.isPowerOn = false;
        console.log("Le cuiseur de riz est éteint");
    }

    keepWarm(): void {
        console.log("Garder le riz au chaud");
    }

    stopWarm(): void {
        console.log("Arrêt de la fonction de maintien au chaud");
    }

    getStatus(): string {
        return this.isPowerOn ? "ALLUMÉ" : "ÉTEINT";
    }

    addWater(liters: number): void {
        if (!this.isCurrentlyCooking) {
            if (this.waterLevelLiters + liters <= this.MAX_WATER_CAPACITY) {
                this.waterLevelLiters += liters;
                console.log(`Ajout de ${liters} litres d'eau. Niveau d'eau actuel : ${this.waterLevelLiters} litres`);
            } else {
                console.log("Capacité d'eau dépassée.");
            }
        } else {
            console.log("Impossible d'ajouter de l'eau pendant la cuisson.");
        }
    }

    addRice(grams: number): void {
        if (!this.isCurrentlyCooking) {
            if (this.riceAmountGrams + grams <= this.MAX_RICE_CAPACITY) {
                this.riceAmountGrams += grams;
                console.log(`Ajout de ${grams} grammes de riz. Quantité de riz actuelle : ${this.riceAmountGrams} grammes`);
            } else {
                console.log("Capacité de riz dépassée.");
            }
        } else {
            console.log("Impossible d'ajouter du riz pendant la cuisson.");
        }
    }

    isCooking(): boolean {
        return this.isCurrentlyCooking;
    }
}

export default RiceCookerModel