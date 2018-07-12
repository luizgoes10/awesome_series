package awesomeseries.com.br.awesomeseries.models

class PopularSeriesResult {
    var page = 0
    var total_results = 0
    var total_pages = 0
    var results = mutableListOf<PopularSeries>()
    var namePage = ""
}