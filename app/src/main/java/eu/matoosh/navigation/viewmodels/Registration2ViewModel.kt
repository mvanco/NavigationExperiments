package eu.matoosh.navigation.viewmodels

import android.view.View
import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

enum class Registration2ErrorCode() {
    UNKNOWN_ERROR
}

@Stable
sealed interface Registration2UiState {
    data class Idle(val name: String, val surname: String) : Registration2UiState
}

@HiltViewModel
class Registration2ViewModel @Inject constructor(

) : ViewModel() {
    private val _uiState = MutableStateFlow<Registration2UiState>(Registration2UiState.Idle("", ""))
    val uiState = _uiState.asStateFlow()

    private val _name = MutableStateFlow<String>("")
    val name = _name.asStateFlow()

    private val _surname = MutableStateFlow<String>("")
    val surname = _surname.asStateFlow()

    val nick = MutableStateFlow<String>("")
    val password = MutableStateFlow<String>("")

    fun initialize(name: String, surname: String) {
        _uiState.value = Registration2UiState.Idle(name, surname)
        _name.value = name
        _surname.value = surname
    }

    fun onDone(v: View) {

    }
}