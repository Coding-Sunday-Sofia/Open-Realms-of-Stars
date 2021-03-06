package org.openRealmOfStars.player.SpaceRace;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openRealmOfStars.player.diplomacy.Attitude;

/**
 * 
 * Open Realm of Stars game project
 * Copyright (C) 2016-2018 Tuomo Untinen
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
 * Test for SpaceRaceUtility class
 */

public class SpaceRaceUtilityTest {

  @Test
  @Category(org.openRealmOfStars.UnitTest.class)
  public void testRandomNameGeneratorHuman() {
    SpaceRace race = SpaceRace.HUMAN;
    assertEquals(Attitude.DIPLOMATIC, race.getAttitude());
    for (int i=0;i<100;i++) {
      String tmp = SpaceRaceUtility.getRandomName(race);
      String[] parts = tmp.split(" ");
      if (parts.length == 2) {
        assertFalse(!parts[0].equals("Terran") && !parts[0].equals("Human"));
        assertFalse(!parts[1].equals("Empire") && !parts[1].equals("Federation")
            && !parts[1].equals("Republic") && !parts[1].equals("Alliance")
            && !parts[1].equals("Kingdom") && !parts[1].equals("Democracy")
            && !parts[1].equals("Hegemony") && !parts[1].equals("Hiearchy"));
          
      } else if (parts.length == 3) {
        assertFalse(!parts[0].equals("Empire") && !parts[0].equals("Federation")
            && !parts[0].equals("Republic") && !parts[0].equals("Alliance")
            && !parts[0].equals("Kingdom") && !parts[0].equals("Democracy")
            && !parts[0].equals("Hegemony") && !parts[0].equals("Hiearchy"));
        assertEquals("of", parts[1]);
        assertFalse(!parts[2].equals("Terran") && !parts[2].equals("Humans"));
      }
    }
  }

  @Test
  @Category(org.openRealmOfStars.UnitTest.class)
  public void testRandomNameGeneratorMechions() {
    SpaceRace race = SpaceRace.MECHIONS;
    assertEquals(Attitude.LOGICAL, race.getAttitude());
    for (int i=0;i<100;i++) {
      String tmp = SpaceRaceUtility.getRandomName(race);
      String[] parts = tmp.split(" ");
      if (parts.length == 2) {
        assertEquals("Mechion", parts[0]);
        assertFalse(!parts[1].equals("Empire") && !parts[1].equals("Federation")
            && !parts[1].equals("Republic") && !parts[1].equals("Alliance")
            && !parts[1].equals("Horde") && !parts[1].equals("AI")
            && !parts[1].equals("Hegemony") && !parts[1].equals("Hiearchy"));
          
      } else if (parts.length == 3) {
        assertFalse(!parts[0].equals("Empire") && !parts[0].equals("Federation")
            && !parts[0].equals("Republic") && !parts[0].equals("Alliance")
            && !parts[0].equals("Horde") && !parts[0].equals("AI")
            && !parts[0].equals("Hegemony") && !parts[0].equals("Hiearchy"));
        assertEquals("of", parts[1]);
        assertEquals("Mechions", parts[2]);
      }
    }
  }

  @Test
  @Category(org.openRealmOfStars.UnitTest.class)
  public void testRandomNameGeneratorCentaurs() {
    SpaceRace race = SpaceRace.CENTAURS;
    assertEquals(Attitude.DIPLOMATIC, race.getAttitude());
    for (int i=0;i<100;i++) {
      String tmp = SpaceRaceUtility.getRandomName(race);
      String[] parts = tmp.split(" ");
      if (parts.length == 2) {
        assertEquals("Centaur", parts[0]);
        assertFalse(!parts[1].equals("Empire") && !parts[1].equals("Federation")
            && !parts[1].equals("Republic") && !parts[1].equals("Alliance")
            && !parts[1].equals("Kingdom") && !parts[1].equals("Democracy")
            && !parts[1].equals("Hegemony") && !parts[1].equals("Hiearchy"));
          
      } else if (parts.length == 3) {
        assertFalse(!parts[0].equals("Empire") && !parts[0].equals("Federation")
            && !parts[0].equals("Republic") && !parts[0].equals("Alliance")
            && !parts[0].equals("Kingdom") && !parts[0].equals("Democracy")
            && !parts[0].equals("Hegemony") && !parts[0].equals("Hiearchy"));
        assertEquals("of", parts[1]);
        assertEquals("Centaurs", parts[2]);
      }
    }
  }

