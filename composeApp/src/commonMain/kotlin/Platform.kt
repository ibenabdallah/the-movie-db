interface Platform {
    val name: String
    val local: Local
}

data class Local(val language: String, val country: String?) {
    fun lang() = "$language-$country"
}

expect fun getPlatform(): Platform