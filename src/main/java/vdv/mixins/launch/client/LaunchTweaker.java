package vdv.mixins.launch.client;

import net.minecraft.launchwrapper.ITweaker;
import vdv.mixins.launch.CommonLaunchTweaker;

public class LaunchTweaker extends CommonLaunchTweaker {

    @Override
    public String getLaunchTarget() {
        return "net.minecraft.client.main.Main";
    }

    @Override
    protected Class<? extends ITweaker> environmentTweaker() {
        return EnvironmentSetupTweaker.class;
    }
}
