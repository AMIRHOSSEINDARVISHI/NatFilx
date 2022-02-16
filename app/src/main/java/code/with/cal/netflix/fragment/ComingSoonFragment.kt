package code.with.cal.netflix.fragment


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import code.with.cal.netflix.R
import code.with.cal.netflix.adapter.VideoShareAdapter
import code.with.cal.netflix.data.VideoModel
import code.with.cal.netflix.databinding.FragmentComingSoonBinding

class ComingSoonFragment:Fragment(R.layout.fragment_coming_soon) {

    private lateinit var bindingComingSoon: FragmentComingSoonBinding
    private lateinit var videoAdapter: VideoShareAdapter
    private var videoList = mutableListOf<VideoModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        bindingComingSoon = FragmentComingSoonBinding.bind(view)

        bindingComingSoon.recyclerviewComingSoon.layoutManager = GridLayoutManager(context, 1)
        videoAdapter = VideoShareAdapter(context!!)

        videoList.add(
            VideoModel(
                R.drawable.black_widow,
                "BlackWidow",
                false,
                "Description Video Black Widow"
            )
        )
        videoList.add(
            VideoModel(
                R.drawable.breaking_bad,
                "Breaking Bad",
                false,
                "Description Video Breaking Bad"
            )
        )
        videoList.add(
            VideoModel(
                R.drawable.captain_america,
                "Captain America",
                false,
                "Description Video Captain America"
            )
        )

        videoAdapter.setDataList(videoList)

        bindingComingSoon.recyclerviewComingSoon.adapter = videoAdapter

        super.onViewCreated(view, savedInstanceState)
    }
}