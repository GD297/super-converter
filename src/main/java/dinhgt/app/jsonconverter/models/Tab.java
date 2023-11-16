package dinhgt.app.jsonconverter.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.fxmisc.richtext.CodeArea;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tab {
    private CodeArea codeArea;

    private String text;
}
