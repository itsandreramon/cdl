package co.andrethiele.cdl.resources

import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSBundle
import platform.Foundation.NSString
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.stringWithContentsOfFile

actual class ResourceLoaderImpl : ResourceLoader {
    @OptIn(ExperimentalForeignApi::class)
    override fun readJson(path: String): String? {
        val path2 = NSBundle.mainBundle.pathForResource(path.removeSuffix(".json"), ofType = "json")
                ?: return null
        return NSString.stringWithContentsOfFile(path2, encoding = NSUTF8StringEncoding, error = null) as String
    }
}