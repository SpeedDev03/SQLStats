package speeddev.info.stats.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;
import speeddev.info.stats.Stats;

public class StatsCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player) {
			  if (cmd.getName().equalsIgnoreCase("stats")) {
				  
				  Player p = (Player) sender;
				  int deaths = Stats.getDeaths(p.getUniqueId().toString());
				  int kills = Stats.getKills(p.getUniqueId().toString());
				  double kd = kills;
					
					if(deaths > 0) {
						kd = (double)kills/deaths;
					}
				  
				  if (args.length == 0) {
					  p.sendMessage("§0--- §9[Statistics§9] §0---");
					  p.sendMessage("§fName: " + ChatColor.GOLD + p.getName());
					  p.sendMessage("§fKills: " + ChatColor.GOLD + kills);
					  p.sendMessage("§fDeaths: " + ChatColor.GOLD + deaths);
					  p.sendMessage("§fK/D Ratio: " + ChatColor.GOLD + kd);					  
					  return true;
						  }
				  
				  @SuppressWarnings("deprecation")
					Player target = Bukkit.getServer().getPlayer(args[0]);
				  int deaths1 = Stats.getDeaths(p.getUniqueId().toString());
				  int kills1 = Stats.getKills(p.getUniqueId().toString());
				  double kd1 = kills1;
					
					if(deaths1 > 0) {
						kd1 = (double)kills1/deaths1;
					}
				  
				  p.sendMessage("§0--- §9[Statistics] §0---");
    			  p.sendMessage("§fName: " + ChatColor.GOLD + target.getName());
    			  p.sendMessage("§fKills: " + ChatColor.GOLD + kills1);
    			  p.sendMessage("§fDeaths: " + ChatColor.GOLD + deaths1);
    			  p.sendMessage("§fK/D Ratio: " + ChatColor.GOLD + kd1);
    			  return true;
			  }
			
		} else {
			sender.sendMessage(ChatColor.RED + "Only players can use this command!");
		}
		
		
		return true;
	}

}
