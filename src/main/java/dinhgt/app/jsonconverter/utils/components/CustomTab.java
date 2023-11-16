package dinhgt.app.jsonconverter.utils.components;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import dinhgt.app.jsonconverter.utils.json.JsonHighligh;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.function.IntFunction;

public class CustomTab extends Tab{
    private CodeArea codeAreaOrigin = new CodeArea();
    private TextArea textAreaResult = new TextArea();
    private Button btnConvertXML = new Button("XML");
    private Button btnConvertJavaClass = new Button("Java Class");
    private Button buttonConvertUnEscape = new Button("Unescape");
    private Button btnEscape = new Button("Escape");
    private Button btnConvertJson = new Button("To Json");
    private Button btnRemoveNull = new Button("Remove Null");
    private Button btnSaveOrigin = new Button("Save Left");
    private Button btnClearResult = new Button("Clear Result");
    private Button btnSaveResult = new Button("Save Right");
    private Button btnClearAll = new Button("Clear All");
    private Button btnBeauty = new Button("Beauty");
    private Button btnDeepBeauty = new Button("Deep Beauty");
    private Pane paneConvertBtn = new Pane();
    private Pane paneSaveBtn = new Pane();
    private SplitPane splitPane = new SplitPane();
    private SplitPane splitPane2 = new SplitPane();
    private MenuItem wrapTextItem = new CheckMenuItem();
    private MenuItem jsonLanguage = new CheckMenuItem();
    private Menu languageItem = new Menu();
    private ContextMenu contextMenu = new ContextMenu();

