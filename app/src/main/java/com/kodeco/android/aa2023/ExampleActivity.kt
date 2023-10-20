package com.kodeco.android.aa2023

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.kodeco.android.aa2023.databinding.ExampleActivityBinding

class ExampleActivity : FragmentActivity() {

    private lateinit var binding: ExampleActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ExampleActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
