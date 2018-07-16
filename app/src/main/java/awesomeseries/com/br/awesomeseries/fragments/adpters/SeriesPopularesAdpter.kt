package awesomeseries.com.br.awesomeseries.fragments.adpters

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import awesomeseries.com.br.awesomeseries.R
import awesomeseries.com.br.awesomeseries.models.PopularSeries
import com.squareup.picasso.Picasso

//Define o construtor que recebe (lista, e o evento click)
class SeriesPopularesAdpter(
        val context: Context,
        var series:List<PopularSeries>,
        val onClick:(PopularSeries)->Unit) :RecyclerView.Adapter<SeriesPopularesAdpter.SeriesPopularesViewHolder>(){

    //View holde com as views
    class SeriesPopularesViewHolder(view: View): RecyclerView.ViewHolder(view){
        var tNome: TextView
        var imgCaminhoImagem: ImageView
        var pbProgresso: ProgressBar
        var card: CardView
        var tAvaliacao:TextView
        init{
            //salva as views nas view holders
            tNome = view.findViewById<TextView>(R.id.tName)
            imgCaminhoImagem = view.findViewById<ImageView>(R.id.imgPosterPath)
            pbProgresso = view.findViewById<ProgressBar>(R.id.pbProgress)
            card = view.findViewById<CardView>(R.id.card_view)
            tAvaliacao = view.findViewById<TextView>(R.id.tVoteAverage)
        }

    }

    fun setList(listSeries: MutableList<PopularSeries>){
        series = listSeries
    }
    //quantia de items da lista
    override fun getItemCount() = series.size

    //infla o layout do adpter e retorna a viewholder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesPopularesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.seriespopulares_adpter, parent,false)
        val holder = SeriesPopularesViewHolder(view)
        return holder
    }

    //faz os binds para atualizar o valor das views com os dados da serie

    override fun onBindViewHolder(holder: SeriesPopularesViewHolder, position: Int) {
        val context = holder.itemView.context
        //recupera a serie
        val serie = series[position]
        //atualiza os dados da serie
        holder.tNome.text = serie.name
        holder.pbProgresso.visibility = View.VISIBLE
        // faz o download da imagem e mostra o progress bar
        Picasso.with(context).load(serie.thumb + serie.poster_path).fit().into(holder.imgCaminhoImagem,
                object : com.squareup.picasso.Callback{
                    override fun onSuccess() {
                        holder.pbProgresso.visibility = View.GONE
                    }

                    override fun onError() {
                        holder.pbProgresso.visibility = View.GONE
                    }
                })
        holder.tAvaliacao.text = serie.vote_average.toString()
        //adiciona o evento de click na linha
        holder.itemView.setOnClickListener{onClick(serie)}
    }

}