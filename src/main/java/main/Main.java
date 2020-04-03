package main;


import java.util.Scanner;

import commandparser.CommandParser;
import config.GameState;

public class Main {


        static GameState gameState;

        public GameState getGameState() {
            return gameState;
        }

        public static void setGameState(GameState gamePhase) {
            gameState = gamePhase;
        }

        public static void main(String[] args) {
            CommandParser parser = new CommandParser();
            gameState = GameState.RISK_STATE_MAP_EDITING;
            Scanner sc = new Scanner(System.in);
            System.out.println("---------- Welcome to Risk game ----------");
            String command;

            while (true) {

                switch (gameState) {

                    case RISK_STATE_MAP_EDITING:

                        System.out.println("Current state: Map editor (editcontinent, "
                                + "editcountry, editneighbor, showmap, savemap, editmap, validatemap, loadmap)");
                        System.out.println("When map editing gets finised, Use \"loadmap filename\" command to start the game");
                        System.out.println("Please enter any commands to continue ...");

                        command = sc.nextLine();

                        if (parser.processMapEditCommands(command)) {
                            setGameState(GameState.RISK_STATE_GAMEPLAY_CREATE_PLAYERS);
                            System.out.println("----------------------------------");
                        }
                        break;

                    case RISK_STATE_GAMEPLAY_CREATE_PLAYERS:

                        System.out.println("Current state: Gameplay create players (gameplayer -add playername -remove playername, populatecountries, showmap)");
                        System.out.println("Use \"populatecountries\" command to allocate initial armies to players");
                        System.out.println("Please enter any commands to continue ...");

                        command = sc.nextLine();

                        if (parser.processGamePlayCreatePlayerCommands(command)) {
                            setGameState(GameState.RISK_STATE_GAMEPLAY_STARTUP_PHASE);
                            System.out.println("----------------------------------");
                        }
                        break;

                    case RISK_STATE_GAMEPLAY_STARTUP_PHASE:

                        if (parser.processGamePlayStartupCommands(sc)) {
                            setGameState(GameState.RISK_STATE_GAMEPLAY_REINFORCEMENT_PHASE);
                            System.out.println("----------------------------------");
                        }
                        break;

                    case RISK_STATE_GAMEPLAY_REINFORCEMENT_PHASE:
                        if (parser.processGamePlayReinforcementCommands(sc)) {
                            setGameState(GameState.RISK_STATE_GAMEPLAY_FORTIFICATION_PHASE);
                            System.out.println("----------------------------------");
                        }
                        break;

                    case RISK_STATE_GAMEPLAY_FORTIFICATION_PHASE:
                        if (parser.processGamePlayFortifyCommands(sc)) {
                            setGameState(GameState.RISK_STATE_GAMEPLAY_REINFORCEMENT_PHASE);
                            System.out.println("----------------------------------");
                        }

                    default:
                        break;
                }
            }
        }
    }

