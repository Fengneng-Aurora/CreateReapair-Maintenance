package com.aurora.createram.repair

import com.simibubi.create.content.kinetics.base.KineticBlockEntity
import net.minecraft.core.BlockPos
import net.minecraft.core.Vec3i
import net.minecraft.world.entity.Entity
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.GrassBlock
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.material.Fluid
import net.minecraft.world.level.material.WaterFluid
import net.minecraft.world.phys.AABB

class KineticEnvironment(val be: KineticBlockEntity) {
    private var livingBlocks: MutableList<BlockState> = mutableListOf()
    private var waterBlocks: MutableList<BlockState> = mutableListOf()
    private var existEntities: MutableList<Entity> = mutableListOf()
    private val level: Level = be.level!!
    init {
        livingBlocks = level.getBlockStates(AABB(be.blockPos.offset(-2, -2, -2), be.blockPos.offset(2, 2, 2)))
            .filter { it.block is GrassBlock }
            .toList()
        waterBlocks = level.getBlockStates(AABB(be.blockPos.offset(-2, -2, -2), be.blockPos.offset(2, 2, 2)))
            .filter { it.block is Fluid }
            .toList()
        existEntities = level.getEntities(null, AABB(be.blockPos.offset(-2, -2, -2), be.blockPos.offset(2, 2, 2)))
    }

    fun getLivingBlocksNumber(): Int {
        return livingBlocks.size
    }

    fun getHumidity(): Int {
        return (waterBlocks.size * 0.8 + if (level.isRainingAt(be.blockPos)) 0.2 else 0.0) .toInt()
    }
}