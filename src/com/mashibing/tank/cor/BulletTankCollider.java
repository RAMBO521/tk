package com.mashibing.tank.cor;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.GameObject;
import com.mashibing.tank.Tank;

/**
 * @Auther: LiuJY
 * @Date: 2023/02/04 - 02 - 04 - 20:20
 * @Description: com.mashibing.tank.cor
 * @version: 1.0
 */
public class BulletTankCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Tank && o2 instanceof Bullet){
            Tank t = (Tank)o1;
            Bullet b = (Bullet)o2;
            if(b.collideWith(t)){//如果是坦克和子弹碰撞了的话就让责任链停止
                return false;
            };
        }else if(o1 instanceof Bullet && o2 instanceof Tank){
            collide(o2,o1);
        }
            return true;


    }
}
