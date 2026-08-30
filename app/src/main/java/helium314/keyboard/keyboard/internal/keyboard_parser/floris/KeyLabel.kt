/*
 * Copyright (C) 2021 Patrick Goldinger
 * modified
 * SPDX-License-Identifier: Apache-2.0 AND GPL-3.0-only
 */
package helium314.keyboard.keyboard.internal.keyboard_parser.floris

import helium314.keyboard.keyboard.internal.KeyboardParams

object KeyLabel {
    const val SHIFT = "shift"
    const val DELETE = "delete"
    const val SYMBOL_ALPHA = "symbol_alpha"
    const val SYMBOL = "symbol"
    const val ALPHA = "alpha"
    const val COMMA = "comma"
    const val PERIOD = "period"
    const val LANGUAGE_SWITCH = "language_switch"
    const val NUMPAD = "numpad"
    const val DPAD = "dpad"
    const val SPACE = "space"
    const val ACTION = "action"
    const val COM = "com"
    const val CTRL = "ctrl"
    const val ALT = "alt"
    const val FN = "fn"
    const val META = "meta"
    const val EMOJI_SEARCH = "emoji_search"
    const val CURRENCY = "currency"
    const val ZWNJ = "zwnj"
    const val ZWJ = "zwj"

    fun convertFlorisLabel(label: String?): String? {
        if (label == null) return null
        return keyLabelToActualLabel(label)
    }

    fun keyLabelToActualLabel(label: String, params: KeyboardParams? = null): String {
        return when (label) {
            "\\n" -> "\n"
            "\\t" -> "\t"
            "\\u0020" -> " "
            "\\u200C" -> "\u200C"
            "\\u200D" -> "\u200D"
            else -> label
        }
    }

    fun rtlLabel(label: String, isRtl: Boolean): String {
        if (!isRtl) return label
        return when (label) {
            "(" -> ")"
            ")" -> "("
            "[" -> "]"
            "]" -> "["
            "{" -> "}"
            "}" -> "{"
            "<" -> ">"
            ">" -> "<"
            "«" -> "»"
            "»" -> "«"
            else -> label
        }
    }
}

fun String.convertFlorisLabel(): String = KeyLabel.convertFlorisLabel(this) ?: this
fun String.rtlLabel(params: KeyboardParams): String = KeyLabel.rtlLabel(this, params.mId.subtype.isRtlSubtype)
fun String.rtlLabel(isRtl: Boolean): String = KeyLabel.rtlLabel(this, isRtl)
