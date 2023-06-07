package org.idnp.jetpackpagingsample

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.idnp.jetpackpagingsample.adapters.CountryAdapter
import org.idnp.jetpackpagingsample.entities.Country
import org.idnp.jetpackpagingsample.model.CountryDatabase
import org.idnp.jetpackpagingsample.paging.CountryViewModel

class CountryMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.country_activity_main)

        val viewModel by viewModels<CountryViewModel>()
        val recyclerView = findViewById<RecyclerView>(R.id.country_recycler_view)
        val pagingAdapter = CountryAdapter()

        recyclerView.adapter = pagingAdapter
        recyclerView.apply {
            addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))
        }

        lifecycleScope.launch {
            viewModel.items().collectLatest { pageData ->
                pagingAdapter.submitData(pageData)
            }
        }

        prePopDB()
    }

    // Populate Country Database
    private fun prePopDB() {
        val dao = Room.databaseBuilder(this, CountryDatabase::class.java, "country-db").build()
            .countryDao()

        GlobalScope.launch {
            for (i in 0..5) {
                dao.insert(
                    Country(
                        id = 0,
                        name_en = "Name_en $i",
                        name_es = "Name_es $i",
                        continent_en = "Continent_en $i",
                        continent_es = "Continent_es $i",
                        capital_en = "Capital_en $i",
                        capital_es = "Capital_es $i",
                        dial_code = "Dial_code $i",
                        code_2 = "Code_2 $i",
                        code_3 = "Code_3 $i",
                        tld = "Tld $i",
                        km2 = i * 1000
                    )
                )
            }
        }
    }
}