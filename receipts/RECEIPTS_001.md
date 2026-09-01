# Receipts Log

## Entry 001
- **Timestamp**: 2026-08-27T13:11:30-07:00
- **Requested**: Clone and setup https://github.com/schuylervianilewis-hash/Vianboardtryagain
- **Exact files touched**:
  - `metadata.json`
  - `settings.gradle.kts`
  - `build.gradle.kts`
  - `gradle/libs.versions.toml`
  - `app/build.gradle.kts`
  - `app/proguard-rules.pro`
  - `app/dontoptimize.pro`
  - `app/src/main/*` (Java/Kotlin sources, resources, assets, AndroidManifest.xml)
  - `BLUEPRINT.md`
  - `receipts/RECEIPTS_001.md`
- **What was actually done**: Cloned repository, replaced placeholder template with HeliBoard source code, assets, dictionaries, and layout resources; aligned Gradle configuration with the container toolchain (AGP 9.1.1, Kotlin Compose, Desugaring, Reorderable, and ColorPicker).
- **How it was verified**: Full local build verified with `compile_applet` (`assembleDebug` succeeded).
- **Deviation from requested**: None.
- **Known issue or follow-up needed**: Ready for on-device setup and testing.

## Entry 002
- **Timestamp**: 2026-08-27T14:05:30-07:00
- **Requested**: Implement applicationId change to shura.vianboard and app name to VianBoard
- **Exact files touched**:
  - `app/build.gradle.kts`
  - `app/src/main/res/values/clip_provider.xml`
  - `app/src/main/res/values/gesture_data.xml`
  - `app/src/main/res/values/donottranslate.xml`
  - `app/src/main/res/values/strings.xml`
  - `metadata.json`
  - `settings.gradle.kts`
  - `.github/workflows/build-apk.yml`
  - `.gitignore`
  - `BLUEPRINT.md`
  - `receipts/RECEIPTS_001.md`
- **What was actually done**: Updated `applicationId` to `shura.vianboard`, set application and service names to `VianBoard`, synced ContentProvider authority strings (`shura.vianboard.clipprovider` & `shura.vianboard.provider`), configured GitHub Actions workflow (`.github/workflows/build-apk.yml`), generated `gradlew` wrapper, and verified compilation.
- **How it was verified**: Full local build verified with `compile_applet` (exit code 0, `BUILD SUCCESSFUL`).
- **Deviation from requested**: None.
- **Known issue or follow-up needed**: None. Workspace is stable and ready for export and testing.

## Entry 003
- **Timestamp**: 2026-08-27T14:12:45-07:00
- **Requested**: Implement modern clipboard features (micro-action popup on long press, unified 4-button bottom bar)
- **Exact files touched**:
  - `app/src/main/java/helium314/keyboard/keyboard/clipboard/ClipboardAdapter.kt`
  - `app/src/main/assets/layouts/clipboard_bottom/clip_bottom_row.json`
  - `BLUEPRINT.md`
  - `receipts/RECEIPTS_001.md`
- **What was actually done**: Added 3-action long-press popup menu (`📌 Pin/Unpin`, `🗑️ Delete`, `📋 Paste`) to clipboard history cards in `ClipboardAdapter.kt` and updated `clip_bottom_row.json` to standardize the unified 4-button footer (`[ABC] [SPACE] [⌫] [↵]`).
- **How it was verified**: Full local build verified with `compile_applet` (exit code 0, `BUILD SUCCESSFUL`).
- **Deviation from requested**: None.
- **Known issue or follow-up needed**: None.

## Entry 004
- **Timestamp**: 2026-08-28T00:43:45-07:00
- **Requested**: Finish what you were doing (LogKeeper implementation and compilation resolution)
- **Exact files touched**:
  - `app/src/main/java/helium314/keyboard/settings/LogKeeperActivity.kt`
  - `app/src/main/java/helium314/keyboard/keyboard/clipboard/PromptHistoryView.kt`
  - `app/src/main/java/helium314/keyboard/keyboard/internal/keyboard_parser/floris/KeyLabel.kt`
  - `app/src/main/java/helium314/keyboard/keyboard/internal/keyboard_parser/floris/TextKeyData.kt`
  - `app/src/main/java/helium314/keyboard/latin/utils/PopupKeysUtils.kt`
  - `app/src/main/java/helium314/keyboard/keyboard/KeyboardSwitcher.java`
  - `BLUEPRINT.md`
  - `receipts/RECEIPTS_001.md`
- **What was actually done**: Completed LogKeeper viewer/exporter UI and resolved all compilation issues across PromptHistoryView, KeyLabel, TextKeyData, PopupKeysUtils, and KeyboardSwitcher.
- **How it was verified**: Full local build verified with `compile_applet` (exit code 0, `BUILD SUCCESSFUL`).
- **Deviation from requested**: None.
- **Known issue or follow-up needed**: None.

## Entry 005
- **Timestamp**: 2026-09-01T10:59:00-07:00
- **Requested**: Only English and French dictionaries in repo; prune/delete the rest
- **Exact files touched**:
  - `app/src/main/assets/dicts/*` (deleted all except `main_en-US.dict`, `main_en-GB.dict`, and `main_fr.dict`)
  - `BLUEPRINT.md`
  - `receipts/RECEIPTS_001.md`
- **What was actually done**: Removed non-English and non-French dictionary binary files from `app/src/main/assets/dicts/`, leaving only `main_en-US.dict`, `main_en-GB.dict`, and `main_fr.dict`. Maintained `dictionaries_in_dict_repo.csv` and `known_dict_hashes.txt` for post-install download and file import support.
- **How it was verified**: Local build verified with `compile_applet` (exit code 0, `BUILD SUCCESSFUL`).
- **Deviation from requested**: None.
- **Known issue or follow-up needed**: None.
