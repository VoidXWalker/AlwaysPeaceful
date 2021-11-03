package me.voidxwalker.peaceful.mixin;

import net.minecraft.client.gui.screen.world.CreateWorldScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreateWorldScreen.class)
public class CreateWorldScreenMixin {
    @Shadow public boolean hardcore;

    @Inject(method = "createLevel", at = @At("HEAD"))
    public void setHardcore(CallbackInfo ci){
        this.hardcore=false;
    }
}
