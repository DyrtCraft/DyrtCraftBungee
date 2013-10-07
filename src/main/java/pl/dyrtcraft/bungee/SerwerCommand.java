package pl.dyrtcraft.bungee;

import java.util.Map;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class SerwerCommand extends Command {

	public SerwerCommand() {
		super("serwer", "dyrtcraft.command.serwer");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(args.length==1) {
			String serverName = args[0];
			serverConnectArg(sender, serverName);
		} else {
			serversArg(sender);
			DyrtCraftBungee.debug(sender.getName() + " issued BungeeCord command /serwer");
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
			sender.sendMessage(ChatColor.GRAY + "Przelaczanie na serwer " + ChatColor.GOLD + serverName + ChatColor.GRAY + "...");
			player.connect(serverInfo);
			DyrtCraftBungee.debug(sender.getName() + " issued DyrtCraftBungee command /serwer " + serverInfo);
		} else {
			sender.sendMessage(ChatColor.RED + "Serwer " + serverName + " nie istnieje!");
			serversArg(sender);
			DyrtCraftBungee.debug(sender.getName() + " issued DyrtCraftBungee command /serwer " + serverName);
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
		String server_sender = ProxyServer.getInstance().getPlayer(sender_nick).getServer().getInfo().toString();
		
		StringBuilder server_list = new StringBuilder();
		for(ServerInfo server : servers.values()) {
			server_list.append(ChatColor.GOLD + server.getName());
			server_list.append(ChatColor.GRAY + ", ");
		}
		
		sender.sendMessage(ChatColor.GRAY + "Obecnie jestes polaczony z serwerem: " + ChatColor.GOLD + server_sender);
		sender.sendMessage(ChatColor.GRAY + "Lista serwerów z którymi mozesz sie obecnie polaczyc:");
		sender.sendMessage(ChatColor.GRAY + server_list.toString());
		sender.sendMessage(ChatColor.GRAY + "Aby przejsc na wybrany serwer uzyj " + ChatColor.GOLD + "/serwer <nazwa>");
	}
	
	
	
}
