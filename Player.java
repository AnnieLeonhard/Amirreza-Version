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
    int theCapacity = 12;
    private int count;
    private int animateSpeed = 5;
    private int animateImage = 0;
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
        animate();
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
        GreenfootSound gunShot = new GreenfootSound("gun_shot.mp3");
        if (Greenfoot.mousePressed(null) && theCapacity > 0) {
        Projectile projectile =  new  Projectile();
        getWorld().addObject(projectile, getX(), getY());
        projectile.setRotation(getRotation());
        theCapacity--;
        gunShot.play();
        gunShot.setVolume(30);
        } 
        if (Greenfoot.isKeyDown("space") && getObjectsInRange(100, Projectile.class).isEmpty())
        {
        Projectile projectile =  new  Projectile();
        getWorld().addObject(projectile, getX(), getY());
        projectile.setRotation(getRotation());
        gunShot.play();
        gunShot.setVolume(30);
        }
        
    }
    
    public void reload()
    {
        if (Greenfoot.isKeyDown("r"))
        {
            theCapacity = 12;
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
    
    public void animate(){
    if(Greenfoot.isKeyDown("w")){
        if(count % animateSpeed == 0) {
            if(animateImage == 20) {
                animateImage = 0;
            }
            setImage("survivor-move_handgun_" + animateImage + ".png");
            animateImage = animateImage + 1;
            getImage().scale(78,78);
        }
    }
    else if (Greenfoot.isKeyDown("a")) {
           if (count % animateSpeed == 0) {
                if (animateImage == 20) {
                   animateImage = 0;
                }
                setImage("survivor-move_handgun_" + animateImage + ".png");
                animateImage = animateImage + 1;
                getImage().scale(78, 78);
        }
        }
    else if (Greenfoot.isKeyDown("s")) {
            if (count % animateSpeed == 0) {
                if (animateImage == 20) {
                   animateImage = 0;
                }
                setImage("survivor-move_handgun_" + animateImage + ".png");
                animateImage = animateImage + 1;
                getImage().scale(78, 78);
        }
        }
    else if (Greenfoot.isKeyDown("d")) {
            if (count % animateSpeed == 0) {
                if (animateImage == 20) {
                   animateImage = 0;
                }
                setImage("survivor-move_handgun_" + animateImage + ".png");
                animateImage = animateImage + 1;
                getImage().scale(78, 78);
        }
      }
    else{
        if (count % animateSpeed == 0) {
                if (animateImage == 20) {
                   animateImage = 0;
                }
                setImage("survivor-idle_handgun_" + animateImage + ".png");
                animateImage = animateImage + 1;
                getImage().scale(78, 78);
        }
    }
    }
}
