package eu.matoosh.navigation.registration

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
    data object Idle : Registration1UiState
}

@HiltViewModel
class Registration1ViewModel @Inject constructor(

) : ViewModel() {
    private val _uiState = MutableStateFlow<Registration1UiState>(Registration1UiState.Idle)
    val uiState = _uiState.asStateFlow()

    val name = MutableStateFlow<String>("")
    val surname = MutableStateFlow<String>("")
}