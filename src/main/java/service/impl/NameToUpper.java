package service.impl;

import service.Filter;


public class NameToUpper implements Filter {
    @Override
    public String execute(Object input) {
        String[] fields = input.toString().split(",");
        fields[0]=fields[0].toUpperCase();
        StringBuilder modifiedInput = new StringBuilder();
        for(String field: fields){
            modifiedInput.append(field).append(",");
        }
        return modifiedInput.substring(0,modifiedInput.length()-1);
    }
}
