// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;
import java.util.List;
public class MyWorld extends World
{
    private int count = 0;
    /* if you lower value of spawnSpeed, the Spawn speed will be faster.*/
    private int spawnSpeed = 50;
    private int randomSpawn;
    //GreenfootSound backgroundMusic = new GreenfootSound("My War.wav");
    public Player mainPlayer = new Player();
    Counter counter = new Counter();
    HealthBar healthbar = new HealthBar();
    int waveNumber = 1;
    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld()
    {
        super(1320,850, 1);
        setBackground("tileable10t.png");
        addObject(mainPlayer, getWidth()/2, getHeight()/2);
        addObject(counter, 130, 100);
        addObject(healthbar, mainPlayer.getX() - 5, mainPlayer.getY()-50);
        showText​("Wave 1", 660, 660);
        //backgroundMusic.playLoop();
        //backgroundMusic.setVolume(35);
    }

    public Player getPlayer()
    {
        return mainPlayer; 
    }

    /**
     * 
     */
    public void act()
    {
        count++;
        spawnZombies();
        showWave();
        waveCompleted();
        waveTime();
    }

    public void spawnZombies()
    {
        if (count % spawnSpeed == 0) {
            randomSpawn = Greenfoot.getRandomNumber(8);
            switch (randomSpawn) {
                case 0 : addObject(new Zombie(mainPlayer, counter), 0, 0); 
                break;
                case 1 : addObject(new Zombie(mainPlayer, counter), getWidth()/2, 0);
                break;
                case 2 : addObject(new Zombie(mainPlayer, counter), getWidth(), 0); 
                break;
                case 3 : addObject(new Zombie(mainPlayer, counter), 0, getHeight()/2);
                break;
                case 4 : addObject(new Zombie(mainPlayer, counter), getWidth(), getHeight()/2);
                break;
                case 5 : addObject(new Zombie(mainPlayer, counter), 0, getHeight());
                break;
                case 6 : addObject(new Zombie(mainPlayer, counter), getWidth()/2, getHeight());
                break;
                case 7 : addObject(new Zombie(mainPlayer, counter), getWidth(), getHeight());
                break;

            }
        }
    
    }
   
    /*public void wave()
    {
        if (count/60 < 13)
        {
            removeObjects(getObjects(Zombie.class));
            showText​("Wave 1 Completed", 660, 660);
            
        } else {
            showText("Wave 2", 660,660);
            spawnZombies();
        }
    }*/
    
   
    public void showWave()
    {
        showText("Wave " + waveNumber, 660, 660);
    }
    
    public void waveCompleted()
    {
        if(count/80 > 10 && count/75 < 15)
        {
            showText("Wave " + waveNumber + " Completed", 660, 660);
            removeObjects(getObjects(Zombie.class));
        }
    }
    
    public void waveTime()
    {
        if(count/60 > 14)
        {
            waveNumber++;
            count = 0;
            spawnZombies();
        }
    }
    
    public void stopped()
    {
        //backgroundMusic.pause();
    }

}