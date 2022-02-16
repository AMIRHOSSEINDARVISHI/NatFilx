package code.with.cal.netflix.fragment


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import code.with.cal.netflix.R
import code.with.cal.netflix.adapter.VideoLikeAdapter
import code.with.cal.netflix.data.ViewModel
import code.with.cal.netflix.data.VideoModel
import code.with.cal.netflix.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var bindingHome: FragmentHomeBinding
    private lateinit var videoAdapter: VideoLikeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        bindingHome = FragmentHomeBinding.bind(view)

        bindingHome.recyclerviewHome.layoutManager = GridLayoutManager(context,2)
        videoAdapter = VideoLikeAdapter()

        videoAdapter.setDataList(ViewModel().videoList)

        bindingHome.recyclerviewHome.adapter = videoAdapter

        super.onViewCreated(view, savedInstanceState)
    }
}