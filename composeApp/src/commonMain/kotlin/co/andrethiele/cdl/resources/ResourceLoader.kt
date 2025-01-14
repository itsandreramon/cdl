package co.andrethiele.cdl.resources

interface ResourceLoader {
    fun readJson(path: String): String?
}

expect class ResourceLoaderImpl : ResourceLoader