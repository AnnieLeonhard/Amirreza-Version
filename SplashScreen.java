// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class SplashScreen extends World
{
    int time = 0;
    /**
     * Constructor for objects of class StartScreen.
     */
    public SplashScreen()
    {
        super(1000, 800, 1);
        setBackground("Cool2.jpg");
        getBackground().scale(1020,800);
        prepare();
    }

    /**
     * 
     */
    public void act()
    {
        time++;
        if (Greenfoot.isKeyDown("enter")) {
            Greenfoot.setWorld( new MenuWorld());
        } else {
            if(time/60 > 3){
            Greenfoot.setWorld( new MenuWorld());
            }
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //TitleLetters titleLetters =  new TitleLetters();
        //addObject(titleLetters, 500, 325);
    }
}
