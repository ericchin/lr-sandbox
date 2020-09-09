package com.ericwchin.liferay.pwa.configuration.definition;

import com.ericwchin.liferay.pwa.configuration.PWAConfiguration;
import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = ConfigurationBeanDeclaration.class)
public class PWAConfigurationBeanDeclaration
	implements ConfigurationBeanDeclaration {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return PWAConfiguration.class;
	}

}
