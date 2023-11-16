package dinhgt.app.jsonconverter.utils.components;

import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.model.EditableStyledDocument;
import org.fxmisc.richtext.model.StyleSpans;

import java.util.Collection;

public class CustomCodeArea extends CodeArea {
    private String codeType;
    private StyleSpans<Collection<String>> styleSpans;

    public CustomCodeArea(EditableStyledDocument<Collection<String>, String, Collection<String>> document) {
        super(document);
    }

    public CustomCodeArea() {
    }

    public CustomCodeArea(String text) {
        super(text);
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.replaceText(codeType);
        this.codeType = codeType;
    }

    public StyleSpans<Collection<String>> getStyleSpans() {
        return styleSpans;
    }

    public void setStyleSpans(StyleSpans<Collection<String>> styleSpans) {

        this.styleSpans = styleSpans;
    }
}
