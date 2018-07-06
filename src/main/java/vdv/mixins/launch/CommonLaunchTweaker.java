package vdv.mixins.launch;

import com.google.common.base.Strings;
import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class CommonLaunchTweaker implements ITweaker {
    private List<String> arguments = new ArrayList<>();

    protected abstract Class<? extends ITweaker> environmentTweaker();

    @Override
    public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {
        this.arguments.addAll(args);
        if (gameDir != null) {
            this.arguments.add("--gameDir");    this.arguments.add(gameDir.getPath());
        }
        if (assetsDir != null) {
            this.arguments.add("--assetsDir");  this.arguments.add(assetsDir.getPath());
        }
        if (!Strings.isNullOrEmpty(profile)) {
            this.arguments.add("--version");    this.arguments.add(profile);
        }
        @SuppressWarnings("unchecked")
        List<String> tweakers = (List<String>) Launch.blackboard.get("TweakClasses");
        tweakers.add("org.spongepowered.asm.launch.MixinTweaker");
        tweakers.add(environmentTweaker().getName());
    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader classLoader) {}

    @SuppressWarnings("unchecked")
    @Override
    public String[] getLaunchArguments() {
        return arguments.toArray(new String[arguments.size()]);
//        List<String> list = new ArrayList<>();
//        List<String> args = (List<String>) Launch.blackboard.get("ArgumentList");
//        if(args == null)
//            args = new ArrayList<>();
//        for(int i = 0; i < this.arguments.size(); i+=2){
//            String s = this.arguments.get(i);
//            if(s.startsWith("--")){
//                if(!args.contains(s)){
//                    list.add(s);
//                    list.add(this.arguments.get(i+1));
//                }
//            }else{
//                i--;
//            }
//        }
//        return list.toArray(new String[list.size()]);
    }
}
