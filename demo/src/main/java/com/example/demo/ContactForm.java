package com.example.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame{
    public JTextField nameField;
    public JTextField emailField;
    public JRadioButton male;
    public JRadioButton female;
    public JCheckBox check;


    public ContactForm(){
        // установка диалогового окна
        super("Contact Information");
        super.setBounds(750, 300,350,200);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // создание размеров
        Container container = super.getContentPane();
        container.setLayout(new GridLayout(4,2,2,10));

        // создание полей
        JLabel name = new JLabel("Enter your name :");
        nameField = new JTextField("",1);

        JLabel email = new JLabel("Enter your email :");
        emailField = new JTextField("",1);

        // добавление полей в диалоговое окно
        container.add(name);
        container.add(nameField);
        container.add(email);
        container.add(emailField);

        // добавление радиокнопок
        male = new JRadioButton("Male",true);
        female = new JRadioButton("Female");
        check = new JCheckBox("Do you agree ?",false);
        JButton sendButton = new JButton("Send");



        // объединение радиокнопок в одну группу
        ButtonGroup btnGroup = new ButtonGroup();
        btnGroup.add(male);
        btnGroup.add(female);

        // добавление радио-чекБокс-кнопок и кнопки в диалоговое окно
        container.add(male);
        container.add(female);
        container.add(check);
        container.add(sendButton);

        sendButton.addActionListener(new ButtonEventManager());
    }
    class ButtonEventManager implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String email = emailField.getText();

            String isMale = "Male";
            if (!male.isSelected())
                isMale = "Female";

            boolean checkbox = check.isSelected();

            JOptionPane.showMessageDialog(null,
                    "Your mail : " + email
                            + "\nYour gender : " + isMale + "\n"
                            + " Do you agree ? : " + checkbox,
                            "Hello,  " + name, JOptionPane.PLAIN_MESSAGE);
        }
    }
}
