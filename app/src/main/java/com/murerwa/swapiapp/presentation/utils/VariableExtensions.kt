package com.murerwa.swapiapp.presentation.utils

import java.text.NumberFormat
import java.util.*

fun String.getYear() = this.substring(0, 4)

fun Number.commaSeparated(): String {
    return NumberFormat.getNumberInstance(Locale.US).format(this)
}