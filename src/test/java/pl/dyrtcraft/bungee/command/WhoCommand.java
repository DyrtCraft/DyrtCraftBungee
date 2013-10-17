package pl.dyrtcraft.bungee.command;

import java.util.Map;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import pl.dyrtcraft.bungee.DyrtCraftBungee;

public class WhoCommand extends Command {

	public WhoCommand() {
		super("who", "dyrtcraft.command.who", "glist");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(args.length==0) {
			DyrtCraftBungee.debug(sender.getName() + " issued DyrtCraftBungee command /who or /glist");
			if(!(sender instanceof ProxiedPlayer)) {
				showAll(sender);
				return;
			}
			ProxiedPlayer player = (ProxiedPlayer) sender;
			show(player);
			return;
		}
		if(args.length==1) {
			DyrtCraftBungee.debug(sender.getName() + " issued DyrtCraftBungee command /who or /glist " + args[0]);
			if(args[0].equalsIgnoreCase("-ALL")) {
				showAll(sender);
				return;
			} else {
				Map<String, ServerInfo> servers = ProxyServer.getInstance().getServers();
				ServerInfo serverInfo = servers.get(args[0]);
				
				show(serverInfo, sender);
				return;
			}
		} else {
			sender.sendMessage(ChatColor.RED + "Zbyt duzo argumentów!");
			sender.sendMessage(ChatColor.RED + "Uzycie: /who [-ALL|serwer]");
			return;
		}
	}
	
	protected void show(ProxiedPlayer player) {
		Map<String, ServerInfo> servers = ProxyServer.getInstance().getServers();
		String server = player.getServer().getInfo().getName();
		int liczba = player.getServer().getInfo().getPlayers().size();
		
		StringBuilder graczeLista = new StringBuilder();
		for(ServerInfo gracze : servers.values()) {
			graczeLista.append(ChatColor.GOLD + gracze.getName());
			graczeLista.append(ChatColor.GRAY + ", ");
		}
		
		player.sendMessage(ChatColor.GRAY + "Liczba graczy na serwerze " + ChatColor.GOLD + server + ChatColor.GRAY + " to " + ChatColor.GOLD + liczba + ChatColor.GRAY + ".");
		player.sendMessage(ChatColor.GRAY + "Lista graczy " + ChatColor.GREEN + "online" + ChatColor.GRAY + ":");
		player.sendMessage(graczeLista.toString());
		player.sendMessage(ChatColor.GRAY + "Aby uzyskac wiecej informacji o danym graczu uzyj " + ChatColor.GOLD + "/gdzie <gracz>");
		return;
	}
	
	protected void showAll(CommandSender sender) {
		int liczba = ProxyServer.getInstance().getOnlineCount();
		
		sender.sendMessage(ChatColor.GRAY + "Liczba graczy na serwerowni DyrtCraft Network to " + ChatColor.GOLD + liczba + ChatColor.GRAY + ".");
		return;
	}
	
	protected void show(ServerInfo server, CommandSender sender) {
		Map<String, ServerInfo> servers = ProxyServer.getInstance().getServers();
		int liczba = server.getPlayers().size();
		
		StringBuilder graczeLista = new StringBuilder();
		for(ServerInfo gracze : servers.values()) {
			graczeLista.append(ChatColor.GOLD + gracze.getName());
			graczeLista.append(ChatColor.GRAY + ", ");
		}
		
		sender.sendMessage(ChatColor.GRAY + "Liczba graczy na serwerze " + ChatColor.GOLD + server + ChatColor.GRAY + " to " + ChatColor.GOLD + liczba + ChatColor.GRAY + ".");
		sender.sendMessage(ChatColor.GRAY + "Lista graczy " + ChatColor.GREEN + "online" + ChatColor.GRAY + ":");
		sender.sendMessage(graczeLista.toString());
		sender.sendMessage(ChatColor.GRAY + "Aby uzyskac wiecej informacji o danym graczu uzyj " + ChatColor.GOLD + "/gdzie <gracz>");
		return;
	}
	
}
