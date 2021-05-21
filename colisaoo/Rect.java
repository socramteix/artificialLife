package colisaoo;
import java.awt.Graphics;
import java.awt.Color;

class Rect extends Forma { 
	 private Ponto p1;
     private int w; 
     private int h;
     private int k;
     
   
     Rect(int x, int y, int w, int h){
         p1 = new Ponto(x,y);
         this.w = w;
         this.h = h;
         rd = new Ponto(x+w,y+h);
         lu = new Ponto(x,y);
         centro = new Ponto(x+(w/2),y+(h/2));
         k = 10;
         genero = r.nextInt(2);
         if(genero == 1){
        	 cor = new Color(239,0,43);
         }
         else{cor = new Color(0,0,0);}
         if(r.nextBoolean() == true){
             d = new Ponto(r.nextInt(5),r.nextInt(5));     
         }
         else{
             d = new Ponto(-1*r.nextInt(5),-1*r.nextInt(5)); 
         }
        
         energia   = 1000;         
     }
     
     public void draw(Graphics g){
         g.setColor(cor);
         g.fillRect(p1.x,p1.y,w,h);
     }
     
     private void newDir(){
    	  d.x = (r.nextInt(2) == 0) ? (-1)*r.nextInt(7) : r.nextInt(7);
          d.y = (r.nextInt(2) == 0) ? (-1)*r.nextInt(7) : r.nextInt(7);
          k = r.nextInt(8);
     }

     public void move(){
          super.move();
          p1.add(d); 
          if(k<=0){newDir();}
          k--;
          energia -= 3;
    }
         public Forma reproducao(Forma f){
    	     int h1 = r.nextInt(10);
    	     int h2 = r.nextInt(10);
    	     if(r.nextBoolean() == true){
    	         h1 = -h1;
    	     }
    	     if(r.nextBoolean() == true){
        	     h2 = -h2;
             }
    	     if(r.nextInt(100)>=10){return null;}
    	     else{decEnergia(500);
    	     return new Rect(f.centro.x+h1,f.centro.y+h2,10,10);} 
     }
    
     public Forma colisao(Forma f){
    	    if(f.getEspecie()== 2){
    	         if(f.energia > 500){
    	              return reproducao(f); 	 
    	         }
            }
    	    else{
    		     if(f.getEspecie() == 0){
                      f.morrer();
                      return null;
    		     } 
    		     if(f.getEspecie() == 3){
    			 return f.colisao(this);
    		     }
    		
           }
       
    	 return null;
     }
     public void predar(Forma f){
    	 energia += 200;
    	 f.morrer();
     }
     public int getEspecie(){
    	 return 2;
     }
     public int getEnergia(){
    	 return energia;
     }
     public void changeColor() {
	     cor = new Color(100,0,0);
	 }
	
}
