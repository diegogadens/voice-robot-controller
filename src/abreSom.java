
import java.awt.BorderLayout;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author diego
 */
public class abreSom {
    public static JPanel tela;

            public static void main(String args[])
        {
            tela = new JPanel(new BorderLayout());

            //tela.add(botoesControle, BorderLayout.NORTH);
            //tela.add(btnPanel, BorderLayout.SOUTH);


            //tela.setTitle("Copyright 2003, R.G.Baldwin");
            //tela.setDefaultCloseOperation(EXIT_ON_CLOSE);
            tela.setSize(300,120);
            tela.setVisible(true);
            tela.repaint();
            
        }


}
