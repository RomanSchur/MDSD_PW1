package com.example.pw1_2.data
import kotlin.math.acos
import kotlin.math.round
import kotlin.math.tan
class Calculator {
    fun calculatePowerAdvanced(activePowerStr: String,cosPhi1Str: String,cosPhi2Str: String): Double {
        val p = activePowerStr.toDoubleOrNull() ?: 0.0
        val cos1 = cosPhi1Str.toDoubleOrNull() ?: 0.0
        val cos2 = cosPhi2Str.toDoubleOrNull() ?: 0.0

        if (p <= 0.0 || cos1 !in 0.1..0.99 || cos2 !in 0.1..1.0 || cos1 >= cos2) {
            return 0.0
        }
        val tanPhi1 = tan(acos(cos1))
        val tanPhi2 = tan(acos(cos2))
        val qc = p * (tanPhi1 - tanPhi2)

        return round(qc * 100) / 100.0
    }
}