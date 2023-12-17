package service.impl;

import service.Filter;

public class AddressFilter implements Filter {
    @Override
    public String execute(Object input) {
        String line = input.toString();
        String[] fields = line.split(",");
        if (fields.length > 1 && containsSkopje(fields[2])) {
            return line;
        }
        return "";
    }

    private boolean containsSkopje(String addressField) {
        return addressField.trim().toLowerCase().contains("skopje");
    }
}