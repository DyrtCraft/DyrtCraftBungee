package pl.dyrtcraft.bungee.command;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import pl.dyrtcraft.bungee.DyrtCraftBungee;

public class GdzieCommand extends Command {

	public GdzieCommand() {
		super("gdzie", "dyrtcraft.command.gdzie", "where");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(args.length==1) {
			kiedyArg(sender, args[0]);
		} else {
			erArg(sender);
		}
	}
	
	protected void erArg(CommandSender sender) {
		DyrtCraftBungee.debug(sender.getName() + " issued DyrtCraftBungee command /gdzie or /where"); // Debug
		sender.sendMessage(ChatColor.RED + "Podales/as nieprawidlowa liczbe argumentów!");
		sender.sendMessage(ChatColor.RED + "Uzycie: /gdzie <gracz>");
	}
	
	protected void kiedyArg(CommandSender sender, String arg) {
		ProxiedPlayer player = ProxyServer.getInstance().getPlayer(arg);
		if(GdzieCommand.isProxedPlayerOnline(player)) {
			DyrtCraftBungee.debug(sender.getName() + " issued DyrtCraftBungee command /gdzie or /where " + arg); // Debug
			sender.sendMessage(ChatColor.GRAY + "Gracz " + ChatColor.GOLD + player.getName() + ChatColor.GRAY + " jest teraz " + ChatColor.GREEN + "online" + ChatColor.GRAY + " na serwerze " + ChatColor.GOLD + player.getServer().getInfo().getName() + ChatColor.GRAY + ".");
			if(sender.hasPermission("dyrtcraft.operator")) {
				sender.sendMessage(ChatColor.GOLD + "========== Operator ==========");
				sender.sendMessage(ChatColor.GRAY + "Ping: " + ChatColor.GOLD + player.getPing() + ChatColor.GRAY + ".");
				sender.sendMessage(ChatColor.GRAY + "IP: " + ChatColor.GOLD + player.getAddress());
				sender.sendMessage(ChatColor.GRAY + "Grupa: " + ChatColor.GOLD + player.getGroups());
			}
		} else {
			DyrtCraftBungee.debug(sender.getName() + " issued DyrtCraftBungee command /gdzie or /where " + arg); // Debug
			sender.sendMessage(ChatColor.GRAY + "Gracz " + ChatColor.GOLD + arg + ChatColor.GRAY + " jest teraz " + ChatColor.RED + "offline" + ChatColor.GRAY + "!");
		}
	}
	
	public static boolean isProxedPlayerOnline(ProxiedPlayer player) {
		if(player == null || player.getServer() == null) {
			return false;
		} else {
			return true;
		}
	}
	
}
