package dinhgt.app.jsonconverter.utils.components;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import org.fxmisc.richtext.CodeArea;

public class TabUtils {
    public static Tab initNewTab(int index){
//        TextArea textAreaOrigin = new TextArea();
        CodeArea textAreaOrigin = new CodeArea();

        textAreaOrigin.setPrefHeight(480);
        textAreaOrigin.setPrefWidth(273);
        textAreaOrigin.setId("textAreaOrigin"+index);

//        // JSON content
//        String json = """
//                {
//                    "glossary": {
//                        "title": "example glossary",
//                        "GlossDiv": {
//                            "title": "S",
//                            "GlossList": {
//                                "GlossEntry": {
//                                    "ID": "SGML",
//                                    "SortAs": "SGML",
//                                    "GlossTerm": "Standard Generalized Markup Language",
//                                    "Acronym": "SGML",
//                                    "Abbrev": "ISO 8879:1986",
//                                    "GlossDef": {
//                                        "para": "A meta-markup language, used to create markup languages such as DocBook.",
//                                        "GlossSeeAlso": ["GML", "XML"]
//                                    },
//                                    "GlossSee": "markup"
//                                }
//                            }
//                        }
//                    }
//                }
//                """;


        TextArea textAreaResult = new TextArea();
        textAreaResult.setPrefHeight(480);
        textAreaResult.setPrefWidth(383);
        textAreaResult.setEditable(false);
        textAreaResult.setId("textAreaResult"+index);

        Button btnConvertXML = new Button("XML");
        btnConvertXML.setLayoutX(4.0);
        btnConvertXML.setLayoutY(2.0);
        btnConvertXML.setMnemonicParsing(false);
        btnConvertXML.prefHeight(25);
        btnConvertXML.prefWidth(50);
        btnConvertXML.setId("btnConvertXML"+index);


        Button btnConvertJavaClass = new Button("Java Class");
        btnConvertJavaClass.setLayoutX(58.0);
        btnConvertJavaClass.setLayoutY(2.0);
        btnConvertJavaClass.setMnemonicParsing(false);
        btnConvertJavaClass.setId("btnConvertJavaClass"+index);


        Button btnUnescape = new Button("Unescape");
        btnUnescape.setLayoutX(4);
        btnUnescape.setLayoutY(76.0);
        btnUnescape.setMnemonicParsing(false);
        btnUnescape.prefHeight(25);
        btnUnescape.prefWidth(70);
        btnUnescape.setId("btnUnescape"+index);


        Button btnEscape = new Button("Escape");
        btnEscape.setLayoutX(3);
        btnEscape.setLayoutY(52.0);
        btnEscape.setMnemonicParsing(false);
        btnEscape.setId("btnEscape"+index);

        Button btnConvertJson = new Button("Json");
        btnConvertJson.setLayoutX(4);
        btnConvertJson.setLayoutY(27.0);
        btnConvertJson.setMnemonicParsing(false);
        btnConvertJson.prefHeight(25);
        btnConvertJson.prefWidth(50);
        btnConvertJson.setId("btnConvertJson"+index);

        Button btnRemoveNull = new Button("Remove Null");
        btnRemoveNull.setLayoutX(4);
        btnRemoveNull.setLayoutY(137.0);
        btnRemoveNull.setMnemonicParsing(false);
        btnRemoveNull.prefHeight(25);
        btnRemoveNull.prefWidth(119);
        btnRemoveNull.setId("btnRemoveNull"+index);

        Button btnSaveOrigin = new Button("Save Origin");
        btnSaveOrigin.setLayoutX(21);
        btnSaveOrigin.setLayoutY(14.0);
        btnSaveOrigin.setMnemonicParsing(false);
        btnSaveOrigin.setId("btnSaveOrigin"+index);

        Button btnClearResult = new Button("Clear Result");
        btnClearResult.setLayoutX(26);
        btnClearResult.setLayoutY(237.0);
        btnClearResult.setMnemonicParsing(false);
        btnClearResult.setId("btnClearResult"+index);

        Button btnSaveResult = new Button("Save Result");
        btnSaveResult.setLayoutX(25);
        btnSaveResult.setLayoutY(46.0);
        btnSaveResult.setMnemonicParsing(false);
        btnSaveResult.setId("btnSaveResult"+index);

        Button btnClearAll = new Button("Clear All");
        btnClearAll.setLayoutX(34);
        btnClearAll.setLayoutY(272.0);
        btnClearAll.setMnemonicParsing(false);
        btnClearAll.setId("btnClearAll"+index);

        Button btnBeauty = new Button("Beauty");
        btnBeauty.setLayoutX(37);
        btnBeauty.setLayoutY(82.0);
        btnBeauty.setMnemonicParsing(false);
        btnBeauty.setId("btnBeauty"+index);
        btnBeauty.setOnMouseClicked(mouseEvent -> onClickBeauty(textAreaOrigin));


        Button btnDeepBeauty = new Button("Deep Beauty");
        btnDeepBeauty.setLayoutX(21);
        btnDeepBeauty.setLayoutY(124.0);
        btnDeepBeauty.setMnemonicParsing(false);
        btnDeepBeauty.setId("btnDeepBeauty"+index);

        Pane paneConvertBtn = new Pane();
        paneConvertBtn.maxHeight(Double.NEGATIVE_INFINITY);
        paneConvertBtn.maxWidth(Double.NEGATIVE_INFINITY);
        paneConvertBtn.setPrefHeight(200);
        paneConvertBtn.setPrefWidth(200);
        paneConvertBtn.setId("paneConvertBtn"+index);
        SplitPane.setResizableWithParent(paneConvertBtn, false);
        paneConvertBtn.getChildren().addAll(btnConvertXML, btnConvertJavaClass, btnUnescape, btnEscape, btnConvertJson, btnRemoveNull);

        Pane paneSaveBtn = new Pane();
        paneSaveBtn.maxHeight(Double.NEGATIVE_INFINITY);
        paneSaveBtn.maxWidth(Double.NEGATIVE_INFINITY);
        paneSaveBtn.setPrefHeight(297);
        paneSaveBtn.setPrefWidth(160);
        paneSaveBtn.getChildren().addAll(btnSaveOrigin, btnClearResult, btnSaveResult, btnClearAll, btnBeauty, btnDeepBeauty);
        paneSaveBtn.setId("paneSaveBtn"+index);

        SplitPane splitPane = new SplitPane();
        splitPane.setDividerPositions(0.3458333333333333);
        splitPane.setMaxWidth(Double.NEGATIVE_INFINITY);
        splitPane.setMinWidth(Double.NEGATIVE_INFINITY);
        splitPane.setOrientation(Orientation.VERTICAL);
        splitPane.setPrefWidth(129);
        splitPane.setPrefHeight(480);
        SplitPane.setResizableWithParent(splitPane, false);
        splitPane.getItems().addAll(paneConvertBtn, paneSaveBtn);
        splitPane.setId("splitPane"+index);

        SplitPane splitPane2 = new SplitPane();
        splitPane2.setDividerPositions(0.4077777777777778, 0.57);
        splitPane2.setPrefWidth(524);
        splitPane2.setPrefHeight(480);
        splitPane2.getItems().addAll(textAreaOrigin, splitPane, textAreaResult);
        splitPane2.setId("splitPane2"+index);

        MenuItem wrapTextItem = new CheckMenuItem();
        wrapTextItem.setText("Wrap Text");
        wrapTextItem.setId("wrapTextItem"+index);
        wrapTextItem.setOnAction(actionEvent -> onClickWorkWrap(textAreaOrigin));

        MenuItem jsonLanguage = new CheckMenuItem();
        jsonLanguage.setText("Json");
        jsonLanguage.setId("jsonLanguage"+index);
        jsonLanguage.setOnAction(actionEvent -> onClickWorkWrap(textAreaOrigin));
        Menu languageItem = new Menu();
        languageItem.setText("Language");
        languageItem.setId("languageItem"+index);
        languageItem.setOnAction(actionEvent -> onClickWorkWrap(textAreaOrigin));
        languageItem.getItems().add(jsonLanguage);

        ContextMenu contextMenu = new ContextMenu();
        contextMenu.getItems().add(wrapTextItem);
        contextMenu.getItems().add(languageItem);
        contextMenu.setId("contextMenu"+index);


        Tab tab = new Tab();
        tab.setText("New Tab " + index);
        tab.setContextMenu(contextMenu);
        tab.setContent(splitPane2);
        tab.setId("tab"+index);

        TabPane tabPane = new TabPane();
        tabPane.setId("originTabPane" + index);
        tabPane.setPrefHeight(520);
        tabPane.setPrefWidth(900);
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        VBox.setVgrow(tabPane, Priority.ALWAYS);
        tabPane.getTabs().add(tab);
        tabPane.setId("tabPane"+index);

        return tab;
    }
    private static void onClickWorkWrap(CodeArea textArea){
        textArea.setWrapText(!textArea.isWrapText());
    }

    private static void onClickBeauty(CodeArea textArea){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement je = JsonParser.parseString(textArea.getText());
        String jsonBeauty = gson.toJson(je);
        textArea = new CodeArea(jsonBeauty);
    }
}
