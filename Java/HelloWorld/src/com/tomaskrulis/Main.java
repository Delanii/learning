package com.tomaskrulis; // The package definition reflect the folder structure. Each dot is a subfolder, so the `Main.java` file has to be located in the path: `HelloWorld/src/com/tomaskrulis/Main.java`

    public class Main {
        public static void main(String[] args) {

            TextBox textBox1 = new TextBox();
            textBox1.setText("Box 1");
            System.out.println(textBox1.text);

            var textBox2 = new TextBox();
            textBox2.setText("Box 2");
            System.out.println(textBox2.text);

            var textBox3 = textBox1; // `textBox3` is set to the same type (`TextBox`) and has the same contents as `textBox1`. `textBox1` contains the reference to the object in memory, so both of the object point to the same part of the memory.
            textBox3.setText("Change!");
            System.out.println(textBox1.text); // The `textBox1` and `textBox3` reference the same object.
        }
}
