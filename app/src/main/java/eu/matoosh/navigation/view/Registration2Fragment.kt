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
import eu.matoosh.navigation.databinding.FragmentRegistration2Binding
import eu.matoosh.navigation.viewmodels.Registration1ViewModel
import eu.matoosh.navigation.viewmodels.Registration2ViewModel
import javax.inject.Inject

@AndroidEntryPoint
class Registration2Fragment @Inject constructor() : Fragment() {

    private val viewModel: Registration2ViewModel by viewModels()
    private lateinit var binding: FragmentRegistration2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_registration_2, container, false)
        binding.registration2DoneButton.setOnClickListener {
            val directions = Registration2FragmentDirections.actionRegistration2ToLogin()
            findNavController().navigate(directions)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        viewModel.initialize(arguments?.getString(NAME_KEY) ?: "", arguments?.getString(SURNAME_KEY) ?: "")
    }

    companion object {
        const val TAG = "DisambiguationFragment"
        private const val NAME_KEY = "name"
        private const val SURNAME_KEY = "surname"
    }
}