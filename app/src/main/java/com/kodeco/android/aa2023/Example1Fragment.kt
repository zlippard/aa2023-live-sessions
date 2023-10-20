package com.kodeco.android.aa2023

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.kodeco.android.aa2023.databinding.Example1FragmentBinding
import com.kodeco.android.aa2023.interop.Book
import com.kodeco.android.aa2023.interop.Person

class Example1Fragment : Fragment() {

    private var _binding: Example1FragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: Example1ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Example1FragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.counterLiveData.observe(viewLifecycleOwner) { newValue ->
            binding.counterText.text = "Counter = $newValue"
        }

        binding.button.setOnClickListener {
            findNavController()
                .navigate(Example1FragmentDirections.actionExample1FragmentToExample2Fragment(
                    Book(
                       title = "The Lord of the Rings: The Fellowship of the Ring",
                        author = "J.R.R. Tolkien",
                        pageCount = 432,
                    )
                ))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
