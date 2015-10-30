package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;
import com.brackeen.javagamebook.graphics.Sprite;

/**
 * Created by arthur on 10/29/15.
 */
public class Bullet extends Sprite {
    private boolean dead = false;

    public boolean isPlayerBullet = false;
    private float distToDie = 7f;
    private float startX;

    public Bullet(Animation anim, boolean isPlayerBullet){
        super(anim);
        this.isPlayerBullet = isPlayerBullet;
        this.startX = this.getX();
    }

    public float getMaxSpeed() {
        if (isPlayerBullet) {
            return .5f;
        }
        else{
            return .25f;
        }
    }


    public Object clone() {
        // use reflection to create the correct subclass
        //super.clone();
        return new Bullet((Animation)anim.clone(), this.isPlayerBullet);

    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(){
        this.dead = true;
    }

    @Override
    public void update(long elapsedTime) {
        super.update(elapsedTime);
        //TODO add in self dying to bullets
        if (Math.abs(getX()-startX) > distToDie){
            setDead();
        }
    }
}
