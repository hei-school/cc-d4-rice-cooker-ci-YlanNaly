package main

import (
	"testing"
)

func TestRiceCookerModel(t *testing.T) {
	cooker := &RiceCookerModel{}

	t.Run("Test Power On/Off", func(t *testing.T) {
		cooker.PowerOn()
		if !cooker.powerStatus {
			t.Errorf("Expected power status to be true after PowerOn, got %v", cooker.powerStatus)
		}

		cooker.PowerOff()
		if cooker.powerStatus {
			t.Errorf("Expected power status to be false after PowerOff, got %v", cooker.powerStatus)
		}
	})

	t.Run("Test Adding Water", func(t *testing.T) {
		cooker.AddWater(2)
		if cooker.waterLiters != 2 {
			t.Errorf("Expected 2 litres d'eau ajoutés., got %v", cooker.waterLiters)
		}
	})

	t.Run("Test Adding Rice", func(t *testing.T) {
		cooker.AddRice(300)
		if cooker.riceGrams != 300 {
			t.Errorf("Expected 300 grammes de riz ajoutés., got %v", cooker.riceGrams)
		}
	})

	t.Run("Test Cooking", func(t *testing.T) {
		cooker.PowerOn()
		cooker.AddWater(1)
		cooker.AddRice(100)
		cooker.Cook("15")
		if !cooker.cooking {
			t.Error("Expected cooking to be true")
		}
	})

	t.Run("Test Keep Warm", func(t *testing.T) {
		cooker.KeepWarm()
		// You might want to include additional assertions here based on your logic
		// regarding the KeepWarm function.
	})

	t.Run("Test Status", func(t *testing.T) {
		status := cooker.GetStatus()
		expected := "Le cuiseur de riz est éteint."
		if cooker.powerStatus {
			expected = "Le cuiseur de riz est allumé."
		}
		if status != expected {
			t.Errorf("Expected status to be '%s', got '%s'", expected, status)
		}
	})

	t.Run("Test IsCooking", func(t *testing.T) {
		isCooking := cooker.IsCooking()
		if !isCooking {
			t.Error("Expected IsCooking to be true")
		}
	})
}
