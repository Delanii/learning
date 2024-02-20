package com.tomaskrulis;

public class TextBox {

    public String text = ""; // a class field initialized to empty string to prevent the `NullPointerException`. If the field is not initialized and someone tries to use it, they get a null pointer ... :D The field doesn't exist in the memory yet.

    public void setText(String text) {
        this.text = text; // the `text` field of the TextBox object is set to the value passed to the `setText` method
    }

    public void clear() {
        text = "";
    }
}
