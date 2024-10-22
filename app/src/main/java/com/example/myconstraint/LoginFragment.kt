package com.example.myconstraint

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myconstraint.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    // Using lazy to initialize the binding
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the binding layout
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Get the data from arguments
        val username = arguments?.getString("username")
        val email = arguments?.getString("email")
        val fullname = arguments?.getString("fullname")
        val password = arguments?.getString("password")

        // Logic
        with(binding) {
            btnLogin.setOnClickListener {
                if (binding.username.text.toString().isEmpty() || binding.password.text.toString().isEmpty()){
                    binding.username.error = "Username Tidak Boleh Kosong"
                    binding.password.error = "Password Tidak Boleh Kosong"
                    return@setOnClickListener
                }
                else if(binding.password.text.toString() != password || binding.username.text.toString() != username){
                    binding.username.error = "Password atau Username Salah"
                    binding.password.error = "Password atau Username Salah"
                    return@setOnClickListener
                }
                else{
                    val intentToSecondActivity = Intent(activity,DashboardActivity::class.java)
                    intentToSecondActivity.putExtra("username",username)
                    intentToSecondActivity.putExtra("email",email)
                    intentToSecondActivity.putExtra("password",password)
                    intentToSecondActivity.putExtra("fullname",fullname)
                    startActivity(intentToSecondActivity)
                }
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        // Clear the binding when the view is destroyed to prevent memory leaks
        _binding = null
    }
}
