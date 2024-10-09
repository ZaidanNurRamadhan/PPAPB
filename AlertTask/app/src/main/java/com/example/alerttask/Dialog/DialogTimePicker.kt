package com.example.alerttask.Dialog

import android.app.Dialog
import android.app.TimePickerDialog
import android.app.TimePickerDialog.OnTimeSetListener
import android.icu.util.Calendar
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.text.format.DateFormat

class DialogTimePicker : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR)
        val minute = calendar.get(Calendar.MINUTE)
        return TimePickerDialog(
            requireActivity(), activity as OnTimeSetListener, hour, minute, DateFormat.is24HourFormat(activity)
        )
    }
}