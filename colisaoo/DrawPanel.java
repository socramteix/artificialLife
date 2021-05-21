package colisaoo;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.util.Random;

public class DrawPanel extends JPanel implements ActionListener{
	
	private Timer t;
    private Timer t1;
    public int tail;
    public Forma formas[];
    public JLabel jl;	
    private Random r = new Random();
    private int tempo;
    private int fim;
    
    public void addForma(Forma f){
    	if(tail >= formas.length){return;}
        formas[tail] = f;
        formas[tail].setIdx(tail);
        tail++;
    }
    
    public void removerForma(Forma f){
    	if(tail <= 0){return;}
        formas[tail-1].setIdx(f.getIdx());
    	formas[f.getIdx()] = formas[tail-1];
        tail --;
        
        }
    
     public void paintComponent(Graphics g){
          super.paintComponent(g);   
          g.drawRect(0,0,700,500);
          
          for(int i=0; i < tail; i++ ){
        	  if(formas[i] != null){
                   formas[i].move();
                   formas[i].draw(g);
              }
          }
     }
     
     public void colisoes(){
    	Forma r;
        for(int i = 0; i< tail-1; i++){
        	if(formas[i].energia <= 0){
        		formas[i].morrer();
        	}
           for(int j = i+1; j < tail; j++){
        	  if(formas[i] != null && formas[j] != null){
                if(formas[i].inRange(formas[j])){
            	    r = formas[i].colisao(formas[j]);
            	    if(r!=null){
            	    	addForma(r);
            	    }
            	    if(!formas[j].estarVivo()){
            	    	removerForma(formas[j]);
            	    }
            	    break;
                }
        	  }
           }
    	   if(!formas[i].estarVivo()){
   	    	removerForma(formas[i]);
   	       }  
        }
     }

     public void actionPerformed(ActionEvent e){
           colisoes(); 
           repaint();
     }
         
     class VegReprod implements ActionListener{
    	 	
    	 
	 public void actionPerformed(ActionEvent arg0) {
		     int k = 0;
			 for(int i = 0; i< tail-1; i++){        	 
	        	 if(formas[i].getEspecie() == 0){
	        		k++;
			     }
			 }
			 for(int i =0; i<= k; i++){
			     Forma f = new Circulo(10+ r.nextInt(700),10+ r.nextInt(700),10,10);      	 
    		     addForma(f);
			 }
	 } 
     }
     
    public void actionEvent(){}
    public void action(){} 
    public void stop(){
    	 t.stop();
         t1.stop();
    } 
    public void start(){
        t.start();
        t1.start();
    }
    
    DrawPanel(){
        super();
        tail = 0;
        formas = new Forma[1000];
        t = new Timer(150,this);
        tempo = 20;
        t1 = new Timer(tempo*1000,new VegReprod());
        fim = formas.length;
              
     }
    void setTempo(int tempo){
    	this.tempo = tempo;
    }
}