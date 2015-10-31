package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;
import com.brackeen.javagamebook.graphics.Sprite;
import com.brackeen.javagamebook.tilegame.TileGameResourceManager;
import com.brackeen.javagamebook.tilegame.TileMap;

/**
    The Player.
*/
public class Player extends Creature {

    private static final float JUMP_SPEED = -.95f;

    private boolean onGround;

    private int health = 20;
    private static final int healthMax = 40;

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

    public void bulletHit(){
        if (health >= 5){
            health -= 5;
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


}
