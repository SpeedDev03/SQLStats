package speeddev.info.stats.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import speeddev.info.stats.Stats;

public class PlayerDeath implements Listener {
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		Player p = (Player) e.getEntity();
		
		if(p.getKiller() instanceof Player) {
			Stats.addDeaths(p.getUniqueId().toString(), 1);
		    Stats.addKills(p.getKiller().getUniqueId().toString(), 1);
		
		} else {
			Stats.addDeaths(p.getUniqueId().toString(), 1);
		}
	}

}
