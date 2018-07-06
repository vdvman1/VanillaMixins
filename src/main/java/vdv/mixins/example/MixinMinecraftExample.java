package vdv.mixins.example;

import net.minecraft.client.Minecraft;
import net.minecraft.profiler.ISnooperInfo;
import net.minecraft.util.IThreadListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MixinMinecraftExample implements IThreadListener, ISnooperInfo {

    @Inject(method = "run", at = @At("HEAD"))
    private void onRun(CallbackInfo ci) {
        System.out.println("onRun was called, mixin working!");
    }
}