  @Test
  @Category(org.openRealmOfStars.UnitTest.class)
  public void testRandomNameGeneratorGreyans() {
    SpaceRace race = SpaceRace.GREYANS;
    assertEquals(Attitude.SCIENTIFIC, race.getAttitude());
    for (int i=0;i<100;i++) {
      String tmp = SpaceRaceUtility.getRandomName(race);
      String[] parts = tmp.split(" ");
      if (parts.length == 2) {
        assertEquals("Greyan", parts[0]);
        assertFalse(!parts[1].equals("Empire") && !parts[1].equals("Federation")
            && !parts[1].equals("Republic") && !parts[1].equals("Alliance")
            && !parts[1].equals("Kingdom") && !parts[1].equals("Democracy")
            && !parts[1].equals("Hegemony") && !parts[1].equals("Hiearchy"));
          
      } else if (parts.length == 3) {
        assertFalse(!parts[0].equals("Empire") && !parts[0].equals("Federation")
            && !parts[0].equals("Republic") && !parts[0].equals("Alliance")
            && !parts[0].equals("Kingdom") && !parts[0].equals("Democracy")
            && !parts[0].equals("Hegemony") && !parts[0].equals("Hiearchy"));
        assertEquals("of", parts[1]);
        assertEquals("Greyans", parts[2]);
      }
    }
  }

  @Test
  @Category(org.openRealmOfStars.UnitTest.class)
  public void testRandomNameGeneratorHomarians() {
    SpaceRace race = SpaceRace.HOMARIANS;
    assertEquals(Attitude.PEACEFUL, race.getAttitude());
    for (int i=0;i<100;i++) {
      String tmp = SpaceRaceUtility.getRandomName(race);
      String[] parts = tmp.split(" ");
      if (parts.length == 2) {
        assertEquals("Homarian", parts[0]);
        assertFalse(!parts[1].equals("Empire") && !parts[1].equals("Federation")
            && !parts[1].equals("Republic") && !parts[1].equals("Alliance")
            && !parts[1].equals("Kingdom") && !parts[1].equals("Democracy")
            && !parts[1].equals("Nest") && !parts[1].equals("Hiearchy"));
          
      } else if (parts.length == 3) {
        assertFalse(!parts[0].equals("Empire") && !parts[0].equals("Federation")
            && !parts[0].equals("Republic") && !parts[0].equals("Alliance")
            && !parts[0].equals("Kingdom") && !parts[0].equals("Democracy")
            && !parts[0].equals("Nest") && !parts[0].equals("Hiearchy"));
        assertEquals("of", parts[1]);
        assertEquals("Homarians", parts[2]);
      }
    }
  }

  @Test
  @Category(org.openRealmOfStars.UnitTest.class)
  public void testRandomNameGeneratorSporks() {
    SpaceRace race = SpaceRace.SPORKS;
    assertEquals(Attitude.AGGRESSIVE, race.getAttitude());
    for (int i=0;i<100;i++) {
      String tmp = SpaceRaceUtility.getRandomName(race);
      String[] parts = tmp.split(" ");
      if (parts.length == 2) {
        assertEquals("Spork", parts[0]);
        assertFalse(!parts[1].equals("Empire") && !parts[1].equals("Federation")
            && !parts[1].equals("Republic") && !parts[1].equals("Alliance")
            && !parts[1].equals("Horde") && !parts[1].equals("Democracy")
            && !parts[1].equals("Clan") && !parts[1].equals("Hiearchy"));
          
      } else if (parts.length == 3) {
        assertFalse(!parts[0].equals("Empire") && !parts[0].equals("Federation")
            && !parts[0].equals("Republic") && !parts[0].equals("Alliance")
            && !parts[0].equals("Horde") && !parts[0].equals("Democracy")
            && !parts[0].equals("Clan") && !parts[0].equals("Hiearchy"));
        assertEquals("of", parts[1]);
        assertEquals("Sporks", parts[2]);
      }
    }
  }

