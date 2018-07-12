package awesomeseries.com.br.awesomeseries.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

open class ResponseVO : Serializable {

    lateinit var code: String

    var message = "Houve um erro, tente mais tarde"

    @SerializedName("listSeries")
    lateinit var seriesList: List<PopularSeriesResult>


    var popularSeriesList:MutableList<PopularSeriesResult> = mutableListOf()


    fun isSucessFul():Boolean{
        return code == "SUCESS"
    }
}