package org.openRealmOfStars.game.States;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import org.openRealmOfStars.game.GameCommands;
import org.openRealmOfStars.gui.GuiStatics;
import org.openRealmOfStars.gui.ListRenderers.ProductionListRenderer;
import org.openRealmOfStars.gui.borders.SimpleBorder;
import org.openRealmOfStars.gui.buttons.SpaceButton;
import org.openRealmOfStars.gui.icons.Icons;
import org.openRealmOfStars.gui.infopanel.InfoPanel;
import org.openRealmOfStars.gui.labels.IconLabel;
import org.openRealmOfStars.gui.labels.InfoTextArea;
import org.openRealmOfStars.gui.labels.TransparentLabel;
import org.openRealmOfStars.gui.panels.BigImagePanel;
import org.openRealmOfStars.gui.panels.BlackPanel;
import org.openRealmOfStars.gui.panels.InvisiblePanel;
import org.openRealmOfStars.gui.panels.WorkerProductionPanel;
import org.openRealmOfStars.player.SpaceRace;
import org.openRealmOfStars.starMap.planet.Planet;
import org.openRealmOfStars.starMap.planet.construction.Building;
import org.openRealmOfStars.starMap.planet.construction.Construction;

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
 * Planet view for handling single planet production and space dock.
 *
 */
public class PlanetView extends BlackPanel {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private WorkerProductionPanel farmPanel;
  private WorkerProductionPanel minePanel;
  private WorkerProductionPanel factoryPanel;
  private WorkerProductionPanel resePanel;
  private WorkerProductionPanel taxPanel;

  private IconLabel cultureLabel;

  private IconLabel totalPeople;
  private IconLabel peopleGrowth;
  private IconLabel farmProd;
  private IconLabel mineProd;
  private IconLabel prodProd;
  private IconLabel reseProd;
  private IconLabel cultProd;
  private IconLabel credProd;
  private IconLabel maintenance;
  private IconLabel metal;
  private IconLabel metalOre;
  private JComboBox<Construction> constructionSelect;
  private TransparentLabel buildingLabel;
  private TransparentLabel buildingEstimate;
  private InfoTextArea productionInfo;
  private InfoTextArea buildingInfo;
  private JList<Building> buildingList;
  private SpaceButton demolishBuildingBtn;
  /**
   * Planet to show
   */
  private Planet planet;

