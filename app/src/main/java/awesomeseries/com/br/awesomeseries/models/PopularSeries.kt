package awesomeseries.com.br.awesomeseries.models

import awesomeseries.com.br.awesomeseries.api.BaseUrl
import java.util.*

class PopularSeries {

    var original_name = ""
    var id = 0L
    var name = ""
    var popularity = 0.00
    var vote_count = 0
    var vote_average = 0.00
    var date_time = Date()
    var poster_path = ""
    var genre_ids = IntArray(size = 5)
    var original_language = ""
    var backdrop_path = ""
    var overview = ""
    var origin_country = arrayOfNulls<String>(10)

    var numberPage = 0
    var namePage = ""
    var titlePage = ""

    var thumb = BaseUrl.API_BASE_IMAGE + "w200"
    var screenshotMed = BaseUrl.API_BASE_IMAGE + "w300"
    var logMed = BaseUrl.API_BASE_IMAGE + "original"
    var screenshotBig = BaseUrl.API_BASE_IMAGE + "w500"
}