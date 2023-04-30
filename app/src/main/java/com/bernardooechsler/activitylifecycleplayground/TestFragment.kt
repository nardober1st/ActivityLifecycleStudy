package com.bernardooechsler.activitylifecycleplayground

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bernardooechsler.activitylifecycleplayground.databinding.FragmentTestBinding

class TestFragment : Fragment() {

    private lateinit var binding: FragmentTestBinding
    private var fragmentListener: TestFragmentListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentListener = context as TestFragmentListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textViewFragmentText.text = "We have made it into our new Fragment. This is the onViewCreated() code"
        binding.buttonClearScreen.setOnClickListener {
            fragmentListener?.clearActivityScreen()
        }
    }

    override fun onDetach() {
        super.onDetach()
        fragmentListener = null
    }

    interface TestFragmentListener {

        fun clearActivityScreen()
    }
}