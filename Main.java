import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel fLabel;
  JLabel cLabel;

  JTextField fInput;
  JTextField cInput;

  JButton fButton;
  JButton cButton;

  Font biggerText;


  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("TemperatureConverter");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);

    // initialize the main JPanel
    mainPanel = new JPanel();
    // disable any layout helpers
    mainPanel.setLayout(null);
    
    //initialize the labels
    fLabel = new JLabel("Degrees Fahrenheit");
    cLabel = new JLabel("Degrees Celsius");
    // set the location and setSize
    fLabel.setBounds(100, 100, 200, 20);
    cLabel.setBounds(100, 140, 200, 20);
    // add the JLabels to the main panel
    mainPanel.add(fLabel);
    mainPanel.add(cLabel);

    // initialize the text areas
    fInput = new JTextField();
    cInput = new JTextField();
    // set the location and size
    fInput.setBounds(310, 100, 100, 20);
    cInput.setBounds(310, 140, 100, 20);
    // add the text areas to the main panel
    mainPanel.add(fInput);
    mainPanel.add(cInput);

    // initialize the JButtons
    fButton = new JButton("F -> C");
    cButton = new JButton("C -> F");
    // set the location and size
    fButton.setBounds(420, 100, 100, 20);
    cButton.setBounds(420, 140, 100, 20);
    // add an action listener to the buttons
    fButton.addActionListener(this);
    cButton.addActionListener(this);
    // set the action command on the buttons
    fButton.setActionCommand("F -> C");
    cButton.setActionCommand("C -> F");
    // add the JButtons to the main panel
    mainPanel.add(fButton);
    mainPanel.add(cButton);

    // create a bigger font to use
    biggerText = new Font("arial",Font.PLAIN, 16);
    // set the font on the area I want to use it
    fLabel.setFont(biggerText);    
    cLabel.setFont(biggerText);
    fInput.setFont(biggerText);
    cInput.setFont(biggerText);
    fButton.setFont(biggerText);
    cButton.setFont(biggerText);


    // add the main panel to the window
    frame.add(mainPanel);
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    if(command.equals("F -> C")){
      // get the text from the text box
      String fahrenheitText = fInput.getText();

      // change the string into an integer
      int fInteger = Integer.parseInt(fahrenheitText);

      // calculate fahrenhiet into celsuis
      int celsuis = ((fInteger-32)*5)/9;
      
      // print out result in string form using ""
      cInput.setText("" + celsuis);
    } else if(command.equals("C -> F")){

      // get the text from the text box
      String celsuisText = cInput.getText();

      // change the string into an integer
      int cInteger = Integer.parseInt(celsuisText);

      // calculate celsuis into fahrenheit
      int fahrenheit = (cInteger*9)/5+32;
      
      // print out result in string form using ""
      fInput.setText("" + fahrenheit);
    }

  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}
