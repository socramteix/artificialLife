package colisaoo;
public class Ponto{
  public int x;
  public int y;
  
  Ponto(int x, int y){
     this.x = x;
     this.y = y;
  }

  public void add(Ponto p){
    x += p.x;
    y += p.y;
  }

  public String toString(){
     return ("(" + x + " , " + y + ")"); 
  }
}