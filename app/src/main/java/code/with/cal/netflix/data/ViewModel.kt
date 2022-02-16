package code.with.cal.netflix.data


import android.graphics.drawable.Drawable
import androidx.lifecycle.ViewModel
import code.with.cal.netflix.R

class ViewModel : ViewModel() {
    var image: Drawable? = null
    var fullname: String? = null
    var email: String? = null
    var username: String? = null

    var isRegister: Boolean = false

    val videoListFavorite = mutableListOf<VideoModel>(
        VideoModel(R.drawable.vikings, "Vikings", true),
        VideoModel(R.drawable.deadpool1, "Deadpool 1", true),
        VideoModel(R.drawable.iron_man, "Iron Man", true)
    )
    val videoList = mutableListOf<VideoModel>(
        VideoModel(R.drawable.black_widow, "BlackWidow", false),
        VideoModel(R.drawable.breaking_bad, "Breaking Bad", false),
        VideoModel(R.drawable.captain_america, "Captain America", false),
        VideoModel(R.drawable.deadpool1, "Deadpool 1", false),
        VideoModel(R.drawable.deadpool2, "Deadpool 2", false),
        VideoModel(R.drawable.eternals, "Eternals", false),
        VideoModel(R.drawable.free_guy, "Free Guy", false),
        VideoModel(R.drawable.friends, "Friends", false),
        VideoModel(R.drawable.game_of_thrones, "Game Of Thrones", false),
        VideoModel(R.drawable.halloween_kills, "Halloween Kills", false),
        VideoModel(R.drawable.iron_man, "Iron Man", false),
        VideoModel(R.drawable.lucifer, "Lucifer", false),
        VideoModel(R.drawable.mad_max, "Mad Max", false),
        VideoModel(R.drawable.matrix, "Matrix", false),
        VideoModel(R.drawable.red_notice, "Red Notice", false),
        VideoModel(R.drawable.shang_chi, "Shang Chi", false),
        VideoModel(R.drawable.spider_man_no_way_home, "Spider-Man No Way Home", false),
        VideoModel(R.drawable.suicide_squad1, "Suicide Squad 1", false),
        VideoModel(R.drawable.suicide_squad2, "Suicide Squad 2", false),
        VideoModel(R.drawable.venom, "Venom", false),
        VideoModel(R.drawable.vikings, "Vikings", false)
    )

}