package com.cg.renderer;

import com.cg.provider.MessageProvider;

public interface MessageRenderer {

	void setMessageProvider(MessageProvider provider);
	void render();
}
