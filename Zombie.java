// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Zombie extends Actor
{
    private int count;
    private int animateSpeed = 5;
    private int animateImage = 0;
    private int health = 3;
    Player player;
    Counter counter;
    /**
     * 
     */
    public Zombie(Player mainPlayer, Counter counter)
    {
        this.counter = counter;
        player = mainPlayer;
        setImage("skeleton-idle_16.png");
        getImage().scale(60, 60);
    }

    /**
     * Act - do whatever the Zombie wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        count = count + 1;
        animate();
        moveAround();
        hitByProjectile();
    }

    /**
     * 
     */
    public void animate()
    {
        if (count % animateSpeed == 0) {
            if (animateImage == 16) {
                animateImage = 0;
            }
            setImage("skeleton-move_" + animateImage + ".png");
            animateImage = animateImage + 1;
            getImage().scale(80, 80);
        }
    }

    public void moveAround()
    { move(1);
        turnTowards(player.getX(), player.getY());
    }

    public void hitByProjectile(){
        Actor projectile = getOneIntersectingObject(Projectile.class);
        if(projectile != null)
        {
            health--;
            getWorld().removeObject(projectile);
        }
        if(health == 0){
            counter.score++;
            counter.money+=5;
            GreenfootSound deathSound = new GreenfootSound("Death_3.wav");
            deathSound.setVolume(55);
            //Greenfoot.playSound("Death_3.wav");
            deathSound.play();
            getWorld().removeObject(this);
        }
    }
}
