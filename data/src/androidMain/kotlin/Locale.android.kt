import java.util.Locale as JavaLocale

class AndroidLocale : Locale {
    override val language: String? = JavaLocale.getDefault().language
    override val country: String? = JavaLocale.getDefault().country
}

actual fun getLocale(): Locale = AndroidLocale()