package code.with.cal.netflix.fragment


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import code.with.cal.netflix.R
import code.with.cal.netflix.adapter.VideoFavoriteAdapter

import code.with.cal.netflix.data.ViewModel
import code.with.cal.netflix.data.ValueSharedPreferences
import code.with.cal.netflix.data.VideoModel
import code.with.cal.netflix.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    private lateinit var favoriteBinding: FragmentFavoriteBinding
    private lateinit var videoAdapter: VideoFavoriteAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favoriteBinding = FragmentFavoriteBinding.bind(view)

        favoriteBinding.recyclerviewFavorite.visibility = View.GONE
        favoriteBinding.textviewNoRegister.visibility = View.VISIBLE

        checkRegister()



        favoriteBinding.recyclerviewFavorite.layoutManager = GridLayoutManager(context, 2)
        videoAdapter = VideoFavoriteAdapter()

        videoAdapter.setDataList(ViewModel().videoListFavorite)
        favoriteBinding.recyclerviewFavorite.adapter = videoAdapter

    }

    private fun checkRegister() {
        val sharedPref =
            activity?.getSharedPreferences(ValueSharedPreferences.NAME_FILE, Context.MODE_PRIVATE)

        try {
            ViewModel().isRegister = true

            val fullname = sharedPref?.getString(ValueSharedPreferences.FULL_NAME_ID, "")
            val password = sharedPref?.getString(ValueSharedPreferences.EMAIL_ID, "")
            val username = sharedPref?.getString(ValueSharedPreferences.USER_NAME_ID, "")

            if (
                fullname != null && fullname != "" ||
                username != null && username != "" ||
                password != null && password != ""
            ) {
                favoriteBinding.recyclerviewFavorite.visibility = View.VISIBLE
                favoriteBinding.textviewNoRegister.visibility = View.GONE
            }
        } catch (e: Exception) {
            Log.i("App", e.toString())
        }


    }
}