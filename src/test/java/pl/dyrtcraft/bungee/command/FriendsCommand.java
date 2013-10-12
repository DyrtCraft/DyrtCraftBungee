package pl.dyrtcraft.bungee.command;

import pl.dyrtcraft.bungee.DyrtCraftBungee;
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
		if(args.length==0) {
			DyrtCraftBungee.debug(sender.getName() + " issued DyrtCraftBungee command /friends or /fr " + args); // Debug
			if(!(sender instanceof ProxiedPlayer)) {
				sender.sendMessage(ChatColor.RED + "Nie mozesz wykonac tego polecenia z poziomu konsoli!");
				return;
			}
			ProxiedPlayer player = (ProxiedPlayer) sender;
			FriendsCommand.showOnline(player);
			return;
		}
		if(args.length==1) {
			DyrtCraftBungee.debug(sender.getName() + " issued DyrtCraftBungee command /friends or /fr " + args); // Debug
			if(!(sender instanceof ProxiedPlayer)) {
				sender.sendMessage(ChatColor.RED + "Nie mozesz wykonac tego polecenia z poziomu konsoli!");
				return;
			}
			ProxiedPlayer player = (ProxiedPlayer) sender;
			if(args[0].equalsIgnoreCase("-list") || args[0].equalsIgnoreCase("lista") || args[0].equalsIgnoreCase("pokaz") || args[0].equalsIgnoreCase("show")) {
				FriendsCommand.show(player);
				return;
			}
			if(args[0].equalsIgnoreCase("-add") || args[0].equalsIgnoreCase("-delete") || args[0].equalsIgnoreCase("-remove")) {
				erArg(sender);
				return;
			}
			if(sender.hasPermission("dyrtcraft.operator")) {
				FriendsCommand.show(ProxyServer.getInstance().getPlayer(args[0]));
				return;
			} else {
				erArg(sender);
				return;
			}
		}
		if(args.length==2) {
			DyrtCraftBungee.debug(sender.getName() + " issued DyrtCraftBungee command /friends or /fr " + args); // Debug
			if(!(sender instanceof ProxiedPlayer)) {
				sender.sendMessage(ChatColor.RED + "Nie mozesz wykonac tego polecenia z poziomu konsoli!");
				return;
			}
			ProxiedPlayer player = (ProxiedPlayer) sender;
			if(args[0].equalsIgnoreCase("-add") || args[0].equalsIgnoreCase("-dodaj") || args[0].equalsIgnoreCase("-zapros")) {
				FriendsCommand.add(player, args[1]);
				return;
			}
			if(args[0].equalsIgnoreCase("-delete") || args[0].equalsIgnoreCase("-remove") || args[0].equalsIgnoreCase("-usun") || args[0].equalsIgnoreCase("-wyrzuc")) {
				FriendsCommand.remove(player, args[0]);
				return;
			} else {
				erArg(sender);
				return;
			}
		} else {
			erArg(sender);
			return;
		}
	}
	
	public static void add(ProxiedPlayer player, String add) {
		player.sendMessage(ChatColor.YELLOW + "W budowie ;D");
		/*
		 * TODO
		 */
	}
	
	public static void remove(ProxiedPlayer player, String remove) {
		player.sendMessage(ChatColor.YELLOW + "W budowie ;D");
		/*
		 * TODO
		 */
	}
	
	public static void show(ProxiedPlayer player) {
		player.sendMessage(ChatColor.YELLOW + "W budowie ;D");
		/*
		 * TODO
		 */
	}
	
	public static void showOnline(ProxiedPlayer player) {
		player.sendMessage(ChatColor.YELLOW + "W budowie ;D");
		/*
		 * TODO
		 */
	}
	
	
	protected void erArg(CommandSender sender) {
		if(sender.hasPermission("dyrtcraft.operator")) {
			sender.sendMessage(ChatColor.RED + "/fr " + ChatColor.GOLD + "Znajomi online");
			sender.sendMessage(ChatColor.RED + "/fr <gracz> " + ChatColor.GOLD + "Wszyscy znajomi gracza \"gracz\"");
			sender.sendMessage(ChatColor.RED + "/fr -add <gracz> " + ChatColor.GOLD + "Dodaj znajomego");
			sender.sendMessage(ChatColor.RED + "/fr -list " + ChatColor.GOLD + "Lista znajomych");
			sender.sendMessage(ChatColor.RED + "/fr -remove <gracz> " + ChatColor.GOLD + "Usun znajomego");
			return;
		} else {
			sender.sendMessage(ChatColor.RED + "Podales/as nieprawidlowa liczbe argumentów!");
			sender.sendMessage(ChatColor.RED + "Uzycie: /friends [-dodaj|-lista|-usun] [gracz]");
			return;
		}
	}
	
}
