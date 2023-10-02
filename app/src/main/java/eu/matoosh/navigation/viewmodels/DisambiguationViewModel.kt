package eu.matoosh.navigation.viewmodels

import android.view.View
import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import dagger.hilt.android.lifecycle.HiltViewModel
import eu.matoosh.navigation.view.DisambiguationFragmentDirections
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

enum class DisambiguationErrorCode() {
    UNKNOWN_ERROR
}

@Stable
sealed interface DisambiguationUiState {
    object Idle : DisambiguationUiState
}

@HiltViewModel
class DisambiguationViewModel @Inject constructor(

) : ViewModel() {
    private val _uiState = MutableStateFlow<DisambiguationUiState>(DisambiguationUiState.Idle)
    val uiState = _uiState.asStateFlow()


    fun onLoginClick(v: View) {
    }

    fun onRegistrationClick(v: View) {

    }
}