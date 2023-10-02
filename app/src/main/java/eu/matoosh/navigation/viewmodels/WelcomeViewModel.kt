package eu.matoosh.navigation.viewmodels

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

enum class WelcomeErrorCode() {
    UNKNOWN_ERROR
}

@Stable
sealed interface WelcomeUiState {
    object Idle : WelcomeUiState
}

@HiltViewModel
class WelcomeViewModel @Inject constructor(

) : ViewModel() {
    private val _uiState = MutableStateFlow<WelcomeUiState>(WelcomeUiState.Idle)
    val uiState = _uiState.asStateFlow()

    private val _session = MutableStateFlow<String>("")
    val session = _session.asStateFlow()

    fun initialize(session: String) {
        _session.value = "session: \"$session\""
    }
}