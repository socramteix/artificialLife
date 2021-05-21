package colisaoo;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

interface Drawable{
   public void draw(Graphics g);
   public void move(); 
}


public abstract class Forma implements Drawable{
   private int idx;	
   protected Ponto centro;
   protected int raio = 100;
   protected Color cor;
   protected Ponto lu;
   protected Ponto rd;
   protected Random r;
   protected Ponto d;  
   protected int energia;
   protected int genero;
   protected boolean vivo;

   Forma(){
	  r = new Random() ;
	  vivo = true;
   }
    
   public Ponto getCenter(){ return centro;}
   
   public abstract int getEspecie();
   
   
   public boolean inRange(Forma f){
	   
       Ponto c = f.getCenter();
       int dx = (c.x-centro.x);
       int dy = (c.y-centro.y);
       return ((dx*dx + dy*dy) < raio);
	   }
	
	   
   
   public abstract void changeColor();
  
   abstract public Forma colisao(Forma f);
   abstract public int getEnergia();
   
   public void move(){
	      if (rd.x+d.x >= 700 || lu.x+d.x <= 0){
	          d.x = -d.x;
	      }
	      if(lu.y+d.y <= 0 || rd.y+d.y >= 500){
	          d.y = -d.y;
	      }
	      lu.add(d);
	      rd.add(d);
	      centro.add(d);
   }
   public boolean estarVivo(){
      	return vivo;
   }
   
   public void morrer(){
        vivo = false;
   }
    
   public void decEnergia(int n){
    	energia -= n;
    	if(energia <= 0){
    		morrer();
    	}
    }
    
    public final void setIdx(int i){
    	idx = i;
    }
    public final int getIdx(){
    	return idx;
    }
}