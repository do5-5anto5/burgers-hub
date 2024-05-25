package com.example.burgershub.presenter.burgers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.burgershub.databinding.FragmentBurgersBinding
import com.example.burgershub.domain.model.Burger
import com.example.burgershub.util.StateView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BurgersFragment : Fragment() {

    private var _binding: FragmentBurgersBinding? = null
    private val binding get() = _binding!!

    private val viewModel: BurgerViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBurgersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getBurgers()
    }

    private fun getBurgers() {
        viewModel.getBurgers().observe(viewLifecycleOwner) { stateView ->
            when (stateView) {
                is StateView.Loading -> {
                }
                is StateView.Success -> {
                    binding.progressBar.visibility = View.GONE

                    val burgers = stateView.data ?: emptyList()
                    initRecyclerView(burgers)
                }
                is StateView.Error -> {
                    binding.progressBar.visibility = View.GONE

                    Toast.makeText(requireContext(), stateView.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun initRecyclerView(burgers: List<Burger>) {
        with(binding.rvBurgers) {
            setHasFixedSize(true)
            adapter = BurgersAdapter(burgers) { burgerId ->

            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}