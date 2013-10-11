package pl.dyrtcraft.bungee.command;

import java.util.Map;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import pl.dyrtcraft.bungee.DyrtCraftBungee;

public class SerwerCommand extends Command {

	public SerwerCommand() {
		super("serwer", "dyrtcraft.command.serwer", "server");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(args.length==1) {
			String serverName = args[0];
			serverConnectArg(sender, serverName);
		} else {
			serversArg(sender);
			DyrtCraftBungee.debug(sender.getName() + " issued DyrtCraftBungee command /serwer or /server");
		}
	}
	
	protected void serverConnectArg(CommandSender sender, String serverName) {
		if(!(sender instanceof ProxiedPlayer)) {
			sender.sendMessage(ChatColor.RED + "Nie mozesz wykonac tego polecenia z poziomu konsoli!");
			return;
		}
		Map<String, ServerInfo> servers = ProxyServer.getInstance().getServers();
		ProxiedPlayer player = (ProxiedPlayer) sender;
		ServerInfo serverInfo = servers.get(serverName);
		
		if(servers.containsKey(serverName)) {
			DyrtCraftBungee.debug(sender.getName() + " issued DyrtCraftBungee command /serwer or /server " + serverInfo);
			sender.sendMessage(ChatColor.GRAY + "Przelaczanie na serwer " + ChatColor.GOLD + serverName + ChatColor.GRAY + "...");
			player.connect(serverInfo);
		} else {
			DyrtCraftBungee.debug(sender.getName() + " issued DyrtCraftBungee command /serwer or /server " + serverName);
			sender.sendMessage(ChatColor.RED + "Serwer " + serverName + " nie istnieje!");
			serversArg(sender);
			DyrtCraftBungee.debug("Nie znaleziono serwera " + serverName);
		}
	}
	
	protected void serversArg(CommandSender sender) {
		if(!(sender instanceof ProxiedPlayer)) {
			sender.sendMessage(ChatColor.RED + "Nie mozesz wykonac tego polecenia z poziomu konsoli!");
			return;
		}
		Map<String, ServerInfo> servers = ProxyServer.getInstance().getServers();
		
		String sender_nick = sender.getName();
		String server_sender = ProxyServer.getInstance().getPlayer(sender_nick).getServer().getInfo().getName();
		
		StringBuilder server_list = new StringBuilder();
		for(ServerInfo server : servers.values()) {
			server_list.append(ChatColor.GOLD + server.getName());
			server_list.append(ChatColor.GRAY + ", ");
		}
		
		sender.sendMessage(ChatColor.GRAY + "Obecnie jestes polaczony z serwerem: " + ChatColor.GOLD + server_sender + ChatColor.GRAY + ".");
		sender.sendMessage(ChatColor.GRAY + "Lista serwerów z którymi mozesz sie obecnie polaczyc:");
		sender.sendMessage(ChatColor.GRAY + server_list.toString());
		sender.sendMessage(ChatColor.GRAY + "Aby przejsc na wybrany serwer uzyj " + ChatColor.GOLD + "/serwer <nazwa>" + ChatColor.GRAY + "!");
	}
	
	
	
}
