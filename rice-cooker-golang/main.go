package main

import (
	"fmt"
	"strconv"
)

func main() {
	riceCooker := &RiceCookerModel{}

	for {
		fmt.Println("État actuel:", riceCooker.GetStatus())
		displayMenu()

		var choice int
		_, err := fmt.Scanln(&choice)
		if err != nil {
			return
		}

		switch choice {
		case 1:
			riceCooker.PowerOn()
		case 2:
			riceCooker.PowerOff()
		case 3:
			riceCooker.KeepWarm()
		case 4:
			riceCooker.StopWarm()
		case 5:
			if !containsAllumé(riceCooker.GetStatus()) {
				fmt.Println("Veuillez allumer le cuiseur de riz d'abord.")
			} else {
				fmt.Println("Entrez les grammes de riz à ajouter :")
				var input string
				_, err := fmt.Scanln(&input)
				if err != nil {
					return
				}
				grams, err := strconv.Atoi(input)
				if err != nil {
					fmt.Println("Entrée invalide. Veuillez entrer un nombre de grammes valide.")
					break
				}
				riceCooker.AddRice(grams)
			}
		case 6:
			if !containsAllumé(riceCooker.GetStatus()) {
				fmt.Println("Veuillez allumer le cuiseur de riz d'abord.")
			} else {
				fmt.Println("Entrez les litres d'eau à ajouter :")
				var input string
				_, err := fmt.Scanln(&input)
				if err != nil {
					return
				}
				liters, err := strconv.Atoi(input)
				if err != nil {
					fmt.Println("Entrée invalide. Veuillez entrer un nombre de litres valide.")
					break
				}
				riceCooker.AddWater(liters)
			}
		case 7:
			if !containsAllumé(riceCooker.GetStatus()) {
				fmt.Println("Veuillez allumer le cuiseur de riz d'abord.")
			} else {
				riceCooker.Boil("10")
			}
		case 8:
			if !containsAllumé(riceCooker.GetStatus()) {
				fmt.Println("Veuillez allumer le cuiseur de riz d'abord.")
			} else {
				riceCooker.Cook("15")
			}
		case 9:
			fmt.Println("Programme terminé.")
			return
		default:
			fmt.Println("Entrée invalide. Veuillez entrer une option valide.")
		}
	}
}

func displayMenu() {
	fmt.Println(
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

func containsAllumé(status string) bool {
	return contains(status, "allumé")
}

func contains(s, substr string) bool {
	return len(s) > 0 && len(substr) > 0 && (len(s) >= len(substr) && s[len(s)-len(substr):] == substr || len(s) > len(substr) && s[len(s)-len(substr)-1:] == " "+substr)
}
