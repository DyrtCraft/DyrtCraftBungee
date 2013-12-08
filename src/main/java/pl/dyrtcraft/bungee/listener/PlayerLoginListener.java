package pl.dyrtcraft.bungee.listener;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerLoginListener implements Listener {

	@EventHandler
	public void onPlayerLogin(LoginEvent e) {
		BungeeCord.getInstance().broadcast(ChatColor.GOLD+"["+e.getConnection().getName()+"]: dolaczyl na serwerownie do "+ChatColor.DARK_GREEN+"Lobby");
	}
	
}
