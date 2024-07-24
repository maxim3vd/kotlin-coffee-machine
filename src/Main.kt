fun main() {
    data class CupOfCoffee(val water: Int = 200, val milk: Int = 50, val coffeeBeans: Int = 15)

    data class Ingredient(val name: String, val unit: String, private var _quantity: Int) {
        val quantity: Int
            get() = _quantity

        fun setQuantity(newQuantity: Int) {
            _quantity = newQuantity
        }
    }

    fun cupsOfCoffeeAvailable(ingredients: Map<String, Ingredient>): Int {
        val cupOfCoffee = CupOfCoffee()
        val cupsByWater = ingredients["water"]!!.quantity / cupOfCoffee.water
        val cupsByMilk = ingredients["milk"]!!.quantity / cupOfCoffee.milk
        val cupsByCoffeeBeans = ingredients["coffee beans"]!!.quantity / cupOfCoffee.coffeeBeans

        return minOf(cupsByWater, cupsByMilk, cupsByCoffeeBeans)
    }

    val ingredients: Map<String, Ingredient> = mapOf(
        "water" to Ingredient(name = "water", unit = "ml", _quantity = 0),
        "milk" to Ingredient(name = "milk", unit = "ml", _quantity = 0),
        "coffee beans" to Ingredient(name = "coffee beans", unit = "grams", _quantity = 0)
    )

    for ((name, ingredient) in ingredients) {
        println("Write how many ${ingredient.unit} of $name the coffee machine has:")
        val newQuantity = readln().toInt()
        ingredient.setQuantity(newQuantity)
    }

    println("Write how many cups of coffee you will need:")
    val cupsOfCoffeeRequested: Int = readln().toInt()

    val cupOfCoffeeAvailable = cupsOfCoffeeAvailable(ingredients)
}