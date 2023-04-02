package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.*;
import it.polito.tdp.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private TextField txtInsert;

    @FXML
    void doCalcolcaAnagrammi(ActionEvent event) {
    	String parola = this.txtInsert.getText();
    	List<String> corrette = new ArrayList<String>();
    	List<String> errate = new ArrayList<String>();
    	List<String> totale = this.model.anagrammi(parola);
    	for (String p : totale) {
    		if (this.model.isCorrect(p)==true) {
    			corrette.add(p);
    		}
    		else{
    			errate.add(p);
    		}
    	}
    	for (String p : corrette) {
    		this.txtCorretti.appendText(p+"\n");
    	}
    	for (String p : errate) {
    		this.txtErrati.appendText(p+"\n");
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtInsert.clear();
    	this.txtCorretti.clear();
    	this.txtErrati.clear();
    }

    @FXML
    void initialize() {
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Scene.fxml'.";

    }

    public void setModel(Model model) {
    	this.model = model;
    }
}
