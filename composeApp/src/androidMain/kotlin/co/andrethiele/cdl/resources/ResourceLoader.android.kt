package co.andrethiele.cdl.resources

import android.content.Context
import kotlinx.io.IOException

actual class ResourceLoaderImpl(
    private val context: Context,
) : ResourceLoader {
    override fun readJsonFromAssets(path: String): String? {
        return try {
            context.assets.open(path).bufferedReader()
                .use { reader -> reader.readText() }
        } catch (ioe: IOException) {
            null
        }
    }
}