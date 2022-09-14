package com.shoppi.kotlin

import android.content.Context


class AssetLoader {

    fun getJsonString(context: Context, fileName: String): String? {
       return kotlin.runCatching { loadAsset(context, fileName) }.getOrNull()
    }

    private fun loadAsset(context: Context, fileName: String): String? {
        return context.assets?.open(fileName)?.use { inputstream ->
            val size = inputstream.available()
            val bytes = ByteArray(size)
            inputstream.read(bytes)
            String(bytes)
        }
    }
}
