import platform.Foundation.NSLocale
import platform.Foundation.countryCode
import platform.Foundation.currentLocale
import platform.Foundation.languageCode

class IOSLocale: Locale {
    override val language: String = NSLocale.currentLocale.languageCode
    override val country: String? = NSLocale.currentLocale.countryCode
}

actual fun getLocale(): Locale = IOSLocale()