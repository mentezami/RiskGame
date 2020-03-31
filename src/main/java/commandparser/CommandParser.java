package commandparser;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import config.Commands;
import entity.Hmap;
import entity.Player;
import exception.InvalidMap;
import mapparser.MapReader;
import mapparser.MapVerifier;
import playerparser.PlayerCommands;


public class CommandParser {


        Hmap rootMap;
        PlayerCommands playerCommands;

        String editFilePath = "";
        boolean isReinfoceArmiesAssigned = false;

        public CommandParser() {
            this.playerCommands = new PlayerCommands();
            this.rootMap = new Hmap();
        }

        private Hmap setMap(Hmap map) {
            return this.rootMap = map;
        }

        private Hmap getMap() {
            return rootMap;
        }

        public boolean processMapEditCommands(String command) {

            String[] words = command.split(" ");
            String commandType = words[0];
            MapReader mapReader;
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();

            if (Commands.MAP_COMMAND_EDIT_CONTINENT.equals(commandType)) {
                for (int idx = 1; idx < words.length; idx++) {

                    if (words[idx].equals(Commands.MAP_COMMAND_OPTION_ADD)) {

                        if (words.length < idx + 3) {
                            System.out.println("Invalid command, Try again !!!");
                            return false;
                        }


                    } else if (words[idx].equals(Commands.MAP_COMMAND_OPTION_REMOVE)) {

                        if (words.length < idx + 2) {
                            System.out.println("Invalid command, Try again !!!");
                            return false;
                        }


                    } else {
                        System.out.println("Invalid command, Try again !!!");
                    }
                }
            } else if (Commands.MAP_COMMAND_EDIT_COUNTRY.equals(commandType)) {
                for (int idx = 1; idx < words.length; idx++) {

                    if (words[idx].equals(Commands.MAP_COMMAND_OPTION_ADD)) {

                        if (words.length < idx + 3) {
                            System.out.println("Invalid command, Try again !!!");
                            return false;
                        }


                    } else if (words[idx].equals(Commands.MAP_COMMAND_OPTION_REMOVE)) {

                        if (words.length < idx + 2) {
                            System.out.println("Invalid command, Try again !!!");
                            return false;
                        }


                    } else {
                        System.out.println("Invalid command, Try again !!!");
                    }
                }
            } else if (Commands.MAP_COMMAND_EDIT_NEIGHBOR.equals(commandType)) {
                for (int idx = 1; idx < words.length; idx++) {

                    if (words[idx].equals(Commands.MAP_COMMAND_OPTION_ADD)) {

                        if (words.length < idx + 3) {
                            System.out.println("Invalid command, Try again !!!");
                            return false;
                        }


                    } else if (words[idx].equals(Commands.MAP_COMMAND_OPTION_REMOVE)) {

                        if (words.length < idx + 3) {
                            System.out.println("Invalid command, Try again !!!");
                            return false;
                        }


                    } else {
                        System.out.println("Invalid command, Try again !!!");
                    }
                }

            } else if (Commands.MAP_COMMAND_SAVEMAP.equals(commandType)) {
                if (words.length < 2) {
                    System.out.println("Invalid command, Try again !!!");
                    return false;
                }


                try {
                    MapVerifier.verifyMap(getMap());
                } catch (InvalidMap e1) {
                    System.out.println("Exception: " + e1.toString());
                    return false;
                }

            } else if (Commands.MAP_COMMAND_EDITMAP.equals(commandType)) {
                if (words.length < 2) {
                    System.out.println("Invalid command, Try again !!!");
                    return false;
                }

                editFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\" + words[1];
                File editMapFile = new File(editFilePath);
                mapReader = new MapReader();

                if (editMapFile.exists()) {
                    try {
                        setMap(mapReader.readMapFile(editMapFile));
                    } catch (InvalidMap e) {
                        System.out.println("Exception: " + e.toString());
                    }
                } else {
                    System.out.println("Given map file does not exist. New Map file has been created.");
                    try {
                        editMapFile.createNewFile();
                    } catch (IOException e) {
                        System.out.println("Exception: " + e.toString());
                    }
                }
            } else if (Commands.MAP_COMMAND_VALIDATEMAP.equals(commandType)) {
                try {
                    MapVerifier.verifyMap(getMap());
                } catch (InvalidMap e1) {
                    System.out.println("Exception: " + e1.toString());
                }
            } else if (Commands.MAP_COMMAND_LOADMAP.equals(commandType)) {
                if (words.length < 2) {
                    System.out.println("Invalid command, Try again !!!");
                    return false;
                }

                mapReader = new MapReader();

                if (null == classloader.getResource(words[1])) {
                    System.out.println("Exception: File does not exist: " + words[1]);
                    return false;
                }

                File inputMapFile = new File(classloader.getResource(words[1]).getFile().replace("%20", " "));

                if (inputMapFile.exists()) {
                    try {
                        setMap(mapReader.readMapFile(inputMapFile));
                        return true;
                    } catch (InvalidMap e) {
                        System.out.println("Exception: " + e.toString());
                    }
                } else {
                    System.out.println("Exception: File does not exist: " + inputMapFile.getAbsolutePath());
                }
            } else {
                System.out.println("Invalid command, Try again !!!");
            }
            return false;
        }

