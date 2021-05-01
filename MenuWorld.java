// WARNING: This file is auto-generated and any changes to it will be overwritten
import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class MenuWorld extends World
{

    /**
     * Constructor for objects of class MenuWorld.
     */
    public MenuWorld()
    {
        super(1000, 800, 1);
        setBackground("Menu.png");
        getBackground().scale(1000, 800);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Start start = new Start();
        addObject(start,308,539);
        Settings settings = new Settings();
        addObject(settings,674,535);
    }
    
}
