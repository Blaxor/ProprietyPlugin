package ro.deiutzblaxo.ProprietyPlugin.Main;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import java.util.Collection;
import java.util.List;

public class Util {

    /**
     * Registers an event if a certain condition is met
     *
     * @param listener  - Listener to be registered
     * @param condition - Condition to be met when registering wanted listener
     */
    protected  final void registerEventIf(Listener listener, boolean condition) {
        if (condition) registerEvent(listener);
    }

    /**
     * Registers an event
     *
     * @param listener - Listener to be registered
     */
    protected final void registerEvent(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, Main.instance);
    }

    /**
     * Registers a list of listeners
     *
     * @param listeners - The list of listeners which have to be registered
     */
    protected final void registerEvents(Collection<? extends Listener> listeners) {
        listeners.forEach(this::registerEvent);
    }

    /**
     * Registers each listener in a list of listeners if a certain condition is met
     *
     * @param listeners - The list of listeners which have to be registered
     * @param condition - Condition to be met when registering wanted listener
     */
    protected  final void registerEventsIf(List<Listener> listeners, boolean condition) {
        listeners.forEach(listener -> registerEventIf(listener, condition));
    }
}
