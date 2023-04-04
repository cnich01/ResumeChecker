package com.example.resumechecker;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class Controller {
    //panes
    @FXML
    Pane applicationPane;
    @FXML
    Pane acceptancePane;
    @FXML
    Pane rejectionPane;

    //text fields
    @FXML
    TextField positionTxt;

    //date pickers
    @FXML
    DatePicker birthDatePicker;

    //toggle groups
    @FXML
    ToggleGroup work;
    @FXML
    ToggleGroup bachelors;
    @FXML
    ToggleGroup troubleshooting;
    @FXML
    ToggleGroup communication;

    //radio buttons
    @FXML
    RadioButton workYesBtn;
    @FXML
    RadioButton workNoBtn;
    @FXML
    RadioButton bachelorsYesBtn;
    @FXML
    RadioButton bachelorsNoBtn;
    @FXML
    RadioButton troubleshootingYesBtn;
    @FXML
    RadioButton troubleshootingNoBtn;
    @FXML
    RadioButton communicationYesBtn;
    @FXML
    RadioButton communicationNoBtn;

    //choice boxes
    @FXML
    ChoiceBox<?> javaYearsPicker;
    @FXML
    ChoiceBox<?> HTMLYearsPicker;
    @FXML
    ChoiceBox<?> cPlusYearsPicker;
    @FXML
    ChoiceBox<?> cSharpYearsPicker;

    //labels
    @FXML
    Label requirementsLbl;

    //buttons
    @FXML
    Button submitAppBtn;
    @FXML
    Button submitInterviewBtn;
    @FXML
    Button exitBtn;


    //methods
    @FXML
    void submitApplication(ActionEvent event) {
        //get user's birth date, subtract from current date and store to age

        //run each of the methods for the requirements
        //if all return true adn age is >=18, the applicant passes onto the interview
        //print list of days and times
        //ask user to pick a timeslot from the list
        //remove that time slot from the list fro the next user
        //print the confrimation message
        //exit application
        //else, applicant is sent rejection letter
        //loop through to see what the false requirement was and print the requirement vs what the user input
        //exit application
    }

    @FXML
    void exitApplication(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    //sets the application pane visible and the other panes invisible on startup
    public void initialize(){
        applicationPane.setVisible(true);
        acceptancePane.setVisible(false);
        rejectionPane.setVisible(false);
    }

    //methods to check requirements
    //checks that user has marked "5+" on the programming languages questions
    //public boolean hasExperience(){
       //if java, html, c++, and c# all are 5+
            //return true
        //else return false
    //}

    //checks that user has marked "yes" on the work authorization question
    public boolean canWork(){
        if(workYesBtn.isSelected()){
            return true;
        }
        else{
            return false;
        }
    }

    //checks that user has marked "yes" on the bachelors degree question
    public boolean hasBachelors(){
        if(bachelorsYesBtn.isSelected()){
            return true;
        }
        else{
            return false;
        }
    }

    //checks that user has marked "yes" on the troubleshooting skills question
    public boolean hasTroubleshootingSkills(){
        if(troubleshootingYesBtn.isSelected()){
            return true;
        }
        else{
            return false;
        }
    }

    //checks that user has marked "yes" on the communication skills question
    public boolean hasCommunicationSkills(){
        if(communicationYesBtn.isSelected()){
            return true;
        }
        else{
            return false;
        }
    }
}