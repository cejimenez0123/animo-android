package com.solbao.animo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform