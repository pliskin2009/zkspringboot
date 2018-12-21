package org.zkoss.zkspringboot.scopes;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractZkScope implements Scope {

	protected abstract org.zkoss.zk.ui.ext.Scope currentZkScope();

	protected abstract String springBeanScopeMapAttributeName();

	@Override
	public Object get(String name, ObjectFactory<?> objectFactory) {
		return springBeanScopeMap().computeIfAbsent(name, key -> objectFactory.getObject());
	}

	@Override
	public Object remove(String name) {
		return springBeanScopeMap().remove(name);
	}

	private Map<String, Object> springBeanScopeMap() {
		return (Map<String, Object>) currentZkScope().getAttributes()
				.computeIfAbsent(springBeanScopeMapAttributeName(), key -> new HashMap<String, Object>());
	}

	@Override
	public void registerDestructionCallback(String s, Runnable runnable) {
	}

	@Override
	public Object resolveContextualObject(String s) {
		return null;
	}

}
