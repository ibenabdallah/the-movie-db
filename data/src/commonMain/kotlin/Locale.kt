interface Locale {
    val language: String?
    val country: String?
    fun lang() = "$language-$country"
}

expect fun getLocale(): Locale