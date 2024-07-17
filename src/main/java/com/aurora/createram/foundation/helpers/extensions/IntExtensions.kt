package com.aurora.createram.foundation.helpers.extensions

import net.minecraft.util.Mth

object IntExtensions {
    infix fun Int.reduce(percentage: Double): Double {
        return this * (1 - Mth.clamp(percentage, 0.0, 1.0))
    }

    infix fun Int.percentOf(percentage: Double): Double {
        return this * Mth.clamp(percentage, 0.0, 1.0)
    }
}