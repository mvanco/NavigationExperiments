package eu.matoosh.navigation.disambiguation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import eu.matoosh.navigation.R
import eu.matoosh.navigation.databinding.FragmentDisambiguationBinding
import javax.inject.Inject

@AndroidEntryPoint
class DisambiguationFragment @Inject constructor() : Fragment() {

    private val viewModel: DisambiguationViewModel by viewModels()
    private lateinit var binding: FragmentDisambiguationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_disambiguation, container, false)
        binding.registrationButton.setOnClickListener {
            val action = DisambiguationFragmentDirections.actionDisambiguationToRegistration1()
            findNavController().navigate(action)
        }
        binding.loginButton.setOnClickListener {
            val directions = DisambiguationFragmentDirections.actionDisambiguationToLogin()
            findNavController().navigate(directions)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
    }
}