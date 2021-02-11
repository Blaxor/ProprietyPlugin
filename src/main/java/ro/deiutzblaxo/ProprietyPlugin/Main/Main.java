package ro.deiutzblaxo.ProprietyPlugin.Main;


import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import ro.deiutzblaxo.ProprietyPlugin.EventHandler.BuildEvent;
import ro.deiutzblaxo.ProprietyPlugin.EventHandler.InteractEvent;
import ro.deiutzblaxo.ProprietyPlugin.EventHandler.PlayerMoveEvent;
import ro.deiutzblaxo.ProprietyPlugin.EventHandler.PlayerQuit;
import ro.deiutzblaxo.ProprietyPlugin.Land.LandService;
import ro.deiutzblaxo.ProprietyPlugin.Selection.SelectorService;

import java.util.ArrayList;
import java.util.Arrays;

public class Main extends JavaPlugin {

	public static final SelectorService selectorService = new SelectorService();
	public static final LandService landService = new LandService();
	public static Main instance;
	private final ArrayList<Listener> events = (ArrayList<Listener>) Arrays.asList(new InteractEvent(),new PlayerQuit(),new PlayerMoveEvent(), new BuildEvent());
	private final Util utils = new Util();
	public void onEnable() {
		instance = this;
		utils.registerEvents(events);
		getCommand("test").setExecutor(new TestExecutor());
	}




}
