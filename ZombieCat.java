import java.util.Random;
import java.lang.Math.*;
public class ZombieCat extends Cat{
    private int round;
    private boolean ate = false;
    private Creature currentChasing;
    public ZombieCat(int x, int y, City cty, Random rnd){
        super(x, y, cty, rnd);
        this.lab = LAB_RED;
    }

    public void step(){
        point.x += 3 * dirX[this.dir];
        point.y += 3 * dirY[this.dir];
        this.round ++;
    }
    public void takeAction(){
        randomTurn();
        dies();
        search();
        chase();
    }
    public void dies(){
        if(this.round == 100 && this.ate == false){
            this.dead = true;
        }
    }
    public void eat(){
        if(this.point.equals(currentChasing.point) == true){
            if(currentChasing instanceof Mouse){
                currentChasing.dead = true;
                this.ate = true;  
                this.lab = LAB_RED;              
                currentChasing = null;
            }
            else{
                currentChasing.dead = true;
                this.ate = true;  
                this.city.creaturesToAdd.add(new ZombieCat(this.getX(),this.getY(),this.city,rand));              
                this.lab = LAB_RED; 
                currentChasing = null;
            }
        } 
    }
    public void search(){
        for(Creature c: city.creatures){
            if(this.point.dist(c.point) <= 40 && ((c instanceof Cat) && (c instanceof ZombieCat == false) || c instanceof Mouse)){
                currentChasing = c;
                this.lab = LAB_BLACK;
            }
        }
    }
    public void chase(){
        if(currentChasing != null){
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