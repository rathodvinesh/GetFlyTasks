package com.learnvinesh.getflytasks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.learnvinesh.getflytasks.adapter.PastEventsRecyclerViewAdapter
import com.learnvinesh.getflytasks.databinding.FragmentPastEventsBinding
import com.learnvinesh.getflytasks.models.PastEvents

class PastEventsFragment : Fragment() {

    private var _binding: FragmentPastEventsBinding? = null
    private val binding get() = _binding!!
    private lateinit var seminarAdapter: PastEventsRecyclerViewAdapter
    private val seminarList = listOf(
        PastEvents("Seminar on AI", "Description of AI Seminar", "24 Feb"),
        PastEvents("Seminar on ML", "Description of ML Seminar", "24 Feb"),
        PastEvents("Seminar on ML", "Description of ML Seminar", "24 Feb"),
        PastEvents("Seminar on ML", "Description of ML Seminar", "24 Feb"),
        PastEvents("Seminar on ML", "Description of ML Seminar", "24 Feb"),
        PastEvents("Seminar on ML", "Description of ML Seminar", "24 Feb"),
        PastEvents("Seminar on ML", "Description of ML Seminar", "24 Feb"),
        PastEvents("Seminar on ML", "Description of ML Seminar", "24 Feb"),
        PastEvents("Seminar on ML", "Description of ML Seminar", "24 Feb"),
        PastEvents("Seminar on ML", "Description of ML Seminar", "24 Feb"),
        PastEvents("Seminar on ML", "Description of ML Seminar", "24 Feb"),
        // Add more seminars here
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPastEventsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.pastEventsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        seminarAdapter = PastEventsRecyclerViewAdapter(seminarList)
        binding.pastEventsRecyclerView.adapter = seminarAdapter

        (requireActivity() as MainActivity).setToolbarTitle("Past Events")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}