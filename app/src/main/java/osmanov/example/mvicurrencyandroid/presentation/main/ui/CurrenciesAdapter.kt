package osmanov.example.mvicurrencyandroid.presentation.main.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_currency.view.*
import osmanov.example.mvicurrencyandroid.R
import osmanov.example.mvicurrencyandroid.data.remote.model.CurrencyResponse
import osmanov.example.mvicurrencyandroid.model.CurrencyModel

class CurrenciesAdapter(
    private val currencyClickListener: (CurrencyModel) -> Unit
) : RecyclerView.Adapter<CurrenciesAdapter.Holder>() {

    private val currenciesList = mutableListOf<CurrencyModel>()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): Holder =
        Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_currency, parent, false))

    override fun getItemCount(): Int = currenciesList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        return holder.bind(currenciesList[position])
    }

    fun updateList(currencies: List<CurrencyModel>) {
        currenciesList.clear()
        currenciesList.addAll(currencies)
        notifyDataSetChanged()
    }


    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(currency: CurrencyModel): Unit = with(itemView) {
            clRoot.setOnClickListener { currencyClickListener(currency) }
            tvName.text = currency.name.trim()
            tvCode.text = currency.code.trim()
        }

    }

}
