package com.ricecooker

class RiceCookerModel extends TRiceCooker {
  private var powerStatus: Boolean = false
  private var waterLiters: Int = 0
  private var riceGrams: Int = 0
  private var cooking: Boolean = false

  override def cook(minutes: String): Unit = {
    if (powerStatus && waterLiters > 0 && riceGrams > 0) {
      println(s"Cuisson pendant $minutes minutes.")
      cooking = true
    } else {
      println("Impossible de cuisiner. Assurez-vous que le cuiseur de riz est allumé et contient de l'eau et du riz.")
    }
  }

  override def boil(minutes: String): Unit = {
    if (powerStatus && waterLiters > 0) {
      println(s"Ébullition d'eau pendant $minutes minutes.")
    } else {
      println("Impossible d'ébullition. Assurez-vous que le cuiseur de riz est allumé et contient de l'eau.")
    }
  }

  override def powerOn(): Unit = {
    powerStatus = true
    println("Le cuiseur de riz est allumé.")
  }

  override def powerOff(): Unit = {
    powerStatus = false
    println("Le cuiseur de riz est éteint.")
  }

  override def keepWarm(): Unit = {
    if (powerStatus) {
      println("Garder le riz au chaud.")
    } else {
      println("Impossible de garder au chaud. Allumez d'abord le cuiseur de riz.")
    }
  }

  override def stopWarm(): Unit = {
    println("Arrêt de la fonction de maintien au chaud.")
  }

  override def getStatus: String = {
    if (powerStatus) "Le cuiseur de riz est allumé." else "Le cuiseur de riz est éteint."
  }

  override def addWater(liters: Int): Unit = {
    waterLiters += liters
    println(s"$liters litres d'eau ajoutés.")
  }

  override def addRice(grams: Int): Unit = {
    riceGrams += grams
    println(s"$grams grammes de riz ajoutés.")
  }

  override def isCooking: Boolean = cooking
}

