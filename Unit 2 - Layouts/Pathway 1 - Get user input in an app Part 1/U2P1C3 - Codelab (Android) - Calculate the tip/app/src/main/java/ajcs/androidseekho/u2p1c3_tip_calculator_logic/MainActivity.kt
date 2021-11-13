package ajcs.androidseekho.u2p1c3_tip_calculator_logic

import ajcs.androidseekho.u2p1c3_tip_calculator_logic.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.text.NumberFormat
import java.util.*
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener{
            calculateTip()
        }
    }

    private fun calculateTip()
    {
        val cost = when (val value = binding.editTextServiceCost.editText?.text.toString())
        {
             "" -> 0.0
            else -> value.toDouble()
        }

        val percentage = when (binding.radioGroup.checkedRadioButtonId){
            R.id.radioButton_amazing -> 0.20
            R.id.radioButton_good -> 0.10
            R.id.radioButton_okay -> 0.05
            else -> 0.00
        }
        var tip = cost * percentage
        if (binding.switchRoundUpTip.isChecked){
            tip = ceil(tip)
        }
        val formattedTip = NumberFormat.getCurrencyInstance(Locale.US).format(tip)
        binding.textViewTipResult.text = getString(R.string.tip_amount, formattedTip)
    }
}