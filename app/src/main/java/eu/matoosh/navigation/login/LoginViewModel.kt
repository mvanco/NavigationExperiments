package eu.matoosh.navigation.login

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

enum class LoginErrorCode() {
    UNKNOWN_ERROR
}

@Stable
sealed interface LoginUiState {
    object Idle : LoginUiState
}

@HiltViewModel
class LoginViewModel @Inject constructor(

) : ViewModel() {
    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
    val uiState = _uiState.asStateFlow()

    val nick = MutableStateFlow<String>("")
    val password = MutableStateFlow<String>("")

    fun prefill(nickParam: String, passwordParam: String) {
        nick.value = nickParam
        password.value = passwordParam
    }

}