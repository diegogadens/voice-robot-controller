
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Simulador.java
 *
 * Created on 17 de Novembro de 2008, 16:06
 */

/**
 *
 * @author  Diego
 */
public class Simulador extends javax.swing.JFrame {
    
    public static String direçãoAtual = "Cima";
    public static SampleThread novaThread;
    public static int pontoX = 250, pontoY = 250;

    /** Creates new form Simulador */
    public Simulador() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelRobo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setName("jPanel1"); // NOI18N

        labelRobo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/robôDireita.jpg"))); // NOI18N
        labelRobo.setName("labelRobo"); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(222, Short.MAX_VALUE)
                .addComponent(labelRobo)
                .addGap(206, 206, 206))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(labelRobo)
                .addContainerGap(272, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Simulador().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JLabel labelRobo;
    // End of variables declaration//GEN-END:variables
    
    public void setDireção(String direção)
    {
        if (direção.equals("Direita") && direçãoAtual.equals("Direita")){
            labelRobo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/robôBaixo.jpg")));
            direçãoAtual = "Baixo";
        }
        else
        if (direção.equals("Direita") && direçãoAtual.equals("Baixo")){
            labelRobo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/robôEsquerda.jpg")));
            direçãoAtual = "Esquerda";
        }
        else
        if (direção.equals("Direita") && direçãoAtual.equals("Esquerda")){
            labelRobo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/robôCima.jpg")));
            direçãoAtual = "Cima";
        }
        else
        if (direção.equals("Direita") && direçãoAtual.equals("Cima")){
            labelRobo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/robôDireita.jpg")));
            direçãoAtual = "Direita";
        }
        else
            
            
            
        if (direção.equals("Esquerda") && direçãoAtual.equals("Direita")){
            labelRobo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/robôCima.jpg")));
            direçãoAtual = "Cima";
        }
        else
        if (direção.equals("Esquerda") && direçãoAtual.equals("Cima")){
            labelRobo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/robôEsquerda.jpg")));
            direçãoAtual = "Esquerda";
        }
        else
        if (direção.equals("Esquerda") && direçãoAtual.equals("Esquerda")){
            labelRobo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/robôBaixo.jpg")));
            direçãoAtual = "Baixo";
        }
        else
        if (direção.equals("Esquerda") && direçãoAtual.equals("Baixo")){
            labelRobo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/robôDireita.jpg")));
            direçãoAtual = "Direita";
        }
    }
    
    
    public static void iniciaMovimento()
    {
        novaThread = new SampleThread("Iniciar");
    }
    
    public static void movimenta()
    {
        for(int i=0; i<100; i++){
            try {
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                Logger.getLogger(Simulador.class.getName()).log(Level.SEVERE, null, ex);
            }
            //System.out.println(direçãoAtual + "entrou no for");
            if(direçãoAtual.equals("Direita")){
                labelRobo.setLocation(pontoX+1, pontoY);
                pontoX++;
            }
            else    
            if(direçãoAtual.equals("Esquerda")){
                labelRobo.setLocation(pontoX-1, pontoY);
                pontoX--;
            }
            else
            if(direçãoAtual.equals("Cima")){
                labelRobo.setLocation(pontoX, pontoY-1);
                pontoY--;
            }
            else
            if(direçãoAtual.equals("Baixo")){
                labelRobo.setLocation(pontoX, pontoY+1);
                pontoY++;
                
            }
        }
            
       System.out.println("saiu do for");     
            
    }
    
    private static class SampleThread extends Thread {
        public String st;
        public SampleThread(String str) {
        
        super(str);
        st = str;
    }
    public void run() {
        
        if(st.equals("Iniciar"))
        {
            Simulador.movimenta();
        }
        

    }
}
    
}
