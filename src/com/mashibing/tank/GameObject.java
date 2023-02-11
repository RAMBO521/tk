package com.mashibing.tank;

import java.awt.*;

/**
 * @Auther: LiuJY
 * @Date: 2023/02/04 - 02 - 04 - 19:43
 * @Description: com.mashibing.tank
 * @version: 1.0
 * 抽象出一个游戏物体父类， 游戏物体有 炮弹，坦克，爆炸，地雷等
 */
public abstract class GameObject {
    int x,y;
    public abstract void paint(Graphics g);
}
