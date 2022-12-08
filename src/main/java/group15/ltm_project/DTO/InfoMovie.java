package group15.ltm_project.DTO;

import java.util.ArrayList;

/**
 *
 * @author baoluan
 */
class InfoMovie {
    private String fieldName;
    private ArrayList<String> value;

    public InfoMovie(String fieldName, ArrayList<String> value) {
        this.fieldName = fieldName;
        this.value = value;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public ArrayList<String> getValue() {
        return value;
    }

    public void setValue(ArrayList<String> value) {
        this.value = value;
    }

    
}
