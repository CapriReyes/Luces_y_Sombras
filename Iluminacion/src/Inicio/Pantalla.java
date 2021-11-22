package Inicio;

import javax.swing.JFrame;

public class Pantalla extends JFrame {
    public Panel panel;    
    public Pantalla(){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Iluminacion");
        setSize(1200,700);
        setLocationRelativeTo(null);
        componentes();
    }
    public void componentes(){
        setLayout(null);
        panel=new Panel();
        panel.setBounds(0, 0,1200,700);
        add(panel);
    }
}   
