package club.machine.features.module;

import club.machine.utilities.Logger;
import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ModuleManager {
    private final List<Module> modules;

    public ModuleManager() {
        modules = new ArrayList<>();
    }

    public void init() {
        try {
            // Search for package and collect classes.
            Set<Class<? extends Module>> classes = new Reflections("").getSubTypesOf(Module.class);
            for (Class<? extends Module> clazz : classes) {
                Module module = clazz.newInstance();
                this.registerModule(module);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerModule(Module module) {
        this.modules.add(module);
        Logger.info("Added Module - " + module.getModuleData().name());
    }

    public boolean isEnabled(Class<?> clazz) {
        Module module = this.getModuleByClass(clazz);
        return (module != null && module.isEnabled());
    }

    public Module getModuleByClass(Class<?> clazz) {
        for (Module module : this.modules) {
            if (module.getClass() == clazz) {
                return module;
            }
        }
        return null;
    }

    public Module getModuleByString(String name) {
        for (Module module : this.modules) {
            if (module.getModuleData().name().replaceAll(" ", "").equalsIgnoreCase(name.toLowerCase())) {
                return module;
            }
        }
        return null;
    }

    public ArrayList<Module> getModulesByCategory(Category cat) {
        ArrayList<Module> mods = new ArrayList<>();
        for (Module module : getModules()) {
            if (module.getModuleData().category() == cat) {
                mods.add(module);
            }
        }
        return mods.isEmpty() ? null : mods;
    }

    public List<Module> getModules() {
        return modules;
    }
}
