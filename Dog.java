import java.util.Random;
import java.lang.Math.*;
public class Dog extends Creature{
    private int round;
    private Creature currentChasing;
    public Dog(int x, int y, City cty, Random rnd){
        super(x, y, cty, rnd);
        this.lab = LAB_GREEN;
    }

    public void step(){
        if(currentChasing != null){
            if(this.point.dist(currentChasing.point) <= 3){
                point.x += dirX[this.dir];
                point.y += dirY[this.dir];
                this.round ++;
            }
            else{
                point.x += 4 * dirX[this.dir];
                point.y += 4 * dirY[this.dir];
                this.round ++;  
            }
        }
        else{
            point.x += 4 * dirX[this.dir];
            point.y += 4 * dirY[this.dir];
            this.round ++;  
        } 
    }
    public void takeAction(){
        randomTurn();
        chase();
    }
    public void eat(){
        if(this.point.equals(currentChasing.point) == true){
            currentChasing.dead = true;
            this.lab = LAB_GREEN;  
            this.city.creaturesToAdd.add(new Dog(this.getX(),this.getY(),this.city,rand));            
            currentChasing = null;
        } 
    }
    public void chase(){
        for(Creature c: city.creatures){
            if((this.point.dist(c.point) <= 50) && (c instanceof ZombieCat)){
                currentChasing = c;
            }
        }
        if(currentChasing != null){
            this.lab = LAB_MAGENTA;
            if(Math.abs(currentChasing.getX() - this.getX()) > Math.abs(currentChasing.getY() - this.getY())){
                if(currentChasing.getX() > this.getX()){
                    this.dir = EAST;
                    eat();
                }
                else if(currentChasing.getX() < this.getX()){
                    this.dir = WEST;
                    eat();
                }
            }
            else{
                if(currentChasing.getY() > this.getY()){
                    this.dir = SOUTH;
                    eat();
                }
                else{
                    this.dir = NORTH;
                    eat();
                }
            }  
        }
    }
}