import java.util.HashMap;
/**
 * Write a description of class Ficha here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ficha
{
    // instance variables - replace the example below with your own
    private int x;
    private int y,width;
    public static  boolean sele;
    public static boolean dr, dl, ur, ul;
    private Circle ficha;
    private String color;
    private boolean king;
    public static HashMap<Integer,int[]> enumera;
    /**
     * Constructor for objects of class Ficha
     */
    public Ficha(int x, int y , String color,int width, boolean king)
    {
        this.x = x;
        this.y = y;
        this.color = color;
        this.king = king;
        sele  = false;
        ficha = new Circle(x,y,color,width);
        
    }
    /**
     * @param String color
     */
    public void cambiarColor(String color){
        ficha.changeColor(color);
        this.color = color;
    }
    /**
     * vuelve visible la ficha
     */
    public void makeVisible(){
        ficha.makeVisible();    
    }
    /**
     * vuelve insible la ficha
     */
    public void makeInvisible(){
        ficha.makeInvisible();    
    }
    /**
     * @return int x
     */
    public Integer getX(){
        return x;
    }
    /**
     * @return int y
     */
    public Integer getY(){
        return y;
    }
    /**
     * @return boolean king
     */
    public boolean getKing(){
        return king;
    }
    /**
     * @param boolean top
     * @param boolean right
     */
    public void move(boolean top, boolean right){
        if (top==false && right == true){
            ficha.moveDiagonal(20,20);
            x+=20;
            y+=20;
        }else if(top==false && right == false){
            ficha.moveDiagonal(20,-20);
            x+=20;
            y-=20;
        }else if(top == true && right == true){
            ficha.moveDiagonal(-20,-20);
            x-=20;
            y-=20;
        }else{
            ficha.moveDiagonal(-20,20);
            x-=20;
            y+=20;
        }
    }
    
    public void moveDiagonal(int x , int y){
        this.x +=x;
        this.y +=y;
        ficha.moveDiagonal(x,y);        
    }
    /**
     * @boolean top
     * @boolean right
     */
    public void jump(boolean top, boolean right){
        if (top==false && right == true){
            ficha.moveDiagonal(40,40);
            x+=40;
            y+=40;
        }else if(top==false && right == false){
            ficha.moveDiagonal(40,-40);
            x-=40;
            y+=40;
        }else if(top == true && right == true){
            ficha.moveDiagonal(-40,40);
            x+=40;
            y-=40;
        }else if(top == true && right == false){
            ficha.moveDiagonal(-40,-40);
            x-=40;
            y-=40;
        }
    }
    /**
     * @return String color
     */
    public String getColor(){
        return color;
    }
    
    

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
