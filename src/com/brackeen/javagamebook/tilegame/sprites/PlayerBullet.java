package com.brackeen.javagamebook.tilegame.sprites;

import com.brackeen.javagamebook.graphics.Animation;
import com.brackeen.javagamebook.graphics.Sprite;

/**
 * Created by arthur on 10/29/15.
 */
public class PlayerBullet extends Sprite {


    public PlayerBullet(Animation anim){
        super(anim);
    }

    public float getMaxSpeed() {
        return .5f;
    }

}
