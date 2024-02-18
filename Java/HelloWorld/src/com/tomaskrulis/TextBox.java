package com.tomaskrulis;

public class TextBox {

    public String text; // a class field

    public void setText(String text) {
        this.text = text; // the `text` field of the TextBox object is set to the value passed to the `setText` method
    }

    public void clear() {
        text = "";
    }
}
