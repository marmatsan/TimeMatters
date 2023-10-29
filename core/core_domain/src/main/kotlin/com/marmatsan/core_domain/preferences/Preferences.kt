package com.marmatsan.core_domain.preferences

import com.marmatsan.core_domain.PreferencesData
import kotlinx.coroutines.flow.Flow

interface Preferences {
    suspend fun readOnboardingCompleted(): Boolean
    fun preferencesDataFlow(): Flow<PreferencesData>
}