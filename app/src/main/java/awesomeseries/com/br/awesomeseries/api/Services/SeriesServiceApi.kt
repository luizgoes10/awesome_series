package awesomeseries.com.br.awesomeseries.api.Services

import awesomeseries.com.br.awesomeseries.api.Utils.Exceptions.SeriesException
import awesomeseries.com.br.awesomeseries.api.Utils.checkForErros
import awesomeseries.com.br.awesomeseries.api.Utils.createRetrofitService
import awesomeseries.com.br.awesomeseries.api.BaseUrl
import awesomeseries.com.br.awesomeseries.models.PopularSeriesResult
import awesomeseries.com.br.awesomeseries.api.ResponseVO
import retrofit2.Call
import retrofit2.http.GET

class SeriesServiceApi {
    interface Retrofit{

        @GET("/top_rated?page=1&language=pt-BR&api_key=7e8b94028880068513979678abef3a0a")
        fun getPopularSeries(): Call<ResponseVO>

    }

    companion object Factory {

        @Throws
        fun getPopularSeries():MutableList<PopularSeriesResult>{


            val service = createRetrofitService<Retrofit>(BaseUrl.URL_ADDRESS)
            val execute = service.getPopularSeries().execute()
            val responseVO = execute.body()
            responseVO?.let {

                checkForErros<SeriesException>(it)
                return it.popularSeriesList
            }

            throw SeriesException("Houve um erro")
        }
    }
}