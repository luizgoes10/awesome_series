package awesomeseries.com.br.awesomeseries.presenters

import android.os.Bundle
import awesomeseries.com.br.awesomeseries.api.Services.SeriesServiceApi
import awesomeseries.com.br.awesomeseries.models.PopularSeries
import awesomeseries.com.br.awesomeseries.models.PopularSeriesResult
import java.util.*
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.rxkotlin.subscribeBy

open class MainViewPresenter(val viewCallBack:ViewCallBack) {

    interface ViewCallBack{

        fun setUpRecycler()
        fun setPopularSeries(series: MutableList<PopularSeries>)
        fun hideRecycle()
        fun showProgress()
        fun hideProgress()
        fun onSwipeLoadItems()
        fun onSwipeCompleteLoadItems()
    }

    open fun onViewCreated(){

        viewCallBack.setUpRecycler()
        viewCallBack.showProgress()
        getPopularSeries()
    }


    private fun getPopularSeries(){

        taskSeriesPopulares()

    }
    open fun taskSeriesPopulares(){

        //Padrão Observador-> programação reativa
        Observable.fromCallable { SeriesServiceApi.getPopularSeries() }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy (onNext = {

                    if(it.results.isEmpty()){
                        return@subscribeBy
                    }
                    viewCallBack.hideProgress()
                    viewCallBack.onSwipeLoadItems()
                    viewCallBack.onSwipeCompleteLoadItems()
                    viewCallBack.setPopularSeries(it.results)
                },
                        onError = {
                            viewCallBack.hideProgress()
                        })
    }
    fun clickedItem(series: PopularSeries) {
        val bundle = Bundle()
    }
}