package me.voidxwalker.peaceful.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.ResourcePackManager;
import net.minecraft.resource.ServerResourceManager;
import net.minecraft.world.Difficulty;
import net.minecraft.world.SaveProperties;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.IntegratedResourceManager.class)
public class MinecraftClientIntegratedResourceManagerMixin {
    @Mutable
    @Shadow @Final private SaveProperties saveProperties;

    @Inject(method = "<init>(Lnet/minecraft/resource/ResourcePackManager;Lnet/minecraft/resource/ServerResourceManager;Lnet/minecraft/world/SaveProperties;)V", at = @At("TAIL"))
    public void setPeaceful(ResourcePackManager resourcePackManager, ServerResourceManager serverResourceManager, SaveProperties saveProperties, CallbackInfo ci){
        saveProperties.setDifficulty(Difficulty.PEACEFUL);
        saveProperties.setDifficultyLocked(true);
        this.saveProperties=saveProperties;
    }
}
