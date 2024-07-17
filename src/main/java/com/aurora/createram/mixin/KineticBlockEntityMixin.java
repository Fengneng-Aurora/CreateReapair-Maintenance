package com.aurora.createram.mixin;

import com.simibubi.create.content.kinetics.base.KineticBlock;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import net.minecraft.nbt.CompoundTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(KineticBlockEntity.class)
class KineticBlockEntityMixin {

    @Inject(method = "write", at = @At("HEAD"), remap = false)
    protected void write(CompoundTag compound, boolean clientPacket, CallbackInfo ci) {

    }
}
