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
        PastEvents("Seminar on AI", "10:00 am • Haware Building, Vashi", "24\nFeb", R.drawable.event1),
        PastEvents("Webinar on Data Science", "2:00 pm • Online via Zoom", "15\nMar", R.drawable.event2),
        PastEvents("Workshop on Machine Learning", "9:30 am • Tech Lab 3, Andheri", "10\nApr", R.drawable.event3),
        PastEvents("Guest Lecture on Cybersecurity", "11:00 am • Auditorium, IIT Bombay", "5\nMay", R.drawable.event4),
        PastEvents("Panel Discussion on Cloud Computing", "3:00 pm • Hall B, Nehru Centre, Worli", "20\nJun", R.drawable.event5)

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