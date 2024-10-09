package com.example.alerttask

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alerttask.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private val binding by lazy { ActivityThirdBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        binding.taskTitle.text = intent.getStringExtra("title")
        binding.taskDate.text = intent.getStringExtra("date")
        binding.taskTime.text = intent.getStringExtra("time")
        binding.taskRepeat.text = intent.getStringExtra("repeat")

        binding.btnToSecondAct.setOnClickListener {
            val intentToSecondActivity = Intent(this, SecondActivity::class.java)
            startActivity(intentToSecondActivity)
        }
    }
}