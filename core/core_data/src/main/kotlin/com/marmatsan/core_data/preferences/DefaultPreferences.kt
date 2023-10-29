package com.marmatsan.core_data.preferences

import android.util.Log
import androidx.datastore.core.DataStore
import com.marmatsan.core_domain.PreferencesData
import com.marmatsan.core_domain.preferences.Preferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import java.io.IOException
import javax.inject.Inject

class DefaultPreferences @Inject constructor(
    private val dataStore: DataStore<PreferencesData>
) : Preferences {

    override fun preferencesDataFlow(): Flow<PreferencesData> = dataStore.data.catch { exception ->
        if (exception is IOException) {
            Log.e("UserPreferencesRepo", "Error reading sort order preferences.", exception)
            emit(PreferencesData.getDefaultInstance())
        } else {
            throw exception
        }
    }

    override suspend fun readOnboardingCompleted(): Boolean {
        return preferencesDataFlow().first().onboardingCompleted
    }

}