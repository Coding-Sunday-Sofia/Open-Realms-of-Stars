package org.openRealmOfStars.player.combat;

import org.openRealmOfStars.player.PlayerInfo;
import org.openRealmOfStars.player.ship.Ship;

/**
 * 
 * Open Realm of Stars game project
 * Copyright (C) 2016  Tuomo Untinen
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see http://www.gnu.org/licenses/
 * 
 * 
 * Single ship in combat
 * 
 */

public class CombatShip implements Comparable<CombatShip>{

  /**
   * Ship information
   */
  private Ship ship;
  
  /**
   * Is component used or not for this round
   */
  private boolean[] componentUsed;
  
  /**
   * Ship's X coordinate in combat
   */
  private int x;

  /**
   * Ship's Y coordinate in combat
   */
  private int y;
  
  /**
   * Player whom owns the ship
   */
  private PlayerInfo player;
  
  /**
   * Flip Y axel on ship image
   */
  private boolean flipY;
  
  /**
   * How many moves left for this round
   */
  private int movesLeft;
  
  /**
   * Constructor for Combat ship
   * @param ship Ship to put in combat
   * @param player Player who owns the ship
   * @param x Ship's X coordinate in combat map
   * @param y Ship's Y coordinate in combat map
   * @param flip Ship's image on Y axel
   */
  public CombatShip(Ship ship, PlayerInfo player, int x, int y,boolean flip) {
    this.ship = ship;
    this.x = x;
    this.y = y;
    this.player = player;
    this.flipY = flip;
    this.movesLeft = ship.getTacticSpeed();
    reInitShipForRound();
  }

  public Ship getShip() {
    return ship;
  }

  public void setShip(Ship ship) {
    this.ship = ship;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public PlayerInfo getPlayer() {
    return player;
  }

  public void setPlayer(PlayerInfo player) {
    this.player = player;
  }

  @Override
  public int compareTo(CombatShip o) {
    return this.ship.getInitiative() -o.getShip().getInitiative();
  }

  public boolean isFlipY() {
    return flipY;
  }

  public void setFlipY(boolean flipY) {
    this.flipY = flipY;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(ship.getName());
    sb.append(" - ");
    sb.append(ship.getHull().getName());
    sb.append("\n");
    sb.append("Initiative: ");
    sb.append(ship.getInitiative());
    sb.append("\n");
    sb.append("Moves: ");
    sb.append(movesLeft);
    sb.append("\n");
    sb.append("Hull points: ");
    sb.append(ship.getHullPoints());
    sb.append("/");
    sb.append(ship.getMaxHullPoints());
    sb.append("\n");
    if (ship.getTacticSpeed()==0) {
      sb.append("Immobilized\n");
    }
    if (!ship.hasWeapons()) {
      sb.append("No weapons\n");
    }
    if (ship.getShield()==0 && ship.getTotalShield()>0) {
      sb.append("shields down\n");
    }
    if (ship.getShield()==0 && ship.getTotalShield()==0) {
      sb.append("No shields\n");
    }
    return sb.toString();
  }

  public int getMovesLeft() {
    return movesLeft;
  }
  
  /**
   * Reinitialize ship for next round
   */
  public void reInitShipForRound() {
    setMovesLeft(ship.getTacticSpeed());
    componentUsed = new boolean[ship.getNumberOfComponents()];
    for (int i=0;i<componentUsed.length;i++) {
      componentUsed[i] = false;
    }
  }
  
  /**
   * Is certain component used or not yet during this round
   * @param index Component index
   * @return true if component has been used
   */
  public boolean isComponentUsed(int index) {
    if(index >= 0 && index <componentUsed.length) {
      return componentUsed[index];
    }
    return true;
  }
  
  /**
   * Use certain component for this round
   * @param index Component index
   */
  public void useComponent(int index) {
    if(index >= 0 && index <componentUsed.length) {
      componentUsed[index] = true;
    }    
  }

  public void setMovesLeft(int movesLeft) {
    this.movesLeft = movesLeft;
  }
  
  
  
}