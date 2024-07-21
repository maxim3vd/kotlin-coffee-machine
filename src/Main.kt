const val WATER = 200
const val MILK = 50
const val COFFEE_BEANS = 15

fun ingredientCalculator(cupsNumber: Int) {
    println("""
        For $cupsNumber cups of coffee you will need:
        ${WATER * cupsNumber} ml of water
        ${MILK * cupsNumber} ml of milk
        ${COFFEE_BEANS * cupsNumber} g of coffee beans
    """.trimIndent())
}

fun main() {
    println("Write how many cups of coffee you will need:")
    val cupsNumber: Int = readln().toInt()
    ingredientCalculator(cupsNumber)
}