package eu.matoosh.navigation.home

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class WelcomeErrorCode() {
    UNKNOWN_ERROR
}

@Stable
sealed interface WelcomeUiState {
    data object Loading : WelcomeUiState
    data object Idle : WelcomeUiState
}

@HiltViewModel
class WelcomeViewModel @Inject constructor(

) : ViewModel() {
    private val _session = MutableStateFlow<String>("")
    val session = _session.asStateFlow()

    private val _uiState = MutableStateFlow<WelcomeUiState>(WelcomeUiState.Loading)
    val uiState = _uiState.asStateFlow()

    suspend fun initialize(session: String) {
        viewModelScope.launch {
            _session.collect {
                if (it.isNotEmpty()) {
                    _uiState.value = WelcomeUiState.Idle
                }
            }
        }
        delay(3000)
        _session.value = "session: \"$session\""
    }
}