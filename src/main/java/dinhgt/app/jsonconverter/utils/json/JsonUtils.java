package dinhgt.app.jsonconverter.utils.json;

import com.fasterxml.jackson.core.JsonToken;

public class JsonUtils {

    public static String jsonTokenToClassName(JsonToken jsonToken) {
        if (jsonToken == null) {
            return "";
        }
        return switch (jsonToken) {
            case FIELD_NAME -> "json-property";
            case VALUE_STRING -> "json-string";
            case VALUE_NUMBER_FLOAT, VALUE_NUMBER_INT -> "json-number";
            default -> "";
        };
    }

}
