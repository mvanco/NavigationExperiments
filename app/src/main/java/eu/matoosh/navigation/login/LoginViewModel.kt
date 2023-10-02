package eu.matoosh.navigation.login

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

enum class LoginErrorCode() {
    UNKNOWN_ERROR
}

@Stable
sealed interface LoginUiState {
    data object Disabled : LoginUiState
    data object Enabled : LoginUiState
}

@HiltViewModel
class LoginViewModel @Inject constructor(

) : ViewModel() {
    val nick = MutableStateFlow<String>("")
    val password = MutableStateFlow<String>("")

    val uiState = combine(nick, password) { (nick, password) ->
        if (nick.isNotEmpty() && password.isNotEmpty()) {
            LoginUiState.Enabled
        }
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(),
        LoginUiState.Disabled
    )

    fun prefill(nickParam: String, passwordParam: String) {
        nick.value = nickParam
        password.value = passwordParam
    }

}