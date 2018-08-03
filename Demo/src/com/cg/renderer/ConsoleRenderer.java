package com.cg.renderer;

import com.cg.provider.MessageProvider;

public class ConsoleRenderer implements  MessageRenderer {

	MessageProvider provider;
	@Override
	public void setMessageProvider(MessageProvider provider) {
		this.provider=provider;
		
	}

	@Override
	public void render() {
		System.out.println(provider.getMessage());
		
	}	
}
