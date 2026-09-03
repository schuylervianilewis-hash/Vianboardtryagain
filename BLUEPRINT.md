# Project Blueprint: VianBoard

## 1. Overview
VianBoard is a fully customizable, privacy-conscious offline Android keyboard application based on AOSP / OpenBoard / HeliBoard.
- **Application ID**: `shura.vianboard`
- **Namespace**: `helium314.keyboard.latin`
- **Architecture**: MVVM / Clean Android Architecture with LatinIME Service and Jetpack Compose for modern Settings UI.
- **Offline / Privacy Guarantee**: 100% offline, zero internet permissions.

## 2. Key Modules & Components
- **Core Input Method Service (`LatinIME`)**: Handles touch input, key layout generation, popup keys, gesture data handling, and input connection.
- **Settings & Preferences (`helium314.keyboard.settings`)**: Built with Jetpack Compose (Material 3), enabling theme customization, custom color pickers, key borders, custom layouts, dictionaries, gestures, clipboard manager, and spell checker.
- **Spell Checker (`AndroidSpellCheckerService`)**: AOSP-based offline spell checker service.
- **Clipboard Content Provider (`ClipboardContentProvider`)**: Internal clipboard history (`shura.vianboard.clipprovider`) and secure pasting.
- **Log Keeper / Diagnostics (`Log.kt`, `DebugFlags.kt`)**: Built-in crash and diagnostics logging with debug toggles and export capabilities.

## 3. Development & Migration Phases
- **Phase 1: Project Setup & Cloning**: Import source files, resources, assets, dictionaries, and layouts from repository.
- **Phase 2: Build & Dependency Alignment**: Configure Gradle DSL (`app/build.gradle.kts`, `settings.gradle.kts`, `libs.versions.toml`) with Kotlin 2.2.10, AGP 9.1.1, Compose BOM, Serialization, Desugaring, Reorderable, and ColorPicker.
- **Phase 3: Verification & Compilation**: Proactively compile via `compile_applet` and perform sanity tests.
- **Phase 4: Security & Integrity Audit**: Audit workspace for zero exposed credentials, gitignore checks, and clean artifact state.
- **Phase 5: Package & Identity Alignment**: Updated `applicationId` to `shura.vianboard`, app name to `VianBoard`, sync provider authorities, and added GitHub Actions APK CI workflow.
- **Phase 6: Modern Clipboard Engine**: Standardized 2-column responsive layout, quick-action micro-menu (Pin/Unpin, Delete, Paste), and unified 4-button footer (`[ABC] [SPACE] [⌫] [↵]`).
- **Phase 7: LogKeeper UI & Diagnostics**: Integrated privacy-focused LogKeeper activity (`LogKeeperActivity.kt`) with master toggle, category-based log filtering (Errors/Warnings/Fatal), on-device file export, and resolved all project compilation dependencies.
- **Phase 8: Dictionary Asset Optimization**: Pruned bundled dictionary assets to English (`main_en-US.dict`, `main_en-GB.dict`) and French (`main_fr.dict`) only, optimizing APK size while preserving post-install import and download capabilities for all other languages.
- **Phase 9: CI Pipeline & JVM Metaspace Optimization**: Configured automated debug keystore generation in GitHub Actions workflow to prevent CI packaging failures, and configured `-XX:MaxMetaspaceSize=1024m` in `gradle.properties` to prevent daemon heap exhaustion.
- **Phase 10: Repository & Resource Pruning**: Removed 98 redundant non-English/French localized string resource folders (`values-*`), updated `locales_config.xml`, added `resourceConfigurations += listOf("en", "fr")` and `ndk.abiFilters` (`arm64-v8a`, `x86_64`) in `app/build.gradle.kts`, added `.build-outputs/` to `.gitignore`, reducing res folder by 75% and source repo to <10MB.

## 4. Change Ledger
- **2026-08-27**: Cloned and imported complete source tree from `schuylervianilewis-hash/Vianboardtryagain`.
- **2026-08-27**: Configured Gradle 9.3.1 / AGP 9.1.1 toolchain, updated `metadata.json`, `settings.gradle.kts`, `gradle/libs.versions.toml`, and `app/build.gradle.kts`.
- **2026-08-27**: Updated `applicationId` to `shura.vianboard`, app name resources to `VianBoard`, synced authorities to `shura.vianboard.clipprovider`/`provider`, configured `.github/workflows/build-apk.yml`, generated `gradlew` wrapper, and verified compilation.
- **2026-08-27**: Enhanced modern clipboard modal with 3-action long-press menu (`Pin/Unpin`, `Delete`, `Paste`) and standardized unified 4-button bottom bar.
- **2026-08-28**: Completed `LogKeeperActivity`, resolved `KeyLabel`, `PromptHistoryView`, and `KeyboardSwitcher` compilation dependencies, verified green build via `compile_applet`.
- **2026-09-01**: Pruned non-English/French dictionary assets from `app/src/main/assets/dicts/`, verified build via `compile_applet`.
- **2026-09-02**: Added Ensure Debug Keystore step to `.github/workflows/build-apk.yml` and tuned `gradle.properties` JVM args with `-XX:MaxMetaspaceSize=1024m`.
- **2026-09-03**: Pruned 98 redundant `values-*` directories, configured `resourceConfigurations` and `ndk.abiFilters` in `app/build.gradle.kts`, aligned `locales_config.xml`, and added `.build-outputs/` to `.gitignore`.

