package com.mashibing.tank.cor;

import com.mashibing.tank.GameObject;

/**
 * @Auther: LiuJY
 * @Date: 2023/02/04 - 02 - 04 - 20:19
 * @Description: com.mashibing.tank.cor
 * @version: 1.0
 * 仿照compator设计一个碰撞器来解决碰撞问题
 */
public interface Collider {
    //用一个布尔值来判断是否已经相撞了，如果是，则就没有必要进行下一个碰撞了。
    boolean collide(GameObject o1,GameObject o2);
}
