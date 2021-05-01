// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Projectile extends Actor
{

    /**
     * 
     */
    public Projectile()
    {
        setImage( new GreenfootImage(10, 2));
        getImage().setColor(Color.ORANGE);
        getImage().fillRect(0, 0, 10, 2);
    }

    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(10);
        if(isAtEdge()){
        getWorld().removeObject(this);
        }
    }
    
    
    
}
