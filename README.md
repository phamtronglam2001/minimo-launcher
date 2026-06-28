# Minimo Launcher (Learning Fork)

This repository is a **personal fork** of [Minimo Launcher](https://github.com/VaibhavLakhera/minimo-launcher) by Vaibhav Lakhera. It is kept for learning Android/Kotlin development, not as an official continuation of the upstream project.

Upstream project: minimal text-based Android launcher — no icons, focused on simplicity.

## What changed in this fork

### True Black All Screens

Added under **Minimo Settings → Customisation**:

- Sets **home** and **lock screen** wallpapers to pure black (`#000000`)
- Attempts both `FLAG_SYSTEM` and `FLAG_LOCK` via `WallpaperManager`
- Optionally enables **Black Theme** when turned on
- Uses a confirmation dialog before applying

**Files touched (good starting points for reading the codebase):**

| Layer | File |
|-------|------|
| UI toggle + dialog | `app/src/main/java/.../customisation/CustomisationScreen.kt` |
| Click handler | `app/src/main/java/.../customisation/CustomisationViewModel.kt` |
| Saved preference | `app/src/main/java/.../data/PreferenceHelper.kt` |
| Apply on startup | `app/src/main/java/.../ui/theme/Theme.kt` |
| OS wallpaper call | `app/src/main/java/com/minimo/launcher/utils/WallpaperUtils.kt` |
| Strings | `app/src/main/res/values/strings.xml` |

**Note:** Always-on display / standby wallpaper is controlled by the device OEM; Android has no public API to set it directly.

### Build flavor

Use the **`foss`** flavor — no Google Play billing or in-app review libraries:

```powershell
.\gradlew.bat assembleFossRelease
```

APK output (signed release, arm64, ~3 MB):

```
app/build/outputs/apk/foss/release/app-foss-arm64-v8a-release.apk
```

### Environment (Windows)

Set these user environment variables, then restart the terminal:

| Variable | Example |
|----------|---------|
| `JAVA_HOME` | `D:\app\android-flutter-sdk\jdk17` |
| `GRADLE_USER_HOME` | `D:\app\gradle-home` (optional; `gradlew.bat` / `gradlew` set this if unset) |
| `ANDROID_HOME` | `D:\app\android-flutter-sdk\android-sdk` |

Add `%JAVA_HOME%\bin` to `PATH`. Gradle creates `local.properties` automatically if missing (not committed).

Gradle wrapper distributions and caches live under `%GRADLE_USER_HOME%` (default in scripts: `D:\app\gradle-home`), so builds do not re-download Gradle on every run.


## Tech stack

- Kotlin, Jetpack Compose, MVVM
- Room (app database), DataStore (settings), Hilt (dependency injection)
- Min SDK 26, target SDK 36

## License

Same license as upstream. See upstream repository for original authorship and terms.
