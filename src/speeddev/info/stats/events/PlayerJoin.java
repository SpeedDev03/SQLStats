package speeddev.info.stats.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import speeddev.info.stats.Stats;

public class PlayerJoin implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		Stats.createPlayer(e.getPlayer().getUniqueId().toString());
	}

}
