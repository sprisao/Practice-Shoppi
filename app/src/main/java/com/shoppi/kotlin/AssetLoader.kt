package com.shoppi.kotlin

import android.content.Context


class AssetLoader(private val context: Context) {

    fun getJsonString(fileName: String): String? {
        return kotlin.runCatching { loadAsset(fileName) }.getOrNull()
    }

    private fun loadAsset(fileName: String): String? {
        return context.assets?.open(fileName)?.use { inputstream ->
            val size = inputstream.available()
            val bytes = ByteArray(size)
            inputstream.read(bytes)
            String(bytes)
        }
    }
}
