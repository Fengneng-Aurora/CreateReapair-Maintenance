package com.aurora.createram.repair.aging.kinetic

import com.aurora.createram.repair.KineticEnvironment
import com.simibubi.create.content.kinetics.base.KineticBlockEntity
import net.minecraft.util.Mth
import net.minecraft.world.level.block.entity.BlockEntity

class KineticFactors {
    private var env: KineticEnvironment? = null
    companion object {
        val FACTORS_SYMBOL = "AgingFactors"

        fun getOrCreateFactors(blockEntity: KineticBlockEntity): KineticFactors {
            if (!blockEntity.persistentData.contains(FACTORS_SYMBOL))
                return KineticFactors()
            return KineticFactors(blockEntity.persistentData.getIntArray(FACTORS_SYMBOL), KineticEnvironment(blockEntity))
        }
    }

    fun calculate() {
        calculateAbrasion()
        calculateDeformation()
        calculateVibration()
        calculateFatigue()
        calculateErosion()
        calculateCrack()
        calculateTemperature()
        calculateAverage()
    }
    constructor() {
    }

    constructor(factors: IntArray, env: KineticEnvironment) {
        this.env = env
        var count = 0
        this.average = factors[count]; count++
        this.abrasion = factors[count]; count++
        this.deformation = factors[count]; count++
        this.vibration = factors[count]; count++
        this.fatigue = factors[count]; count++
        this.crack = factors[count]; count++
        this.temperature = factors[count]; count++

        this.lubrication = factors[count]; count++
        this.gasket = factors[count]; count++
        this.bracket = factors[count]; count++
        this.temperature = factors[count]
        calculate()
    }

    var average: Int = 0

    var abrasion: Int = 0
        set(value) { field = Mth.clamp(value, 0, 100) }
    var deformation: Int = 0
        set(value) { field = Mth.clamp(value, 0, 100) }
    var vibration: Int = 0
        set(value) { field = Mth.clamp(value, 0, 100) }
    var fatigue: Int = 0
        set(value) { field = Mth.clamp(value, 0, 100) }
    var erosion: Int = 0
        set(value) { field = Mth.clamp(value, 0, 100) }
    var crack: Int = 0
        set(value) { field = Mth.clamp(value, 0, 100) }
    var temperature: Int = 0
        set(value) { field = Mth.clamp(value, -100, 100) }
    //A D V F E C T advfect

    var lubrication: Int = 0
        set(value) { field = Mth.clamp(value, 0, 100) }
    var gasket: Int = 0
        set(value) { field = Mth.clamp(value, 0, 100) }
    var bracket: Int = 0
        set(value) { field = if (value >= 50) 100 else 0}
    var shell: Int = 0
        set(value) { field = Mth.clamp(value, 0, 100) }
    var layer: Int = 0
        set(value) { field = Mth.clamp(value, 0, 100) }

    open fun calculateAverage() {}

    open fun calculateAbrasion() {}

    open fun calculateDeformation() {}

    open fun calculateVibration() {}

    open fun calculateFatigue() {}

    open fun calculateErosion() {}

    open fun calculateCrack() {}

    open fun calculateTemperature() {}

    fun toArray(): List<Int> {
        return listOf(average, abrasion, deformation, vibration, fatigue, erosion, crack, temperature,
            lubrication, gasket, bracket, shell, layer)
    }
}