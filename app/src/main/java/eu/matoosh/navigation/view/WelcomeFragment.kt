package eu.matoosh.navigation.view

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
import eu.matoosh.navigation.databinding.FragmentWelcomeBinding
import eu.matoosh.navigation.viewmodels.DisambiguationViewModel
import eu.matoosh.navigation.viewmodels.WelcomeViewModel
import javax.inject.Inject

@AndroidEntryPoint
class WelcomeFragment @Inject constructor() : Fragment() {

    private val viewModel: WelcomeViewModel by viewModels()
    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        viewModel.initialize(arguments?.getString(SESSION_KEY) ?: "")
    }

    companion object {
        const val TAG = "WelcomeFragment"
        private const val SESSION_KEY = "session"
    }
}