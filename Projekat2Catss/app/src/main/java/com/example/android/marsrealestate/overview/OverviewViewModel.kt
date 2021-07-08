/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.example.android.marsrealestate.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.marsrealestate.network.CatsApiFilter
import com.example.android.marsrealestate.network.MackeApi
import com.example.android.marsrealestate.network.Macke
import kotlinx.coroutines.launch

enum class CatsApiStatus { LOADING, ERROR, DONE }

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<CatsApiStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<CatsApiStatus>
        get() = _status

    // Internally, we use a MutableLiveData, because we will be updating the List of Macke
    // with new values
    private val _properties = MutableLiveData<List<Macke>>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val properties: LiveData<List<Macke>>
        get() = _properties

    // LiveData to handle navigation to the selected property
    private val _navigateToSelectedProperty = MutableLiveData<Macke>()
    val navigateToSelectedProperty: LiveData<Macke>
        get() = _navigateToSelectedProperty



    /**
     * Call dajMackeZaUdomljavanje() on init so we can display status immediately.
     */
    init {
        dajMackeZaUdomljavanje(CatsApiFilter.SHOW_ALL)
    }

    /**
     * Gets Mars real estate property information from the Mars API Retrofit service and updates the
     * [Macke] [List] [LiveData]. The Retrofit service returns a coroutine Deferred, which we
     * await to get the result of the transaction.
     */
    private fun dajMackeZaUdomljavanje(filter: CatsApiFilter) {

        viewModelScope.launch {
            _status.value = CatsApiStatus.LOADING
            try {
                _properties.value = MackeApi.RETROFIT_SERVICE.dajMacke(filter.value)
                _status.value = CatsApiStatus.DONE
            } catch (e: Exception) {
                _status.value = CatsApiStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }
    fun updateFilter(filter: CatsApiFilter) {
        dajMackeZaUdomljavanje(filter)
    }

    /**
     * When the property is clicked, set the [_navigateToSelectedProperty] [MutableLiveData]
     * @param marsProperty The [MarsProperty] that was clicked on.
     */
    fun displayPropertyDetails(macke: Macke) {
        _navigateToSelectedProperty.value = macke
    }

    /**
     * After the navigation has taken place, make sure navigateToSelectedProperty is set to null
     */
    fun displayPropertyDetailsComplete() {
        _navigateToSelectedProperty.value = null
    }
}

