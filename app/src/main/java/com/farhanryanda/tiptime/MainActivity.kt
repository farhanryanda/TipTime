package com.farhanryanda.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.farhanryanda.tiptime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        displayResult()
        binding.btnCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val tip = binding.edtCost.text.toString()

        if (v == binding.btnCalculate) {
            if (binding.rgQuality.checkedRadioButtonId > 0) {
                val percen: Double
                if (tip.isEmpty()) {
                    binding.edtCost.error = "Masih Kosong"
                } else {
                    when(binding.rgQuality.checkedRadioButtonId) {
                        R.id.rb_amazing_20 -> {
                            percen = 0.2
                            viewModel.calculate(tip,percen.toString())
                            displayResult()
                        }

                        R.id.rb_good_18 -> {
                            percen = 0.18
                            viewModel.calculate(tip,percen.toString())
                            displayResult()
                        }

                        R.id.rb_ok_15 -> {
                            percen = 0.15
                            viewModel.calculate(tip,percen.toString())
                            displayResult()
                        }
                    }
                }
            }
        }
    }

    private fun displayResult() {
        var result = viewModel.result
        if (binding.swRoundtip.isChecked) {
            result = kotlin.math.ceil(result)
            binding.tipAmount.text = String.format(getString(R.string.tip_amount),result)
        } else {
            binding.tipAmount.text = String.format(getString(R.string.tip_amount),result)
        }
    }
}