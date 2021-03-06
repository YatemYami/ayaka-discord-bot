package com.yamiy.ayaka.config;

import javax.security.auth.login.LoginException;

import com.yamiy.ayaka.events.HelloEvent;
import com.yamiy.ayaka.events.PlayerEvent;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

public class JDABasicConfig {
	private static final String token = System.getenv("token");
	
	public static JDABuilder buildJDA() throws LoginException {
		JDABuilder jda = JDABuilder.createDefault(
				token, 
				GatewayIntent.GUILD_MESSAGES,
				GatewayIntent.DIRECT_MESSAGES,
				GatewayIntent.GUILD_VOICE_STATES);
		jda.addEventListeners(new HelloEvent(), new PlayerEvent());
		jda.build();
		
		return jda;
	}
}
