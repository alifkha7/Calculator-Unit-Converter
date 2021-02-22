package com.alkhademy.task3

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alkhademy.calculatorunitconverter.R
import com.alkhademy.calculatorunitconverter.databinding.FragmentVolumeBinding

class VolumeFragment : Fragment() {

    private var _binding: FragmentVolumeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentVolumeBinding.inflate(inflater, container, false)
        binding.calculateVolume.setOnClickListener { calculate() }

        return binding.root
    }

    private fun calculate() {
        val length = binding.etLength.text.toString()
        val width = binding.etWidth.text.toString()
        val height = binding.etHeight.text.toString()

        when {
            length.isEmpty() && width.isEmpty() && height.isEmpty() -> {
                binding.length.error = "Tidak Boleh Kosong !"
                binding.width.error = "Tidak Boleh Kosong !"
                binding.height.error = "Tidak Boleh Kosong !"
            }
            length.isEmpty() -> {
                binding.length.error = "Tidak Boleh Kosong !"
            }
            width.isEmpty() -> {
                binding.width.error = "Tidak Boleh Kosong !"
            }
            height.isEmpty() -> {
                binding.height.error = "Tidak Boleh Kosong !"
            }
            else -> {
                val volume = length.toFloat() * width.toFloat() * height.toFloat()
                binding.resultVolume.text =
                    String.format(resources.getString(R.string.cubic, volume.toString()))
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

        binding.etHeight.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.height.error = null
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })

    }

}