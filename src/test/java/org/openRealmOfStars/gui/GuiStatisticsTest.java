package org.openRealmOfStars.gui;

import static org.junit.Assert.*;

import java.awt.Font;
import java.awt.image.BufferedImage;

import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
*
* Open Realm of Stars game project
* Copyright (C) 2017  Tuomo Untinen
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
* GuiStatics class JUnits
*
*/
public class GuiStatisticsTest {

  @Test
  @Category(org.openRealmOfStars.UnitTest.class)
  public void testCubellanBold() {
    Font font = GuiStatics.getFontCubellanBold();
    assertNotEquals(GuiStatics.FONT_SMALL, font);
    int height = GuiStatics.getTextHeight(font, "test text");
    int width = GuiStatics.getTextWidth(font, "test text");
    assertEquals(19, height);
    assertEquals(110, width);
  }

  @Test
  @Category(org.openRealmOfStars.UnitTest.class)
  public void testCubellanBoldBig() {
    Font font = GuiStatics.getFontCubellanBoldBig();
    assertNotEquals(GuiStatics.FONT_SMALL, font);
    int height = GuiStatics.getTextHeight(font, "test text");
    int width = GuiStatics.getTextWidth(font, "test text");
    assertEquals(28, height);
    assertEquals(160, width);
  }

  @Test
  @Category(org.openRealmOfStars.UnitTest.class)
  public void testCubellanSC() {
    Font font = GuiStatics.getFontCubellanSC();
    assertNotEquals(GuiStatics.FONT_SMALL, font);
    int height = GuiStatics.getTextHeight(font, "test text");
    int width = GuiStatics.getTextWidth(font, "test text");
    assertEquals(10, height);
    assertEquals(59, width);
  }

  @Test
  @Category(org.openRealmOfStars.UnitTest.class)
  public void testCubellanSmaller() {
    Font font = GuiStatics.getFontCubellanSmaller();
    assertNotEquals(GuiStatics.FONT_SMALL, font);
    int height = GuiStatics.getTextHeight(font, "test text");
    int width = GuiStatics.getTextWidth(font, "test text");
    assertEquals(10, height);
    assertEquals(59, width);
  }

  @Test
  @Category(org.openRealmOfStars.UnitTest.class)
  public void testCubellan() {
    Font font = GuiStatics.getFontCubellan();
    assertNotEquals(GuiStatics.FONT_SMALL, font);
    int height = GuiStatics.getTextHeight(font, "test text");
    int width = GuiStatics.getTextWidth(font, "test text");
    assertEquals(12, height);
    assertEquals(72, width);
  }

  @Test
  @Category(org.openRealmOfStars.UnitTest.class)
  public void testScaleHalf() {
    BufferedImage image = new BufferedImage(120, 100, BufferedImage.TYPE_4BYTE_ABGR);
    image = GuiStatics.scaleToHalf(image);
    assertEquals(60, image.getWidth());
    assertEquals(50, image.getHeight());
  }

}
