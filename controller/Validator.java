package controller;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator{
    private LinkedList<String> errors = new LinkedList<String>();   //This list will be used to store multiple errors

    //Those are 2 patterns for 2 input fields, there are 6 more you need to figure them out
    private final String phonePattern = "^[0-9]{8}$";
    private final String TFNPattern = "^[0-9]{3}[-]?[0-9]{3}$";
    private final String emailPattern = "^[A-Za-z0-9+.]+@(.+)$";
    

    public Validator(){    
          ///code goes here
          
    }
   
    public boolean validate(String pattern, String input) {
          ///code to validate pattern and input using Matcher and Pattern
          return input.matches(pattern);
    }
   
    ///This method generate multiple errors and store them in the list  
    public void generateErrors(String name, String email, String phone,String address,String type, String TFN, int hours, double pay){

        if(!validate(emailPattern, email))
            addError("Incorrect email pattern!\n");
        if(!validate(phonePattern,phone))
            addError("Incorrect phone pattern!\n");
        if(!isType(type))
            addError("Incorrect type pattern!\n");
        if(!validate(TFNPattern,TFN))
            addError("Incorrect TFN pattern!\n");


    }
   
    public boolean isValid(String name, String email, String phone,String address,String type, String TFN, int hours, double pay){
            ///code to validate all inputs against all patterns at once
            return validate(TFNPattern, TFN) && validate(phonePattern, phone) && isType(type) 
                    && validate(emailPattern, email);
    }
   
    public void addError(String msg){
         ///add error to the list
         errors.add(msg);
    }
   
    public LinkedList<String> errors(){
        ///access the list
        return this.errors;
    }
   
    public void clear(){
          ///clear the list
          errors.removeAll(errors);
    }
    
    private boolean isType(String JobType){
        return JobType.matches("Casual") || JobType.matches("Full-Time") 
                || JobType.contains("Part-Time");
    }
}