package vdv.mixins.launch.client;

import org.spongepowered.asm.mixin.MixinEnvironment;
import vdv.mixins.launch.CommonEnvironmentSetupTweaker;

public class EnvironmentSetupTweaker extends CommonEnvironmentSetupTweaker {
    public EnvironmentSetupTweaker() {
        super(MixinEnvironment.Side.CLIENT);
    }
}
