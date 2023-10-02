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
import eu.matoosh.navigation.databinding.FragmentLoginBinding
import eu.matoosh.navigation.viewmodels.DisambiguationViewModel
import eu.matoosh.navigation.viewmodels.LoginViewModel
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment @Inject constructor() : Fragment() {

    private val viewModel: LoginViewModel by viewModels()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.loginDoneButton.setOnClickListener {
            if (viewModel.nick.value == "maty" && viewModel.password.value == "heslo") {
                val action = LoginFragmentDirections.actionLoginToWelcome("${viewModel.nick.value}:${viewModel.password.value}")
                findNavController().navigate(action)
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        viewModel.prefill(arguments?.getString(LoginFragment.NICK_KEY) ?: "", arguments?.getString(
            LoginFragment.PASSWORD_KEY
        ) ?: "")
    }

    companion object {
        const val TAG = "LoginFragment"
        private const val NICK_KEY = "nick"
        private const val PASSWORD_KEY = "password"
    }
}