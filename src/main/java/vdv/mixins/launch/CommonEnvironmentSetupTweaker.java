package vdv.mixins.launch;

import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;

import java.io.File;
import java.util.List;

public abstract class CommonEnvironmentSetupTweaker implements ITweaker {

    private MixinEnvironment.Side side;

    protected CommonEnvironmentSetupTweaker(MixinEnvironment.Side side) {
        this.side = side;
    }

    @Override
    public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {
        MixinEnvironment.getDefaultEnvironment().setSide(side);
        Mixins.addConfiguration("mixins.examples.json");
    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader classLoader) {}

    @Override
    public String getLaunchTarget() { return ""; }

    @Override
    public String[] getLaunchArguments() { return new String[0]; }
}