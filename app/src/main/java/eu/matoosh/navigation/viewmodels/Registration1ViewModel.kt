package eu.matoosh.navigation.viewmodels

import android.view.View
import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

enum class Registration1ErrorCode() {
    UNKNOWN_ERROR
}

@Stable
sealed interface Registration1UiState {
    object Idle : Registration1UiState
}

@HiltViewModel
class Registration1ViewModel @Inject constructor(

) : ViewModel() {
    private val _uiState = MutableStateFlow<Registration1UiState>(Registration1UiState.Idle)
    val uiState = _uiState.asStateFlow()

    private val _name = MutableStateFlow<String>("")
    val name = MutableStateFlow<String>("")

    private val _surname = MutableStateFlow<String>("")
    val surname = MutableStateFlow<String>("")

    fun onDone(v: View) {

    }
}