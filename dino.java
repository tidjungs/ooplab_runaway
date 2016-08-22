import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class dino here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class dino extends Actor
{
    /**
     * Act - do whatever the dino wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     
    int vSpeed = 0;
    int acceleration = 1;
    boolean isMoving = false;
    int delay = 0;
    public void act() 
    {
        jump();
        checkFall();
        moving();
        crash();
        slide();
        delay--;
    }
    public void slide()
    {
        if(Greenfoot.isKeyDown("shift")) {
            setRotation(-90);
            setLocation(getX(), 400);
        } else {
            setRotation(0);
        }
    }
    public void jump()
    {
        if (Greenfoot.isKeyDown("space") && getY() == 358) {
            vSpeed = -25;
            fall();
        } 
   
    }
    public void fall()
    {
        //System.out.println(getY());
        setLocation(getX(), getY()+vSpeed);
        vSpeed = vSpeed + acceleration;
    }
    public void checkFall()
    {
        if (getY() >= 358) {
            vSpeed = 0;
            setLocation(getX(), 358);
        }
        else {
            fall();
        }
   }
   public void moving()
    {   
        if(delay == 0) {
            if(isMoving) { 
                setImage(new GreenfootImage("dino.png"));
                delay = 10;
                isMoving = false; 
            } else {
                setImage(new GreenfootImage("dinoMove.png"));
                delay = 10;
                isMoving = true;
            }
        }
    }
    public void crash()
    {
        Actor object = getOneIntersectingObject(Object.class);
        if(object != null) {
           setLocation(getX() - 40, getY());
           World world = getWorld();
           world.removeObject(object);
        }
    }
    
}
