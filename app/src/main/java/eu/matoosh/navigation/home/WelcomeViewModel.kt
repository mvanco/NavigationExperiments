package eu.matoosh.navigation.home

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
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

    val uiState = combine(_session) { (session) ->
        WelcomeUiState.Idle
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = WelcomeUiState.Loading
    )

    fun initialize(session: String) {
        _session.value = "session: \"$session\""
    }
}