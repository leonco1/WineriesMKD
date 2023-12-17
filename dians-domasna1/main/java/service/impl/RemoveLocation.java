package service.impl;

import service.Filter;

public class RemoveLocation implements Filter {
    @Override
    public String execute(Object input) {
        String[] fields = input.toString().split(",");

        if (fields.length!=0) {
            StringBuilder modifiedInput = new StringBuilder(fields[0]);
            for (int i = 1; i < fields.length; i++) {
                if(i==3) {
                    continue;
                }
                modifiedInput.append(",").append(fields[i]);
            }
            return modifiedInput.toString();
        }
        return input.toString();
    }
}