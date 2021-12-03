package com.example.flatmate;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class FlatmateForm extends VBox {
    public FlatmateForm(VBox container, ArrayList<flatMate> list){

        TextField name = new TextField("name");
        TextField email = new TextField("email");
        TextField phonenum = new TextField("phonenum");
        TextField lgbt = new TextField("lgbt");
        TextField sociallyactive = new TextField("sociallyactive");
        TextField ecoconcious = new TextField("ecoconciouslevel");
        TextField clean = new TextField("cleanliness");
        TextField length = new TextField("term length");
        TextField minrent = new TextField("maximum rent");
        TextField location = new TextField("Suburb");
        Button onSubmit = new Button("submit");
        Text result = new Text();

        flatMate[] flatmatearray = new flatMate[list.size()];
        for(int i = 0; i<list.size();i++){
            flatmatearray[i] = list.get(i);
        }

        onSubmit.setOnAction(event->{
            mateSeeker user = new mateSeeker(name.getText()+","+
                    email.getText()+","
                    +phonenum.getText()+","
                    +lgbt.getText()+","
                    +sociallyactive.getText()
                    +","+ecoconcious.getText()+","
                    +clean.getText()+","
                    +length.getText()
                    +","+minrent.getText()
                    +",,"+location.getText());
            flatMate match = user.findMatch(flatmatearray);
            result.setText(match.getName());
        });

        container.getChildren().removeAll();
        container.getChildren().addAll(name,email,phonenum,lgbt,sociallyactive,ecoconcious,length,minrent,clean,location,onSubmit,result);
    }
}
