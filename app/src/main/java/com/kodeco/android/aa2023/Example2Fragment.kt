package com.kodeco.android.aa2023

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.kodeco.android.aa2023.databinding.Example2FragmentBinding
import com.kodeco.android.aa2023.interop.Person

class Example2Fragment : Fragment() {

    private var _binding: Example2FragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val args by navArgs<Example2FragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Example2FragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.bookTitle.text = args.book.title
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
