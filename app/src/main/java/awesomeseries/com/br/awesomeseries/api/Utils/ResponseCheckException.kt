package awesomeseries.com.br.awesomeseries.api.Utils

import awesomeseries.com.br.awesomeseries.api.ResponseVO
import awesomeseries.com.br.awesomeseries.models.PopularSeries
import awesomeseries.com.br.awesomeseries.models.PopularSeriesResult

@Throws
inline fun <reified T : Exception> checkForErros(popularSeries: PopularSeriesResult) {
    if (popularSeries.results.isEmpty()) {
        var message = "houve um erro"
        if (message == "") {
            message = "Houve um erro na validação"
        }

        val newInstance = T::class.java.getConstructor(String::class.java).newInstance(message)
        throw newInstance
    }
}