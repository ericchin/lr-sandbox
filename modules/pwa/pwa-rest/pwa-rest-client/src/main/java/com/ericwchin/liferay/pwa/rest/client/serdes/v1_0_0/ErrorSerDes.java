package com.ericwchin.liferay.pwa.rest.client.serdes.v1_0_0;

import com.ericwchin.liferay.pwa.rest.client.dto.v1_0_0.Error;
import com.ericwchin.liferay.pwa.rest.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author Eric Chin
 * @generated
 */
@Generated("")
public class ErrorSerDes {

	public static Error toDTO(String json) {
		ErrorJSONParser errorJSONParser = new ErrorJSONParser();

		return errorJSONParser.parseToDTO(json);
	}

	public static Error[] toDTOs(String json) {
		ErrorJSONParser errorJSONParser = new ErrorJSONParser();

		return errorJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Error error) {
		if (error == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (error.getCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"code\": ");

			sb.append(error.getCode());
		}

		if (error.getMessage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"message\": ");

			sb.append("\"");

			sb.append(_escape(error.getMessage()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ErrorJSONParser errorJSONParser = new ErrorJSONParser();

		return errorJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Error error) {
		if (error == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (error.getCode() == null) {
			map.put("code", null);
		}
		else {
			map.put("code", String.valueOf(error.getCode()));
		}

		if (error.getMessage() == null) {
			map.put("message", null);
		}
		else {
			map.put("message", String.valueOf(error.getMessage()));
		}

		return map;
	}

	public static class ErrorJSONParser extends BaseJSONParser<Error> {

		@Override
		protected Error createDTO() {
			return new Error();
		}

		@Override
		protected Error[] createDTOArray(int size) {
			return new Error[size];
		}

		@Override
		protected void setField(
			Error error, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "code")) {
				if (jsonParserFieldValue != null) {
					error.setCode(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "message")) {
				if (jsonParserFieldValue != null) {
					error.setMessage((String)jsonParserFieldValue);
				}
			}
			else {
				throw new IllegalArgumentException(
					"Unsupported field name " + jsonParserFieldName);
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\":");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(",");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}