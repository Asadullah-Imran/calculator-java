import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Calculator implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons= new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    Font myFont= new Font("Ink Free",Font.BOLD,30);
    double num1=0,num2=0,result=0;
    char operator;

    Calculator(){
        frame= new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textField=new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont); //add myFont which ser previously
        textField.setEditable(false); // so that we cant be able to change the screen number

        addButton= new JButton("+");
        subButton= new JButton("-");
        mulButton= new JButton("*");
        divButton= new JButton("/");
        decButton= new JButton(".");
        equButton= new JButton("=");
        delButton= new JButton("Del");
        clrButton= new JButton("Clr");
        negButton= new JButton("(-)");

        functionButtons[0]=addButton;
        functionButtons[1]=subButton;
        functionButtons[2]=mulButton;
        functionButtons[3]=divButton;
        functionButtons[4]=decButton;
        functionButtons[5]=equButton;
        functionButtons[6]=delButton;
        functionButtons[7]=clrButton;
        functionButtons[8]=negButton;

        for(int i=0;i<9;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
        for(int i=0;i<10;i++){
            numberButtons[i]= new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);
    //  panel start*******
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,6,6));
        panel.setBackground(Color.GRAY);

        // First row
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        //second row
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        //3rd row
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);

        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);



        //adding frame (in visible things)
        frame.add(panel);
        frame.add(textField);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.setVisible(true);
    }



    public static void main(String[] args) {

        Calculator  calc = new Calculator();

        }

    @Override
    public void actionPerformed(ActionEvent e) {
    for(int i=0; i<10;i++){
        if(e.getSource()==numberButtons[i]){
            textField.setText(textField.getText().concat(String.valueOf(i)));
        }
    }
    if(e.getSource()==decButton){
        textField.setText((textField.getText().concat(".")));
    }
    //In addition
    if(e.getSource()==addButton){
        num1= Double.parseDouble(textField.getText());
        operator='+';
        textField.setText("");
    }
    //for subtraction
        if(e.getSource()==subButton){
            num1= Double.parseDouble(textField.getText());
            operator='-';
            textField.setText("");
        }
    //for multiplication
    if(e.getSource()==mulButton){
        num1= Double.parseDouble(textField.getText());
        operator='*';
        textField.setText("");
    }
    //for subtraction
    if(e.getSource()==divButton){
        num1= Double.parseDouble(textField.getText());
        operator='/';
        textField.setText("");
    }
//  for equal button

     if(e.getSource()==equButton){
         num2=Double.parseDouble(textField.getText());
         switch (operator){
             case '+': result= num1+num2;
                break;
             case '-': result= num1-num2;
                 break;
             case '*': result= num1*num2;
                 break;
             case '/': result= num1/num2;
                 break;
         }
         textField.setText(String.valueOf(result));
         num1=result;
     }

     //clear button
        if(e.getSource()==clrButton){
            textField.setText("");
            num1=0;
            num2=0;
            result=0;
        }
    // delete button
        if(e.getSource()==delButton){
            String string = textField.getText();
            textField.setText("");
            for(int i=0;i<=string.length()-1;i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        //neg button
        if(e.getSource()==negButton){
            double temp= Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
        }
    }
}