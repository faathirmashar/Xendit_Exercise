package id.sharekom.xenditexercise.views.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import id.sharekom.xenditexercise.databinding.FragmentHomeBinding
import id.sharekom.xenditexercise.viewmodels.ViewModelFactory

class HomeFragment : Fragment(), HomeAdapter.OnItemClickListener {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        homeViewModel = ViewModelProvider(this, factory)[HomeViewModel::class.java]

        homeAdapter = HomeAdapter()

        binding.pbHome.visibility = View.VISIBLE
        homeViewModel.getListData().observe(viewLifecycleOwner) { listData ->
            binding.pbHome.visibility = View.INVISIBLE
            homeAdapter.setData(listData)
            homeAdapter.notifyDataSetChanged()
        }

        binding.rvHome.layoutManager = LinearLayoutManager(requireContext())
        binding.rvHome.setHasFixedSize(true)
        binding.rvHome.adapter = homeAdapter

        homeAdapter.setOnItemClickListener(this)

        binding.rvHome.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClicked(data: String) {
        Toast.makeText(requireContext(), data, Toast.LENGTH_SHORT).show()
    }
}