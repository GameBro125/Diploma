package com.example.diplom.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.diplom.MainActivity
import com.example.diplom.R
import com.example.diplom.databinding.FragmentLoginScreentBinding

class LoginScreenFragment : Fragment() {

    lateinit var navController: NavController

    private var _binding: FragmentLoginScreentBinding? = null
    private val binding get() = _binding!!

    private var login = ""
    private var password = ""



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginScreentBinding.inflate(inflater, container, false)
        navController = findNavController()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAuth.setOnClickListener {
            navController.navigate(R.id.action_loginScreenFragment_to_profileFragment)
        }

        binding.loginInput.doOnTextChanged { text, _, _, _ ->
            login = text?.toString() ?: ""
            binding.buttonAuth.isEnabled = login.isNotBlank() && password.isNotBlank()
        }

        binding.passwordInput.doOnTextChanged { text, _, _, _ ->
            password = text?.toString() ?: ""
            binding.buttonAuth.isEnabled = login.isNotBlank() && password.isNotBlank()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}