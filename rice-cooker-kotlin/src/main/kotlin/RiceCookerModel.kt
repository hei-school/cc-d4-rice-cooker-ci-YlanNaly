class RiceCookerModel : IRiceCooker {
    var isPowerOn: Boolean = false
    private var waterLevelLiters: Int = 0
    private var riceAmountGrams: Int = 0
    private var isCurrentlyCooking: Boolean = false

    override fun cook(minutes: String) {
        if (riceAmountGrams > 0) {
            if (isCurrentlyCooking) {
                println("Impossible d'ajouter autre chose pendant la cuisson.")
            } else {
                println("Cuisson pendant $minutes minutes")
                isCurrentlyCooking = true
            }
        } else {
            println("Impossible de commencer la cuisson. Ajoutez du riz d'abord.")
        }
    }

    override fun boil(minutes: String) {
        if (waterLevelLiters > 0) {
            println("Ébullition pendant $minutes minutes")
        } else {
            println("Impossible de commencer l'ébullition. Ajoutez de l'eau d'abord.")
        }
    }

    override fun powerOn() {
        isPowerOn = true
        println("Le cuiseur de riz est allumé")
    }

    override fun powerOff() {
        isPowerOn = false
        println("Le cuiseur de riz est éteint")
    }

    override fun keepWarm() {
        println("Garder le riz au chaud")
    }

    override fun stopWarm() {
        println("Arrêt de la fonction de maintien au chaud")
    }

    override fun getStatus(): String {
        return if (isPowerOn) "ALLUMÉ" else "ÉTEINT"
    }

    override fun addWater(liters: Int) {
        if (!isCurrentlyCooking) {
            if (waterLevelLiters + liters <= MAX_WATER_CAPACITY) {
                waterLevelLiters += liters
                println("Ajout de $liters litres d'eau. Niveau d'eau actuel : $waterLevelLiters litres")
            } else {
                println("Capacité d'eau dépassée.")
            }
        } else {
            println("Impossible d'ajouter de l'eau pendant la cuisson.")
        }
    }

    override fun addRice(grams: Int) {
        if (!isCurrentlyCooking) {
            if (riceAmountGrams + grams <= MAX_RICE_CAPACITY) {
                riceAmountGrams += grams
                println("Ajout de $grams grammes de riz. Quantité de riz actuelle : $riceAmountGrams grammes")
            } else {
                println("Capacité de riz dépassée.")
            }
        } else {
            println("Impossible d'ajouter du riz pendant la cuisson.")
        }
    }

    override fun isCooking(): Boolean {
        return isCurrentlyCooking
    }

    companion object {
        private const val MAX_WATER_CAPACITY = 5
        private const val MAX_RICE_CAPACITY = 500
    }
}
