package speeddev.info.stats;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import speeddev.info.stats.commands.StatsCommand;
import speeddev.info.stats.events.PlayerDeath;
import speeddev.info.stats.events.PlayerJoin;

public class Main extends JavaPlugin {
	
	public static MySQL mysql;
	
	public void onEnable() {
		ConnectMySQL();
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
		this.getCommand("stats").setExecutor(new StatsCommand());
	}
	
	private void ConnectMySQL() {
		mysql = new MySQL("localhost", "test", "test", "420");
		mysql.update("CREATE TABLE IF NOT EXISTS Stats(UUID varchar(64), KILLS int, DEATHS int);");
	}

}
