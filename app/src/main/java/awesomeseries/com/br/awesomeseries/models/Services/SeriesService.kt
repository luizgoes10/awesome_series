package awesomeseries.com.br.awesomeseries.models.Services

import retrofit2.http.GET

class SeriesService {
    interface Retrofit{

        @GET("/top_rated?page=1&language=pt-BR&api_key=7e8b94028880068513979678abef3a0a")
        fun getPopularSeries()

    }
}