
import java.awt.FlowLayout;

/*
 * TelaPrincipal.java
 *
 * Created on 4 de Outubro de 2008, 21:49
 */
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 *
 * @author  Diego
 */
public class TelaPrincipal extends javax.swing.JFrame {
    
    public static BufferedImage imagem1, imagem2;
    //public static RedeNeural rede;
    public SampleThread sample;
    private FileWriter gravador;
    private FileReader leitor;
    Audio recorder;
    private static Simulador telaSimulador;
    
    
    

    
    /** Creates new form TelaPrincipal */
    public TelaPrincipal() {

        centralizaFrame(this);
        initComponents();
        
        jPanel1.setLayout(new FlowLayout());
        recorder = new Audio();
        recorder.repaint();
        jPanel1.add(recorder);
        recorder.setVisible(true);
        jPanel1.setSize(300, 120);
        jPanel1.setVisible(true);
        this.setVisible(true);
        
        //rede = new RedeNeural();
        
        telaSimulador = new Simulador();
        telaSimulador.setVisible(true);
        
        //telaSimulador.setDireção("Frente");

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        bCapturar = new javax.swing.JButton();
        bParar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        janelaComando = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        grafico1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(53, 78, 212));

        jPanel2.setBackground(new java.awt.Color(101, 157, 235));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setName("jPanel2"); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setMaximumSize(new java.awt.Dimension(210, 70));
        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bCapturar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MicrofoneON.PNG"))); // NOI18N
        bCapturar.setMaximumSize(new java.awt.Dimension(60, 70));
        bCapturar.setMinimumSize(new java.awt.Dimension(60, 70));
        bCapturar.setName("bCapturar"); // NOI18N
        bCapturar.setPreferredSize(new java.awt.Dimension(60, 70));
        bCapturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCapturarActionPerformed(evt);
            }
        });
        jPanel1.add(bCapturar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        bParar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MicrofoneOFF.PNG"))); // NOI18N
        bParar.setMaximumSize(new java.awt.Dimension(60, 70));
        bParar.setMinimumSize(new java.awt.Dimension(60, 70));
        bParar.setName("bParar"); // NOI18N
        bParar.setPreferredSize(new java.awt.Dimension(60, 70));
        bParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPararActionPerformed(evt);
            }
        });
        jPanel1.add(bParar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel3.setText("Comando:");
        jLabel3.setName("jLabel3"); // NOI18N

        janelaComando.setFont(new java.awt.Font("Tahoma", 0, 48));
        janelaComando.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        janelaComando.setName("janelaComando"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(janelaComando, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(janelaComando, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(101, 157, 235));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setName("jPanel3"); // NOI18N

        grafico1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        grafico1.setName("grafico1"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel2.setText("Som Capturado:");
        jLabel2.setName("jLabel2"); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(grafico1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(grafico1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void centralizaFrame(JFrame x)
    {
        //java.awt.Dimension tamanhoTela = java.awt.Toolkit.getDefaultToolkit().getScreenSize();  
        //int larguraTelaPrincipal = x.getWidth();  
        //int alturaTelaPrincipal = x.getHeight();  
        //x.setLocation((tamanhoTela.width-larguraTelaPrincipal)/2, (tamanhoTela.height-alturaTelaPrincipal)/2);
        x.setLocation(575,0);
    }
    
    
private void bCapturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCapturarActionPerformed
// TODO add your handling code here:
    
}//GEN-LAST:event_bCapturarActionPerformed

private void bPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPararActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_bPararActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) 
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }
    
    public static void setComando(String s)
    {
        janelaComando.setText(s);
    }
    
    public static void setGrafico1()
    {
        System.out.println("Seta o gráfico do som captado pelo microfone");
        BufferedImage redimensionada = null;
        try {

            imagem1 = ImageIO.read(new File("D:/imagens/teste2.png"));
            
            
              
                Image teste = imagem1.getScaledInstance(210, 150, BufferedImage.SCALE_SMOOTH);
                redimensionada = (Imagens.toBufferedImage(teste));
            
        } catch (Exception e) {
            System.out.println("Erro na leitura da imagem para colar na interface");
        }
        
        try {
            grafico1.setIcon(new ImageIcon(redimensionada));
                   
        } catch (Exception e) {
            System.out.println("Erro no SetIcon");
        }
        
        
    }
    
    public static void setGrafico2()
    {
        //if frente
            //seta grafico frente
        //if trás
            //seta grafico trás
        //if direita
            //seta grafico direita
        //if esquerda
            //seta grafico esquerda
    }
    
    public static void setErro(String s)
    {
        //vErro.setText(s);
    }
    
    public static void executar()
    {
        //rede.comparaArquivos();
        telaSimulador.setDireção(janelaComando.getText());
    }
    
    public static void mover()
    {
        telaSimulador.movimenta();
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bCapturar;
    public static javax.swing.JButton bParar;
    private static javax.swing.JLabel grafico1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JLabel janelaComando;
    // End of variables declaration//GEN-END:variables

    private class SampleThread extends Thread {
        public String st;
        public SampleThread(String str) {
        
        super(str);
        st = str;
    }
    public void run() {
        
        if(st.equals("Iniciar"))
        {
            //rede.treinar();
            //rede.testar();
        }
        else
        if(st.equals("Parar"))
        {
            //rede.epoch = 5001;
            //rede = null;
           // rede = new RedeNeural();
        }

    }
}

}
