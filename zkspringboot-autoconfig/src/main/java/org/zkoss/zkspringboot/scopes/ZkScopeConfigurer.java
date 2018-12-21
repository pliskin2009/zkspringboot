package org.zkoss.zkspringboot.scopes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.CustomScopeConfigurer;

/**
 * Configure the most common zk scopes 'webapp', 'desktop' and 'execution'.
 */
public class ZkScopeConfigurer extends CustomScopeConfigurer {
	private static final Logger logger = LoggerFactory.getLogger(ZkScopeConfigurer.class);

	public ZkScopeConfigurer() {
		logger.info("ZK-Springboot: Registering custom scopes ('zk-application', 'desktop')");
		addScope("webapp", new WebAppScope());
		addScope("desktop", new DesktopScope());
		addScope("execution", new ExecutionScope());
	}
}
