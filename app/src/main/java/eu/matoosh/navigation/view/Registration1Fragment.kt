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
import eu.matoosh.navigation.databinding.FragmentRegistration1Binding
import eu.matoosh.navigation.databinding.FragmentRegistration2Binding
import eu.matoosh.navigation.viewmodels.Registration1ViewModel
import javax.inject.Inject

@AndroidEntryPoint
class Registration1Fragment @Inject constructor() : Fragment() {

    private val viewModel: Registration1ViewModel by viewModels()
    private lateinit var binding: FragmentRegistration1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_registration_1, container, false)
        binding.registration1DoneButton.setOnClickListener {
            val directions = Registration1FragmentDirections.actionRegistration1ToRegistration2(
                viewModel.name.value,
                viewModel.surname.value
            )
            findNavController().navigate(directions)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
    }

    companion object {
        const val TAG = "DisambiguationFragment"
        private const val KEY_ID = "id"

        fun forId(id: String) = DisambiguationFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_ID, id)
            }
        }
    }
}