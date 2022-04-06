package it.polito.tdp.anagrammi;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.model.Anagramma;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
		
	private Anagramma modelAnagramma;
	
    @FXML
    private Button btnCalcolaAnagrammi;

    @FXML
    private Button btnReset;

    @FXML
    private TextArea txtAreaCorretti;

    @FXML
    private TextArea txtAreaErrati;

    @FXML
    private TextField txtParolaInserita;

    @FXML
    void handleCalcolaAnagrammi(ActionEvent event) {
    	String parola = txtParolaInserita.getText();
    	
    	for (String s : this.modelAnagramma.anagramma(parola)) {
    		if(this.modelAnagramma.isCorrettoDAO(s)==true) {
    			txtAreaCorretti.appendText(s + "\n");
    		}
    		else {
    			txtAreaErrati.appendText(s + "\n");
    		}
    	}
    }

    @FXML
    void handleReset(ActionEvent event) {
    	txtAreaCorretti.clear();
    	txtAreaErrati.clear();
    	txtParolaInserita.clear();
    }
    
    public void setModel(Anagramma a) {
    	this.modelAnagramma = a;
    }

}
