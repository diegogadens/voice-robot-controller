
import java.awt.Graphics;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Diego
 */
public class Imagens 
{
    public boolean leuImagem = false;
    public BufferedImage imagem;
    public BufferedImage imagemCortada;
    public File deletar;
    
    public static int tSilêncio = 20, alturaFinal = 45, larguraFinal = 20, nPixels = 900;
    
    private static BufferedImage imagemAConverter;
    private static FileWriter ps;
    
    public Imagens() throws InterruptedException
    {
        deletaGráficos();
        geraGráfico();

        //enquanto arquivo nao apareceu no hd espera (Thread.sleep(500))
        //if arquivoApareceuNoHD() == false
        // Thread.sleep(500);
        while(!leuImagem)
        {
            //width = largura
            //height =  altura
            try
            {
                imagem = ImageIO.read(new File("D:/imagens/comando.png"));

                System.out.println("Leu");
                leuImagem = true;
            }
            catch (Exception e)
            {
                System.out.println("Ainda não leu");
                leuImagem = false;
                Thread.sleep(500);
            }            
        }
        
        recortaImagem();
        
        try {
            converte();
        } catch (Exception ex) {
            System.out.println("Erro na conversão para texto");
        }
        
        interpretaComando();
        

    }

    
    public void geraGráfico()
    {
        try {
            Runtime.getRuntime().exec("matlab -r geragrafico"); 
        } catch (Exception ex) {
            System.out.println("Erro na execucao do comando: matlab -r geragrafico");
        } 
    }
    
    public void recortaImagem()
    {
        try
        {
            ImageIO.write(imagem.getSubimage(56, 27, imagem.getWidth()-98 , imagem.getHeight() - 64), "PNG", new File("D:/imagens/teste.png"));
            imagem = ImageIO.read(new File("D:/imagens/teste.png"));
        }
        catch(Exception e)
        {
            System.out.println("Erro ao recortar/salvar imagem");
        }
        
        
        int i, j, tamanho=0, tamanhoHorizontal=0, medidaLateral = 0, x1=0, x2=0, y1=0, y2=0, altura, largura;
        
        largura = imagem.getWidth();
        altura = imagem.getHeight();
        
        
        //encontra x1:
        for(i = 0; i < largura; i++)
        {
          //  System.out.println("entrou no primeiro for");
            tamanho = 0;
            for(j = 0; j < altura; j++)
            {
                if((imagem.getRGB(i, j)!=-1))
                    tamanho++;
            }
            if (tamanho > tSilêncio)
            {    
                x1 = i;
                i = largura;
            }
        }
       // System.out.println("saiu do primeiro for");
        
        
        //encontra x2
        for(i = largura-1; i > 0; i--)
        {
           // System.out.println("entrou no segundo for");
            tamanho = 0;
            for(j = 0; j < altura; j++)
            {
                        if((imagem.getRGB(i, j)!=-1))
                            tamanho++;
            }
            if (tamanho > tSilêncio)
            {    
                x2 = i;
                i = 0;
            }
        }
        //System.out.println("saiu do segundo for");
        
        //encontra y1
        for(j = 0; j < altura; j++)
        {
            //System.out.println("entrou no terceiro for");
            tamanho = 0;
            for(i = 0; i < largura; i++)
            {
                        if((imagem.getRGB(i, j)!=-1))
                            tamanho++;
            }
            if (tamanho > 1)
            {    
                y1 = j;
                j = altura;
            }
        }
        //System.out.println("saiu do terceiro for");
        
        //encontra y2
        for(j = altura-1; j > 0; j--)
        {
            //System.out.println("entrou no quarto for");
            tamanho = 0;
            for(i = 0; i < largura; i++)
            {
                        if((imagem.getRGB(i, j)!=-1))
                            tamanho++;
            }
            if (tamanho > 1)
            {    
                y2 = j;
                j = 0;
            }
        }
        
        //System.out.println("saiu do quarto for");
        tamanhoHorizontal = x2-x1;
        System.out.println("Tamanho Horizontal: "+tamanhoHorizontal);
        
        System.out.println("x1: " + x1 + ", x2: " + x2 + ", y1: " + y1 + ", y2: " + y2);
        
        
        if(tamanhoHorizontal>100)
        {
            try
            {
                //ImageIO.write(imagem.getSubimage(56, 27, imagem.getWidth()-98 , imagem.getHeight() - 64), "PNG", new File("C:/teste2.png"));
                ImageIO.write(imagem.getSubimage(x1, y1, (x2-x1), (y2-y1)), "PNG", new File("D:/imagens/teste2.png") );
                imagem = ImageIO.read(new File("D:/imagens/teste2.png"));
              
                Image teste = imagem.getScaledInstance(alturaFinal, larguraFinal, BufferedImage.SCALE_SMOOTH);
                BufferedImage redimensionada = (toBufferedImage(teste));
              
                ImageIO.write(redimensionada, "PNG", new File("D:/imagens/redimensionada.png")        );
            }
            catch(Exception e)
            {
                System.out.println("Erro ao recortar/salvar imagem");
            }
        }
        else
        {
            medidaLateral = ((150 - tamanhoHorizontal)/2);
            try
            {
                //ImageIO.write(imagem.getSubimage(56, 27, imagem.getWidth()-98 , imagem.getHeight() - 64), "PNG", new File("C:/teste2.png"));
                ImageIO.write(imagem.getSubimage(0, y1, largura, (y2-y1)), "PNG", new File("D:/imagens/teste2.png") );
                imagem = ImageIO.read(new File("D:/imagens/teste2.png"));
              
                Image teste = imagem.getScaledInstance(alturaFinal, larguraFinal, BufferedImage.SCALE_SMOOTH);
                BufferedImage redimensionada = (toBufferedImage(teste));
              
                ImageIO.write(redimensionada, "PNG", new File("D:/imagens/redimensionada.png")        );
            }
            catch(Exception e)
            {
                System.out.println("Erro ao recortar/salvar imagem");
            }
        }
            
                        
    }
    
    
        public static void converte() throws IOException
    {
        try {
            // TODO code application logic here
            imagemAConverter = ImageIO.read(new File("D:/imagens/redimensionada.png"));
        } catch (Exception ex) {
            System.out.println("Erro ao ler a imagem.");
        }
        
        
        ps = new FileWriter(new File("C:imagem.txt"));
        
        
        String resultado = "";
        char[] texto = new char[nPixels];
        int cont = 0;
        int i, j, altura, largura;
        altura = alturaFinal; largura = larguraFinal;
        
        //System.out.println("Vai entrar no for");
        for(i = 0; i < largura; i++)
        {
            //System.out.println("Entrou no for 1");
            for(j = 0; j < altura; j++)
            {
                //System.out.println(i+","+j);
                if(imagemAConverter.getRGB(j, i)!= -1) //if (pixel diferente de branco)
                {
                    //System.out.print("1;");
                    texto[cont] = '1';
                    cont++;
                }
                else
                {
                    //System.out.print("0;");
                    texto[cont] = '0'; 
                    cont++;
                }    
                    
            }
            //resultado += "\n";
            //System.out.print("\n");
            
        }
        //System.out.println("Saiu do for");
        
        for(int k=0; k<nPixels; k++)
        {
            ps.write(texto[k]);
            ps.write(';');
        }
        
        //System.out.println(ps);
        ps.close();
    }
    
    
    public void interpretaComando()
    {
        TelaPrincipal.setGrafico1();
        //TelaPrincipal.executar();
        // height: altura, width: largura
        int i, j, altura, largura, tamanho = 0, picos = 0;
        boolean subindo = false;
        altura = imagem.getHeight();
        largura = imagem.getWidth();
        
        
        for(i = 0; i < largura; i++)
        {
            tamanho = 0;
            for(j = 0; j < altura; j++)
            {
                        //System.out.print(  ((imagem.getRGB(i, j)==-1)? "0": "1")     );
                
                        if(imagem.getRGB(i, j)!=-1)
                            tamanho++;
            }
            //System.out.println(tamanho);
            if(tamanho > 30)
                subindo = true;
            else if (tamanho < 5 && subindo)
            {
                subindo = false;
                picos++;
                System.out.println(i+","+j);
            }
        }
        System.out.println("Picos: "+picos);
        //System.out.println("Altura: "+altura+", Largura: "+ largura);
        
        TelaPrincipal.setComando("");
        
        TelaPrincipal.executar();
        TelaPrincipal.mover();
        
    }

