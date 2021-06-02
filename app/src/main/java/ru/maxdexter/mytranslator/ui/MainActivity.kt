package ru.maxdexter.mytranslator.ui

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import ru.maxdexter.mytranslator.model.DataState
import ru.maxdexter.mytranslator.R
import ru.maxdexter.mytranslator.adapter.MainAdapter
import ru.maxdexter.mytranslator.contracts.Presenter
import ru.maxdexter.mytranslator.contracts.View
import ru.maxdexter.mytranslator.databinding.ActivityMainBinding
import ru.maxdexter.mytranslator.presenter.MainPresenterImpl
import ru.maxdexter.mytranslator.ui.fragments.BottomSheetFragment

class MainActivity : BaseActivity<DataState>() {

    private var adapter: MainAdapter? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.searchFab.setOnClickListener {
            val fragment = BottomSheetFragment.newInstance()
            fragment.setClickListener {
                presenter.getData(it,true)
            }
            supportFragmentManager.beginTransaction().add(fragment,"BOTTOM_SHEET").commitAllowingStateLoss()

        }
        initRecycler()

    }

    private fun initRecycler() {
        adapter = MainAdapter()
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = LinearLayoutManager(this)
    }

    override fun createPresenter(): Presenter<DataState, View> {
        return MainPresenterImpl()
    }

    override fun renderData(dataState: DataState) {
        when(dataState){
            is DataState.Success ->{
                val result = dataState.data
                if (result == null || result.isEmpty()) {
                    showViewError()
                }else  {
                    showViewSuccess()
                    adapter?.setData(result)
                    adapter?.setItemClickListener {

                    }
                }
            }
            is DataState.Loading -> showViewLoading()
            is DataState.Error -> {
                showViewError()
                binding.reloadButton.setOnClickListener {
                    recreate()
                }
            }

        }
    }


    private fun showViewError() {
        binding.successLinearLayout.visibility = android.view.View.GONE
        binding.loadingFrameLayout.visibility = android.view.View.GONE
        binding.errorLinearLayout.visibility = android.view.View.VISIBLE
    }


    private fun showViewSuccess() {
        binding.successLinearLayout.visibility = android.view.View.VISIBLE
        binding.loadingFrameLayout.visibility = android.view.View.GONE
        binding.errorLinearLayout.visibility = android.view.View.GONE
    }

    private fun showViewLoading() {
        binding.successLinearLayout.visibility = android.view.View.GONE
        binding.loadingFrameLayout.visibility = android.view.View.VISIBLE
        binding.errorLinearLayout.visibility = android.view.View.GONE
    }
}