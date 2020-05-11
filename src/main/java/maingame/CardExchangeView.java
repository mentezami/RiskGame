package maingame;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import config.Commands;
import controller.GameController;
import entity.Card;

/**
 * This class controls the behavior of the Card Exchange View. It will display
 * all the cards owned by the current player, then allow the player to select
 * some cards to exchange.
 *
 * @author Mahmoudreza
 * @version 0.0.1
 */
public class CardExchangeView implements Observer{

    /*
     * (non-Javadoc)
     *
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    @Override
    public void update(Observable o, Object arg) {

        String methodValue = (String) arg;
        GameController gameController = (GameController) o;
        Scanner sc = new Scanner(System.in);

        // If the player selects cards, they are given the appropriate number of armies
        // as reinforcement. The player can choose
        // not to exchange cards and exit the card exchange view. If the player own 5
        // cards or more, they must exchange cards. The cards
        // exchange view should cease to exist after the cards exchange.
        if (methodValue.equals("card-exchange")) {

            int cardSize = gameController.getCurrentPlayer().getCardList().size();

            System.out.println("++++++++++ Card Exchange View ++++++++++");
            System.out.println("Current game phase: Gameplay reinforcement (exchangecards)");
            System.out.println(gameController.getCurrentPlayer() + " has " + gameController.getCurrentPlayer().getCardList()
                    + " cards");

            if (cardSize >= 3) {

                int i = 1;
                for (Card card : gameController.getCurrentPlayer().getCardList()) {
                    System.out.println(i + "." + card);
                    i++;
                }

                while (true) {

                    Boolean forcefulExchange = false;
                    if (cardSize >= 5) {
                        System.out.println("You have 5(max) cards, you need to exchange !!!");
                        forcefulExchange = true;
                    }

                    String command = sc.nextLine();
                    String[] words = command.split(" ");
                    String commandType = words[0];

                    switch (commandType) {

                        case Commands.MAP_COMMAND_REINFORCE_OPTION_EXCHANGECARDS:

                            if (words[1].equalsIgnoreCase("-none")) {

                                if (forcefulExchange) {
                                    break;
                                } else {
                                    System.out.println(gameController.getCurrentPlayer() + " has chosen not to exchange cards");
                                    return;
                                }
                            }

                            if (words.length < 4) {
                                System.out.println("Invalid command, Try again !!!");
                                break;
                            }

                            int idx[] = new int[3];

                            try {
                                idx[0] = Integer.parseInt(words[1]) - 1;
                                idx[1] = Integer.parseInt(words[2]) - 1;
                                idx[2] = Integer.parseInt(words[3]) - 1;
                            } catch (Exception e) {
                                System.out.println("Exception: " + e.toString());
                                break;
                            }

                            List<Card> cardsChoosen = new ArrayList<>();
                            List<Card> cardList = gameController.getCurrentPlayer().getCardList();

                            for (int index : idx) {

                                if (index <= 0) {
                                    System.out.println("Error: cannot accept negative index");
                                    break;
                                }

                                try {
                                    cardsChoosen.add(cardList.get(index));
                                } catch (Exception e) {
                                    System.out.println("Exception: " + e.toString());
                                    break;
                                }
                            }

                            Boolean retVal = gameController.getCardModel().areCardsvalidForExchange(cardsChoosen);

                            if (retVal) {
                                gameController.getCardModel().exchangeCards(gameController.getCurrentPlayer(),
                                        cardsChoosen, gameController.getCardsStack());
                                return;
                            } else
                                System.out.println(
                                        "You can only exchange when \n1.Cards of all same type or \n2.Cards of all different type");
                            break;

                        default:
                            System.out.println("Invalid command, Try again !!!");
                            break;
                    }
                }
            }
        }

        System.out.println("+++++++++++++++++++++++++");
    }
}

