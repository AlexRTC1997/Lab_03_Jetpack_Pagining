package org.idnp.jetpackpagingsample.model

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.idnp.jetpackpagingsample.entities.Country

@Dao
interface CountryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(countries: List<Country>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(country: Country)

    // TODO:
    @Query("SELECT * FROM countries")
    fun pagingSource(): PagingSource<Int, Country>

//    @Query("SELECT * FROM countries")
//    fun pagingSource(query: String): PagingSource<Int, Country>

    @Query("DELETE FROM countries")
    suspend fun clearAll()
}