        public boolean processGamePlayCreatePlayerCommands(String command) {

            String[] words = command.split(" ");
            String commandType = words[0];

            if (Commands.MAP_COMMAND_GAMEPLAYER.equals(commandType)) {
                for (int idx = 1; idx < words.length; idx++) {
                    if (words[idx].equals(Commands.MAP_COMMAND_OPTION_ADD)) {

                        if (words.length < idx + 2) {
                            System.out.println("Invalid command, Try again !!!");
                            return false;
                        }

                        String playerName = words[idx + 1];
                        playerCommands.createPlayer(playerName);
                        idx = idx + 1;

                    } else if (words[idx].equals(Commands.MAP_COMMAND_OPTION_REMOVE)) {

                        if (words.length < idx + 2) {
                            System.out.println("Invalid command, Try again !!!");
                            return false;
                        }

                        String playerName = words[idx + 1];
                        playerCommands.removePlayer(playerName);
                        idx = idx + 1;

                    } else {
                        System.out.println("Invalid command, Try again !!!");
                        break;
                    }
                }
            } else if (Commands.MAP_COMMAND_POPULATE_COUNTRIES.equals(commandType)) {
                playerCommands.setCountryList(playerCommands.getCountryListFromMap(getMap()));

                if (playerCommands.assignArmiesToPlayers()) {

                    playerCommands.populateCountries(getMap());
                    playerCommands.intitializeArmiesForAllCountries();

                    for (Player p : playerCommands.getPlayersList()) {
                        int countryCount = p.getAssignedCountry().size();
                        System.out.println("Number of Countries for Player : " + p.getName() + " = " + countryCount);
                    }

                    playerCommands.setCurrentPlayer(playerCommands.getPlayersList().get(0));
                    playerCommands.setCountryMap(playerCommands.getCountryMapFromList(playerCommands.getCountryList()));
                    return true;
                }
            } else {
                System.out.println("Invalid command, Try again !!!");
            }

            return false;
        }

        public boolean processGamePlayStartupCommands(Scanner sc) {

            System.out.println("Current state: Gameplay startup phase (placearmy, placeall, showmap)");
            System.out.println("Current Player: " + playerCommands.getCurrentPlayer().getName() +
                    ", number of armies left = " + playerCommands.getCurrentPlayer().getArmies());

            String command = sc.nextLine();
            String[] words = command.split(" ");
            String commandType = words[0];

            if (Commands.MAP_COMMAND_SHOWMAP.equals(commandType)) {
                playerCommands.gamePlayShowmap();
            } else if (Commands.MAP_COMMAND_PLACE_ARMY.equals(commandType)) {
                if (words.length < 2) {
                    System.out.println("Invalid command, Try again !!!");
                    return false;
                }

                if (playerCommands.placeArmy(words[1])) {
                    playerCommands.changeCurrentPlayer();
                }

                if (playerCommands.isAllPlayersArmiesExhausted()) {
                    playerCommands.setCurrentPlayer(playerCommands.getPlayersList().get(0));
                    return true;
                }
            } else if (Commands.MAP_COMMAND_PLACE_ALL.equals(commandType)) {
                playerCommands.placeAll();
                playerCommands.setCurrentPlayer(playerCommands.getPlayersList().get(0));
                return true;
            } else {
                System.out.println("Invalid command, Try again !!!");
            }

            return false;
        }

