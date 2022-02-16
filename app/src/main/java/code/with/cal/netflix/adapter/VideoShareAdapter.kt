package code.with.cal.netflix.adapter


import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import code.with.cal.netflix.R
import code.with.cal.netflix.data.VideoModel

class VideoShareAdapter(private val context: Context) :
    RecyclerView.Adapter<VideoShareAdapter.ViewHolder>() {
    private var dataList = emptyList<VideoModel>()

    internal fun setDataList(dataList: List<VideoModel>) {
        this.dataList = dataList
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageview_video)
        val title: TextView = itemView.findViewById(R.id.textview_title)
        val description: TextView = itemView.findViewById(R.id.textview_description)
        val share: ImageView = itemView.findViewById(R.id.imageview_share)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.card_video_and_share, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        val origin: Activity = context as Activity

        holder.image.setImageResource(data.videoImage)
        holder.title.text = data.videoTitle
        holder.description.text = data.videoDescription
        holder.share.setOnClickListener {
            val textShare: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Video Title: ${data.videoTitle}\nVideo Description: ${data.videoDescription}")
                type = "text/plain"
            }

            val shareIntent = Intent.createChooser(textShare, null)

            origin.startActivity(shareIntent)
        }
    }

    override fun getItemCount() = dataList.size

}