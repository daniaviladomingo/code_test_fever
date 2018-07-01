package com.test.data.random

import java.util.*

internal var DATA = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
internal var RANDOM = Random()

fun randomName(len: Int): String {
    val sb = StringBuilder(len)

    for (i in 0 until len) {
        sb.append(DATA[RANDOM.nextInt(DATA.length)])
    }

    return sb.toString()
}