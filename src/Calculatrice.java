import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTextField;

public class Calculatrice extends JFrame implements ActionListener {
    private JTextField txtNombres = new JTextField(); // Champ d'affichage
    
    //Premiere ligne
    private JButton btMC = new JButton("MC");
    private JButton btMR = new JButton("MR");
    private JButton btMplus = new JButton("M+");
    private JButton btMinus = new JButton("M-");
    //Deuxieme ligne
    private JButton btOff = new JButton("Off");
    private JButton btAC = new JButton("AC");
    private JButton btC = new JButton("C");
    private JButton btDivise = new JButton("/");
    
    //Troisieme ligne
    private JButton bt7 = new JButton("7");
    private JButton bt8 = new JButton("8");
    private JButton bt9 = new JButton("9");
    private JButton btX = new JButton("X");
    
    //Quatrieme ligne
    private JButton bt4 = new JButton("4");
    private JButton bt5 = new JButton("5");
    private JButton bt6 = new JButton("6");
    private JButton btMoins = new JButton("-");
    
    //Cinquieme ligne
    private JButton bt1 = new JButton("1");
    private JButton bt2 = new JButton("2");
    private JButton bt3 = new JButton("3");
    private JButton btPlus = new JButton("+");
    
    //Sixieme ligne
    private JButton btUnder = new JButton("_");
    private JButton bt0 = new JButton("0");
    private JButton btPoint = new JButton(".");
    private JButton btEgal = new JButton("=");

    // Le menu
    private JMenuBar uneBarre = new JMenuBar();
    private JMenu mnStandar = new JMenu("Standard");

    // Variables pour gérer le calcul
    private double operand1 = 0;
    private double operand2 = 0;
    private String operator = "";
    private boolean startNewInput = true;

    public Calculatrice() {
        this.setTitle("Calculatrice 2A 2025");
        this.setBounds(100, 100, 320, 470);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);

        // Ajouter et configurer le champ d'affichage
        txtNombres.setBounds(20, 20, 270, 50);
        txtNombres.setFont(new Font("Arial", Font.BOLD, 24));
        txtNombres.setHorizontalAlignment(JTextField.RIGHT);
        txtNombres.setEditable(false); // Empêche la saisie manuelle
        this.add(txtNombres);

        // Ajouter et positionner les boutons
        this.btMC.setBounds(20, 105, 60, 40);
        this.add(this.btMC);
        this.btMR.setBounds(90, 105, 60, 40);
        this.add(this.btMR);
        this.btMplus.setBounds(160, 105, 60, 40);
        this.add(this.btMplus);
        this.btMinus.setBounds(230, 105, 60, 40);
        this.add(this.btMinus);

        this.btOff.setBounds(20, 150, 60, 40);
        this.add(this.btOff);
        this.btAC.setBounds(90, 150, 60, 40);
        this.add(this.btAC);
        this.btC.setBounds(160, 150, 60, 40);
        this.add(this.btC);
        this.btDivise.setBounds(230, 150, 60, 40);
        this.add(this.btDivise);

        this.bt7.setBounds(20, 200, 60, 40);
        this.add(this.bt7);
        this.bt8.setBounds(90, 200, 60, 40);
        this.add(this.bt8);
        this.bt9.setBounds(160, 200, 60, 40);
        this.add(this.bt9);
        this.btX.setBounds(230, 200, 60, 40);
        this.add(this.btX);

        this.bt4.setBounds(20, 250, 60, 40);
        this.add(this.bt4);
        this.bt5.setBounds(90, 250, 60, 40);
        this.add(this.bt5);
        this.bt6.setBounds(160, 250, 60, 40);
        this.add(this.bt6);
        this.btMoins.setBounds(230, 250, 60, 40);
        this.add(this.btMoins);