        public boolean processGamePlayReinforcementCommands(Scanner sc) {

            if (!isReinfoceArmiesAssigned) {
                playerCommands.assignReinforceArmiesToPlayers();
                isReinfoceArmiesAssigned = true;
            }

            System.out.println("Current state: Gameplay reinforcement phase (reinforce, showmap)");
            System.out.println("Current Player: " + playerCommands.getCurrentPlayer().getName()
                    + ", Armies left for reinforcement = " + playerCommands.getCurrentPlayer().getArmies());

            String command = sc.nextLine();
            String[] words = command.split(" ");
            String commandType = words[0];

            if (Commands.MAP_COMMAND_SHOWMAP.equals(commandType)) {
                playerCommands.gamePlayShowmap();
            } else if (Commands.MAP_COMMAND_REINFORCE.equals(commandType)) {
                if (words.length < 3) {
                    System.out.println("Invalid command, Try again !!!");
                    return false;
                }

                String countryName = words[1];
                int numberOfArmies = 0;

                try {
                    numberOfArmies = Integer.parseInt(words[2]);
                } catch (Exception e) {
                    System.out.println("Exception: " + e.toString());
                    return false;
                }

                if (numberOfArmies <= 0) {
                    System.out.println("You have entered invalid number of armies.");
                    return false;
                }

                if (!playerCommands.isCountryBelongToPlayer(playerCommands.getCurrentPlayer(), countryName))
                    return false;

                if (playerCommands.reinforceArmiesForCurrentPlayer(countryName, numberOfArmies))
                    return true;
            } else {
                System.out.println("Invalid command, Try again !!!");
            }

            return false;
        }

        public boolean processGamePlayFortifyCommands(Scanner sc) {
            System.out.println("Current state: Gameplay fortify phase (fortify, showmap)");
            System.out.println("Current Player: " + playerCommands.getCurrentPlayer().getName());

            boolean isForifyDone = false;
            String command = sc.nextLine();
            String[] words = command.split(" ");
            String commandType = words[0];

            if (Commands.MAP_COMMAND_SHOWMAP.equals(commandType)) {
                playerCommands.gamePlayShowmap();
            } else if (Commands.MAP_COMMAND_FORTIFY.equals(commandType)) {
                if (words.length < 2) {
                    System.out.println("Invalid command length. Try again !!!");
                    return false;
                }

                if (words[1].equalsIgnoreCase(Commands.MAP_COMMAND_FORTIFY_OPTION_NONE)) {
                    System.out.println("You have chosen to skip fortify.");
                    isForifyDone = true;
                } else {

                    if (words.length < 4) {
                        System.out.println("Invalid command length. Try again !!!");
                        return false;
                    }

                    int numArmies = 0;

                    try {
                        numArmies = Integer.parseInt(words[3]);
                    } catch (Exception e) {
                        System.out.println("Exception: " + e.toString());
                        return false;
                    }

                    if (numArmies <= 0) {
                        System.out.println("Exception: Invalid number of armies");
                        return false;
                    }

                    if (playerCommands.fortifyCurrentPlayer(words[1], words[2], numArmies))
                        isForifyDone = true;
                }

                if (isForifyDone) {
                    if (playerCommands.isLastPlayer(playerCommands.getCurrentPlayer())) {
                        isReinfoceArmiesAssigned = false;
                        System.out.println("***** All players have played. Going back to reinforcement again *****");
                    }
                    playerCommands.changeCurrentPlayer();
                }
            } else {
                System.out.println("Invalid command, Try again !!!");
            }

            return isForifyDone;
        }
    }


