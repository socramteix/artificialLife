/* GRUPO: EVERTON VIEIRA RODRIGUES, 10.1.8231; LUCAS SOARES DA CRUZ, 10.1.8114; MARCOS TEIXEIRA DE OLIVEIRA
, 10.1.8199; WILSON PEREIRA FREITAS, 10.1.8254; */



package colisaoo;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class GUISampleDraw implements ActionListener{
	 static DrawPanel d; 
	        JButton jb, jb2, jb3;
	        JMenuItem jmi, jmi2;
	 static JMenuBar jm;
	 static JPanel p2, opcao, opcao2;
	        JMenu j;
	        JLabel l1, l2, l3;
	 static GUISampleDraw g;
	        JFrame mainWindow2, mainWindow3;
	 static int quantidade;
	        Random r; 
	        JTextField jtf, jtf2;
		
	GUISampleDraw (){
		    j           = new JMenu("COMECANDO");
		    d           = new DrawPanel();
		    jb          = new JButton("PAUSE");
		    jb2         = new JButton("CONTINUE");
		    jb3         = new JButton("OK");
		    jmi         = new JMenuItem("INICIO");
		    jm          = new JMenuBar();
		    l3          = new JLabel("e o tempo de reproducao dos vegetais respectivamente");
		    l1          = new JLabel(" >>>>> VIDA ARTIFICIAL IMPLEMENTADA EM JAVA <<<<< "); 
		    l2          = new JLabel("Digite a quantidade de seres de cada especie");
		    p2          = new JPanel();
		    jtf2        = new JTextField("0",5);
		    jtf         = new JTextField("0",5);
	        opcao       = new JPanel();
	        mainWindow2 = new JFrame();
	        r           = new Random();
			
			
			jb .addActionListener(this);
			jb2.addActionListener(this);
			jb3.addActionListener(this);
			jmi.addActionListener(this);
	
			
			p2    .add(l1);
			p2    .add(jb);
			p2    .add(jb2);
			jm    .add(j);
		    j     .add(jmi);
		    opcao .add(jtf);
			opcao .add(jtf2);
			opcao .add(l2);
			opcao .add(l3);
			opcao .add(jb3);
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == jmi){
			
			mainWindow2.setVisible(true);
			mainWindow2.setSize(350,140);
			mainWindow2.add(opcao,BorderLayout.CENTER);
			mainWindow2.setResizable(false);	
		}
		if(e.getSource() == jb){
		    d.stop();			
		}
		if(e.getSource() == jb2){
			d.start();
		}
		if(e.getSource() == jb3){
			try{
			quantidade = Integer.parseInt(jtf.getText());
			d.setTempo(Integer.parseInt(jtf2.getText()));
			}
			catch(Exception exce){ JOptionPane.showMessageDialog(null,"Dgite um numero valido!");}
			
			for(int i = 0; i < quantidade; i++){
				  int h = r.nextInt(650);
				  int k = r.nextInt(450);
				  d.addForma(new Rect(10+r.nextInt(550),10+r.nextInt(450),10,10));
				  d.addForma(new Triangulo(25+h,20+k,30+h,30+k,20+h,30+k));
				  d.addForma(new Circulo(10+r.nextInt(650),10+r.nextInt(450),10,10));
		    }
		    d.start();
		    mainWindow2.dispose();
		}
		
}
 public static void main(String args[]){
	  g = new GUISampleDraw();
	  d = new DrawPanel();
	  
      d.setSize(720,520);
      d.setBackground(new Color(170,157,0));
      
     JFrame mainWindow = new JFrame();
     
     mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     mainWindow.setTitle("UNIVERSIDADE FEDERAL DE OURO PRETO - ICEA - JOAO MONLEVADE - VIDA ARTIFIAL");
     mainWindow.setJMenuBar(jm);
     mainWindow.add(d,BorderLayout.CENTER);
     mainWindow.add(p2,BorderLayout.NORTH);
     mainWindow.setSize( 707, 588);
     mainWindow.setVisible( true );
     mainWindow.setResizable(false);
  
  }
 		
}
