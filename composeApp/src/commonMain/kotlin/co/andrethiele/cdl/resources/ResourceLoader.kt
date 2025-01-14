package co.andrethiele.cdl.resources

interface ResourceLoader {
    fun readJsonFromAssets(path: String): String?
}

expect class ResourceLoaderImpl : ResourceLoader