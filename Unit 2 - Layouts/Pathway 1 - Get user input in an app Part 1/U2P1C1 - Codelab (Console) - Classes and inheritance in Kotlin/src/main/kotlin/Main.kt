import kotlin.math.PI
import kotlin.math.sqrt

abstract class Dwelling(private var residents : Int){
    abstract val name : String
    abstract val material : String
    abstract val capacity : Int

    fun hasRoom() : Boolean{
        return residents < capacity
    }
    fun getRoom() {
        if (hasRoom()){
            residents ++
            println("Yay! You got a room")
        }
        else
            println("Sorry! House full.")
    }
    abstract fun floorArea() : Double

}

class SquareCabin(residents: Int, private val length : Double) : Dwelling(residents){
    override val name = "SquareCabin"
    override val material = "Wood"
    override val capacity = 8
    override fun floorArea(): Double {
        return length * length
    }
}

open class RoundHut(residents: Int, private val radius : Double) : Dwelling(residents){
    override val name = "RoundHut"
    override val material = "Straw"
    override val capacity = 10

    override fun floorArea(): Double {
        return PI * radius * radius
    }

    fun calculateMaxCarpetSize() : Double
    {
        val diameter = 2 * radius
        return sqrt(diameter * diameter / 2)
    }
}

class RoundTower(residents: Int, radius: Double, private val floors : Int) : RoundHut(residents,radius){
    override val name = "RoundTower"
    override val material = "Stone"
    override val capacity = 4 * floors

    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}

fun printDwelling(dwelling: Dwelling)
{
    println("\n${dwelling.name}")
    repeat(dwelling.name.length) {print("=")}
    println()
    println("Material : ${dwelling.material}")
    println("Capacity : ${dwelling.capacity}")
    println("Floor Area : %.2f".format(dwelling.floorArea()))
    println("Has Room : ${dwelling.hasRoom()}")
    dwelling.getRoom()
    if(dwelling is RoundHut)
    {
        println("Carpet Size : ${dwelling.calculateMaxCarpetSize()}")
    }
}


fun main(args: Array<String>) {
    val squareCabin = SquareCabin(10,50.0)
    val roundHut = RoundHut(5,30.0)
    val roundTower = RoundTower(17,35.0,4)

    printDwelling(squareCabin)
    printDwelling(roundHut)
    printDwelling(roundTower)
}