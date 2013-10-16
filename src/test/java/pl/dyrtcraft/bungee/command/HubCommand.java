package pl.dyrtcraft.bungee.command;

import pl.dyrtcraft.bungee.DyrtCraftBungee;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class HubCommand extends Command {
	
	ServerInfo serverInfo = ProxyServer.getInstance().getServers().get("lobby");
	
	public HubCommand() {
		super("hub", "dyrtcraft.command.hub", "lobby");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		// Liczba argumentow - 0
		if(args.length == 0) {
			DyrtCraftBungee.debug(sender.getName() + " issued DyrtCraftBungee command /hub or /lobby");
			// Jezeli wyslano z konsoli
			if(!(sender instanceof ProxiedPlayer)) {
				sender.sendMessage(ChatColor.RED + "Nie mozesz wykonac tego polecenia z poziomu konsoli!");
				return;
			}
			// Jezeli wyslal gracz
			ProxiedPlayer player = (ProxiedPlayer) sender;
			// Polacz z serwerem lobby
			player.connect(serverInfo);
			return;
		}
		// Liczba argumentow - 1
		if(args.length == 1) {
			// Argument 0: -all
			if(args[0].equalsIgnoreCase("-ALL")) {
				DyrtCraftBungee.debug(sender.getName() + " issued DyrtCraftBungee command /hub or /lobby -ALL");
				// Jezeli sender nie jest operatorem serwera
				if(!(sender.hasPermission("dyrtcraft.command.hub.kickall"))) {
					sender.sendMessage(ChatColor.RED + "Ojj, brak odpowiednich uprawnien!");
					return;
				}
				// Jezeli wyslano z konsoli
				if(!(sender instanceof ProxiedPlayer)) {
					sender.sendMessage(ChatColor.RED + "Nie mozesz wykonac tego polecenia z poziomu konsoli!");
					return;
				}
				ProxiedPlayer player = (ProxiedPlayer) sender;
				// For: gracze to wszyscy gracze na serwerze
				for(ProxiedPlayer gracze : ProxyServer.getInstance().getServerInfo(player.getServer().getInfo().getName()).getPlayers()) {
					// Wiadomosc do wysylacacego (operatora)
					sender.sendMessage(ChatColor.RED + "Wyrzucanie wszystkich graczy z serwera...");
					// Polacz z serwerem lobby
					gracze.sendMessage(ChatColor.GRAY + "Przelaczanie na serwer " + ChatColor.GOLD + "Lobby" + ChatColor.GRAY + "...");
					player.connect(serverInfo);
					player.sendMessage(ChatColor.GOLD + "Zostales przeniesiony na serwer Lobby.");
					return;
				}
			// Jezeli argument 0 to nie: -all
			} else {
				// Pobieranie gracza z listy graczy online
				DyrtCraftBungee.debug(sender.getName() + " issued DyrtCraftBungee command /hub or /lobby " + args[0]);
				ProxiedPlayer gracz = ProxyServer.getInstance().getPlayer(args[0]);
				// Jezeli sender nie jest operatorem serwera
				if(!(sender.hasPermission("dyrtcraft.command.hub.player"))) {
					sender.sendMessage(ChatColor.RED + "Ojj, brak odpowiednich uprawnien!");
					return;
				}
				// Jezeli pobrany gracz nie jest online na serwerze
				if(gracz == null) {
		        	sender.sendMessage(ChatColor.RED + "Gracz \"" + args[0] + "\" nie jest obecnie na serwerze!");
		        	return;
				}
				// Polacz z serwerem lobby
				gracz.sendMessage(ChatColor.GRAY + "Przelaczanie na serwer " + ChatColor.GOLD + "Lobby" + ChatColor.GRAY + "...");
				gracz.connect(serverInfo);
				return;
			}
		// Liczba argumentow nie zostala spelniona
		} else {
			sender.sendMessage(ChatColor.RED + "Zbyt duzo argumentów!");
			sender.sendMessage(ChatColor.RED + "Uzycie: /lobby [-ALL|gracz]");
			return;
		}
	}
	
}
