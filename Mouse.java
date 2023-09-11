import java.util.Random;
public class Mouse extends Creature{
    private int round;
    public Mouse(int x, int y, City cty, Random rnd){
        super(x, y, cty, rnd);
        this.lab = LAB_BLUE;
    }
    public void step(){
        point.x += dirX[this.dir];
        point.y += dirY[this.dir];
        this.round ++;
    }
    public void takeAction(){
        changeDir();
        babyMouse();
        dies();
    }
    public void changeDir(){
        if(rand.nextInt(5) == 0){
            randomTurn();
        }
    }
    public void babyMouse(){
        if(this.round == 20){
            this.city.creaturesToAdd.add(new Mouse(this.getX(),this.getY(),this.city,rand));
        }
    }
    public void dies(){
        if(this.round == 30){
            this.dead = true;
        }
    }
}