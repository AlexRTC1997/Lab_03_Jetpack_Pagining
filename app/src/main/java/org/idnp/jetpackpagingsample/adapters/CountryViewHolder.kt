package org.idnp.jetpackpagingsample.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.idnp.jetpackpagingsample.R
import org.idnp.jetpackpagingsample.entities.Country

class CountryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val idText = view.findViewById<TextView>(R.id.textViewId) as TextView
    private val nameEnText = view.findViewById<TextView>(R.id.textViewNameEn) as TextView
//    private val nameEsText = view.findViewById<TextView>(R.id.textViewNameEs) as TextView
//    private val continentEnText = view.findViewById<TextView>(R.id.textViewContinentEn) as TextView
//    private val continentEsText = view.findViewById<TextView>(R.id.textViewContinentEs) as TextView
    private val capitalEnText = view.findViewById<TextView>(R.id.textViewCapitalEn) as TextView
//    private val capitalEsText = view.findViewById<TextView>(R.id.textViewCapitalEs) as TextView
//    private val dialCodeText = view.findViewById<TextView>(R.id.textViewDialCode) as TextView
//    private val code2Text = view.findViewById<TextView>(R.id.textViewCode2) as TextView
//    private val code3Text = view.findViewById<TextView>(R.id.textViewCode3) as TextView
//    private val tldText = view.findViewById<TextView>(R.id.textViewTld) as TextView
//    private val km2Text = view.findViewById<TextView>(R.id.textViewKm2) as TextView

    fun bind(country: Country) {
        with(country) {
            idText.text = id.toString()
            nameEnText.text = name_en.toString()
//            nameEsText.text = name_es.toString()
//            continentEnText.text = continent_en.toString()
//            continentEsText.text = continent_es.toString()
            capitalEnText.text = capital_en.toString()
//            capitalEsText.text = capital_es.toString()
//            dialCodeText.text = dial_code.toString()
//            code2Text.text = code_2.toString()
//            code3Text.text = code_3.toString()
//            tldText.text = tld.toString()
//            km2Text.text = km2.toString()
        }
    }
}