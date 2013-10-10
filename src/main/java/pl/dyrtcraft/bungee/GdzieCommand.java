package pl.dyrtcraft.bungee;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

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
		sender.sendMessage(ChatColor.RED + "Podales/as nieprawidlowa liczbe argumentów!");
		sender.sendMessage(ChatColor.RED + "Uzycie: /gdzie <gracz>");
		DyrtCraftBungee.debug(sender.getName() + " issued DyrtCraftBungee command /gdzie or /where");
	}
	
	protected void kiedyArg(CommandSender sender, String arg) {
		ProxiedPlayer player = ProxyServer.getInstance().getPlayer(arg);
		if(isProxedPlayerOnline(player)) {
			sender.sendMessage(ChatColor.GRAY + "Gracz " + ChatColor.GOLD + player.getName() + ChatColor.GRAY + " jest teraz " + ChatColor.GREEN + "online" + ChatColor.GRAY + " na serwerze " + ChatColor.GOLD + player.getServer().getInfo().getName() + ChatColor.GRAY + ".");
			sender.sendMessage(ChatColor.GRAY + "Obecny ping gracza " + ChatColor.GOLD + player.getName() + ChatColor.GRAY + " to " + ChatColor.GOLD + player.getPing() + ChatColor.GRAY + ".");
		} else {
			sender.sendMessage(ChatColor.RED + "Gracz \"" + arg + "\" nie jest obecnie online!");
		}
		DyrtCraftBungee.debug(sender.getName() + " issued DyrtCraftBungee command /gdzie or /where " + arg);
	}
	
	protected boolean isProxedPlayerOnline(ProxiedPlayer player) {
		if(player == null || player.getServer() == null) {
			return false;
		} else {
			return true;
		}
	}
	
}
