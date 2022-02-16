package code.with.cal.netflix.adapter


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import code.with.cal.netflix.R
import code.with.cal.netflix.data.VideoModel
import code.with.cal.netflix.data.ViewModel

class VideoLikeAdapter : RecyclerView.Adapter<VideoLikeAdapter.ViewHolder>() {
    private var dataList = emptyList<VideoModel>()

    internal fun setDataList(dataList: List<VideoModel>) {
        this.dataList = dataList
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageview_video)
        val title: TextView = itemView.findViewById(R.id.textview_title)
        val like: ImageView = itemView.findViewById(R.id.imageViewLike)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.card_video_and_like, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]

        holder.image.setImageResource(data.videoImage)
        holder.title.text = data.videoTitle
        holder.like.setOnClickListener {
            Log.i("AppMan", data.toString())

            if (data.videoLike) {
                data.videoLike = false

                holder.like.setImageResource(R.drawable.ic_round_like_on_24)
                ViewModel().videoListFavorite.add(data)
                Log.i("Like", data.toString())
            } else {
                data.videoLike = true
                holder.like.setImageResource(R.drawable.ic_round_like_off_24)
                ViewModel().videoListFavorite.remove(data)
                Log.i("Unlike", data.toString())
            }
            Log.i("TAG",ViewModel().videoListFavorite.toString())

        }
    }

    override fun getItemCount() = dataList.size

}