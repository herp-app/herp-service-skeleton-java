package com.herp.service.skeletonjava;

public class NodeDefinition{
    private String name;
    private String label;
    private Field[] inputs;
    private Field[] outputs;

    NodeDefinition(String name, String label, Field[] inputs, Field[] outputs){
	this.name = name;
	this.label=label;
	this.inputs=inputs;
	this.outputs=outputs;
    }
   
    public String getName(){
	return name;
    }
    public void setLName(String name){
	this.name=name;
    }
    public String getLabel(){
	return label;
    }
    public void setLabel(String label){
	this.label=label;
    }
    public Field[] getInputs(){
	return inputs;
    }
    public void setInputs(Field[] inputs){
	this.inputs=inputs;
    }
    public Field[] getOutputs(){
	return outputs;
    }
    public void setOutputs(Field[] outputs){
	this.outputs=outputs;
    }
}
				
