package com.example.pengenalan

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edtWidth: EditText
    private lateinit var edtHeight:EditText
    private lateinit var edtLength:EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edt_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)
    }

    override fun onClick(p0: View?){
        if (p0?.id == R.id.btn_calculate) {
            val inputLength = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            var isEmptyFields = false
            val isInvalidDouble = false
            if (TextUtils.isEmpty(inputLength)) {
                isEmptyFields = true
                edtLength.setError("Field ini tidak boleh kosong")
            }
            if (TextUtils.isEmpty(inputWidth)) {
                isEmptyFields = true
                edtWidth.setError("Field ini tidak boleh kosong")
            }
            if (TextUtils.isEmpty(inputHeight)) {
                isEmptyFields = true
                edtHeight.setError("Field ini tidak boleh kosong")
            }
            if (!isEmptyFields && !isInvalidDouble) {
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                tvResult.text == volume.toString()
            }
        }
    }
}