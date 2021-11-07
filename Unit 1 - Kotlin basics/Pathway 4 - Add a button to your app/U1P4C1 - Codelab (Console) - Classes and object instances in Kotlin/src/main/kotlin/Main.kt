fun main(args: Array<String>) {
    val dice1 = Dice(6)
    println("Your ${dice1.getSides()} sided die rolled ${dice1.roll()}")

    val dice2 = Dice(20)
    println("Your ${dice2.getSides()} sided die rolled ${dice2.roll()}")

    val coin1 = Coin("Heads")
    println("You ${coin1.flipAndCheck()}")
}

class Dice(private val sides: Int) {

    fun roll() : Int = (1..sides).random()
    fun getSides () : Int = sides
}

class Coin (private var guess : String){

    private val faces = mapOf(0 to "heads" ,1 to "tails")
    private val message = mapOf(true to "Win", false to "Lose")
    private fun flip() : Int = (0..1).random()

    fun flipAndCheck() : String = message[faces[flip()].equals(guess.lowercase())]!!
}
