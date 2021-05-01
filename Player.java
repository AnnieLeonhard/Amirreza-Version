import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Player extends Actor
{
    int speed = 3;
    int time = 0;
    int theCapacity = 7;
    /**
     * 
     */
    public void health()
    {
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        turnAround();
        moveAround();
        fireProjectile();
        setImage("Player.png");
        getImage().scale(60,60);
        hitByZombie();
        running();
        time++;
        reload();
    }

    /**
     * 
     */
    public void turnAround()
    {
        if (Greenfoot.getMouseInfo() != null) {
            turnTowards(Greenfoot.getMouseInfo().getX(), Greenfoot.getMouseInfo().getY());
        }
    }

    /**
     * 
     */
    public void moveAround()
    {
        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - speed);
        }
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - speed, getY());
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + speed);
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + speed, getY());
        }
    }

    /**
     * 
     */
    public void fireProjectile()
    {
        if (Greenfoot.mousePressed(null) && theCapacity > 0) {
        Projectile projectile =  new  Projectile();
        getWorld().addObject(projectile, getX(), getY());
        projectile.setRotation(getRotation());
        theCapacity--;
        } 
        if (Greenfoot.isKeyDown("space") && getObjectsInRange(100, Projectile.class).isEmpty())
        {
        Projectile projectile =  new  Projectile();
        getWorld().addObject(projectile, getX(), getY());
        projectile.setRotation(getRotation());
        }
        
    }
    
    public void reload()
    {
        if (Greenfoot.isKeyDown("r"))
        {
            theCapacity = 7;
        }
    }
    
    public boolean hitByZombie()
    {
        Actor zombie = getOneObjectAtOffset(0, 0, Zombie.class);
        if(zombie!=null)
        {
            return true;
        }
        else
            return false;
    }

    public void running()
    {
        if (Greenfoot.isKeyDown("Shift")) {
            speed = 6;
        } else {
            speed = 3;
        }
    }
}
