package pl.dyrtcraft.bungee.command;

import pl.dyrtcraft.bungee.DyrtCraftBungee;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class StaffCommand extends Command {
	
	public StaffCommand() {
		super("staff", "dyrtcraft.command.staff", "admini");
	}
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		DyrtCraftBungee.debug(sender.getName() + " issued DyrtCraftBungee command /gdzie or /where"); // Debug
		
		if(args.length == 1) {
			if(args[0].equalsIgnoreCase("-ALL")) {
				all(sender);
				return;
			} else {
				server(sender, args[0].toLowerCase());
				return;
			}
		} else {
			if(!(sender instanceof ProxiedPlayer)) {
				all(sender);
				return;
			}
			String server = BungeeCord.getInstance().getPlayer(sender.getName()).getServer().getInfo().getName();
			server(sender, server);
			return;
		}
	}
	
	private void all(CommandSender sender) {
		sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + " ---------- " + ChatColor.DARK_GREEN + "Administracja online" + ChatColor.GOLD + " ---------- ");
		
		StringBuilder str = new StringBuilder();
		for(ProxiedPlayer players : BungeeCord.getInstance().getPlayers()) {
			if(players.hasPermission("dyrtcraft.staff")) {
				str.append(ChatColor.DARK_GRAY + players.getName() + ChatColor.GOLD + " (" + players.getServer().getInfo().getName() + ")");
				str.append(ChatColor.GOLD + ", ");
			}
		}
	}
	
	private void server(CommandSender sender, String server) {
		sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + " ---------- " + ChatColor.DARK_GREEN + "Administracja online" + ChatColor.GOLD + " ---------- ");
		
		if(BungeeCord.getInstance().getServerInfo(server) == null) {
			sender.sendMessage(ChatColor.RED + "Nie znaleziono serwera o nazwie \"" + server + "\"!");
			return;
		}
		
		StringBuilder str = new StringBuilder();
		for(ProxiedPlayer players : BungeeCord.getInstance().getServerInfo(server).getPlayers()) {
			if(players.hasPermission("dyrtcraft.staff")) {
				str.append(ChatColor.DARK_GRAY + players.getName());
				str.append(ChatColor.GOLD + ", ");
			}
		}
		sender.sendMessage(str.toString());
	}
	
}