  public PlanetView(final Planet planet, final ActionListener listener) {
    this.setPlanet(planet);
    // Background image
    BigImagePanel imgBase = new BigImagePanel(planet, true, null);
    this.setLayout(new BorderLayout());

    // Top Panel
    InfoPanel topPanel = new InfoPanel();
    topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));

    topPanel.add(Box.createRigidArea(new Dimension(15, 25)));
    InvisiblePanel invisible = new InvisiblePanel(topPanel);
    invisible.setLayout(new BoxLayout(invisible, BoxLayout.Y_AXIS));
    totalPeople = new IconLabel(invisible,
        Icons.getIconByName(Icons.ICON_PEOPLE),
        ": " + planet.getTotalPopulation());
    totalPeople.setToolTipText("Total number of people on planet.");
    totalPeople.setAlignmentX(Component.LEFT_ALIGNMENT);
    invisible.add(totalPeople);
    farmPanel = new WorkerProductionPanel(invisible,
        GameCommands.COMMAND_MINUS_FARM, GameCommands.COMMAND_PLUS_FARM,
        Icons.ICON_FARM, ": " + planet.getWorkers(Planet.FOOD_FARMERS),
        "Number of people working as a farmers.", listener);
    farmPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
    invisible.add(farmPanel);
    minePanel = new WorkerProductionPanel(invisible,
        GameCommands.COMMAND_MINUS_MINE, GameCommands.COMMAND_PLUS_MINE,
        Icons.ICON_MINE, ": " + planet.getWorkers(Planet.METAL_MINERS),
        "Number of people working as a miners.", listener);
    minePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
    invisible.add(minePanel);
    factoryPanel = new WorkerProductionPanel(invisible,
        GameCommands.COMMAND_MINUS_PRODUCTION,
        GameCommands.COMMAND_PLUS_PRODUCTION, Icons.ICON_FACTORY,
        ": " + planet.getWorkers(Planet.PRODUCTION_WORKERS),
        "Number of people working as a factory worker.", listener);
    factoryPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
    invisible.add(factoryPanel);
    resePanel = new WorkerProductionPanel(invisible,
        GameCommands.COMMAND_MINUS_RESEARCH, GameCommands.COMMAND_PLUS_RESEARCH,
        Icons.ICON_RESEARCH,
        ": " + planet.getWorkers(Planet.RESEARCH_SCIENTIST),
        "Number of people working as a scientist.", listener);
    resePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
    invisible.add(resePanel);
    cultureLabel = new IconLabel(invisible,
        Icons.getIconByName(Icons.ICON_CULTURE),
        ": " + planet.getWorkers(Planet.CULTURE_ARTIST));
    cultureLabel.setToolTipText("Number of people producing culture.");
    cultureLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
    invisible.add(cultureLabel);
    topPanel.add(invisible);
    topPanel.add(Box.createRigidArea(new Dimension(15, 25)));

    invisible = new InvisiblePanel(topPanel);
    invisible.setLayout(new BoxLayout(invisible, BoxLayout.Y_AXIS));
    peopleGrowth = new IconLabel(invisible,
        Icons.getIconByName(Icons.ICON_PEOPLE), "1000 turns");
    int peopleGrow = planet.getTotalProduction(Planet.PRODUCTION_POPULATION);
    if (peopleGrow > 0) {
      peopleGrowth.setText(peopleGrow + " turns.");
      peopleGrowth.setLeftIcon(Icons.getIconByName(Icons.ICON_PEOPLE));
    } else if (peopleGrow < 0) {
      peopleGrow = peopleGrow * -1;
      peopleGrowth.setText(peopleGrow + " turns. ");
      peopleGrowth.setLeftIcon(Icons.getIconByName(Icons.ICON_DEATH));
    } else {
      peopleGrowth.setText("no growth ");
      peopleGrowth.setLeftIcon(Icons.getIconByName(Icons.ICON_PEOPLE));
    }
    peopleGrowth.setToolTipText("How many turns to population growth.");
    peopleGrowth.setAlignmentX(Component.LEFT_ALIGNMENT);
    invisible.add(peopleGrowth);
    farmProd = new IconLabel(invisible, Icons.getIconByName(Icons.ICON_FARM),
        ": " + planet.getTotalProduction(Planet.PRODUCTION_FOOD));
    farmProd.setToolTipText("Total production of food");
    farmProd.setAlignmentX(Component.LEFT_ALIGNMENT);
    invisible.add(farmProd);
    mineProd = new IconLabel(invisible, Icons.getIconByName(Icons.ICON_MINE),
        ": " + planet.getTotalProduction(Planet.PRODUCTION_METAL));
    mineProd.setToolTipText("Total production of metal");
    mineProd.setAlignmentX(Component.LEFT_ALIGNMENT);
    invisible.add(mineProd);
    prodProd = new IconLabel(invisible, Icons.getIconByName(Icons.ICON_FACTORY),
        ": " + planet.getTotalProduction(Planet.PRODUCTION_PRODUCTION));
    prodProd.setToolTipText("Total production of production");
    prodProd.setAlignmentX(Component.LEFT_ALIGNMENT);
    invisible.add(prodProd);
    reseProd = new IconLabel(invisible,
        Icons.getIconByName(Icons.ICON_RESEARCH),
        ": " + planet.getTotalProduction(Planet.PRODUCTION_RESEARCH));
    reseProd.setToolTipText("Total production of research");
    reseProd.setAlignmentX(Component.LEFT_ALIGNMENT);
    invisible.add(reseProd);
    cultProd = new IconLabel(invisible, Icons.getIconByName(Icons.ICON_CULTURE),
        ": " + planet.getTotalProduction(Planet.PRODUCTION_CULTURE));
    cultProd.setToolTipText("Total production of culture");
    cultProd.setAlignmentX(Component.LEFT_ALIGNMENT);
    invisible.add(cultProd);
    topPanel.add(invisible);
    topPanel.add(Box.createRigidArea(new Dimension(15, 25)));

    invisible = new InvisiblePanel(topPanel);
    invisible.setLayout(new BoxLayout(invisible, BoxLayout.Y_AXIS));
    credProd = new IconLabel(invisible, Icons.getIconByName(Icons.ICON_CREDIT),
        ": " + planet.getTotalProduction(Planet.PRODUCTION_CREDITS));
    credProd.setToolTipText("Total production of credits");
    credProd.setAlignmentX(Component.LEFT_ALIGNMENT);
    invisible.add(credProd);

    maintenance = new IconLabel(invisible,
        Icons.getIconByName(Icons.ICON_MAINTENANCE),
        ": " + planet.getMaintenanceCost());
    maintenance.setToolTipText("Maintenance cost of planet");
    maintenance.setAlignmentX(Component.LEFT_ALIGNMENT);
    invisible.add(maintenance);

    taxPanel = new WorkerProductionPanel(invisible,
        GameCommands.COMMAND_MINUS_TAX, GameCommands.COMMAND_PLUS_TAX,
        Icons.ICON_TAX, ": " + planet.getTax(),
        "How many productions are converted to credits", listener);
    taxPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
    invisible.add(taxPanel);

    metal = new IconLabel(invisible, Icons.getIconByName(Icons.ICON_METAL),
        ": " + planet.getMetal());
    metal.setToolTipText("Total metal on surface");
    metal.setAlignmentX(Component.LEFT_ALIGNMENT);
    invisible.add(metal);
    metalOre = new IconLabel(invisible,
        Icons.getIconByName(Icons.ICON_METAL_ORE),
        ": " + planet.getAmountMetalInGround());
    metalOre.setToolTipText("Total metal ore to mine.");
    metalOre.setAlignmentX(Component.LEFT_ALIGNMENT);
    invisible.add(metalOre);
    topPanel.add(invisible);
    topPanel.add(Box.createRigidArea(new Dimension(25, 25)));

    invisible = new InvisiblePanel(topPanel);
    invisible.setLayout(new BoxLayout(invisible, BoxLayout.Y_AXIS));
    IconLabel label = new IconLabel(invisible,
        Icons.getIconByName(Icons.ICON_FACTORY), "Next project:");
    label.setAlignmentX(Component.RIGHT_ALIGNMENT);
    invisible.add(label);
    constructionSelect = new JComboBox<>(this.planet.getProductionList());
    constructionSelect.addActionListener(listener);
    constructionSelect.setActionCommand(GameCommands.COMMAND_PRODUCTION_LIST);
    constructionSelect.setBackground(GuiStatics.COLOR_COOL_SPACE_BLUE_DARK);
    constructionSelect.setForeground(GuiStatics.COLOR_COOL_SPACE_BLUE);
    constructionSelect.setBorder(new SimpleBorder());
    constructionSelect.setFont(GuiStatics.getFontCubellan());
    constructionSelect.setRenderer(new ProductionListRenderer());
    if (planet.getUnderConstruction() != null) {
      Construction[] list = this.planet.getProductionList();
      for (int i = 0; i < list.length; i++) {
        if (list[i].getName().equals(planet.getUnderConstruction().getName())) {
          constructionSelect.setSelectedIndex(i);
          break;
        }
      }
    }
    constructionSelect.setEditable(false);
    constructionSelect.setAlignmentX(Component.RIGHT_ALIGNMENT);
    invisible.add(constructionSelect);
    invisible.add(Box.createRigidArea(new Dimension(60, 5)));
    buildingEstimate = new TransparentLabel(topPanel, planet.getProductionTime(
        (Construction) constructionSelect.getSelectedItem()));
    buildingEstimate.setAlignmentX(Component.RIGHT_ALIGNMENT);
    invisible.add(buildingEstimate);
    invisible.add(Box.createRigidArea(new Dimension(50, 25)));
    topPanel.add(invisible);

    topPanel.add(Box.createRigidArea(new Dimension(10, 25)));
    productionInfo = new InfoTextArea(5, 35);
    productionInfo.setFont(GuiStatics.getFontCubellanSmaller());
    productionInfo.setEditable(false);
    topPanel.add(productionInfo);
    topPanel.add(Box.createRigidArea(new Dimension(15, 25)));

    topPanel.setTitle(planet.getName());

    InvisiblePanel eastPanel = new InvisiblePanel(imgBase);
    if (planet != null) {
      buildingLabel = new TransparentLabel(eastPanel, "Buildings("
          + planet.getUsedPlanetSize() + "/" + planet.getGroundSize() + "):");
      buildingLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
      eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
      eastPanel.add(buildingLabel);
      buildingList = new JList<>(planet.getBuildingList());
      buildingList.setCellRenderer(new ProductionListRenderer());
      buildingList.setAlignmentX(Component.LEFT_ALIGNMENT);
      buildingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      buildingList.setBackground(Color.BLACK);
      JScrollPane scroll = new JScrollPane(buildingList);
      scroll.setBackground(Color.BLACK);
      scroll.setPreferredSize(new Dimension(200, 200));
      eastPanel.add(scroll);
      buildingInfo = new InfoTextArea(5, 35);
      buildingInfo.setFont(GuiStatics.getFontCubellanSmaller());
      buildingInfo.setEditable(false);
      eastPanel.add(buildingInfo);
      String demoBtnText = "Demolish";
      if (planet.getRecycleBonus() > 0) {
        demoBtnText = "Recycle";
      }
      demolishBuildingBtn = new SpaceButton(demoBtnText,
          GameCommands.COMMAND_DEMOLISH_BUILDING);
      demolishBuildingBtn
          .setSpaceIcon(Icons.getIconByName(Icons.ICON_IMPROVEMENT_TECH));
      demolishBuildingBtn.addActionListener(listener);
      eastPanel.add(demolishBuildingBtn);

      imgBase.setLayout(new BorderLayout());
      if (planet.getPlanetOwnerIndex() != -1) {
        imgBase.add(eastPanel, BorderLayout.EAST);
      }
    }

    // Bottom panel
    InfoPanel bottomPanel = new InfoPanel();
    bottomPanel.setLayout(new BorderLayout());
    bottomPanel.setTitle(null);
    SpaceButton btn = new SpaceButton("Back to star map",
        GameCommands.COMMAND_VIEW_STARMAP);
    btn.addActionListener(listener);
    bottomPanel.add(btn, BorderLayout.CENTER);

    this.updatePanel();

    // Add panels to base
    this.add(bottomPanel, BorderLayout.SOUTH);
    this.add(imgBase, BorderLayout.CENTER);
    if (planet.getPlanetOwnerIndex() != -1) {
      this.add(topPanel, BorderLayout.NORTH);
    }

  }

  /**
   * Update Planet view panels
   */
  public void updatePanel() {
    totalPeople.setText(": " + planet.getTotalPopulation());
    farmPanel.setText(": " + planet.getWorkers(Planet.FOOD_FARMERS));
    minePanel.setText(": " + planet.getWorkers(Planet.METAL_MINERS));
    factoryPanel.setText(": " + planet.getWorkers(Planet.PRODUCTION_WORKERS));
    resePanel.setText(": " + planet.getWorkers(Planet.RESEARCH_SCIENTIST));
    cultureLabel.setText(": " + planet.getWorkers(Planet.CULTURE_ARTIST));

    int peopleGrow = planet.getTotalProduction(Planet.PRODUCTION_POPULATION);
    if (peopleGrow > 0) {
      if (planet.exceedRadiation()) {
        peopleGrowth.setText("Never");
        peopleGrowth.setLeftIcon(Icons.getIconByName(Icons.ICON_RADIATION));
      } else {
        peopleGrowth.setLeftIcon(Icons.getIconByName(Icons.ICON_PEOPLE));
        peopleGrowth.setText(peopleGrow + " turns.");
      }
    } else if (peopleGrow < 0) {
      peopleGrow = peopleGrow * -1;
      peopleGrowth.setText(peopleGrow + " turns.");
      peopleGrowth.setLeftIcon(Icons.getIconByName(Icons.ICON_DEATH));
    } else {
      if (planet.getPlanetPlayerInfo() != null
          && planet.getPlanetPlayerInfo().getRace() == SpaceRace.MECHIONS) {
        peopleGrowth.setText("no growth");
        peopleGrowth.setToolTipText(
            "Mechions needs to be built to get more population.");
      } else {
        peopleGrowth.setText("stable ");
      }
      peopleGrowth.setLeftIcon(Icons.getIconByName(Icons.ICON_PEOPLE));
    }
    farmProd.setText(": " + planet.getTotalProduction(Planet.PRODUCTION_FOOD));
    mineProd.setText(": " + planet.getTotalProduction(Planet.PRODUCTION_METAL));
    prodProd.setText(
        ": " + planet.getTotalProduction(Planet.PRODUCTION_PRODUCTION));
    reseProd
        .setText(": " + planet.getTotalProduction(Planet.PRODUCTION_RESEARCH));
    cultProd
        .setText(": " + planet.getTotalProduction(Planet.PRODUCTION_CULTURE));

    credProd
        .setText(": " + planet.getTotalProduction(Planet.PRODUCTION_CREDITS));
    maintenance.setText(": " + planet.getMaintenanceCost());
    taxPanel.setText(": " + planet.getTax());
    metal.setText(": " + planet.getMetal());
    metalOre.setText(": " + planet.getAmountMetalInGround());
    buildingLabel.setText("Buildings(" + planet.getUsedPlanetSize() + "/"
        + planet.getGroundSize() + "):");

    Construction building = (Construction) constructionSelect.getSelectedItem();
    buildingEstimate.setText(planet.getProductionTime(building));

    productionInfo.setText(building.getFullDescription());
    buildingList.setListData(planet.getBuildingList());

  }

  /**
   * @return the planet
   */
  public Planet getPlanet() {
    return planet;
  }

  /**
   * @param planet the planet to set
   */
  public void setPlanet(final Planet planet) {
    this.planet = planet;
  }

  /**
   * Handle actions for Planet view.
   * @param arg0 ActionEvent command what player did
   */
  public void handleAction(final ActionEvent arg0) {
    if (arg0.getActionCommand().equals(GameCommands.COMMAND_ANIMATION_TIMER)) {
      Building building = buildingList.getSelectedValue();
      if (building != null) {
        buildingInfo.setText(building.getFullDescription());
      }
    }
    if (arg0.getActionCommand()
        .equals(GameCommands.COMMAND_DEMOLISH_BUILDING)) {
      Building building = buildingList.getSelectedValue();
      if (building != null) {
        planet.removeBuilding(building);
        updatePanel();
      }
    }
    if (arg0.getActionCommand()
        .equalsIgnoreCase(GameCommands.COMMAND_MINUS_FARM)
        && planet.getWorkers(Planet.FOOD_FARMERS) > 0) {
      planet.setWorkers(Planet.FOOD_FARMERS,
          planet.getWorkers(Planet.FOOD_FARMERS) - 1);
      planet.setWorkers(Planet.CULTURE_ARTIST,
          planet.getWorkers(Planet.CULTURE_ARTIST) + 1);
      updatePanel();
    }
    if (arg0.getActionCommand().equalsIgnoreCase(GameCommands.COMMAND_PLUS_FARM)
        && planet.getWorkers(Planet.CULTURE_ARTIST) > 0) {
      planet.setWorkers(Planet.FOOD_FARMERS,
          planet.getWorkers(Planet.FOOD_FARMERS) + 1);
      planet.setWorkers(Planet.CULTURE_ARTIST,
          planet.getWorkers(Planet.CULTURE_ARTIST) - 1);
      updatePanel();
    }
    if (arg0.getActionCommand()
        .equalsIgnoreCase(GameCommands.COMMAND_MINUS_MINE)
        && planet.getWorkers(Planet.METAL_MINERS) > 0) {
      planet.setWorkers(Planet.METAL_MINERS,
          planet.getWorkers(Planet.METAL_MINERS) - 1);
      planet.setWorkers(Planet.CULTURE_ARTIST,
          planet.getWorkers(Planet.CULTURE_ARTIST) + 1);
      updatePanel();
    }
    if (arg0.getActionCommand().equalsIgnoreCase(GameCommands.COMMAND_PLUS_MINE)
        && planet.getWorkers(Planet.CULTURE_ARTIST) > 0) {
      planet.setWorkers(Planet.METAL_MINERS,
          planet.getWorkers(Planet.METAL_MINERS) + 1);
      planet.setWorkers(Planet.CULTURE_ARTIST,
          planet.getWorkers(Planet.CULTURE_ARTIST) - 1);
      updatePanel();
    }
    if (arg0.getActionCommand()
        .equalsIgnoreCase(GameCommands.COMMAND_MINUS_PRODUCTION)
        && planet.getWorkers(Planet.PRODUCTION_WORKERS) > 0) {
      planet.setWorkers(Planet.PRODUCTION_WORKERS,
          planet.getWorkers(Planet.PRODUCTION_WORKERS) - 1);
      planet.setWorkers(Planet.CULTURE_ARTIST,
          planet.getWorkers(Planet.CULTURE_ARTIST) + 1);
      updatePanel();
    }
    if (arg0.getActionCommand()
        .equalsIgnoreCase(GameCommands.COMMAND_PLUS_PRODUCTION)
        && planet.getWorkers(Planet.CULTURE_ARTIST) > 0) {
      planet.setWorkers(Planet.PRODUCTION_WORKERS,
          planet.getWorkers(Planet.PRODUCTION_WORKERS) + 1);
      planet.setWorkers(Planet.CULTURE_ARTIST,
          planet.getWorkers(Planet.CULTURE_ARTIST) - 1);
      updatePanel();
    }
    if (arg0.getActionCommand()
        .equalsIgnoreCase(GameCommands.COMMAND_MINUS_RESEARCH)
        && planet.getWorkers(Planet.RESEARCH_SCIENTIST) > 0) {
      planet.setWorkers(Planet.RESEARCH_SCIENTIST,
          planet.getWorkers(Planet.RESEARCH_SCIENTIST) - 1);
      planet.setWorkers(Planet.CULTURE_ARTIST,
          planet.getWorkers(Planet.CULTURE_ARTIST) + 1);
      updatePanel();
    }
    if (arg0.getActionCommand()
        .equalsIgnoreCase(GameCommands.COMMAND_PLUS_RESEARCH)
        && planet.getWorkers(Planet.CULTURE_ARTIST) > 0) {
      planet.setWorkers(Planet.RESEARCH_SCIENTIST,
          planet.getWorkers(Planet.RESEARCH_SCIENTIST) + 1);
      planet.setWorkers(Planet.CULTURE_ARTIST,
          planet.getWorkers(Planet.CULTURE_ARTIST) - 1);
      updatePanel();
    }
    if (arg0.getActionCommand()
        .equalsIgnoreCase(GameCommands.COMMAND_MINUS_TAX)) {
      planet.setTax(planet.getTax() - 1);
      updatePanel();
    }
    if (arg0.getActionCommand()
        .equalsIgnoreCase(GameCommands.COMMAND_PLUS_TAX)) {
      planet.setTax(planet.getTax() + 1);
      updatePanel();
    }
    if (arg0.getActionCommand()
        .equalsIgnoreCase(GameCommands.COMMAND_PRODUCTION_LIST)) {
      planet.setUnderConstruction(
          (Construction) constructionSelect.getSelectedItem());
      updatePanel();
    }
  }
}