package com.alkhademy.calculatorunitconverter

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alkhademy.calculatorunitconverter.databinding.FragmentAreaBinding

class AreaFragment : Fragment() {

    private var _binding: FragmentAreaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAreaBinding.inflate(inflater, container, false)
        binding.calculateArea.setOnClickListener { calculate() }

        return binding.root
    }

    private fun calculate() {
        val length = binding.etLength.text.toString()
        val width = binding.etWidth.text.toString()

        when {
            length.isEmpty() && width.isEmpty() -> {
                binding.length.error = "Tidak Boleh Kosong !"
                binding.width.error = "Tidak Boleh Kosong !"
            }
            length.isEmpty() -> {
                binding.length.error = "Tidak Boleh Kosong !"
            }
            width.isEmpty() -> {
                binding.width.error = "Tidak Boleh Kosong !"
            }
            else -> {
                val area = length.toFloat() * width.toFloat()
                binding.resultArea.text =
                    String.format(resources.getString(R.string.square, area.toString()))
            }
        }

        binding.etLength.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.length.error = null
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

        binding.etWidth.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.width.error = null
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
    }

}