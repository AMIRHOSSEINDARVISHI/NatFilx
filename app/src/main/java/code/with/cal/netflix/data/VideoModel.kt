package code.with.cal.netflix.data

data class VideoModel(
    var videoImage: Int,
    var videoTitle: String,
    var videoLike: Boolean,
    var videoDescription: String = ""
)