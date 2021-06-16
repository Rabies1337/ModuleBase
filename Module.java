package club.machine.features.module;

import club.machine.Client;
import club.machine.event.Event;
import club.machine.event.Listener;
import club.machine.utilities.IMC;

import java.util.LinkedHashMap;
import java.util.Map;

public class Module implements IToggleable, IMC, Listener {
    private final ModuleData moduleData;
    private boolean toggled;
    private int keyBind;

    public Module() {
        this.moduleData = this.getClass().getAnnotation(ModuleData.class);
        this.keyBind = this.moduleData.defaultKeyBind();
    }

    @Override
    public void toggle() {
        if (mc.player == null || mc.world == null) {
            return;
        }

        this.toggled = !this.toggled;
//        mc.timer.setTimerSpeed(1.0F);

        if (this.toggled) {
            this.setEnable();
        } else {
            this.setDisable();
        }
    }

    public void setEnable() {
        this.onEnable();
        Client.getEventManager().register(this);
    }

    public void setDisable() {
        this.onDisable();
        Client.getEventManager().unregister(this);
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }

    @Override
    public void onEvent(Event event) {
    }

    @Override
    public boolean isEnabled() {
        return this.toggled;
    }

    public int getKeyBind() {
        return keyBind;
    }

    public void setKeyBind(int keyBind) {
        this.keyBind = keyBind;
    }

    public ModuleData getModuleData() {
        return moduleData;
    }
}
