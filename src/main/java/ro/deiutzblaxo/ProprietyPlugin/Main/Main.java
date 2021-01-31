package ro.deiutzblaxo.ProprietyPlugin.Main;

import org.bukkit.plugin.java.JavaPlugin;

import ro.deiutzblaxo.ProprietyPlugin.EventHandler.BuildEvent;
import ro.deiutzblaxo.ProprietyPlugin.EventHandler.InteractEvent;
import ro.deiutzblaxo.ProprietyPlugin.EventHandler.PlayerMoveEvent;
import ro.deiutzblaxo.ProprietyPlugin.EventHandler.PlayerQuit;
import ro.deiutzblaxo.ProprietyPlugin.Land.LandService;
import ro.deiutzblaxo.ProprietyPlugin.Selection.SelectorService;

public class Main extends JavaPlugin {

	public static SelectorService selectorService = new SelectorService();
	public static LandService landService = new LandService();
	public void onEnable() {

		getCommand("test").setExecutor(new TestExecutor());
		this.getServer().getPluginManager().registerEvents(new InteractEvent(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
		this.getServer().getPluginManager().registerEvents(new PlayerMoveEvent(), this);
		this.getServer().getPluginManager().registerEvents(new BuildEvent(), this);
	}

}
