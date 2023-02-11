package com.mashibing.tank.cor;

import com.mashibing.tank.GameObject;

import java.util.LinkedList;
import java.util.List;

/**
 * @Auther: LiuJY
 * @Date: 2023/02/04 - 02 - 04 - 21:59
 * @Description: com.mashibing.tank.cor
 * @version: 1.0
 */
public class ColliderChain implements Collider{
    private List<Collider> colliders = new LinkedList<>();

    public ColliderChain(){
        add(new BulletTankCollider());
        add(new TankTankCollider());
    }

    public void add(Collider c){
        colliders.add(c);
    }

    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            if(colliders.get(i).collide(o1,o2)){
                return false;
            }
        }
        return true;
    }
}