    public CustomTab(int index){
        this.codeAreaOrigin.setPrefHeight(480);
        this.codeAreaOrigin.setPrefWidth(273);
        this.codeAreaOrigin.setId("textAreaOrigin"+index);
        this.codeAreaOrigin.textProperty().addListener((obs, oldText, newText) -> {
            try {
                codeAreaOrigin.setStyleSpans(0, JsonHighligh.highlight(codeAreaOrigin.getText()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        IntFunction<Node> numberFactory = LineNumberFactory.get(this.codeAreaOrigin);
        IntFunction<Node> arrowFactory = new ArrowFactory(this.codeAreaOrigin.currentParagraphProperty());
        IntFunction<Node> graphicFactory = line -> {
            HBox hbox = new HBox(
                    numberFactory.apply(line),
                    arrowFactory.apply(line));
            hbox.setAlignment(Pos.CENTER_LEFT);
            return hbox;
        };
        this.codeAreaOrigin.setParagraphGraphicFactory(graphicFactory);


        this.textAreaResult.setPrefHeight(480);
        this.textAreaResult.setPrefWidth(383);
        this.textAreaResult.setEditable(false);
        this.textAreaResult.setId("textAreaResult"+index);

        this.btnConvertXML.setLayoutX(4.0);
        this.btnConvertXML.setLayoutY(2.0);
        this.btnConvertXML.setMnemonicParsing(false);
        this.btnConvertXML.prefHeight(25);
        this.btnConvertXML.prefWidth(50);
        this.btnConvertXML.setId("btnConvertXML"+index);


        this.btnConvertJavaClass.setLayoutX(58.0);
        this.btnConvertJavaClass.setLayoutY(2.0);
        this.btnConvertJavaClass.setMnemonicParsing(false);
        this.btnConvertJavaClass.setId("btnConvertJavaClass"+index);


        this.buttonConvertUnEscape.setLayoutX(4);
        this.buttonConvertUnEscape.setLayoutY(76.0);
        this.buttonConvertUnEscape.setMnemonicParsing(false);
        this.buttonConvertUnEscape.prefHeight(25);
        this.buttonConvertUnEscape.prefWidth(70);
        this.buttonConvertUnEscape.setId("btnUnescape"+index);

        this.btnEscape.setLayoutX(3);
        this.btnEscape.setLayoutY(52.0);
        this.btnEscape.setMnemonicParsing(false);
        this.btnEscape.setId("btnEscape"+index);

        btnConvertJson.setLayoutX(4);
        btnConvertJson.setLayoutY(27.0);
        btnConvertJson.setMnemonicParsing(false);
        btnConvertJson.prefHeight(25);
        btnConvertJson.prefWidth(50);
        btnConvertJson.setId("btnConvertJson"+index);

        this.btnRemoveNull.setLayoutX(4);
        this.btnRemoveNull.setLayoutY(137.0);
        this.btnRemoveNull.setMnemonicParsing(false);
        this.btnRemoveNull.prefHeight(25);
        this.btnRemoveNull.prefWidth(119);
        this.btnRemoveNull.setId("btnRemoveNull"+index);

        this.btnSaveOrigin.setLayoutX(21);
        this.btnSaveOrigin.setLayoutY(14.0);
        this.btnSaveOrigin.setMnemonicParsing(false);
        this.btnSaveOrigin.setId("btnSaveOrigin"+index);

        this.btnClearResult.setLayoutX(26);
        this.btnClearResult.setLayoutY(237.0);
        this.btnClearResult.setMnemonicParsing(false);
        this.btnClearResult.setId("btnClearResult"+index);

        this.btnSaveResult.setLayoutX(25);
        this.btnSaveResult.setLayoutY(46.0);
        this.btnSaveResult.setMnemonicParsing(false);
        this.btnSaveResult.setId("btnSaveResult"+index);

        this.btnClearAll.setLayoutX(34);
        this.btnClearAll.setLayoutY(272.0);
        this.btnClearAll.setMnemonicParsing(false);
        this.btnClearAll.setId("btnClearAll"+index);

        this.btnBeauty.setLayoutX(37);
        this.btnBeauty.setLayoutY(82.0);
        this.btnBeauty.setMnemonicParsing(false);
        this.btnBeauty.setId("btnBeauty"+index);
        this.btnBeauty.setOnMouseClicked(mouseEvent -> onClickBeauty());


        this.btnDeepBeauty.setLayoutX(21);
        this.btnDeepBeauty.setLayoutY(124.0);
        this.btnDeepBeauty.setMnemonicParsing(false);
        this.btnDeepBeauty.setId("btnDeepBeauty"+index);

        this.paneConvertBtn.maxHeight(Double.NEGATIVE_INFINITY);
        this.paneConvertBtn.maxWidth(Double.NEGATIVE_INFINITY);
        this.paneConvertBtn.setPrefHeight(200);
        this.paneConvertBtn.setPrefWidth(200);
        this.paneConvertBtn.setId("paneConvertBtn"+index);
        SplitPane.setResizableWithParent(paneConvertBtn, false);
        this.paneConvertBtn.getChildren().addAll(btnConvertXML, btnConvertJavaClass, buttonConvertUnEscape, btnEscape, btnConvertJson, btnRemoveNull);

        this.paneSaveBtn.maxHeight(Double.NEGATIVE_INFINITY);
        this.paneSaveBtn.maxWidth(Double.NEGATIVE_INFINITY);
        this.paneSaveBtn.setPrefHeight(297);
        this.paneSaveBtn.setPrefWidth(160);
        this.paneSaveBtn.getChildren().addAll(btnSaveOrigin, btnClearResult, btnSaveResult, btnClearAll, btnBeauty, btnDeepBeauty);
        this.paneSaveBtn.setId("paneSaveBtn"+index);

        this.splitPane.setDividerPositions(0.3458333333333333);
        this.splitPane.setMaxWidth(Double.NEGATIVE_INFINITY);
        this.splitPane.setMinWidth(Double.NEGATIVE_INFINITY);
        this.splitPane.setOrientation(Orientation.VERTICAL);
        this.splitPane.setPrefWidth(129);
        this.splitPane.setPrefHeight(480);
        SplitPane.setResizableWithParent(splitPane, false);
        this.splitPane.getItems().addAll(paneConvertBtn, paneSaveBtn);
        this.splitPane.setId("splitPane"+index);

        this.splitPane2.setDividerPositions(0.4077777777777778, 0.57);
        this.splitPane2.setPrefWidth(524);
        this.splitPane2.setPrefHeight(480);
        this.splitPane2.getItems().addAll(codeAreaOrigin, splitPane, textAreaResult);
        this.splitPane2.setId("splitPane2"+index);

        this.wrapTextItem.setText("Wrap Text");
        this.wrapTextItem.setId("wrapTextItem"+index);
        this.wrapTextItem.setOnAction(actionEvent -> onClickWorkWrap(this.codeAreaOrigin));

        this.jsonLanguage.setText("Json");
        this.jsonLanguage.setId("jsonLanguage"+index);
        this.jsonLanguage.setOnAction(actionEvent -> onClickWorkWrap(this.codeAreaOrigin));
        this.languageItem.setText("Language");
        this.languageItem.setId("languageItem"+index);
        this.languageItem.setOnAction(actionEvent -> onClickWorkWrap(this.codeAreaOrigin));
        this.languageItem.getItems().add(jsonLanguage);

        this.contextMenu.getItems().add(wrapTextItem);
        this.contextMenu.getItems().add(languageItem);
        this.contextMenu.setId("contextMenu"+index);

        this.setText("New Tab " + index);
        this.setContextMenu(contextMenu);
        this.setContent(splitPane2);
        this.setId("tab"+index);
    }

    private static void onClickWorkWrap(CodeArea textArea){
        textArea.setWrapText(!textArea.isWrapText());
    }

    public void onClickBeauty(){
        System.out.println("Beauty");
        System.out.println(this.codeAreaOrigin);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement je = JsonParser.parseString(this.codeAreaOrigin.getText());
        String jsonBeauty = gson.toJson(je);
        this.codeAreaOrigin.replaceText(jsonBeauty);

    }

    private static StyleSpans<Collection<String>> computeHighlighting(String text) {
        StyleSpansBuilder<Collection<String>> spansBuilder = new StyleSpansBuilder<>();
        spansBuilder.add(List.of("red-text"), text.length() / 2);
        return spansBuilder.create();
    }


}
