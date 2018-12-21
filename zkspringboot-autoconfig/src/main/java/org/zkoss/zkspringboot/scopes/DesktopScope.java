package org.zkoss.zkspringboot.scopes;

import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;

import java.util.Optional;

public class DesktopScope extends AbstractZkScope {
	private static final String DESKTOP_SCOPE = "ZK_SPRING_DESKTOP_SCOPE";

	@Override
	protected Desktop currentZkScope() {
		return Optional.ofNullable(Executions.getCurrent())
				.map(Execution::getDesktop)
				.orElseThrow(() -> new IllegalStateException("Can't access desktop-scoped beans outside a ZK Execution."));
	}

	@Override
	protected String springBeanScopeMapAttributeName() {
		return DESKTOP_SCOPE;
	}

	@Override
	public String getConversationId() {
		return currentZkScope().getId();
	}
}
