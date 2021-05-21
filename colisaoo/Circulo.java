package colisaoo;

import java.awt.Color;
import java.awt.Graphics;

public class Circulo extends Forma{
	private Ponto p1;
	private int w;
	private int h;
		
	Circulo(int x, int y, int w, int h){
		p1 = new Ponto(x,y);
        this.w = w;
        this.h = h;
        rd = new Ponto(x+w,y+h);
        lu = new Ponto(x,y);
        centro = new Ponto(x+(w/2),y+(h/2));
        cor = new Color(41,168,19);
        if(r.nextBoolean() == true){
            d = new Ponto(r.nextInt(5),r.nextInt(5));     
        }
        else{
            d = new Ponto(-1*r.nextInt(5),-1*r.nextInt(5)); 
        }
        energia = 200;
        genero = r.nextInt(1);
	}
	
	public void draw(Graphics g){
        g.setColor(cor);
        g.fillOval(p1.x,p1.y,w,h);
    }

    public void move(){
	      
    }
    public int getEspecie(){
  	    return 0;
    }
    public Forma colisao(Forma f){
	   return null;
    }
    public int getEnergia(){
	   return energia;
    }
  
    public void changeColor(){
         cor = new Color(100,0,0);
    }
}