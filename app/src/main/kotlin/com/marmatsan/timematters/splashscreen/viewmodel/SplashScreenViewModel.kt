package com.marmatsan.timematters.splashscreen.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marmatsan.core_domain.preferences.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.milliseconds

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
    private val preferences: Preferences
) : ViewModel() {

    private val _startDestination = MutableStateFlow("welcome")
    private val _isLoading = MutableStateFlow(true)

    val startDestination = _startDestination.asStateFlow()
    val isLoading = _isLoading.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val onboardingCompleted = preferences.readOnboardingCompleted()
            if (onboardingCompleted) {
                _startDestination.value = "overview"
            } else {
                _startDestination.value = "welcome"
            }
            delay(150.milliseconds)
            _isLoading.value = false
        }
    }

}