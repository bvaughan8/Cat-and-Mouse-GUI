import java.util.Random;
import java.lang.Math.*;
public class Cat extends Creature{
    private int round;
    private boolean ate = false;
    private Creature currentChasing;
    public Cat(int x, int y, City cty, Random rnd){
        super(x, y, cty, rnd);
        this.lab = LAB_YELLOW;
    }

    public void step(){
        point.x += 2 * dirX[this.dir];
        point.y += 2 * dirY[this.dir];
        this.round ++;
    }
    public void takeAction(){
        changeDir();
        zombie();
        search();
        chase();
    }
    public void changeDir(){
        if(rand.nextInt(20) == 0){
            randomTurn();
        }
    }
    public void zombie(){
        if(this.round == 50 && this.ate == false){
            this.dead = true;
            this.city.creaturesToAdd.add(new ZombieCat(this.getX(),this.getY(),this.city,rand));
        }
    }
    public void eat(){
        if(this.point.equals(currentChasing.point) == true){
            currentChasing.dead = true;
            this.ate = true;  
            this.lab = LAB_YELLOW;               
            currentChasing = null;
        } 
    }
    public void search(){
        for(Creature c: city.creatures){
            if(this.point.dist(c.point) <= 20 && c instanceof Mouse){
                currentChasing = c;
                this.lab = LAB_CYAN;
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