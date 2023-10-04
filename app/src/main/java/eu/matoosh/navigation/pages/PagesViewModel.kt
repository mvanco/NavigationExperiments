package eu.matoosh.navigation.pages

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

enum class PagesErrorCode() {
    UNKNOWN_ERROR
}

@Stable
sealed interface PagesUiState {
    data object Idle : PagesUiState
}

@HiltViewModel
class PagesViewModel @Inject constructor(

) : ViewModel() {
    private val _uiState = MutableStateFlow<PagesUiState>(PagesUiState.Idle)
    val uiState = _uiState.asStateFlow()

    private val _title = MutableStateFlow<String>("N/A")
    val title = _title.asStateFlow()

    fun initialize(message: String) {
        _title.value = message
    }
}