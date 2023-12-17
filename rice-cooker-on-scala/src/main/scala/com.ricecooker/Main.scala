package com.ricecooker
import java.util.Scanner

object Main {
  def main(args: Array[String]): Unit = {
    val riceCooker = new RiceCookerModel
    val scanner = new Scanner(System.in)
    while (true) {
      println(s"État actuel : ${riceCooker.getStatus}")
      displayMenu()

      try {
        val choice = scanner.nextInt()
        choice match {
          case 1 => riceCooker.powerOn()
          case 2 => riceCooker.powerOff()
          case 3 => riceCooker.keepWarm()
          case 4 => riceCooker.stopWarm()
          case 5 =>
            if (!riceCooker.getStatus.contains("allumé")) {
              println("Veuillez allumer le cuiseur de riz d'abord.")
            } else {
              println("Entrez les grammes de riz à ajouter :")
              val riceToAdd = scanner.nextInt()
              riceCooker.addRice(riceToAdd)
            }
          case 6 =>
            if (!riceCooker.getStatus.contains("allumé")) {
              println("Veuillez allumer le cuiseur de riz d'abord.")
            } else {
              println("Entrez les litres d'eau à ajouter :")
              val waterToAdd = scanner.nextInt()
              riceCooker.addWater(waterToAdd)
            }
          case 7 =>
            if (!riceCooker.getStatus.contains("allumé")) {
              println("Veuillez allumer le cuiseur de riz d'abord.")
            } else {
              riceCooker.boil("10")
            }
          case 8 =>
            if (!riceCooker.getStatus.contains("allumé")) {
              println("Veuillez allumer le cuiseur de riz d'abord.")
            } else {
              riceCooker.cook("15")
            }
          case 9 =>
            println("Programme terminé.")
            return
          case _ =>
            println("Entrée invalide. Veuillez entrer une option valide.")
        }
      } catch {
        case _: Exception =>
          println("Format d'entrée invalide. Veuillez entrer une option valide.")
          scanner.nextLine()
      }
    }
  }

  private def displayMenu(): Unit = {
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
        "9. Éteindre"
    )
  }
}
