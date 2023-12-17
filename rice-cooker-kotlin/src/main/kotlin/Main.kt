import java.util.Scanner

fun main() {
    val reset = "\u001B[0m"
    val bold = "\u001B[1m"
    val green = "\u001B[32m"

    val banner = """
        $bold$green
         ██╗    ██╗ ██████╗ ██████╗ ███████╗██████╗  █████╗ ██╗   ██╗██╗  ██╗
         ██║    ██║██╔═══██╗██╔══██╗██╔════╝██╔══██╗██╔══██╗██║   ██║╚██╗██╔╝
         ██║ █╗ ██║██║   ██║██║  ██║█████╗  ██████╔╝███████║██║   ██║ ╚███╔╝
         ██║███╗██║██║   ██║██║  ██║██╔══╝  ██╔══██╗██╔══██║██║   ██║ ██╔██╗
         ╚███╔███╔╝╚██████╔╝██████╔╝███████╗██║  ██║██║  ██║╚██████╔╝██╔╝ ██╗
          ╚══╝╚══╝  ╚═════╝ ╚═════╝ ╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝ ╚═╝  ╚═╝
    $reset"""

    println(banner)
    val riceCooker = RiceCookerModel()
    val scanner = Scanner(System.`in`)

    while (true) {
        println("État actuel : ${riceCooker.getStatus()}")
        menu()
        val choice = scanner.nextInt()
        try {
            when (choice) {
                1 -> riceCooker.powerOn()
                2 -> riceCooker.powerOff()
                3 -> riceCooker.keepWarm()
                4 -> riceCooker.stopWarm()
                5 -> {
                    if (!riceCooker.isPowerOn) {
                        println("Veuillez allumer le cuiseur de riz d'abord.")
                    } else {
                        println("Entrez les grammes de riz à ajouter :")
                        val riceToAdd = scanner.nextInt()
                        riceCooker.addRice(riceToAdd)
                    }
                }
                6 -> {
                    if (!riceCooker.isPowerOn) {
                        println("Veuillez allumer le cuiseur de riz d'abord.")
                    } else {
                        println("Entrez les litres d'eau à ajouter :")
                        val waterToAdd = scanner.nextInt()
                        riceCooker.addWater(waterToAdd)
                    }
                }
                7 -> {
                    if (!riceCooker.isPowerOn) {
                        println("Veuillez allumer le cuiseur de riz d'abord.")
                    } else {
                        riceCooker.boil("10")
                    }
                }
                8 -> {
                    if (!riceCooker.isPowerOn) {
                        println("Veuillez allumer le cuiseur de riz d'abord.")
                    } else {
                        riceCooker.cook("15")
                    }
                }
                9 -> {
                    println("Programme terminé")
                    return
                }
                else -> println("Entrée invalide. Veuillez entrer une option valide.")
            }
        } catch (e: Exception) {
            println("Format d'entrée invalide. Veuillez entrer une option valide.")
            scanner.nextLine()
        }
    }
}

fun menu() {
    println(
        "Programme du cuiseur de riz, voici les fonctionnalités : \n" +
            "1. Allumer\n" +
            "2. Éteindre\n" +
            "3. Garder au chaud\n" +
            "4. Arrêter de maintenir au chaud\n" +
            "5. Ajouter du riz\n" +
            "6. Ajouter de l'eau\n" +
            "7. Ébullition\n" +
            "8. Cuisson\n" +
            "9. Éteindre",
    )
}
