package com.liferay.frontend.custom.alloyeditor.button.editor.configuration;

import com.liferay.portal.kernel.editor.configuration.BaseEditorConfigContributor;
import com.liferay.portal.kernel.editor.configuration.EditorConfigContributor;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;

import java.util.Map;
import java.util.Objects;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eric Chin
 */
@Component(
	immediate = true,
	property = {
		"editor.name=alloyeditor", "service.ranking:Integer=100"
	},
	service = EditorConfigContributor.class
)
public class ButtonEditorConfigContributor extends BaseEditorConfigContributor {

	@Override
	public void populateConfigJSONObject(
		JSONObject jsonObject, Map<String, Object> inputEditorTaglibAttributes,
		ThemeDisplay themeDisplay,
		RequestBackedPortletURLFactory requestBackedPortletURLFactory) {

		String extraPlugins = jsonObject.getString("extraPlugins");

		if (Validator.isNotNull(extraPlugins)) {
			extraPlugins += ",youtube";
		}
		else {
			extraPlugins = "youtube";
		}

		JSONObject toolbarsJSONObject = jsonObject.getJSONObject("toolbars");

		if (toolbarsJSONObject == null) {
			toolbarsJSONObject = JSONFactoryUtil.createJSONObject();
		}

		JSONObject addToolbar = toolbarsJSONObject.getJSONObject("add");

		if (addToolbar == null) {
			addToolbar = JSONFactoryUtil.createJSONObject();
		}

		JSONArray buttonsJSONArray = addToolbar.getJSONArray("buttons");

		buttonsJSONArray.put("youtube");

		JSONObject stylesToolbar = toolbarsJSONObject.getJSONObject("styles");

		if (stylesToolbar == null) {
			stylesToolbar = JSONFactoryUtil.createJSONObject();
		}

		JSONArray selectionsJSONArray = stylesToolbar.getJSONArray(
			"selections");

		for (int i = 0; i < selectionsJSONArray.length(); i++) {
			JSONObject selection = selectionsJSONArray.getJSONObject(i);

			if (Objects.equals(selection.get("name"), "text")) {
				JSONArray buttons = selection.getJSONArray("buttons");

				// Add selection buttons here
			}
		}

		addToolbar.put("buttons", buttonsJSONArray);
		toolbarsJSONObject.put("add", addToolbar);
		stylesToolbar.put("selections", selectionsJSONArray);
		toolbarsJSONObject.put("styles", stylesToolbar);
		jsonObject.put("toolbars", toolbarsJSONObject);
		jsonObject.put("extraPlugins", extraPlugins);
	}

}
