package com.example.resumechecker;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.time.LocalDate;
import java.time.Period;

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
    TextField firstNameTxt;
    @FXML
    TextField lastNameTxt;
    @FXML
    TextField positionTxt;

    //date pickers
    @FXML
    DatePicker birthDatePicker;
    @FXML
    DatePicker dateOnePicker;
    @FXML
    DatePicker dateTwoPicker;
    @FXML
    DatePicker dateThreePicker;


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
    ChoiceBox<String> javaYearsPicker;
    @FXML
    ChoiceBox<String> HTMLYearsPicker;
    @FXML
    ChoiceBox<String> cPlusYearsPicker;
    @FXML
    ChoiceBox<String> cSharpYearsPicker;

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

    String missingRequirements = "Missing Requirements:";
    boolean accepted = true;

    //methods
    @FXML
    void submitApplication(ActionEvent event) {
        //run through all methods
        isAtLeast18();
        canWork();
        hasJavaExperience();
        hasHTMLExperience();
        hasCPlusExperience();
        hasCSharpExperience();
        hasBachelors();
        hasTroubleshootingSkills();
        hasCommunicationSkills();

        if(accepted == true){
            applicationPane.setVisible(false);
            acceptancePane.setVisible(true);
        }
        else{
            requirementsLbl.setText(missingRequirements);
            applicationPane.setVisible(false);
            rejectionPane.setVisible(true);
        }
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

        workYesBtn.setToggleGroup(work);
        workNoBtn.setToggleGroup(work);
        bachelorsYesBtn.setToggleGroup(bachelors);
        bachelorsNoBtn.setToggleGroup(bachelors);
        troubleshootingYesBtn.setToggleGroup(troubleshooting);
        troubleshootingNoBtn.setToggleGroup(troubleshooting);
        communicationYesBtn.setToggleGroup(communication);
        communicationNoBtn.setToggleGroup(communication);

        javaYearsPicker.getItems().add("<1");
        javaYearsPicker.getItems().add("1-2");
        javaYearsPicker.getItems().add("3-4");
        javaYearsPicker.getItems().add("5+");

        HTMLYearsPicker.getItems().add("<1");
        HTMLYearsPicker.getItems().add("1-2");
        HTMLYearsPicker.getItems().add("3-4");
        HTMLYearsPicker.getItems().add("5+");

        cPlusYearsPicker.getItems().add("<1");
        cPlusYearsPicker.getItems().add("1-2");
        cPlusYearsPicker.getItems().add("3-4");
        cPlusYearsPicker.getItems().add("5+");

        cSharpYearsPicker.getItems().add("<1");
        cSharpYearsPicker.getItems().add("1-2");
        cSharpYearsPicker.getItems().add("3-4");
        cSharpYearsPicker.getItems().add("5+");
    }

    //methods to check requirements

    //checks that user is at least 18 years old
    public boolean isAtLeast18(){
        LocalDate today = LocalDate.now(); // Today's date is 10th Jan 2022
        LocalDate birthday = birthDatePicker.getValue(); // Birth date

        Period p = Period.between(birthday, today);

        if((p.getYears()==18)||(p.getYears()>18)){
            return true;
        }
        else{
            missingRequirements = missingRequirements + "\n-Not at least 18 years of age";
            accepted = false;
            return false;
        }
    }

    //checks that user has marked "5+" on the programming languages questions
    public boolean hasJavaExperience(){
       String value = (String) javaYearsPicker.getValue();
       if(value.equals("5+")){
           return true;
       }
       else{
           missingRequirements = missingRequirements + "\n-Lacks enough Java experience";
           accepted = false;
           return false;
       }
    }

    public boolean hasHTMLExperience(){
        String value = (String) HTMLYearsPicker.getValue();
        if(value.equals("5+")){
            return true;
        }
        else{
            missingRequirements = missingRequirements + "\n-Lacks enough HTML experience";
            accepted = false;
            return false;
        }
    }

    public boolean hasCPlusExperience(){
        String value = (String) cPlusYearsPicker.getValue();
        if(value.equals("5+")){
            return true;
        }
        else{
            missingRequirements = missingRequirements + "\n-Lacks enough C++ experience";
            accepted = false;
            return false;
        }
    }

    public boolean hasCSharpExperience(){
        String value = (String) cSharpYearsPicker.getValue();
        if(value.equals("5+")){
            return true;
        }
        else{
            missingRequirements = missingRequirements + "\n-Lacks enough C# experience";
            accepted = false;
            return false;
        }
    }

    //checks that user has marked "yes" on the work authorization question
    public boolean canWork(){
        if(workYesBtn.isSelected()){
            return true;
        }
        else{
            missingRequirements = missingRequirements + "\n-Unable to work in the US";
            accepted = false;
            return false;
        }
    }

    //checks that user has marked "yes" on the bachelors degree question
    public boolean hasBachelors(){
        if(bachelorsYesBtn.isSelected()){
            return true;
        }
        else{
            missingRequirements = missingRequirements + "\n-Lacks a Bachelor's Degree in Computer Science or engineering related field";
            accepted = false;
            return false;
        }
    }

    //checks that user has marked "yes" on the troubleshooting skills question
    public boolean hasTroubleshootingSkills(){
        if(troubleshootingYesBtn.isSelected()){
            return true;
        }
        else{
            missingRequirements = missingRequirements + "\n-Lacks troubleshooting skills";
            accepted = false;
            return false;
        }
    }

    //checks that user has marked "yes" on the communication skills question
    public boolean hasCommunicationSkills(){
        if(communicationYesBtn.isSelected()){
            return true;
        }
        else{
            missingRequirements = missingRequirements + "\n-Lacks communication skills";
            accepted = false;
            return false;
        }
    }
}