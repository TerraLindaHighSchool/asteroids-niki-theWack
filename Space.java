import greenfoot.*;

/**
 * Space. Something for rockets to fly in.
 * 
 * @author Michael Kölling
 * @version 1.1
 */
public class Space extends World
{
    private Counter scoreCounter;
    private int startAsteroids = 3;
    //private static int pointsToAdd = 25;

    /**
     * Create the space and all objects within it.
     */
    public Space() 
    {
        super(600, 500, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        
        Rocket rocket = new Rocket();
        addObject(rocket, getWidth()/2 + 100, getHeight()/2);
        
        addAsteroids(startAsteroids);
        paintStars(300);
        
        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 60, 480);

        Explosion.initializeImages();
        ProtonWave.initializeImages();
    }
    
    /**
     * Add a given number of asteroids to our world. Asteroids are only added into
     * the left half of the world.
     */
    private void addAsteroids(int count) 
    {
        for(int i = 0; i < count; i++) 
        {
            int x = Greenfoot.getRandomNumber(getWidth()/2);
            int y = Greenfoot.getRandomNumber(getHeight()/2);
            addObject(new Asteroid(), x, y);
        }
    }
    
    public void updateScore(int addToScore)
    {
        scoreCounter.add(addToScore);
    }
    
    private void paintStars(int count)
    {
        GreenfootImage background = getBackground();
        for(int i = 0; i < count; i++)
        {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            
            int deltaRed = Greenfoot.getRandomNumber(80) - 40;
            int deltaGreen = Greenfoot.getRandomNumber(80) - 40;
            int deltaBlue = Greenfoot.getRandomNumber(80) - 40;
            
            int starBrightness = Greenfoot.getRandomNumber(120) + 80;
            
            Color StarColor = new Color(starBrightness + deltaRed, starBrightness + deltaGreen, starBrightness + deltaBlue);
            
            int starSize = Greenfoot.getRandomNumber(4) + 1;
            
            background.setColor(StarColor);
            background.fillOval(x, y, starSize,starSize);
         
        }
        
        }
   
        /**
         * This method is called when the game is over to display the final score.
         */
    public void gameOver() 
    {
        // TODO: show the score board here. Currently missing.
        int x = getWidth() / 2;
        int y = getHeight() / 2;
        int currentScore = scoreCounter.getValue();
        addObject(new ScoreBoard(currentScore), x, y);
    }

}


       
    
    
   