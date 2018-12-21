package org.zkoss.zkspringboot.scopes;

import org.zkoss.zk.ui.*;

import java.util.Optional;

public class WebAppScope extends AbstractZkScope {
	private static final String WEBAPP_SCOPE = "ZK_SPRING_APP_SCOPE";

	@Override
	protected WebApp currentZkScope() {
		return Optional.ofNullable(WebApps.getCurrent())
				.orElseThrow(() -> new IllegalStateException("ZK WebApp not initialized."));
	}

	@Override
	protected String springBeanScopeMapAttributeName() {
		return WEBAPP_SCOPE;
	}

	@Override
	public String getConversationId() {
		return currentZkScope().getAppName();
	}

}
