package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;
import com.brackeen.javagamebook.graphics.Sprite;

import java.lang.reflect.Constructor;

/**
 * Created by arthur on 10/29/15.
 */
public class PlayerBullet extends Sprite {
    private boolean dead = false;

    public PlayerBullet(Animation anim){
        super(anim);
    }

    public float getMaxSpeed() {
        return .5f;
    }


    public Object clone() {
        // use reflection to create the correct subclass
        //super.clone();
        return new PlayerBullet(anim);

    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(){
        this.dead = true;
    }
}
