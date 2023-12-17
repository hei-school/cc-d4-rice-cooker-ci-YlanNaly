interface IRiceCooker {
    fun cook(minutes: String)
    fun boil(minutes: String)
    fun powerOn()
    fun powerOff()
    fun keepWarm()
    fun stopWarm()
    fun getStatus(): String
    fun addWater(liters: Int)
    fun addRice(grams: Int)
    fun isCooking(): Boolean
}
