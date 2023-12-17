package main

type RiceCooker interface {
	Cook(minutes string)
	Boil(minutes string)
	PowerOn()
	PowerOff()
	KeepWarm()
	StopWarm()
	GetStatus() string
	AddWater(liters int)
	AddRice(grams int)
	IsCooking() bool
}
