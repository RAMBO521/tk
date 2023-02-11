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
public class TankTankCollider implements Collider{
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Tank && o2 instanceof Tank){
            Tank t1 = (Tank)o1;
            Tank t2 = (Tank)o2;
            if(t1.getRect().intersects(t2.getRect())){
                t1.stop();
            }
        }

                return true;//坦克相撞时继续进行下一个相撞测试
    }
}
