package com.ricecooker

trait TRiceCooker {
  def cook(minutes: String): Unit
  def boil(minutes: String): Unit
  def powerOn(): Unit
  def powerOff(): Unit
  def keepWarm(): Unit
  def stopWarm(): Unit
  def getStatus: String
  def addWater(liters: Int): Unit
  def addRice(grams: Int): Unit
  def isCooking: Boolean
}
