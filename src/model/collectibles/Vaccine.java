package model.collectibles;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import engine.Game;
import model.characters.Character;
import model.characters.Hero;
import model.world.Cell;
import model.world.CharacterCell;
import views.start;

public class Vaccine implements Collectible {

	@Override
	public void pickUp(Hero h) {
		h.getVaccineInventory().add(this);
	}

	@Override
	public void use(Hero h) {
		h.getVaccineInventory().remove(this);
		Point p = h.getTarget().getLocation();
		Cell cell = Game.map[p.x][p.y];
		Game.zombies.remove(h.getTarget());
		Hero tba = Game.availableHeroes.get((int) (Math.random() * Game.availableHeroes.size()));
		Game.availableHeroes.remove(tba);
		Game.heroes.add(tba);
		((CharacterCell) cell).setCharacter(tba);
		tba.setLocation(p);
		Icon icon = new ImageIcon("HERO.jpg");
		start.map[p.x][p.y].setIcon(icon);
	}

}
