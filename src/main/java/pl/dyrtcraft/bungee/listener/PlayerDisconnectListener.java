package pl.dyrtcraft.bungee.listener;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerDisconnectListener implements Listener {
	
	@EventHandler
	public void onPlayerDisconnect(PlayerDisconnectEvent e) {
		BungeeCord.getInstance().broadcast(ChatColor.GOLD+"["+e.getPlayer().getName()+"]: wyszedl z serwerowni z "+ChatColor.DARK_GREEN+e.getPlayer().getServer().getInfo().getName());
	}

}