    public void deletaGráficos() 
    {
        deletar = new File("D:/imagens/comando.png");  
        if (deletar.exists() && deletar.isFile() )   
        {  
            deletar.delete();          
        }
        
        deletar = new File("D:/imagens/teste.png");  
        if (deletar.exists() && deletar.isFile() )   
        {  
            deletar.delete();          
        }
        
        deletar = new File("D:/imagens/teste2.png");  
        if (deletar.exists() && deletar.isFile() )   
        {  
            deletar.delete();          
        }
        
        deletar = new File("D:/imagens/teste.png");  
        if (deletar.exists() && deletar.isFile() )   
        {  
            deletar.delete();          
        }
    }
    
    // This method returns a buffered image with the contents of an image
    public static BufferedImage toBufferedImage(Image image) {
        if (image instanceof BufferedImage) {
            return (BufferedImage)image;
        }
    
        // This code ensures that all the pixels in the image are loaded
        image = new ImageIcon(image).getImage();
    
        // Determine if the image has transparent pixels; for this method's
        // implementation, see e661 Determining If an Image Has Transparent Pixels
        boolean hasAlpha = hasAlpha(image);
    
        // Create a buffered image with a format that's compatible with the screen
        BufferedImage bimage = null;
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            // Determine the type of transparency of the new buffered image
            int transparency = Transparency.OPAQUE;
            if (hasAlpha) {
                transparency = Transparency.BITMASK;
            }
    
            // Create the buffered image
            GraphicsDevice gs = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gs.getDefaultConfiguration();
            bimage = gc.createCompatibleImage(
                image.getWidth(null), image.getHeight(null), transparency);
        } catch (HeadlessException e) {
            // The system does not have a screen
        }
    
        if (bimage == null) {
            // Create a buffered image using the default color model
            int type = BufferedImage.TYPE_INT_RGB;
            if (hasAlpha) {
                type = BufferedImage.TYPE_INT_ARGB;
            }
            bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
        }
    
        // Copy image to buffered image
        Graphics g = bimage.createGraphics();
    
        // Paint the image onto the buffered image
        g.drawImage(image, 0, 0, null);
        g.dispose();
    
        return bimage;
    }

    
    // This method returns true if the specified image has transparent pixels
    public static boolean hasAlpha(Image image) {
        // If buffered image, the color model is readily available
        if (image instanceof BufferedImage) {
            BufferedImage bimage = (BufferedImage)image;
            return bimage.getColorModel().hasAlpha();
        }
    
        // Use a pixel grabber to retrieve the image's color model;
        // grabbing a single pixel is usually sufficient
         PixelGrabber pg = new PixelGrabber(image, 0, 0, 1, 1, false);
        try {
            pg.grabPixels();
        } catch (InterruptedException e) {
        }
    
        // Get the image's color model
        ColorModel cm = pg.getColorModel();
        return cm.hasAlpha();
    }

    
}
