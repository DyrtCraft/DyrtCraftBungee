package pl.dyrtcraft.bungee.listener;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ServerConnectListener implements Listener {

	@EventHandler
	public void onServerConnect(ServerConnectEvent e) {
		BungeeCord.getInstance().broadcast(ChatColor.GOLD+"["+e.getPlayer().getName()+"]: "+ChatColor.DARK_GREEN+e.getPlayer().getServer().getInfo().getName()+ChatColor.GOLD+" -> "+ChatColor.DARK_GREEN+e.getTarget().getName());
	}
	
}
