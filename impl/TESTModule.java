package club.machine.features.module.impl;

import club.machine.event.Event;
import club.machine.event.events.EventTick;
import club.machine.features.module.Module;
import club.machine.features.module.ModuleData;
import club.machine.utilities.Logger;
import org.lwjgl.input.Keyboard;

@ModuleData(name = "TEST", defaultKeyBind = Keyboard.KEY_M)
public class TESTModule extends Module {
    @Override
    public void onEvent(Event event) {
        if (event instanceof EventTick) {
            Logger.chat("tick");
        }
    }
}
