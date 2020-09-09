package com.ericwchin.liferay.pwa.configuration;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

import aQute.bnd.annotation.metatype.Meta;

/**
 * @author Eric Chin
 */
@ExtendedObjectClassDefinition(
	category = "pwa",
	scope = ExtendedObjectClassDefinition.Scope.COMPANY
)
@Meta.OCD(
	id = "com.ericwchin.liferay.pwa.configuration.PWAConfiguration",
	localization = "content/Language", name = "pwa-configuration-name"
)
public interface PWAConfiguration {

	@Meta.AD(
		description = "public-key-description", name = "public-key-name",
		required = false
	)
	public String publicKey();

	@Meta.AD(
		description = "private-key-description", name = "private-key-name",
		required = false
	)
	public String privateKey();

}