  @Test
  @Category(org.openRealmOfStars.UnitTest.class)
  public void testRandomNameGeneratorMothoids() {
    SpaceRace race = SpaceRace.MOTHOIDS;
    assertEquals(Attitude.EXPANSIONIST, race.getAttitude());
    for (int i=0;i<100;i++) {
      String tmp = SpaceRaceUtility.getRandomName(race);
      String[] parts = tmp.split(" ");
      if (parts.length == 2) {
        assertEquals("Mothoid", parts[0]);
        assertFalse(!parts[1].equals("Empire") && !parts[1].equals("Federation")
            && !parts[1].equals("Nest") && !parts[1].equals("Alliance")
            && !parts[1].equals("Kingdom") && !parts[1].equals("Hive")
            && !parts[1].equals("Hegemony") && !parts[1].equals("Hiearchy"));
          
      } else if (parts.length == 3) {
        assertFalse(!parts[0].equals("Empire") && !parts[0].equals("Federation")
            && !parts[0].equals("Nest") && !parts[0].equals("Alliance")
            && !parts[0].equals("Kingdom") && !parts[0].equals("Hive")
            && !parts[0].equals("Hegemony") && !parts[0].equals("Hiearchy"));
        assertEquals("of", parts[1]);
        assertEquals("Mothoids", parts[2]);
      }
    }
  }

  @Test
  @Category(org.openRealmOfStars.UnitTest.class)
  public void testRandomNameGeneratorTechtidae() {
    SpaceRace race = SpaceRace.TEUTHIDAES;
    assertEquals(Attitude.MILITARISTIC, race.getAttitude());
    for (int i=0;i<100;i++) {
      String tmp = SpaceRaceUtility.getRandomName(race);
      String[] parts = tmp.split(" ");
      if (parts.length == 2) {
        assertEquals("Teuthidae", parts[0]);
        assertFalse(!parts[1].equals("Empire") && !parts[1].equals("Federation")
            && !parts[1].equals("Republic") && !parts[1].equals("Alliance")
            && !parts[1].equals("Horde") && !parts[1].equals("Democracy")
            && !parts[1].equals("Hegemony") && !parts[1].equals("Hiearchy"));
          
      } else if (parts.length == 3) {
        assertFalse(!parts[0].equals("Empire") && !parts[0].equals("Federation")
            && !parts[0].equals("Republic") && !parts[0].equals("Alliance")
            && !parts[0].equals("Horde") && !parts[0].equals("Democracy")
            && !parts[0].equals("Hegemony") && !parts[0].equals("Hiearchy"));
        assertEquals("of", parts[1]);
        assertEquals("Teuthidaes", parts[2]);
      }
    }
  }

