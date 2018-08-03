package com.cg.renderer;

import com.cg.provider.MessageProvider;

public class PDFRenderer implements MessageRenderer{

	MessageProvider provider;
	@Override
	public void render() {
		System.out.println(provider.getMessage()+" on PDF :D");
		
	}
	@Override
	public void setMessageProvider(MessageProvider provider) {
		this.provider=provider;
		
	}
	
	
}
