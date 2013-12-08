package pl.dyrtcraft.bungee.command;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class FriendsCommand extends Command {

	public FriendsCommand() {
		super("friends", "dyrtcraft.command.friends", "fr");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(!(sender instanceof ProxiedPlayer)) {
			sender.sendMessage(ChatColor.RED + "System znajomych jest dostepny tylko dla graczy 'in-game'!");
			return;
		}
		
		ProxiedPlayer cmdSender = (ProxiedPlayer) sender;
		if(args.length == 0) {
			friends(cmdSender);
		}
		if(args.length == 2) {
			if(args[0].equalsIgnoreCase("akceptuj") || args[0].equalsIgnoreCase("accept")) {
				cmdSender.sendMessage(ChatColor.RED + "Przykro mi, lecz nie podales nicku gracza! :(");
				cmdSender.sendMessage(ChatColor.GOLD + "Podaj jego nick uzywajac /fr akceptuj <nick>");
			}
			if(args[0].equalsIgnoreCase("lista") || args[0].equalsIgnoreCase("list") || args[0].equalsIgnoreCase("l")) {
				friends(cmdSender);
			}
			if(args[0].equalsIgnoreCase("odmow") || args[0].equalsIgnoreCase("odmów") || args[0].equalsIgnoreCase("deny")) {
				cmdSender.sendMessage(ChatColor.RED + "Przykro mi, lecz nie podales nicku gracza! :(");
				cmdSender.sendMessage(ChatColor.GOLD + "Podaj jego nick uzywajac /fr odmow <nick>");
			}
			if(args[0].equalsIgnoreCase("pomoc") || args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("?")) {
				showHelp(cmdSender);
			}
			if(args[0].equalsIgnoreCase("wyrzuc") || args[0].equalsIgnoreCase("kick")) {
				cmdSender.sendMessage(ChatColor.RED + "Przykro mi, lecz nie podales nicku gracza! :(");
				cmdSender.sendMessage(ChatColor.GOLD + "Podaj jego nick uzywajac /fr wyrzuc <nick>");
			}
			if(args[0].equalsIgnoreCase("zapros") || args[0].equalsIgnoreCase("invite")) {
				cmdSender.sendMessage(ChatColor.RED + "Przykro mi, lecz nie podales nicku gracza! :(");
				cmdSender.sendMessage(ChatColor.GOLD + "Podaj jego nick uzywajac /fr zapros <nick>");
			}
			if(args[0].equalsIgnoreCase("zaproszenia") || args[0].equalsIgnoreCase("fr") || args[0].equalsIgnoreCase("friends")) {
				unknownFriends(cmdSender);
			} else {
				cmdSender.sendMessage(ChatColor.RED + "Przykro mi, lecz nie zrozumialem polecenia \"" + args[0] + "\". :(");
				cmdSender.sendMessage(ChatColor.GOLD + "Aby uzyskac pomoc systemu znajomych uzyj komendy /fr pomoc!");
			}
		}
		if(args.length == 3) {
			ProxiedPlayer player = ProxyServer.getInstance().getPlayer(args[1]);
			if(player == null || player.getServer() == null) {
				sender.sendMessage(ChatColor.RED + "Przykro mi, lecz gracz \"" + player + "\" nie jest obecnie online!");
			} else {
				if(args[0].equalsIgnoreCase("akceptuj") || args[0].equalsIgnoreCase("accept")) {
					accept(cmdSender, player);
				}
				if(args[0].equalsIgnoreCase("odmow") || args[0].equalsIgnoreCase("odmów") || args[0].equalsIgnoreCase("deny")) {
					deny(cmdSender, player);
				}
				if(args[0].equalsIgnoreCase("wyrzuc") || args[0].equalsIgnoreCase("kick")) {
					kick(cmdSender, player);
				}
				if(args[0].equalsIgnoreCase("zapros") || args[0].equalsIgnoreCase("invite")) {
					invite(cmdSender, player);
				} else {
					cmdSender.sendMessage(ChatColor.RED + "Przykro mi, lecz nie zrozumialem polecenia \"" + args[0] + "\". :(");
					cmdSender.sendMessage(ChatColor.GOLD + "Aby uzyskac pomoc systemu znajomych uzyj komendy /fr pomoc!");
				}
			}
		} else {
			cmdSender.sendMessage(ChatColor.RED + "Przykro mi, lecz podales zbyt duzo polecen! (" + args.toString() + ") :(");
			cmdSender.sendMessage(ChatColor.GOLD + "Aby uzyskac pomoc systemu znajomych uzyj komendy /fr pomoc!");
		}
	}
	
	private void showHelp(ProxiedPlayer cmdSender) {
		cmdSender.sendMessage(ChatColor.GOLD + " ===== Centrum pomocy systemu znajomych w DyrtCraft Network ===== ");
		cmdSender.sendMessage(ChatColor.GOLD + "/fr akceptuj <nick> " + ChatColor.GRAY + "- Akceptuj zaproszenie do gracza");
		cmdSender.sendMessage(ChatColor.GOLD + "/fr lista " + ChatColor.GRAY + "- Lista Twoich znajomych");
		cmdSender.sendMessage(ChatColor.GOLD + "/fr odmow <nick> " + ChatColor.GRAY + "- Odmów na zaproszenie od gracza");
		cmdSender.sendMessage(ChatColor.GOLD + "/fr wyrzuc <nick> " + ChatColor.GRAY + "- Zerwij znajomosc z graczem");
		cmdSender.sendMessage(ChatColor.GOLD + "/fr zapros <nick> " + ChatColor.GRAY + "- Zapros znajomego");
		cmdSender.sendMessage(ChatColor.GOLD + "/fr zaproszenia " + ChatColor.GRAY + "- Lista zapytan od graczy");
	}
	
	private void accept(ProxiedPlayer cmdSender, ProxiedPlayer player) {
		// TODO
	}
	
	private void friends(ProxiedPlayer cmdSender) {
		// TODO
	}
	
	private void deny(ProxiedPlayer cmdSender, ProxiedPlayer player) {
		// TODO
	}
	
	private void kick(ProxiedPlayer cmdSender, ProxiedPlayer player) {
		// TODO
	}
	
	private void invite(ProxiedPlayer cmdSender, ProxiedPlayer player) {
		// TODO
	}
	
	private void unknownFriends(ProxiedPlayer cmdSender) {
		// TODO
	}
	
}
