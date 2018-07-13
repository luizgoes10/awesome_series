package awesomeseries.com.br.awesomeseries.api.Utils

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

inline fun <reified T> createRetrofitService(url: String): T =
        buildRetrofit(url).create(T::class.java)

fun buildRetrofit(url: String): Retrofit = Retrofit
        .Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create()))
        .baseUrl(url).build()