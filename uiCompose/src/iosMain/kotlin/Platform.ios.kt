import platform.Foundation.NSLocale
import platform.Foundation.countryCode
import platform.Foundation.currentLocale
import platform.Foundation.languageCode
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override val local: Local = Local(NSLocale.currentLocale.languageCode, NSLocale.currentLocale.countryCode)
}

actual fun getPlatform(): Platform = IOSPlatform()