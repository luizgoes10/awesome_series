package awesomeseries.com.br.awesomeseries.api

import awesomeseries.com.br.awesomeseries.models.PopularSeriesResult
import com.google.gson.annotations.SerializedName
import java.io.Serializable

open class ResponseVO : Serializable {

    lateinit var code: String

    var message = "Houve um erro, tente mais tarde"

    var popularSeries:MutableList<PopularSeriesResult> = mutableListOf()


    fun isSucessFul():Boolean{
        return code == "SUCESS"
    }
}