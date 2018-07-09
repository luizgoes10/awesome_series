package awesomeseries.com.br.awesomeseries.presenters

open class MainViewPresenter(val viewCallBack:ViewCallBack) {

    interface ViewCallBack{

        fun showHideProgress(show: Boolean)
    }
}