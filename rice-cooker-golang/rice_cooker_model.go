package main

import (
	"fmt"
)

type RiceCookerModel struct {
	powerStatus bool
	waterLiters int
	riceGrams   int
	cooking     bool
}

func (rc *RiceCookerModel) Cook(minutes string) {
	if rc.powerStatus && rc.waterLiters > 0 && rc.riceGrams > 0 {
		fmt.Printf("Cuisson pendant %s minutes.\n", minutes)
		rc.cooking = true
	} else {
		fmt.Println("Impossible de cuire. Assurez-vous que le cuiseur de riz est allumé et contient de l'eau et du riz.")
	}
}

func (rc *RiceCookerModel) Boil(minutes string) {
	if rc.powerStatus && rc.waterLiters > 0 {
		fmt.Printf("Ébullition de l'eau pendant %s minutes.\n", minutes)
	} else {
		fmt.Println("Impossible de faire bouillir. Assurez-vous que le cuiseur de riz est allumé et contient de l'eau.")
	}
}

func (rc *RiceCookerModel) PowerOn() {
	rc.powerStatus = true
	fmt.Println("Le cuiseur de riz est allumé.")
}

func (rc *RiceCookerModel) PowerOff() {
	rc.powerStatus = false
	fmt.Println("Le cuiseur de riz est éteint.")
}

func (rc *RiceCookerModel) KeepWarm() {
	if rc.powerStatus {
		fmt.Println("Maintien au chaud du riz.")
	} else {
		fmt.Println("Impossible de maintenir au chaud. Allumez d'abord le cuiseur de riz.")
	}
}

func (rc *RiceCookerModel) StopWarm() {
	fmt.Println("Arrêt du maintien au chaud.")
}

func (rc *RiceCookerModel) GetStatus() string {
	if rc.powerStatus {
		return "Le cuiseur de riz est allumé."
	}
	return "Le cuiseur de riz est éteint."
}

func (rc *RiceCookerModel) AddWater(liters int) {
	rc.waterLiters += liters
	fmt.Printf("%d litres d'eau ajoutés.\n", liters)
}

func (rc *RiceCookerModel) AddRice(grams int) {
	rc.riceGrams += grams
	fmt.Printf("%d grammes de riz ajoutés.\n", grams)
}

func (rc *RiceCookerModel) IsCooking() bool {
	return rc.cooking
}
