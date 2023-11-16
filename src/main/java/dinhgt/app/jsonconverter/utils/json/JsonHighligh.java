package dinhgt.app.jsonconverter.utils.json;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

public class JsonHighligh {
    private static final JsonFactory jsonFactory = new JsonFactory();

    public static StyleSpans<Collection<String>> highlight(String code) throws IOException {
        StyleSpansBuilder<Collection<String>> spansBuilder = new StyleSpansBuilder<>();
        int lastPos = 0;
        try {
            JsonParser parser = jsonFactory.createParser(code);
            while (!parser.isClosed()) {
                JsonToken jsonToken = parser.nextToken();

                int length = parser.getTextLength();
                if(jsonToken == JsonToken.VALUE_STRING || jsonToken == JsonToken.FIELD_NAME) {
                    length += 2;
                }

                String className = JsonUtils.jsonTokenToClassName(jsonToken);
                if (!className.isEmpty()) {
                    int start = (int) parser.getTokenLocation().getCharOffset();

                    // Fill the gaps, since Style Spans need to be contiguous.
                    if(start > lastPos)
                    {
                        int noStyleLength = start - lastPos;
                        spansBuilder.add(Collections.emptyList(), noStyleLength);
                    }
                    lastPos = length+ start;

                    spansBuilder.add(Collections.singleton(className), length);
                }
            }
        } catch (JsonParseException e){
            // TODO highlight error line and character
        } catch (IOException e) {
            // Ignoring JSON parsing exception in the context of
            // syntax highlighting
        }

        return spansBuilder.create();
    }

}
