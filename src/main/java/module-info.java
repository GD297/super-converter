module dinhgt.app.jsonconverter {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires lombok;
    requires com.google.gson;
    requires org.fxmisc.richtext;
    requires com.fasterxml.jackson.core;
    requires reactfx;

    opens dinhgt.app.jsonconverter to javafx.fxml;
    exports dinhgt.app.jsonconverter;
    exports dinhgt.app.jsonconverter.controller;
    opens dinhgt.app.jsonconverter.controller to javafx.fxml;
}