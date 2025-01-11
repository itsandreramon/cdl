package co.andrethiele.cdl

interface Platform {
  val name: String
}

expect fun getPlatform(): Platform
