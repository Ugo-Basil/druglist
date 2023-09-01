package com.drug.drug.exception;

public class DrugNotFoundException extends  RuntimeException{
    public  DrugNotFoundException(Long id){
        super("Could not find drug with drugId " + id);
    }

}
