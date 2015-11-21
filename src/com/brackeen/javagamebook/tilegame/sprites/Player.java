package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;
import com.brackeen.javagamebook.graphics.Sprite;
import com.brackeen.javagamebook.tilegame.TileGameResourceManager;
import com.brackeen.javagamebook.tilegame.TileMap;
import com.brackeen.javagamebook.tilegame.TileMapRenderer;

/**
    The Player.
*/
public class Player extends Creature {

    private static final float JUMP_SPEED = -.95f;

    private boolean onGround;
    private boolean isGassed = false;
    private boolean starred = false;

    private int health = 20;
    private static final int healthMax = 40;
    private long time = 0;
    private long startime = 0;
    private int starx;
    private int stary;
    private int stardistance;

    public Player(Animation left, Animation right,
        Animation deadLeft, Animation deadRight)
    {
        super(left, right, deadLeft, deadRight);
    }


    public void collideHorizontal() {
        setVelocityX(0);
    }


    public void collideVertical() {
        // check if collided with ground
        if (getVelocityY() > 0) {
            onGround = true;
        }
        setVelocityY(0);
    }


    public void setY(float y) {
        // check if falling
        if (Math.round(y) > Math.round(getY())) {
            onGround = false;
        }
        super.setY(y);
    }


    public void wakeUp() {
        // do nothing
    }

    @Override
    public void update(long elapsedTime) {
        super.update(elapsedTime);
        //TODO add timer to remove effects
        time += elapsedTime;
	if(starred){
	    startime += elapsedTime;
	    stardistance += Math.abs(TileMapRenderer.pixelsToTiles(getX()) - starx) +  Math.abs(TileMapRenderer.pixelsToTiles(getY()) - stary);
	    starx = TileMapRenderer.pixelsToTiles(getX());
	    stary = TileMapRenderer.pixelsToTiles(getY());
	    if (startime >= 1000 || stardistance >= 10)
		starred = false;
	}
	    
        if (time >= 1000){
            isGassed = false;
            time = 1000;
        }
	
	
	
   }

    /**
        Makes the player jump if the player is on the ground or
        if forceJump is true.
    */
    public void jump(boolean forceJump) {
        if (onGround || forceJump) {
            onGround = false;
            setVelocityY(JUMP_SPEED);
        }
    }

    public float getMaxSpeed() {
        return 0.5f;
    }

    public int getHealth(){
        return health;
    }

    public void setGassed(){
        isGassed = true;
        time = 0;
    }

    public boolean isGassed() {
        return isGassed;
    }

    public void bulletHit(){
        if (health >= 5){
            health -= 5;
        }
        else {
            health = 0;
        }
    }

    public void explodingDamage(){
        if (health >= 10){
            health -= 10;
        }
        else {
            health = 0;
        }
    }

    public void creatureDeath(){
        if (health < healthMax - 10){
            health += 10;
        }
        else {
            health = healthMax;
        }
    }

    public void motionlessHealth(){
        if (health < healthMax - 5){
            health += 5;
        }
        else {
            health = healthMax;
        }
    }

    public void movementHealth(){
        if (health < healthMax - 1){
            health += 1;
        }
        else {
            health = healthMax;
        }
    }
    public void gotstar(){
	starred = true;
	startime = 0;
	stardistance = 0;
	starx = TileMapRenderer.pixelsToTiles(getX());
	stary = TileMapRenderer.pixelsToTiles(getY());
    }
    public boolean isStarred() {
        return starred;
    }
}
