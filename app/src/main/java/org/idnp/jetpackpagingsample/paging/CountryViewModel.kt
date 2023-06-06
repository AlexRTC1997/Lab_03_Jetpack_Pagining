package org.idnp.jetpackpagingsample.paging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.flow.Flow
import org.idnp.jetpackpagingsample.entities.Country
import org.idnp.jetpackpagingsample.model.CountryRepository

class CountryViewModel : ViewModel() {
    private val countryRepository: CountryRepository = CountryRepository()

    fun items(): Flow<PagingData<Country>> {
        val pager = Pager(
            PagingConfig(
                pageSize = 5,
                enablePlaceholders = false,
                prefetchDistance = 3
            )
        ) {
            CountryPagingSource(countryRepository)
        }.flow.cachedIn(viewModelScope)

        return pager
    }
}