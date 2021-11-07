fun main(args: Array<String>) {

    //Just change these properties according to your liking
    val name = "Syed Ahmed Jamil"
    val age = 25
    val layer = 4
    val symbol = "-_.._-"

    //Printing Banner
    printBorder(symbol,7)
    println("    Happy Birthday, $name")
    printBorder(symbol,7)

    //Printing the cake
    printCakeCandles(age)
    printCakeTop(age)
    printCakeBottom(age,layer)
}

//Methods
fun printBorder(symbol: String, count: Int){
    repeat(count){
        print(symbol)
    }
    println()
}
fun printCakeTop(age: Int){
    repeat(age + 2){
        print("=")
    }
    println()
}
fun printCakeCandles(age: Int){
    print(" ")
    repeat(age) {
        print(",")
    }
    println()
    print(" ")
    repeat(age)
    {
        print("|")
    }
    println()
}
fun printCakeBottom(age: Int, layers: Int){
    repeat(layers){
        repeat(age + 2){
            print("@")
        }
        println()
    }
    println()
}