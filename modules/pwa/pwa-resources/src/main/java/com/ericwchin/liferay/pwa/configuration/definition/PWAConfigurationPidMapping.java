package com.ericwchin.liferay.pwa.configuration.definition;

import com.ericwchin.liferay.pwa.configuration.PWAConfiguration;
import com.liferay.portal.kernel.settings.definition.ConfigurationPidMapping;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = ConfigurationPidMapping.class)
public class PWAConfigurationPidMapping implements ConfigurationPidMapping {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return PWAConfiguration.class;
	}

	@Override
	public String getConfigurationPid() {
		return "com.ericwchin.liferay.pwa.configuration.PWAConfiguration";
	}

}
