package ajcs.androidseekho.u2p2c3_tip_calculator_polished

import ajcs.androidseekho.u2p2c3_tip_calculator_polished.databinding.ActivityMainBinding
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.text.NumberFormat
import java.util.*
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.editTextServiceCost.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view,keyCode)
        }
        binding.buttonCalculate.setOnClickListener{
            calculateTip()
        }
    }

    private fun calculateTip() {
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
    private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
        if (keyCode == KeyEvent.KEYCODE_ENTER) {
            // Hide the keyboard
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}