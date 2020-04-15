package com.liferay.frontend.custom.alloyeditor.button.servlet.taglib;

import com.liferay.frontend.js.loader.modules.extender.npm.NPMResolver;
import com.liferay.portal.kernel.servlet.taglib.BaseDynamicInclude;
import com.liferay.portal.kernel.servlet.taglib.DynamicInclude;
import com.liferay.portal.kernel.servlet.taglib.aui.ScriptData;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = DynamicInclude.class)
public class ButtonDynamicInclude extends BaseDynamicInclude {

	@Override
	public void include(
			HttpServletRequest request, HttpServletResponse response,
			String key)
		throws IOException {

		ScriptData scriptData = new ScriptData();

		String buttonsCollection = _npmResolver.resolveModuleName(
			"frontend-custom-alloyeditor-button/js/main");

		scriptData.append(
			null, "", buttonsCollection, ScriptData.ModulesType.ES6);

		scriptData.writeTo(response.getWriter());
	}

	@Override
	public void register(DynamicIncludeRegistry dynamicIncludeRegistry) {
		dynamicIncludeRegistry.register(
			"com.liferay.frontend.editor.alloyeditor.web#alloyeditor#" +
				"additionalResources");
	}

	@Reference
	private Portal _portal;

	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.frontend.alloyeditor.button)"
	)
	private ServletContext _servletContext;

	@Reference
	private NPMResolver _npmResolver;

}
