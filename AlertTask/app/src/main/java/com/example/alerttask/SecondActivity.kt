package com.example.alerttask

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.alerttask.databinding.ActivitySecondBinding
import com.example.alerttask.Dialog.DialogDatePicker
import com.example.alerttask.Dialog.DialogTimePicker
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog.OnTimeSetListener
import android.content.Intent
import androidx.appcompat.app.AlertDialog

class SecondActivity : AppCompatActivity(),OnDateSetListener, OnTimeSetListener {
    private val binding by lazy { ActivitySecondBinding.inflate(layoutInflater) }
    var title: String? = null
    var spinnerr: String? = null
    var date: String? = null
    var time: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val stringRepeat = resources.getStringArray(R.array.spinner_repeat)
        val adapterSpinnerRepeat = ArrayAdapter(this, android.R.layout.simple_spinner_item, stringRepeat)
        binding.spinnerRepeat.adapter = adapterSpinnerRepeat
        binding.spinnerRepeat.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                spinnerr = stringRepeat.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    fun showDate(view: View) {
        val datePicker = DialogDatePicker()
        datePicker.show(supportFragmentManager, "datePicker")
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val selectedDate = String.format("%02d, %02d, %04d", dayOfMonth, month, year)
        binding.spinnerDate.text = selectedDate
        date = binding.spinnerDate.text.toString()
    }

    fun showTime(view: View) {
        val timePicker = DialogTimePicker()
        timePicker.show(supportFragmentManager, "timePicker")
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
        binding.spinnerTime.text = selectedTime
        time = binding.spinnerTime.text.toString()
    }

    fun showAlert(view: View) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("SimplyRemind")
        builder.setMessage("Do you want to add this as a new task?")
        builder.setPositiveButton("Yes"){
                dialog, _ ->
            val intentToThirdActivity = Intent(this@SecondActivity, ThirdActivity::class.java)
            title = binding.insertTitle.text.toString()
            intentToThirdActivity.putExtra("title", title)
            intentToThirdActivity.putExtra("repeat", spinnerr)
            intentToThirdActivity.putExtra("date", date)
            intentToThirdActivity.putExtra("time", time)
            startActivity(intentToThirdActivity)
            dialog.dismiss()
        }
        builder.setNegativeButton("No"){ dialog, _ -> dialog.dismiss() }
        val dialog = builder.create()
        dialog.show()
    }
}