        this.bt1.setBounds(20, 300, 60, 40);
        this.add(this.bt1);
        this.bt2.setBounds(90, 300, 60, 40);
        this.add(this.bt2);
        this.bt3.setBounds(160, 300, 60, 40);
        this.add(this.bt3);
        this.btPlus.setBounds(230, 300, 60, 40);
        this.add(this.btPlus);

        this.btUnder.setBounds(20, 350, 60, 40);
        this.add(this.btUnder);
        this.bt0.setBounds(90, 350, 60, 40);
        this.add(this.bt0);
        this.btPoint.setBounds(160, 350, 60, 40);
        this.add(this.btPoint);
        this.btEgal.setBounds(230, 350, 60, 40);
        this.add(this.btEgal);
        
     // Gerer la couleur des boutons
        Color otherButtonColor = new Color(173, 216, 230); 
        Color numberButtonColor = new Color(192, 192, 192);  
        
     // Chiffres
        JButton[] numberButtons = {bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9};

        // Appliquer la couleur aux Chiffres
        for (JButton button : numberButtons) {
            button.setBackground(numberButtonColor);
            button.setForeground(Color.BLACK);
        }

        // Tous les autres boutons
        JButton[] otherButtons = {
            btMC, btMR, btMplus, btMinus, btOff, btAC, btC, btDivise,
            btX, btMoins, btPlus, btUnder, btPoint, btEgal
        };

        // Appliquer la couleur aux autres boutons
        for (JButton button : otherButtons) {
            button.setBackground(otherButtonColor);
            button.setForeground(Color.BLACK);
        }

        // Rendre les boutons écoutables
        JButton[] buttons = {bt7, bt8, bt9, bt4, bt5, bt6, bt1, bt2, bt3, bt0, btPoint, btPlus, btMoins, btX, btDivise, btEgal, btAC, btC, btOff};
        for (JButton button : buttons) {
            button.addActionListener(this);
        }

        // Installer le menu
        mnStandar.setFont(new Font("Arial", Font.BOLD, 25));
        this.uneBarre.add(this.mnStandar);
        this.setJMenuBar(this.uneBarre);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Calculatrice();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == this.btOff) {
            this.dispose(); // Quitte l'application
        } else if (source == this.btAC) {
            // Réinitialise la calculatrice
            this.txtNombres.setText("");
            operand1 = 0;
            operand2 = 0;
            operator = "";
            startNewInput = true;
        } else if (source == this.btC) {
            // Efface le dernier caractère
            String currentText = txtNombres.getText();
            if (!currentText.isEmpty()) {
                txtNombres.setText(currentText.substring(0, currentText.length() - 1));
            }
        } else if (source instanceof JButton) {
            JButton button = (JButton) source;
            String buttonText = button.getText();

            if ("0123456789.".contains(buttonText)) {
                if (startNewInput) {
                    txtNombres.setText("");
                    startNewInput = false;
                }
                txtNombres.setText(txtNombres.getText() + buttonText);
            } else if ("+-X/".contains(buttonText)) {
                if (!txtNombres.getText().isEmpty()) {
                    operand1 = Double.parseDouble(txtNombres.getText());
                    operator = buttonText;
                    startNewInput = true;
                }
            } else if ("=".equals(buttonText)) {
                if (!txtNombres.getText().isEmpty() && !operator.isEmpty()) {
                    operand2 = Double.parseDouble(txtNombres.getText());
                    double result = calculateResult(operand1, operand2, operator);
                    txtNombres.setText(String.valueOf(result));
                    startNewInput = true;
                    operator = ""; // Réinitialiser après le calcul
                }
            }
        }
    }

    private double calculateResult(double op1, double op2, String operator) throws ArithmeticException {
        switch (operator) {
            case "+":
                return op1 + op2;
            case "-":
                return op1 - op2;
            case "X":
                return op1 * op2;
            case "/":
                if (op2 == 0) throw new ArithmeticException("Division par zéro");
                return op1 / op2;
            default:
                throw new IllegalArgumentException("Opérateur non valide");
        }
    }
}
