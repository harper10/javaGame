package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;
import com.brackeen.javagamebook.graphics.Sprite;
import com.brackeen.javagamebook.tilegame.TileMapRenderer;

/**
 * Created by arthur on 10/29/15.
 */
public class Bullet extends Sprite {
    private boolean dead = false;

    public boolean isPlayerBullet = false;
    private int startX;

    public Bullet(Animation anim, boolean isPlayerBullet){
        super(anim);
        this.isPlayerBullet = isPlayerBullet;

    }

    public float getMaxSpeed() {
        if (isPlayerBullet) {
            return .6f;
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

    public void setStartX(){
        this.startX = TileMapRenderer.pixelsToTiles(getX());
    }

    @Override
    public void update(long elapsedTime) {
        super.update(elapsedTime);
        int distToDie = 5;
        if (Math.abs((TileMapRenderer.pixelsToTiles(getX()) - startX)) > distToDie){
            setDead();
        }
    }
}
