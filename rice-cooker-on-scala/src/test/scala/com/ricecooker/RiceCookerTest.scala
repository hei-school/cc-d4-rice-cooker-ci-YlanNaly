package com.ricecooker

import org.scalatest.funsuite.AnyFunSuite

import java.io.{ByteArrayOutputStream, PrintStream}

class RiceCookerTest extends AnyFunSuite {

  test("Test initial status of Rice Cooker") {
    val riceCooker = new RiceCookerModel
    assert(!riceCooker.isCooking)
    assert(!riceCooker.getStatus.contains("allumé"))
  }

  test("Test powering on and off Rice Cooker") {
    val riceCooker = new RiceCookerModel
    riceCooker.powerOn()
    assert(riceCooker.getStatus.contains("allumé"))

    riceCooker.powerOff()
    assert(!riceCooker.getStatus.contains("allumé"))
  }

  test("Test adding water to the Rice Cooker") {
    val riceCooker = new RiceCookerModel

    val outputStream = new ByteArrayOutputStream()
    Console.withOut(new PrintStream(outputStream)) {
      riceCooker.powerOn()
      riceCooker.addWater(100)
    }

    val output = outputStream.toString.trim
    assert(output.contains("Le cuiseur de riz est allumé."))
    assert(output.contains("100 litres d'eau ajoutés."))
  }

  test("Test cooking functionality of the Rice Cooker") {
    val riceCooker = new RiceCookerModel
    val outputStream = new ByteArrayOutputStream()
    Console.withOut(new PrintStream(outputStream)) {
      riceCooker.powerOn()
      riceCooker.addWater(100)
      riceCooker.addRice(200)
      riceCooker.cook("10")
    }

    val output = outputStream.toString.trim
    assert(output.contains("Le cuiseur de riz est allumé."))
    assert(output.contains("100 litres d'eau ajoutés."))
    assert(output.contains("200 grammes de riz ajoutés."))
    assert(output.contains("Cuisson pendant 10 minutes."))
  }

  test("Test boiling water functionality of the Rice Cooker") {
    val riceCooker = new RiceCookerModel
    val outputStream = new ByteArrayOutputStream()
    Console.withOut(new PrintStream(outputStream)) {
      riceCooker.powerOn()
      riceCooker.addWater(100)
      riceCooker.boil("5")
    }

    val output = outputStream.toString.trim
    assert(output.contains("Le cuiseur de riz est allumé."))
    assert(output.contains("100 litres d'eau ajoutés."))
    assert(output.contains("Ébullition d'eau pendant 5 minutes."))
  }

  test("Test keeping warm functionality of the Rice Cooker") {
    val riceCooker = new RiceCookerModel
    val outputStream = new ByteArrayOutputStream()
    Console.withOut(new PrintStream(outputStream)) {
      riceCooker.powerOn()
      riceCooker.keepWarm()
    }

    val output = outputStream.toString.trim

    assert(output.contains("Le cuiseur de riz est allumé."))
    assert(output.contains("Garder le riz au chaud."))
  }

  test("Test when Rice Cooker is not open") {
    val riceCooker = new RiceCookerModel
    val outputStream = new ByteArrayOutputStream()
    Console.withOut(new PrintStream(outputStream)) {
      riceCooker.cook("10")
    }

    val output = outputStream.toString.trim
    assert(output.contains("Impossible de cuisiner. Assurez-vous que le cuiseur de riz est allumé et contient de l'eau et du riz."))
  }
}
