package com.herp.service.skeletonjava;

public class ProvidedOutput{
    private final static Field[] nodeDefinition =  {
	    new Field("string", "outputField", "String output Field")
    };
    String outputField;
    ProvidedOutput(String outputField){
	this.outputField = outputField;
    }
    public String getOutputField(){
	return this.outputField;
    }
    public void setOutputField(String outputField){
	this.outputField=outputField;
    }
    static public Field[] nodeDefinition(){
	return nodeDefinition;
    }
}
