package com.herp.service.skeletonjava;

public class ProvidedInput{
    private final static Field[] nodeDefinition =  {
	new Field("string", "inputField1", "String output Field"),
	new Field("string", "inputField2", "String output Field")
    };

    String inputField1;
    String inputField2;
    
    ProvidedInput(String inputField1, String inputField2){
	this.inputField1 = inputField1;
	this.inputField2 = inputField2;
    }
    
    public String getInputField1(){
	return this.inputField1;
    }
    public void setInputField1(String inputField1){
	this.inputField1=inputField1;
    }
    public String getInputField2(){
	return this.inputField2;
    }
    public void setInputField2(String inputField2){
	this.inputField2=inputField2;
    }
    
    static public Field[] nodeDefinition(){
	return nodeDefinition;
    }
}
