package awesomeseries.com.br.awesomeseries.Utils

import awesomeseries.com.br.awesomeseries.models.ResponseVO

@Throws
inline fun <reified T : Exception> checkForErros(responseVO: ResponseVO) {
    if (!responseVO.isSucessFul()) {
        var message = responseVO.message
        if (message == "") {
            message = "Houve um erro na validação"
        }

        val newInstance = T::class.java.getConstructor(String::class.java).newInstance(message)
        throw newInstance
    }
}