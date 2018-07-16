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

        fun hideSwipeProgress(show: Boolean)
        fun setUpRecycler()
        fun setPopularSeries(series: MutableList<PopularSeries>)
        fun hideRecycle()
        fun showProgress()
        fun hideProgress()
    }

    open fun onViewCreated(){

        viewCallBack.setUpRecycler()
        viewCallBack.showProgress()
        getPopularSeries(true)
    }

    private fun getPopularSeries(reflesh:Boolean){

        taskSeriesPopulares(true)

    }
    open fun taskSeriesPopulares(reflesh: Boolean){

        //Padrão Observador-> programação reativa
        Observable.fromCallable { SeriesServiceApi.getPopularSeries() }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy (onNext = {

                    if(it.results.isEmpty()){
                        return@subscribeBy
                    }
                    if(reflesh){
                        viewCallBack.hideSwipeProgress(reflesh)
                    }
                    viewCallBack.hideProgress()
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