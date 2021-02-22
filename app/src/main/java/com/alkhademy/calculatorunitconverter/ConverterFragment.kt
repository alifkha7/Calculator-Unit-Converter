package com.alkhademy.task3

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.alkhademy.calculatorunitconverter.R
import com.alkhademy.calculatorunitconverter.databinding.FragmentConverterBinding

class ConverterFragment : Fragment() {

    private var _binding: FragmentConverterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentConverterBinding.inflate(inflater, container, false)
        val unitArray = resources.getStringArray(R.array.Unit)
        binding.spinner.adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, unitArray)
        binding.spinner2.adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, unitArray)

        checkEmpty()
        binding.etUnit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                checkEmpty()
            }

            override fun afterTextChanged(s: Editable?) {
                checkSelected()
            }

        })

        binding.swap.setOnClickListener {
            val spinner = binding.spinner.selectedItemPosition
            val spinner2 = binding.spinner2.selectedItemPosition
            binding.spinner.setSelection(spinner2)
            binding.spinner2.setSelection(spinner)
            checkUnit()
        }

        return binding.root
    }

    private fun checkEmpty() {
        if (binding.etUnit.text!!.isNotEmpty()) {
            checkUnit()
        } else {
            binding.etUnit.setText("0")
            binding.etUnitConvert.setText("0")
        }
    }

    private fun checkSelected() {
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                checkUnit()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        binding.spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                checkUnit()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }
    }

    private fun checkUnit() {
        val spinner = binding.spinner
        val spinner2 = binding.spinner2

        if (spinner.selectedItem == "km" && spinner2.selectedItem == "km") {
            multiply1()
        } else if (spinner.selectedItem == "km" && spinner2.selectedItem == "hm") {
            multiply2()
        } else if (spinner.selectedItem == "km" && spinner2.selectedItem == "dam") {
            multiply3()
        } else if (spinner.selectedItem == "km" && spinner2.selectedItem == "m") {
            multiply4()
        } else if (spinner.selectedItem == "km" && spinner2.selectedItem == "dm") {
            multiply5()
        } else if (spinner.selectedItem == "km" && spinner2.selectedItem == "cm") {
            multiply6()
        } else if (spinner.selectedItem == "km" && spinner2.selectedItem == "mm") {
            multiply7()
        } else if (spinner.selectedItem == "hm" && spinner2.selectedItem == "km") {
            divide1()
        } else if (spinner.selectedItem == "hm" && spinner2.selectedItem == "hm") {
            multiply1()
        } else if (spinner.selectedItem == "hm" && spinner2.selectedItem == "dam") {
            multiply2()
        } else if (spinner.selectedItem == "hm" && spinner2.selectedItem == "m") {
            multiply3()
        } else if (spinner.selectedItem == "hm" && spinner2.selectedItem == "dm") {
            multiply4()
        } else if (spinner.selectedItem == "hm" && spinner2.selectedItem == "cm") {
            multiply5()
        } else if (spinner.selectedItem == "hm" && spinner2.selectedItem == "mm") {
            multiply6()
        } else if (spinner.selectedItem == "dam" && spinner2.selectedItem == "km") {
            divide2()
        } else if (spinner.selectedItem == "dam" && spinner2.selectedItem == "hm") {
            divide1()
        } else if (spinner.selectedItem == "dam" && spinner2.selectedItem == "dam") {
            multiply1()
        } else if (spinner.selectedItem == "dam" && spinner2.selectedItem == "m") {
            multiply2()
        } else if (spinner.selectedItem == "dam" && spinner2.selectedItem == "dm") {
            multiply3()
        } else if (spinner.selectedItem == "dam" && spinner2.selectedItem == "cm") {
            multiply4()
        } else if (spinner.selectedItem == "dam" && spinner2.selectedItem == "mm") {
            multiply5()
        } else if (spinner.selectedItem == "m" && spinner2.selectedItem == "km") {
            divide3()
        } else if (spinner.selectedItem == "m" && spinner2.selectedItem == "hm") {
            divide2()
        } else if (spinner.selectedItem == "m" && spinner2.selectedItem == "dam") {
            divide1()
        } else if (spinner.selectedItem == "m" && spinner2.selectedItem == "m") {
            multiply1()
        } else if (spinner.selectedItem == "m" && spinner2.selectedItem == "dm") {
            multiply2()
        } else if (spinner.selectedItem == "m" && spinner2.selectedItem == "cm") {
            multiply3()
        } else if (spinner.selectedItem == "m" && spinner2.selectedItem == "mm") {
            multiply4()
        } else if (spinner.selectedItem == "dm" && spinner2.selectedItem == "km") {
            divide4()
        } else if (spinner.selectedItem == "dm" && spinner2.selectedItem == "hm") {
            divide3()
        } else if (spinner.selectedItem == "dm" && spinner2.selectedItem == "dam") {
            divide2()
        } else if (spinner.selectedItem == "dm" && spinner2.selectedItem == "m") {
            divide1()
        } else if (spinner.selectedItem == "dm" && spinner2.selectedItem == "dm") {
            multiply1()
        } else if (spinner.selectedItem == "dm" && spinner2.selectedItem == "cm") {
            multiply2()
        } else if (spinner.selectedItem == "dm" && spinner2.selectedItem == "mm") {
            multiply3()
        } else if (spinner.selectedItem == "cm" && spinner2.selectedItem == "km") {
            divide5()
        } else if (spinner.selectedItem == "cm" && spinner2.selectedItem == "hm") {
            divide4()
        } else if (spinner.selectedItem == "cm" && spinner2.selectedItem == "dam") {
            divide3()
        } else if (spinner.selectedItem == "cm" && spinner2.selectedItem == "m") {
            divide2()
        } else if (spinner.selectedItem == "cm" && spinner2.selectedItem == "dm") {
            divide1()
        } else if (spinner.selectedItem == "cm" && spinner2.selectedItem == "cm") {
            multiply1()
        } else if (spinner.selectedItem == "cm" && spinner2.selectedItem == "mm") {
            multiply2()
        } else if (spinner.selectedItem == "mm" && spinner2.selectedItem == "km") {
            divide6()
        } else if (spinner.selectedItem == "mm" && spinner2.selectedItem == "hm") {
            divide5()
        } else if (spinner.selectedItem == "mm" && spinner2.selectedItem == "dam") {
            divide4()
        } else if (spinner.selectedItem == "mm" && spinner2.selectedItem == "m") {
            divide3()
        } else if (spinner.selectedItem == "mm" && spinner2.selectedItem == "dm") {
            divide2()
        } else if (spinner.selectedItem == "mm" && spinner2.selectedItem == "cm") {
            divide1()
        } else if (spinner.selectedItem == "mm" && spinner2.selectedItem == "mm") {
            multiply1()
        }
    }

    private fun multiply1() {
        val unit = binding.etUnit.text.toString()
        val result = unit.toDouble() * 1
        binding.etUnitConvert.setText(result.toBigDecimal().toPlainString())
    }

    private fun multiply2() {
        val unit = binding.etUnit.text.toString()
        val result = unit.toDouble() * 10
        binding.etUnitConvert.setText(result.toBigDecimal().toPlainString())
    }

    private fun multiply3() {
        val unit = binding.etUnit.text.toString()
        val result = unit.toDouble() * 100
        binding.etUnitConvert.setText(result.toBigDecimal().toPlainString())
    }

    private fun multiply4() {
        val unit = binding.etUnit.text.toString()
        val result = unit.toDouble() * 1000
        binding.etUnitConvert.setText(result.toBigDecimal().toPlainString())
    }

    private fun multiply5() {
        val unit = binding.etUnit.text.toString()
        val result = unit.toDouble() * 10000
        binding.etUnitConvert.setText(result.toBigDecimal().toPlainString())
    }

    private fun multiply6() {
        val unit = binding.etUnit.text.toString()
        val result = unit.toDouble() * 100000
        binding.etUnitConvert.setText(result.toBigDecimal().toPlainString())
    }

    private fun multiply7() {
        val unit = binding.etUnit.text.toString()
        val result = unit.toDouble() * 1000000
        binding.etUnitConvert.setText(result.toBigDecimal().toPlainString())
    }

    private fun divide1() {
        val unit = binding.etUnit.text.toString()
        val result = unit.toDouble() / 10
        binding.etUnitConvert.setText(result.toBigDecimal().toPlainString())
    }

    private fun divide2() {
        val unit = binding.etUnit.text.toString()
        val result = unit.toDouble() / 100
        binding.etUnitConvert.setText(result.toBigDecimal().toPlainString())
    }

    private fun divide3() {
        val unit = binding.etUnit.text.toString()
        val result = unit.toDouble() / 1000
        binding.etUnitConvert.setText(result.toBigDecimal().toPlainString())
    }

    private fun divide4() {
        val unit = binding.etUnit.text.toString()
        val result = unit.toDouble() / 10000
        binding.etUnitConvert.setText(result.toBigDecimal().toPlainString())
    }

    private fun divide5() {
        val unit = binding.etUnit.text.toString()
        val result = unit.toDouble() / 100000
        binding.etUnitConvert.setText(result.toBigDecimal().toPlainString())
    }

    private fun divide6() {
        val unit = binding.etUnit.text.toString()
        val result = unit.toDouble() / 1000000
        binding.etUnitConvert.setText(result.toBigDecimal().toPlainString())
    }

}