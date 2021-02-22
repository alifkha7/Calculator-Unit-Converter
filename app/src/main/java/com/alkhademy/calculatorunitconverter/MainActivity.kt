package com.alkhademy.calculatorunitconverter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.alkhademy.calculatorunitconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnLogin.setOnClickListener { login() }
    }

    private fun login() {
        val username = resources.getString(R.string.user)
        val password = resources.getString(R.string.pass)
        val etUsername = binding.etUsername.text.toString()
        val etPassword = binding.etPassword.text.toString()

        if (etUsername == username && etPassword == password) {
            binding.username.error = null
            binding.password.error = null
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        if (etUsername.isEmpty() && etPassword.isEmpty()) {
            binding.username.error = resources.getString(R.string.username_null)
            binding.password.error = resources.getString(R.string.password_null)
        } else if (etUsername.isEmpty()) {
            binding.username.error = resources.getString(R.string.username_null)
        } else if (etPassword.isEmpty()) {
            binding.password.error = resources.getString(R.string.password_null)
        } else if (etPassword.length < 6) {
            binding.password.error = resources.getString(R.string.password_less)
        }

        when {
            etUsername.isNotEmpty() && etUsername != username -> {
                Toast.makeText(this, resources.getString(R.string.username_wrong), Toast.LENGTH_LONG).show()
            }
            etPassword.length > 6 && etPassword != password -> {
                Toast.makeText(this, resources.getString(R.string.password_wrong), Toast.LENGTH_LONG).show()
            }
        }

        binding.etUsername.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.username.error = null
            }

        })

        binding.etPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                binding.password.error = null
            }

        })
    }
}