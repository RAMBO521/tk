package com.mashibing.tank;

import com.mashibing.tank.cor.BulletTankCollider;
import com.mashibing.tank.cor.Collider;
import com.mashibing.tank.cor.ColliderChain;
import com.mashibing.tank.cor.TankTankCollider;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class GameModel {

	Tank myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD, this);

	/*Collider collider = new BulletTankCollider();
	Collider collider2 = new TankTankCollider();*/

	ColliderChain  chain = new ColliderChain();

	private ArrayList<GameObject> objects = new ArrayList<>();//将游戏物体放到list中
//	List<Bullet> bullets = new ArrayList<>();
//	List<Tank> tanks = new ArrayList<>();
//	List<Explode> explodes = new ArrayList<>();

	public GameModel() {
		int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));

		// 初始化敌方坦克
		for (int i = 0; i < initTankCount; i++) {
			add(new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD, this));
		}
	}

	public void add(GameObject go){
		this.objects.add(go);
	}

	public void remove(GameObject go){
		this.objects.remove(go);
	}


	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.WHITE);
		/*g.drawString("子弹的数量:" + bullets.size(), 10, 60);
		g.drawString("敌人的数量:" + tanks.size(), 10, 80);
		g.drawString("爆炸的数量:" + explodes.size(), 10, 100);*/
		g.setColor(c);

		myTank.paint(g);
		for (int i = 0; i < objects.size(); i++) {
			objects.get(i).paint(g);
		}

		//互相碰撞
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i+1; j < objects.size(); j++) {
				GameObject o1 = objects.get(i);
				GameObject o2 = objects.get(j);
				/*collider.collide(o1,o2);
				collider2.collide(o1,o2);*/
				chain.collide(o1,o2);
			}
		}


		/*for (int i = 0; i < tanks.size(); i++) {
			tanks.get(i).paint(g);
		}

		for (int i = 0; i < explodes.size(); i++) {
			explodes.get(i).paint(g);
		}
		// collision detect

		for (int i = 0; i < bullets.size(); i++) {
			for (int j = 0; j < tanks.size(); j++)
				bullets.get(i).collideWith(tanks.get(j));
		}
*/
		// for(Iterator<Bullet> it = bullets.iterator(); it.hasNext();) {
		// Bullet b = it.next();
		// if(!b.live) it.remove();
		// }

		// for(Bullet b : bullets) {
		// b.paint(g);
		// }
	}





	public Tank getMainTank() {
		return myTank;
	}

}
