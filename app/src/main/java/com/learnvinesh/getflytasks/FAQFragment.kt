package com.learnvinesh.getflytasks

import android.health.connect.datatypes.units.Length
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.learnvinesh.getflytasks.adapter.FAQRecyclerViewAdapter
import com.learnvinesh.getflytasks.databinding.FragmentFAQBinding
import com.learnvinesh.getflytasks.models.FAQQuestions

class FAQFragment : Fragment() {

    private var _binding: FragmentFAQBinding? = null
    private val binding get() = _binding!!
    private lateinit var faqAdapter: FAQRecyclerViewAdapter
    private val faqList = listOf(
        FAQQuestions("What is this app?", "This app provides information about higher studies."),
        FAQQuestions("How can I raise a new question khhvjyhgjyhghijuhygiyjbjuo?", "Click the 'Raise a New Question' button."),
        FAQQuestions("How can I raise a new question?", "Click the 'Raise a New Question' button."),
        FAQQuestions("How can I raise a new question?", "Click the 'Raise a New Question' button."),
        FAQQuestions("How can I raise a new question?", "Click the 'Raise a New Question' button."),
        FAQQuestions("How can I raise a new question?", "Click the 'Raise a New Question' button."),
        FAQQuestions("How can I raise a new question?", "Click the 'Raise a New Question' button."),
        FAQQuestions("How can I raise a new question?", "Click the 'Raise a New Question' button."),
        FAQQuestions("How can I raise a new question?", "Click the 'Raise a New Question' button."),
        FAQQuestions("How can I raise a new question?", "Click the 'Raise a New Question' button.")
        // Add more FAQs here
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFAQBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        faqAdapter = FAQRecyclerViewAdapter(faqList)
        binding.faqRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.faqRecyclerView.adapter = faqAdapter

        binding.fab.setOnClickListener {
            // Handle the new question logic here
            Toast.makeText(requireContext(),"Still Working on It!!",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}