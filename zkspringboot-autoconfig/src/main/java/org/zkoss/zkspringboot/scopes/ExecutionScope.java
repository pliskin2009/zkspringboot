package org.zkoss.zkspringboot.scopes;

import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Execution;
import org.zkoss.zk.ui.Executions;

import java.util.Optional;

public class ExecutionScope extends AbstractZkScope {
	private static final String EXEC_SCOPE = "ZK_SPRING_EXEC_SCOPE";

	@Override
	protected Execution currentZkScope() {
		return Optional.ofNullable(Executions.getCurrent())
				.orElseThrow(() -> new IllegalStateException("Can't access execution-scoped beans outside a ZK Execution."));
	}

	@Override
	protected String springBeanScopeMapAttributeName() {
		return EXEC_SCOPE;
	}

	@Override
	public String getConversationId() {
		return null;
	}
}
