fun main() {
    data class Ingredient(val name: String, val unit: String, private var _quantity: Int) {
        val quantity: Int
            get() = _quantity

        fun setQuantity(newQuantity: Int) {
            _quantity = newQuantity
        }
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
    val cupsOfCoffee: Int = readln().toInt()
}