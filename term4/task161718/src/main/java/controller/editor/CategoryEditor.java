package controller.editor;

import model.Category;

import java.beans.PropertyEditorSupport;

public class CategoryEditor extends PropertyEditorSupport {

    public void setAsText(String text) {
        setValue(new Category(Long.parseLong(text)));
    }

    public String getAsText(){
        Object value = getValue();
        return value==null?"":((Category) value).getId().toString();
    }
}