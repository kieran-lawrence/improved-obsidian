package com.codebykieran.improvedobsidian.mixin;

import com.codebykieran.improvedobsidian.Constants;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    
    @Inject(at = @At("TAIL"), method = "<init>")
    private void init(CallbackInfo info) {
        
        Constants.LOG.info("Improved Obsidian Common resources!");
        Constants.LOG.info("MC Version: {}", Minecraft.getInstance().getVersionType());
    }
}