import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue


class RiceCookerTest {
	
	private lateinit var riceCooker: RiceCookerModel
	private lateinit var outputStream: ByteArrayOutputStream
	
	@BeforeEach
	fun setUp() {
		riceCooker = RiceCookerModel()
		outputStream = ByteArrayOutputStream()
		System.setOut(PrintStream(outputStream))
	}
	
	@Test
	fun testInitialStatus() {
		assertFalse(riceCooker.isCooking())
		assertEquals("ÉTEINT", riceCooker.getStatus())
	}
	
	@Test
	fun testPowerOnOff() {
		riceCooker.powerOn()
		assertEquals("Le cuiseur de riz est allumé", outputStream.toString().trim())
		
		riceCooker.powerOff()
		assertEquals("Le cuiseur de riz est allumé\n" +
				"Le cuiseur de riz est éteint", outputStream.toString().trim())
	}

	
	@Test
	fun testAddWater() {
		riceCooker.powerOn()
		riceCooker.addWater(3)
		assertEquals("Le cuiseur de riz est allumé\nAjout de 3 litres d'eau. Niveau d'eau actuel : 3 litres", outputStream.toString().trim())
	}
	
	@Test
	fun testCookingFunctionality() {
		riceCooker.powerOn()
		riceCooker.addRice(200)
		riceCooker.cook("10")
		
		assertEquals("Le cuiseur de riz est allumé\n" +
				"Ajout de 200 grammes de riz. Quantité de riz actuelle : 200 grammes\n" +
				"Cuisson pendant 10 minutes", outputStream.toString().trim())
	}
	
	@Test
	fun testBoilFunctionality() {
		riceCooker.powerOn()
		riceCooker.addWater(4)
		riceCooker.boil("5")
		assertEquals("Le cuiseur de riz est allumé\n" +
				"Ajout de 4 litres d'eau. Niveau d'eau actuel : 4 litres\n" +
				"Ébullition pendant 5 minutes", outputStream.toString().trim())
	}
	
	@Test
	fun testKeepingWarmFunctionality() {
		riceCooker.keepWarm()
		assertEquals("Garder le riz au chaud", outputStream.toString().trim())
	}
	
	@Test
	fun testStoppingWarmFunctionality() {
		riceCooker.stopWarm()
		assertEquals("Arrêt de la fonction de maintien au chaud", outputStream.toString().trim())
	}
}
