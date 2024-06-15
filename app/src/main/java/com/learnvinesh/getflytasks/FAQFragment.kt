package com.learnvinesh.getflytasks

import android.app.Dialog
import android.health.connect.datatypes.units.Length
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.learnvinesh.getflytasks.adapter.FAQRecyclerViewAdapter
import com.learnvinesh.getflytasks.databinding.DailogBoxBinding
import com.learnvinesh.getflytasks.databinding.FragmentFAQBinding
import com.learnvinesh.getflytasks.models.FAQQuestions

class FAQFragment : Fragment() {

    private var _binding: FragmentFAQBinding? = null
    private val binding get() = _binding!!
    private lateinit var faqAdapter: FAQRecyclerViewAdapter
    private val faqList = listOf(
        FAQQuestions("What is the purpose of this app?", "This app helps users plan and manage their study abroad journey."),
        FAQQuestions("How do I search for universities?", "You can use the search feature to find universities by name, location, or programs offered."),
        FAQQuestions("What resources are available for scholarship information?", "The app provides a dedicated section with information on various scholarships available for international students."),
        FAQQuestions("How do I connect with other users?", "You can connect with other users through the community forum and messaging features within the app."),
        FAQQuestions("What support is available if I encounter issues?", "Our support team is available 24/7 through the 'Contact Us' section in the app for any assistance you may need.")
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

        binding.fab.setColorFilter(ContextCompat.getColor(requireContext(), android.R.color.white))

        (requireActivity() as MainActivity).setToolbarTitle("FAQ")

        binding.fab.setOnClickListener {
            showPostQuestionDialog()
        }

        binding.searchBarFAQ.setOnClickListener {
            Toast.makeText(requireContext(), "SearchBar clicked", Toast.LENGTH_SHORT).show()
        }
    }
    private fun showPostQuestionDialog() {
        val dialog = Dialog(requireContext(), R.style.CustomDialogTheme)
        val dialogBinding = DailogBoxBinding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)

        dialogBinding.button.setOnClickListener {
            val question = dialogBinding.editTextTextMultiLine.text.toString().trim()
            if (question.isNotEmpty()) {
                Toast.makeText(requireContext(), "Question Posted: $question", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            } else {
                Toast.makeText(requireContext(), "Please enter a question", Toast.LENGTH_SHORT).show()
            }
        }

        dialogBinding.imageView3.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}