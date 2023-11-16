package dinhgt.app.jsonconverter.controller;

import dinhgt.app.jsonconverter.utils.components.CustomTab;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;


public class AddTabController {
    @FXML
    private TabPane originTabPane;

    @FXML
    protected void onClickPlusTab(){
        ObservableList<Tab> tabObservable = originTabPane.getTabs();
        CustomTab tab = new CustomTab((tabObservable.size()-1));
        tabObservable.add((tabObservable.size()-1), tab);
        originTabPane.getSelectionModel().select(tab);
    }




}