  @Test
  @Category(org.openRealmOfStars.UnitTest.class)
  public void testFullDescriptions() {
    String[] expectedResult = new String[SpaceRace.values().length];
    expectedResult[0] = "### Humans\n"+
        "Humans are great diplomats but they are about average in everything else.\n"+
        "* Max radiation: 4\n"+
        "* Troop power: 10\n"+
        "* Production: 100%\n"+
        "* Mining: 100%\n"+
        "* Research: 100%\n"+
        "* Food production: 100%\n"+
        "* Growth: 100%\n"+
        "* Food require: 100%\n"+
        "* Culture: 100%\n"+
        "* Diplomacy bonus: 2\n"+
        "* Rush: Credit\n"+
        "* Special: None";
    expectedResult[1] = "### Mechions\n"+
        "Mechanical beings whom do not eat food. Each now population must be built.\n"+
        "* Max radiation: 8\n"+
        "* Troop power: 12\n"+
        "* Production: 100%\n"+
        "* Mining: 150%\n"+
        "* Research: 50%\n"+
        "* Food production: 0%\n"+
        "* Growth: 0%\n"+
        "* Food require: 0%\n"+
        "* Culture: 50%\n"+
        "* Diplomacy bonus: -2\n"+
        "* Rush: Population\n"+
        "* Special: Population needs to be built";
    expectedResult[2] = "### Sporks\n"+
        "Aggressive and warmongering species.\n"+
        "* Max radiation: 5\n"+
        "* Troop power: 12\n"+
        "* Production: 100%\n"+
        "* Mining: 100%\n"+
        "* Research: 100%\n"+
        "* Food production: 100%\n"+
        "* Growth: 100%\n"+
        "* Food require: 100%\n"+
        "* Culture: 100%\n"+
        "* Diplomacy bonus: -3\n"+
        "* Rush: Credit and population\n"+
        "* Special: Extra scout ship and higher combat tech at start";
    expectedResult[3] = "### Greyans\n"+
        "Humanoid creatures with grey skin and big eyes. Greyan are excellent researchers.\n"+
        "* Max radiation: 6\n"+
        "* Troop power: 8\n"+
        "* Production: 100%\n"+
        "* Mining: 100%\n"+
        "* Research: 150%\n"+
        "* Food production: 100%\n"+
        "* Growth: 50%\n"+
        "* Food require: 100%\n"+
        "* Culture: 100%\n"+
        "* Diplomacy bonus: 0\n"+
        "* Rush: Credit\n"+
        "* Special: Electronics and propulsion techs are higher at start";
    expectedResult[4] = "### Centaurs\n"+
        "Quadrupedal humanoid creatures which are big, about 5 meters tall."
        + " Due their enormous size their space ships are more rigid."
        + " Centaurs need more food to survive.\n"+
        "* Max radiation: 3\n"+
        "* Troop power: 14\n"+
        "* Production: 100%\n"+
        "* Mining: 100%\n"+
        "* Research: 100%\n"+
        "* Food production: 100%\n"+
        "* Growth: 50%\n"+
        "* Food require: 125%\n"+
        "* Culture: 100%\n"+
        "* Diplomacy bonus: -1\n"+
        "* Rush: Credit\n"+
        "* Special: Stronger ships";
    expectedResult[5] = "### Mothoids\n"+
        "Mothoids are sentient insects with hivemind. They are fast breeding "
        + "race. Their song is hypnotic so cultural bonus is granted. "
      + "Mothoids exo-skeleton is weak and therefore get negative bonus on "
      + "mining and troop power.\n"+
        "* Max radiation: 6\n"+
        "* Troop power: 9\n"+
        "* Production: 100%\n"+
        "* Mining: 50%\n"+
        "* Research: 100%\n"+
        "* Food production: 100%\n"+
        "* Growth: 150%\n"+
        "* Food require: 100%\n"+
        "* Culture: 150%\n"+
        "* Diplomacy bonus: 0\n"+
        "* Rush: Population\n"+
        "* Special: No defense tech but one Planetary improvement tech at start";
    expectedResult[6] = "### Teuthidaes\n"
        + "Teuthidaes are octopus like creatures. They are "
        + "scientific and military focused race. Their ships have built-in "
        + "cloaking devices.\n"
        + "* Max radiation: 4\n"
        + "* Troop power: 10\n"
        + "* Production: 100%\n"
        + "* Mining: 100%\n"
        + "* Research: 150%\n"
        + "* Food production: 100%\n"
        + "* Growth: 100%\n"
        + "* Food require: 125%\n"
        + "* Culture: 100%\n"
        + "* Diplomacy bonus: -2\n"
        + "* Rush: Credit\n"
        + "* Special: Each ship has built-in cloaking device";
    expectedResult[7] = "### Scaurians\n"
        + "Scaurians are small but wide humanoid. They are "
        + "merchantical race. They focus make better trades with other "
        + "and gain more credits.\n"
        + "* Max radiation: 5\n"
        + "* Troop power: 12\n"
        + "* Production: 100%\n"
        + "* Mining: 50%\n"
        + "* Research: 100%\n"
        + "* Food production: 100%\n"
        + "* Growth: 50%\n"
        + "* Food require: 100%\n"
        + "* Culture: 100%\n"
        + "* Diplomacy bonus: 1\n"
        + "* Rush: Credit\n"
        + "* Special: Trade fleet gain 50% more credits and better trade buildings.";
    expectedResult[8] = "### Homarians\n"
        + "Homarians are very strong creatures. "
        + "They have humanoid from but they have very thick and "
        + "hard exoskeleton. Due their strength they are good in "
        + "physical tasks.\n"
        + "* Max radiation: 3\n"
        + "* Troop power: 11\n"
        + "* Production: 150%\n"
        + "* Mining: 150%\n"
        + "* Research: 50%\n"
        + "* Food production: 200%\n"
        + "* Growth: 100%\n"
        + "* Food require: 100%\n"
        + "* Culture: 50%\n"
        + "* Diplomacy bonus: 1\n"
        + "* Rush: Population\n"
        + "* Special: Starts with 5 population";
    for (int i = 0; i <  SpaceRace.values().length; i++) {
      SpaceRace race = SpaceRaceUtility.getRaceByIndex(i);
      assertEquals(expectedResult[i],race.getFullDescription(true, false));
      if (i == 0) {
        String result = race.getFullDescription(false, false);
        if (!result.startsWith("<html>")) {
          assertFalse(true);
        }
      }
      //System.out.println(race.getFullDescription(true, true));
    }
  }

}
