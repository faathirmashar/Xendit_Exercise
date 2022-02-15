package id.sharekom.xenditexercise.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.sharekom.xenditexercise.R
import id.sharekom.xenditexercise.databinding.FragmentAccountBinding

class AccountFragment : Fragment() {
    private var _binding: FragmentAccountBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAccountBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding?.tvUserId?.text = getString(R.string.user_id, 123456)
        binding?.tvUserEmail?.text = getString(R.string.user_email, "name@gmail.com")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}