package ajcs.androidseekho.u1p4c2_dice_roller

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton : Button = findViewById(R.id.button_roll)
        rollButton.setOnClickListener{
            rollDice()
        }
    }

    private fun rollDice() {
        val die1 = Dice(6)
        val die2 = Dice(20)
        val die1Details_TextView : TextView = findViewById(R.id.textView_die1sides)
        val die2Details_TextView : TextView = findViewById(R.id.textView_die2details)
        val die1Roll_TextView : TextView = findViewById(R.id.textView_die1roll)
        val die2Roll_TextView : TextView = findViewById(R.id.textView_die2roll)

        die1Details_TextView.setTextColor(die1.color)
        die1Roll_TextView.setTextColor(die1.color)
        die1Details_TextView.text = "${die1.sides} sided die"
        die1Roll_TextView.text = die1.roll().toString()

        die2Details_TextView.setTextColor(die2.color)
        die2Roll_TextView.setTextColor(die2.color)
        die2Details_TextView.text = "${die2.sides} sided die"
        die2Roll_TextView.text = die2.roll().toString()
    }
}

class Dice(val sides: Int) {

    val color = listOf(Color.GREEN, Color.RED, Color.BLUE, Color.CYAN, Color.YELLOW, Color.MAGENTA).random()

    fun roll() : Int = (1..sides).random()
}