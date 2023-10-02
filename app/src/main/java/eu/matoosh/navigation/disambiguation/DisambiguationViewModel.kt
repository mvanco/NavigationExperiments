package eu.matoosh.navigation.disambiguation

import android.view.View
import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
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