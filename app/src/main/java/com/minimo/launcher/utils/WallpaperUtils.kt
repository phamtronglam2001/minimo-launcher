package com.minimo.launcher.utils

import android.app.WallpaperManager
import android.content.Context
import android.graphics.Color
import androidx.core.graphics.createBitmap
import androidx.core.graphics.set

object WallpaperUtils {
    fun setTrueBlackWallpaper(context: Context) {
        setSolidColorWallpaper(context, Color.BLACK)
    }

    fun setSolidColorWallpaper(context: Context, color: Int) {
        try {
            val wallpaperManager = WallpaperManager.getInstance(context)
            if (!wallpaperManager.isWallpaperSupported) {
                return
            }

            val bitmap = createBitmap(1, 1)
            bitmap[0, 0] = color

            val flagsToTry = listOf(
                WallpaperManager.FLAG_SYSTEM or WallpaperManager.FLAG_LOCK,
                WallpaperManager.FLAG_SYSTEM,
                WallpaperManager.FLAG_LOCK
            )

            for (which in flagsToTry) {
                try {
                    wallpaperManager.setBitmap(bitmap, null, true, which)
                    return
                } catch (e: Exception) {
                    // Try the next wallpaper target.
                }
            }

            wallpaperManager.setBitmap(bitmap)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
