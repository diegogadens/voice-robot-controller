//teste

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/*
  * Encog Neural Network and Bot Library for Java
  * http://www.heatonresearch.com/encog/
  * http://code.google.com/p/encog-java/
  * 
  * Copyright 2008, Heaton Research Inc., and individual contributors.
  * See the copyright.txt in the distribution for a full listing of 
  * individual contributors.
  *
  * This is free software; you can redistribute it and/or modify it
  * under the terms of the GNU Lesser General Public License as
  * published by the Free Software Foundation; either version 2.1 of
  * the License, or (at your option) any later version.
  *
  * This software is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
  * Lesser General Public License for more details.
  *
  * You should have received a copy of the GNU Lesser General Public
  * License along with this software; if not, write to the Free
  * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
  * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
  */

//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.StringTokenizer;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.encog.neural.data.NeuralData;
//import org.encog.neural.data.NeuralDataPair;
//import org.encog.neural.data.NeuralDataSet;
//import org.encog.neural.data.basic.BasicNeuralDataSet;
//import org.encog.neural.networks.BasicNetwork;
//import org.encog.neural.networks.Train;
//import org.encog.neural.networks.layers.FeedforwardLayer;
//import org.encog.neural.networks.training.backpropagation.Backpropagation;
//
//
///**
// * XOR: This example is essentially the "Hello World" of neural network
// * programming.  This example shows how to construct an Encog neural
// * network to predict the output from the XOR operator.  This example
// * uses backpropagation to train the neural network.
// *
// * @author $Author$
// * @version $Revision$
// */
//
//public class RedeNeural {
//
//        //public static double INPUT_TREINO[][] = { { 0, 0 }, { 1, 0 },
//			//{ 0, 1 }, { 1, 1 } };
//
//        public static int nNeuronios=900, nSaidas=3, nPadroes = 3;
//        public static double INPUT_TREINO[][] = new double[nPadroes][nNeuronios];
//	public static double SAIDA_IDEAL_TREINO[][] = new double [nPadroes][nSaidas];
//
//        public static double INPUT_EXECUCAO[][] = new double[1][nNeuronios];
//        public static double SAIDA_EXECUCAO[][] = new double[2][nSaidas];
//
//
//        public static int entrada[] = new int[nNeuronios];
//        public static int saida[] = new int[nSaidas];
//        public BasicNetwork network;
//        public NeuralDataSet trainingSet;
//        public NeuralDataSet execução;
//        public int epoch;
//        public boolean parar=false;
//        public int bit1, bit2, bit3, bit4;
//        public Double learnRate, momentum;
//
//	public RedeNeural()
//        {
//		lêArquivoTreinamento();
//
//                //imprimeArquivos();
//
//            network = new BasicNetwork();
//		network.addLayer(new FeedforwardLayer(nNeuronios));
//		network.addLayer(new FeedforwardLayer(nNeuronios/2));
//		network.addLayer(new FeedforwardLayer(nSaidas));
//		network.reset();
//
//
//            trainingSet = new BasicNeuralDataSet(INPUT_TREINO, SAIDA_IDEAL_TREINO);
//
//
//                //--------------treinar();
//                //--------------testar();
//
//                //--------------lêArquivoExecução();
//                //-----------executar();
//	}
//
//
//        public void treinar()
//        {
//            System.out.println("Treina");
//            // train the neural network
//		final Train train = new Backpropagation(network, trainingSet,
//				getLearnRate() , getMomentum());
//
//
//		epoch = 1;
//
//
//                do {
//                        train.iteration();
//			System.out
//					.println("Epoch #" + epoch + " Error:" + train.getError());
//			epoch++;
//                        TelaPrincipal.setErro(""+train.getError());
//		} while ((epoch < 5000) && (train.getError() > 0.01));
//        }
//
//
//        public void testar()
//        {
//            System.out.println("Testa");
//            // test the neural network
//		System.out.println("Neural Network Results:");
//		for(NeuralDataPair pair: trainingSet ) {
//			final NeuralData output = network.compute(pair.getInput());
//
//                        System.out.println("actual=" + output.getData(0) + ", "+output.getData(1) + ", "+output.getData(2) + ",ideal=" + pair.getIdeal().getData(0) +", "+ pair.getIdeal().getData(1)+", "+ pair.getIdeal().getData(2));
//		}
//        }
//
//        public void executar()
//        {
//            execução = new BasicNeuralDataSet(INPUT_EXECUCAO, SAIDA_IDEAL_TREINO);
//            System.out.println("Executa");
//            // test the neural network
//		System.out.println("Neural Network Results:");
//		for(NeuralDataPair pair: execução ) {
//			final NeuralData output = network.compute(pair.getInput());
//
//
//
//                        if(output.getData(0)<0.5)
//                            bit1 = 0;
//                        else
//                        if ((output.getData(0)>=0.5))
//                            bit1 = 1;
//                        else
//                            bit1 = -1;
//
//                        if(output.getData(1)<0.5)
//                            bit2 = 0;
//                        else
//                        if ((output.getData(1)>=0.5))
//                            bit2 = 1;
//                        else
//                            bit2 = -1;
//
//                        if(output.getData(2)<0.5)
//                            bit3 = 0;
//                        else
//                        if ((output.getData(2)>=0.5))
//                            bit3 = 1;
//                        else
//                            bit3 = -1;
//
//                        /*if(output.getData(3)<=0.5)
//                            bit4 = 0;
//                        else
//                        if ((output.getData(3)>=0.5))
//                            bit4 = 1;
//                        else
//                            bit4 = -1;*/
//
//                        System.out.println(output.getData(0)+", "+output.getData(1)+", "+output.getData(2));
//                        //System.out.println(pair.getInput().getData(0) + "," + pair.getInput().getData(1)
//			//		+ ", actual=" + output.getData(0) + ",ideal=" + pair.getIdeal().getData(0));
//		}
//        }
//
//
//        public static void setInputExecução()
//        {
//            for(int i=0; i<nNeuronios; i++)
//            {
//                INPUT_EXECUCAO[0][i] = entrada[i];
//            }
//        }
//
//
//        public static void setInputTreinamento(int linha)
//        {
//            for(int i=0; i<nNeuronios; i++)
//            {
//                INPUT_TREINO[linha][i] = entrada[i];
//            }
//        }
//
//        public static void setOutputTreinamento(int linha)
//        {
//            for(int i=0; i<nSaidas;i++)
//            {
//                SAIDA_IDEAL_TREINO[linha][i] = saida[i];
//            }
//        }
//
//
//        /*public static void imprimeArquivos()
//        {
//            int cont=0;
//                for(int i=0; i<nNeuronios; i++)
//                {
//
//                    System.out.printf("%.0f;",INPUT_TREINO[0][i]);
//                    cont++;
//                    if(cont==30)
//                    {
//                        System.out.println();
//                        cont = 0;
//                    }
//                }
//                //System.out.printf("%.0f;",SAIDA_IDEAL_TREINO[0][0]);
//                //System.out.printf("%.0f;\n",SAIDA_IDEAL_TREINO[0][1]);
//
//                cont=0;
//                for(int i=0; i<nNeuronios; i++)
//                {
//
//                    System.out.printf("%.0f;",INPUT_TREINO[1][i]);
//                    cont++;
//                    if(cont==30)
//                    {
//                        System.out.println();
//                        cont = 0;
//                    }
//                }
//                System.out.printf("%.0f;",SAIDA_IDEAL_TREINO[1][0]);
//                System.out.printf("%.0f;\n",SAIDA_IDEAL_TREINO[1][1]);
//        }*/
//
//
//
//        public static void lêArquivoTreinamento()
//        {
//
//            System.out.println("Le treinamento");
//            //File entrada = new File("C:/xor.txt");
//            String arquivoFonte = "C:/in.txt";
//
//            BufferedReader reader = null;
//
//            int nLinha = 0;
//
//
//            try
//            {
//                reader = new BufferedReader(new FileReader(arquivoFonte));
//            }
//            catch (FileNotFoundException ex)
//            {
//                Logger.getLogger(RedeNeural.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//
//            String linha = "";
//            try
//            {
//                linha = reader.readLine();
//            }
//            catch (Exception e)
//            {
//                System.out.println("erro");
//            }
//
//
//            while (linha != null)
//            {
//
//             StringTokenizer st = new StringTokenizer(linha,";");
//
//                for(int i=0; i<nNeuronios; i++)
//                {
//                    entrada[i] = Integer.parseInt(st.nextToken());
//                }
//
//
//                //for(int i=0;i<nSaidas;i++)
//                //{
//                //    saida[i] = Integer.parseInt(st.nextToken());
//                //}
//
//
//
//                int cont=0;
//                for(int i=0; i<nNeuronios; i++)
//                {
//
//                    //System.out.print(entrada[i]+";");
//                    cont++;
//                    if(cont==30)
//                    {
//                        //System.out.println();
//                        cont = 0;
//                    }
//                }
//                //System.out.print(saida[0]+";");
//                //System.out.println(saida[1]+";");
//
//                setInputTreinamento(nLinha);
//                //setOutputTreinamento(nLinha);
//                nLinha++;
//
//             try {
//
//                linha = reader.readLine();
//            } catch (IOException ex) {
//                Logger.getLogger(RedeNeural.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            }
//        }
//
//
//
//        public static void lêArquivoExecução()
//        {
//            //File entrada = new File("C:/xor.txt");
//            String arquivoFonte = "C:/imagem.txt";
//
//            BufferedReader reader = null;
//
//            int nLinha = 0;
//
//
//            try
//            {
//                reader = new BufferedReader(new FileReader(arquivoFonte));
//            }
//            catch (FileNotFoundException ex)
//            {
//                Logger.getLogger(RedeNeural.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//
//            String linha = "";
//            try
//            {
//                linha = reader.readLine();
//            }
//            catch (Exception e)
//            {
//                System.out.println("erro");
//            }
//
//
//            StringTokenizer st = new StringTokenizer(linha,";");
//
//                for(int i=0; i<nNeuronios; i++){
//
//                    entrada[i] = Integer.parseInt(st.nextToken());
//                }
//
//                setInputExecução();
//
//
//             try {
//
//                linha = reader.readLine();
//            } catch (IOException ex) {
//                Logger.getLogger(RedeNeural.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//        }
//
//        public void comparaArquivos(){
//            int direita = 0, esquerda = 0, frente = 0;
//            lêArquivoExecução();
//
//            for(int j=0; j<900; j++){
//                    if(INPUT_TREINO[0][j] == entrada[j])
//                        direita++;
//            }
//
//            for(int j=0; j<900; j++){
//                    if(INPUT_TREINO[1][j] == entrada[j])
//                        esquerda++;
//            }
//
//            for(int j=0; j<900; j++){
//                    if(INPUT_TREINO[2][j] == entrada[j])
//                        frente++;
//            }
//
//            int maior = 0;
//            String resposta = "";
//
//            if(direita > maior)
//            {
//                maior = direita;
//                resposta = "Direita";
//            }
//
//            if(esquerda > maior)
//            {
//                maior = esquerda;
//                resposta = "Esquerda";
//            }
//
//            if(frente > maior)
//            {
//                maior = frente;
//                resposta = "Frente";
//            }
//
//            System.out.println(
//
//                    "Direita: " + direita +"\n"+
//                    "Esquerda: " + esquerda +"\n"+
//                    "Frente: " + frente
//
//                    );
//
//
//
//            TelaPrincipal.janelaComando.setText(resposta);
//
//        }
//
//
//
//    public int getBit1() {
//        return bit1;
//    }
//
//    public int getBit2() {
//        return bit2;
//    }
//
//    public int getBit3() {
//        return bit3;
//    }
//
//    public int getBit4() {
//        return bit4;
//    }
//
//    public Double getLearnRate() {
//        return learnRate;
//    }
//
//    public void setLearnRate(Double l) {
//        learnRate = l;
//    }
//
//    public Double getMomentum() {
//        return momentum;
//    }
//
//    public void setMomentum(Double m) {
//        momentum = m;
//    }
//
//
//
//}
//