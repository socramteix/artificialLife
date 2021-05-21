package colisaoo;
import java.awt.Graphics;
import java.awt.Color;

public class Triangulo extends Forma{
   private int x[];
   private int y[];
   private int k;
   
   private int min3(int x, int y, int z){
       if (x < y) {
            if ( x < z ){ return x;}
            if ( y < z){return y;}else{return z;}             
       }
       else{
            return (y < z ? y: z);
       }
   }

   private int max3(int x, int y, int z){
       if (x > y){
            if ( x > z ){ return x;}
            if ( y > z){return y;}else{return z;}             
       }
       else{
            return (y > z ? y: z);
       }
   }


   Triangulo(int x0, int y0,
             int x1, int y1,
             int x2, int y2
             ){
	  genero = r.nextInt(2);
	  if(genero == 1){ cor = new Color(185,0,167);}
	  else{cor = new Color(0,0,255);}
      k = 10;
      energia = 10000;
      centro = new Ponto((x0+x1+x2)/3,(y0+y1+y2)/3);
      
      x = new int[3];
      x[0] = x0;
      x[1] = x1;
      x[2] = x2;
      
      y = new int[3];
      y[0] = y0;
      y[1] = y1;
      y[2] = y2;
 
      lu = new Ponto(min3(x[0],x[1],x[2]),min3(y[0],y[1],y[2]));
      rd = new Ponto(max3(x[0],x[1],x[2]),max3(y[0],y[1],y[2]));

      if(r.nextBoolean() == true){
          d = new Ponto(-1*r.nextInt(5),-1*r.nextInt(5));     
      }
      else{
      	  d = new Ponto(r.nextInt(5),r.nextInt(5)); 
      }
     
      genero = r.nextInt(2);
   }
   
  
   public void draw(Graphics g){
      g.setColor(cor);
      g.fillPolygon(x,y,3);
      //g.drawRect(lu.x,lu.y,rd.x-lu.x,rd.y-lu.y);
      //g.drawOval(centro.x-10,centro.y-10,50,20);
      //g.fillOval(centro.x-10,centro.y-10,20,20);
   }

   public void newDir(){ 
     d.x = (r.nextInt(2) == 0) ? (-1)*r.nextInt(7) : r.nextInt(7);
     d.y = (r.nextInt(2) == 0) ? (-1)*r.nextInt(7) : r.nextInt(7);
     k = r.nextInt(8);
   }
   public void move(){
	   super.move();
	   for(int i =0; i < 3; i++){
	         x[i] += d.x;
	         y[i] += d.y;
	   }
	   if(k<=0){newDir();}
	   k--;
	   energia -= 15;
	   
   }
   
   public Forma reproducao(Forma f){
  	   
	   if(r.nextInt(100) >= 11){return null;}
	        else{
	        	decEnergia(6000);
	   	        int h = r.nextInt(5);
	   	        int h1 = r.nextInt(5);
	   	        if(r.nextBoolean() == true){
	   	        h = -h;	
	   	        }
	   	    if(r.nextBoolean() == true){
		   	    h1 = -h1;	
		   	    }
	       
 	        return new Triangulo(f.centro.x+5+h,f.centro.y+h1,f.centro.x+10+h,f.centro.y+10+h1,f.centro.x+h,f.centro.y+10+h1);
 	        
	   	    }
 	   
   }


   public Forma colisao(Forma f) {
	   if(f.getEspecie()== 3){
    	   if(f.energia > 6000){
    	     return reproducao(f); 	
    	   }
        }
    	else{
    		if(f.getEspecie() == 2){
               f.morrer();
               return null;
    		}
        }
	   return null;
   }
   public int getEspecie(){
	   return 3;
   }
   public int getEnergia(){
	   return energia;
   }
   public void changeColor() {
	   cor = new Color(100,0,0);
	
   }
}

