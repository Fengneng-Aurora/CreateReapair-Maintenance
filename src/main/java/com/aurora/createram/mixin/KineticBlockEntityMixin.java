package com.aurora.createram.mixin;

import com.aurora.createram.repair.aging.kinetic.KineticFactors;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.foundation.utility.Lang;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(KineticBlockEntity.class)
class KineticBlockEntityMixin {
    @Inject(method = "addStressImpactStats", at = @At(value = "HEAD", remap = false))
    protected void addStressImpactStats(List<Component> tooltip, float stressAtBase, CallbackInfo ci) {
        var factors = KineticFactors.Companion.getOrCreateFactors((KineticBlockEntity) (Object) this);
        Lang.number(factors.getAverage())
                .text("Aging")
                .style(ChatFormatting.BOLD)
                .forGoggles(tooltip);
    }

    @Inject(method = "tick", at = @At(value = "HEAD", remap = false))
    protected void tick(CallbackInfo ci) {
        var factors = KineticFactors.Companion.getOrCreateFactors((KineticBlockEntity) (Object) this);
        factors.calculate();
    }
}
