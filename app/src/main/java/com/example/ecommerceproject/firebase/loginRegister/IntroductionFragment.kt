package com.example.ecommerceproject.firebase.loginRegister

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.ecommerceproject.R
import com.example.ecommerceproject.activities.ShoppingActivity
import com.example.ecommerceproject.databinding.FragmentIntroductionBinding
import com.example.ecommerceproject.viewModel.IntroductionVIewModel
import com.example.ecommerceproject.viewModel.IntroductionVIewModel.Companion.ACCOUNT_OPTION_FRAGMENT
import com.example.ecommerceproject.viewModel.IntroductionVIewModel.Companion.SHOPPING_ACTIVITY
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IntroductionFragment:Fragment(R.layout.fragment_introduction) {
    private lateinit var binding:FragmentIntroductionBinding
    private val viewModel by viewModels<IntroductionVIewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIntroductionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {
            viewModel.navigate.collect{
                when(it){
                    SHOPPING_ACTIVITY ->{
                        Intent(requireActivity(),ShoppingActivity::class.java).also {intent ->
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                            startActivity(intent)
                        }
                    }
                    ACCOUNT_OPTION_FRAGMENT ->{
                        findNavController().navigate(it)
                    }
                    else -> Unit

                }
            }
        }

        binding.apply {
            buttonStart.setOnClickListener {
                viewModel.startButtonClick()
                findNavController().navigate(R.id.action_introductionFragment_to_accountOptionsFragment)

            }
        }
    }
}