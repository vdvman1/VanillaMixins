package vdv.mixins.launch.server;

import net.minecraft.launchwrapper.ITweaker;
import vdv.mixins.launch.CommonLaunchTweaker;

public class LaunchTweaker extends CommonLaunchTweaker {
    @Override
    public String getLaunchTarget() {
        return "net.minecraft.server.MinecraftServer";
    }

    @Override
    protected Class<? extends ITweaker> environmentTweaker() {
        return EnvironmentSetupTweaker.class;
    }
}
