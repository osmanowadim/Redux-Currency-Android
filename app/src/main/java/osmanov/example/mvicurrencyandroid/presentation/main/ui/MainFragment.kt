package osmanov.example.mvicurrencyandroid.presentation.main.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import osmanov.example.mvicurrencyandroid.R
import osmanov.example.mvicurrencyandroid.common.extensions.navigate
import osmanov.example.mvicurrencyandroid.common.mvi.MviView
import osmanov.example.mvicurrencyandroid.presentation.base.BaseFragment
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainAction
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainNews
import osmanov.example.mvicurrencyandroid.presentation.main.mvi.MainState

class MainFragment : BaseFragment(R.layout.fragment_main), MviView<MainState, MainNews> {

    private val mainViewModel by viewModel<MainViewModel>()

    private val currencyAdapter = CurrenciesAdapter {
        viewLifecycleOwner.lifecycleScope.launch {
            mainViewModel.obtainAction(
                MainAction.CurrencyItemClicked(it)
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainViewModel.bind(viewLifecycleOwner.lifecycleScope, this@MainFragment)

        viewLifecycleOwner.lifecycleScope.launch {
            mainViewModel.obtainAction(
                MainAction.GetCurrencies
            )
        }

        rvList?.apply {
            layoutManager = LinearLayoutManager(this@MainFragment.context)
            adapter = currencyAdapter
        }
        swipeRefreshLayout?.setOnRefreshListener {
            viewLifecycleOwner.lifecycleScope.launch {
                mainViewModel.obtainAction(
                    MainAction.GetCurrencies
                )
            }
        }
    }

    override fun renderState(state: MainState) {
        when (state) {
            is MainState.Default -> {
                pbLoader?.isVisible = false
                state.navDirections?.let {
                    navigate(it)
                    mainViewModel.obtainState(state.copy(null))
                }
            }
            is MainState.Loading -> {
                swipeRefreshLayout?.isRefreshing = false
                tvEmpty?.isVisible = false
                pbLoader.isVisible = true
            }
            is MainState.Error -> {
                rvList?.isVisible = false
                tvEmpty?.isVisible = true
                pbLoader?.isVisible = false
            }
            is MainState.ShowList -> {
                tvEmpty?.isVisible = false
                pbLoader?.isVisible = false
                swipeRefreshLayout?.isRefreshing = false
                currencyAdapter.updateList(state.items)
            }
        }
    }

    override fun renderNews(new: MainNews) {
        when (new) {
            is MainNews.Message -> {
                Toast.makeText(requireContext(), new.content, new.duration).show()
            }
        }
    }

}
