package pl.dyrtcraft.bungee;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;

import pl.dyrtcraft.bungee.command.GdzieCommand;
import pl.dyrtcraft.bungee.command.SerwerCommand;

public class DyrtCraftBungee extends Plugin {
	
	@Override
	public void onEnable() {
		getProxy().getPluginManager().registerCommand(this, new GdzieCommand());
		getProxy().getPluginManager().registerCommand(this, new SerwerCommand());
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
