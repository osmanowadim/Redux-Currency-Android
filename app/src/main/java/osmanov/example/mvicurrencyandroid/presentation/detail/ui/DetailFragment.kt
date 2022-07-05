package osmanov.example.mvicurrencyandroid.presentation.detail.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import osmanov.example.mvicurrencyandroid.R
import osmanov.example.mvicurrencyandroid.common.mvi.MviView
import osmanov.example.mvicurrencyandroid.presentation.base.BaseFragment
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailAction
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailNews
import osmanov.example.mvicurrencyandroid.presentation.detail.mvi.DetailState


class DetailFragment : BaseFragment(R.layout.fragment_detail), MviView<DetailState, DetailNews> {

    private val detailViewModel by viewModel<DetailViewModel>()
    private val detailFragmentArgs by navArgs<DetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailViewModel.bind(viewLifecycleOwner.lifecycleScope, this@DetailFragment)

        viewLifecycleOwner.lifecycleScope.launch {
            detailViewModel.obtainAction(DetailAction.GetCurrencyExchange(detailFragmentArgs.currency))
        }
    }

    override fun renderState(state: DetailState) {
        when (state) {
            is DetailState.Success -> {
                tvError?.isVisible = false
                tvDate?.apply {
                    isVisible = true
                    text = getString(R.string.exchange_on, state.currency.exchangeDate)
                }
                tvCode?.apply {
                    isVisible = true
                    text = getString(R.string.exchange_id_for, state.currency.code)
                }
                tvRate?.apply {
                    isVisible = true
                    text = getString(
                        R.string.exchange_rate_for,
                        state.currency.rate.toString()
                    )
                }
            }
            is DetailState.Error -> {
                tvDate?.isVisible = false
                tvCode?.isVisible = false
                tvRate?.isVisible = false
                tvError?.isVisible = true
            }
            is DetailState.Default -> {
                tvDate?.isVisible = false
                tvCode?.isVisible = false
                tvRate?.isVisible = false
                tvError?.isVisible = false
            }
        }
    }

    override fun renderNews(new: DetailNews) {
        when (new) {
            is DetailNews.Message -> {
                Toast.makeText(requireContext(), new.content, new.duration).show()
            }
        }
    }

}
