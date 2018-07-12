package awesomeseries.com.br.awesomeseries.presenters

open class MainViewPresenter(val viewCallBack:ViewCallBack) {

    interface ViewCallBack{

        fun showSwipeProgress(show: Boolean)
        fun showProgress()
        fun setUpRecycler()
    }

    open fun onViewCreated(){

        viewCallBack.showProgress()

    }
}