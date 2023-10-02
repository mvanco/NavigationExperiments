package eu.matoosh.navigation.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import eu.matoosh.navigation.R
import eu.matoosh.navigation.databinding.FragmentRegistration2Binding
import javax.inject.Inject

@AndroidEntryPoint
class Registration2Fragment @Inject constructor() : Fragment() {

    private val viewModel: Registration2ViewModel by viewModels()
    private val args: Registration2FragmentArgs by navArgs()
    private lateinit var binding: FragmentRegistration2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_registration_2, container, false)
        binding.registration2DoneButton.setOnClickListener {
            val directions = Registration2FragmentDirections.actionRegistration2ToLogin(
                viewModel.nick.value,
                viewModel.password.value
            )
            findNavController().navigate(directions)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        viewModel.initialize(args.name, args.surname)
    }
}