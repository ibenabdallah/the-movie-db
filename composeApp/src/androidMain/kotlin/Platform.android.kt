import android.os.Build
import java.util.Locale

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
    override val local: Local = Local(Locale.getDefault().language, Locale.getDefault().country)
}

actual fun getPlatform(): Platform = AndroidPlatform()