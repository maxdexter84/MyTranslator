package ru.maxdexter.mytranslator

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import geekbrains.ru.translator.model.data.DataModel
import kotlinx.android.synthetic.main.activity_main.*
import ru.maxdexter.mytranslator.adapter.MainAdapter
import ru.maxdexter.mytranslator.contracts.Presenter
import ru.maxdexter.mytranslator.contracts.View
import ru.maxdexter.mytranslator.databinding.ActivityMainBinding
import ru.maxdexter.mytranslator.presenter.MainPresenterImpl

class MainActivity : BaseActivity<DataModel>() {

    private var adapter: MainAdapter? = null
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        initRecycler()

    }

    private fun initRecycler() {
        adapter = MainAdapter()
        binding.recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)
    }

    override fun createPresenter(): Presenter<DataModel, View> {
        return MainPresenterImpl()
    }

    override fun renderData(dataModel: DataModel) {
        when(dataModel){
            is DataModel.Success ->{
                val result = dataModel.data
                if (result == null || result.isEmpty()) {
                    showViewError()
                }else  {
                    showViewSuccess()
                    adapter?.setData(result)
                    adapter?.setItemClickListener {

                    }
                }
            }
            is DataModel.Loading -> showViewLoading()
            is DataModel.Error -> showViewError()

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