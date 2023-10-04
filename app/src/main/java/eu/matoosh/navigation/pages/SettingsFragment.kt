package eu.matoosh.navigation.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import eu.matoosh.navigation.R
import eu.matoosh.navigation.databinding.FragmentsPageBinding
import javax.inject.Inject

@AndroidEntryPoint
class SettingsFragment @Inject constructor() : Fragment() {

    private val viewModel: PagesViewModel by viewModels()
    private lateinit var binding: FragmentsPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragments_page, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        viewModel.initialize("Settings")
    }
}