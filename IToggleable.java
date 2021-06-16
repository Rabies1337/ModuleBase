package club.machine.features.module;

public interface IToggleable {
    void toggle();

    void onEnable();

    void onDisable();

    boolean isEnabled();
}
