package com.herp.service.skeletonjava;

public class Field{
    String fieldType;
    String name;
    String label;
    // TODO: field Type as Enum
    Field(String fieldType, String name, String label){
	this.fieldType = fieldType;
	this.name = name;
	this.label = label;
    }
    public String getFieldType(){
	return fieldType;
    }
    public void setFieldType(String fieldType){
	this.fieldType=fieldType;
    }
        public String getName(){
	return name;
    }
    public void setName(String name){
	this.name=name;
    }
    public String getLabel(){
	return label;
    }
    public void setLabel(String label){
	this.label=label;
    }
}
