package awesomeseries.com.br.awesomeseries.models.Services

import awesomeseries.com.br.awesomeseries.Utils.Exceptions.SeriesException
import awesomeseries.com.br.awesomeseries.Utils.checkForErros
import awesomeseries.com.br.awesomeseries.Utils.createRetrofitService
import awesomeseries.com.br.awesomeseries.models.BaseUrl
import awesomeseries.com.br.awesomeseries.models.PopularSeries
import awesomeseries.com.br.awesomeseries.models.ResponseVO
import retrofit2.Call
import retrofit2.http.GET

class SeriesService {
    interface Retrofit{

        @GET("/top_rated?page=1&language=pt-BR&api_key=7e8b94028880068513979678abef3a0a")
        fun getPopularSeries(): Call<ResponseVO>

    }

    companion object Factory {

        @Throws
        fun getPopularSeries():MutableList<PopularSeries>{


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