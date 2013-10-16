package pl.dyrtcraft.bungee;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

import pl.dyrtcraft.bungee.command.FriendsCommand;
import pl.dyrtcraft.bungee.command.GdzieCommand;
import pl.dyrtcraft.bungee.command.HubCommand;
import pl.dyrtcraft.bungee.command.SerwerCommand;
import pl.dyrtcraft.bungee.command.WhoCommand;

public class DyrtCraftBungee extends Plugin {
	
	@Override
	public void onEnable() {
		getProxy().getPluginManager().registerCommand(this, new FriendsCommand());
		getProxy().getPluginManager().registerCommand(this, new GdzieCommand());
		getProxy().getPluginManager().registerCommand(this, new HubCommand());
		getProxy().getPluginManager().registerCommand(this, new SerwerCommand());
		getProxy().getPluginManager().registerCommand(this, new WhoCommand());
	}
	
	/**
	 * @author TheMolkaPL
	 * @since Release 1.0
	 * @param msg Wiadomosc do konsoli
	 */
	public static void debug(String msg) {
		ProxyServer.getInstance().getLogger().info("[DyrtCraft] " + msg);
	}
	
}
