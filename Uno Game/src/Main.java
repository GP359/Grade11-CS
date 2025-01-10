import java.util.*;
import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    ArrayList <String> Deck = new ArrayList <String>();
      Deck.add("Red 0");
      Deck.add("Red 1");
      Deck.add("Red 1");
      Deck.add("Red 2");
      Deck.add("Red 2");
      Deck.add("Red 3");
      Deck.add("Red 3");
      Deck.add("Red 4");
      Deck.add("Red 4");
      Deck.add("Red 5");
      Deck.add("Red 5");
      Deck.add("Red 6");
      Deck.add("Red 6");
      Deck.add("Red 7");
      Deck.add("Red 7");
      Deck.add("Red 8");
      Deck.add("Red 8");
      Deck.add("Red 9");
      Deck.add("Red 9");
      Deck.add("Yellow 0");
      Deck.add("Yellow 1");
      Deck.add("Yellow 1");
      Deck.add("Yellow 2");
      Deck.add("Yellow 2");
      Deck.add("Yellow 3");
      Deck.add("Yellow 3");
      Deck.add("Yellow 4");
      Deck.add("Yellow 4");
      Deck.add("Yellow 5");
      Deck.add("Yellow 5");
      Deck.add("Yellow 6");
      Deck.add("Yellow 6");
      Deck.add("Yellow 7");
      Deck.add("Yellow 7");
      Deck.add("Yellow 8");
      Deck.add("Yellow 8");
      Deck.add("Yellow 9");
      Deck.add("Yellow 9");
      Deck.add("Green 0");
      Deck.add("Green 1");
      Deck.add("Green 1");
      Deck.add("Green 2");
      Deck.add("Green 2");
      Deck.add("Green 3");
      Deck.add("Green 3");
      Deck.add("Green 4");
      Deck.add("Green 4");
      Deck.add("Green 5");
      Deck.add("Green 5");
      Deck.add("Green 6");
      Deck.add("Green 6");
      Deck.add("Green 7");
      Deck.add("Green 7");
      Deck.add("Green 8");
      Deck.add("Green 8");
      Deck.add("Green 9");
      Deck.add("Green 9");
      Deck.add("Blue 0");
      Deck.add("Blue 1");
      Deck.add("Blue 1");
      Deck.add("Blue 2");
      Deck.add("Blue 2");
      Deck.add("Blue 3");
      Deck.add("Blue 3");
      Deck.add("Blue 4");
      Deck.add("Blue 4");
      Deck.add("Blue 5");
      Deck.add("Blue 5");
      Deck.add("Blue 6");
      Deck.add("Blue 6");
      Deck.add("Blue 7");
      Deck.add("Blue 7");
      Deck.add("Blue 8");
      Deck.add("Blue 8");
      Deck.add("Blue 9");
      Deck.add("Blue 9");
      Deck.add("Wild +4");
      Deck.add("Wild +4");
      Deck.add("Wild +4");
      Deck.add("Wild +4");
      Deck.add("Wild");
      Deck.add("Wild");
      Deck.add("Wild");
      Deck.add("Wild");
      Deck.add("Red +2");
      Deck.add("Red +2");
      Deck.add("Yellow +2");
      Deck.add("Yellow +2");
      Deck.add("Green +2");
      Deck.add("Green +2");
      Deck.add("Blue +2");
      Deck.add("Blue +2");
      Deck.add("Red Skip");
      Deck.add("Red Skip");
      Deck.add("Yellow Skip");
      Deck.add("Yellow Skip");
      Deck.add("Green Skip");
      Deck.add("Green Skip");
      Deck.add("Blue Skip");
      Deck.add("Blue Skip");
      System.out.println("Human mode or AI mode");
      ArrayList <String> Player1 = new ArrayList <String>();
      for ( int i = 0 ; i < 7 ; i ++ ) {
            int random = (int) (Math.random() * Deck.size());
            Player1.add(Deck.get(random));
            Deck.remove(Deck.get(random));
      }
      ArrayList <String> Player2 = new ArrayList <String>();
      for ( int i = 0 ; i < 7 ; i ++ ) {
            int random = (int) (Math.random() * Deck.size());
            Player2.add(Deck.get(random));
            Deck.remove(Deck.get(random));
      }
      String Mode = sc.nextLine();
      Mode = Mode.toUpperCase();
      if (Mode.equals("HUMAN")) {
      String TopCard = "" ;
      boolean TrueCard = false;
      for (int random = (int) (Math.random() * Deck.size()) ; TrueCard == false ; random = (int) (Math.random() * Deck.size())){
            if ( Deck.get(random).contains("Wild") || Deck.get(random).contains("Skip") )
                  TrueCard = false ;
            else {
                  System.out.println("Starting card : " + Deck.get(random));
            TopCard = Deck.get(random);
            Deck.remove(TopCard);
            TrueCard = true ;
            }
      }
      boolean OneWin = false ;
      boolean TwoWin = false ;
      while ( OneWin == false  || TwoWin == false){
      String TopCardColor = "";
      if (TopCard.contains("Red"))
    	  TopCardColor = "Red";
      else if (TopCard.contains("Yellow"))
    	  TopCardColor = "Yellow";
      else if (TopCard.contains("Green"))
    	  TopCardColor = "Green";
      else if (TopCard.contains("Blue"))
    	  TopCardColor = "Blue";
      int Turns = 0;
      for ( int i = 0 ; i < 1 ; i ++ ) {
    	  Turns = (int) (Math.random() * 2);
      }
      if (Turns % 2 == 1) {
    	  boolean check = false;
    	  System.out.println("Player1 is going first");
    	  System.out.println("Player1 Deck : " + Player1 );
    	  for ( int i = 0 ; i == Player1.size() - 1 || check == false ; i ++ ) {
    		  if (Player1.get(i).contains(TopCardColor) || Player1.get(i).contains("Wild")) {
    			  check = true;
    		  }
    	  }
    	  if ( check == true ) {
    		  System.out.println("Use a Card or Draw Card , Enter \"Use\" if use a card or Enter \"Draw\" if draw a card");
    		  String Response = sc.nextLine().toUpperCase();
    		  Boolean ResponseError = false;
    		  while (ResponseError = true) {
    			  Boolean UseError = true;
                  while ( UseError == true) {
                        if (Response.equals("USE")) {
                              ResponseError = false;
                              System.out.println("Pick a card to use in your deck , your currect deck : " + Player1 );
                              System.out.println("TopCard : " + TopCard );
                              Response = sc.nextLine();
                              UseError = false;
                              Boolean PickError = true;
                              while ( PickError == true) {
                                    if(Player1.contains(Response) && Response.contains(TopCardColor) || Player1.contains("Wild") && Response.contains("Wild")) {
                                    TopCard = Response;
                                    Player1.remove(Response);
                                    System.out.println("Card used " + Response + ", Your deck have now remains " + Player1);
                                    PickError = false;
                                    if ( Response == "Wild") {
                                          boolean ColorError = false;
                                          System.out.println("Enter new color for next round");
                                          TopCardColor = sc.nextLine().toUpperCase();
                                          if ( TopCardColor != "RED" || TopCardColor != "YELLOW" || TopCardColor != "GREEN" || TopCardColor != "BLUE" )
                                          ColorError = true;
                                          while ( ColorError == true ) {
                                          System.out.println("Please re-enter , this color doesn't not include in Uno");
                                          TopCardColor = sc.nextLine();
                                                if ( TopCardColor == "RED" || TopCardColor == "YELLOW" || TopCardColor == "GREEN" || TopCardColor == "BLUE" )
                                                ColorError = false;
                                          }    
                                    }      
                                    else if ( Response == "Wild +4" ) {
                                          boolean ColorError = false;
                                          for ( int i = 0 ; i < 3 ; i ++ ) {
                                                int random = (int) (Math.random() * Deck.size());
                                                Player2.add(Deck.get(random));
                                                Deck.remove(Deck.get(random));
                                          }
                                          System.out.println("Enter new color for next round");
                                          TopCardColor = sc.nextLine().toUpperCase();
                                          if ( TopCardColor != "RED" || TopCardColor != "YELLOW" || TopCardColor != "GREEN" || TopCardColor != "BLUE" )
                                               ColorError = true;
                                          while ( ColorError == true ) {
                                                System.out.println("Please re-enter , this color doesn't not include in Uno");
                                                TopCardColor = sc.nextLine();
                                                if ( TopCardColor == "RED" || TopCardColor == "YELLOW" || TopCardColor == "GREEN" || TopCardColor == "BLUE" )
                                                ColorError = false;
                                          }
                                    }
                                    else if ( Response.contains("Skip")) {
                                          Turns ++ ;
                                    }
                                    else if ( Response.contains("+2")) {
                                          for ( int i = 0 ; i < 1 ; i ++ ) {
                                                int random = (int) (Math.random() * Deck.size());
                                                Player2.add(Deck.get(random));
                                                Deck.remove(Deck.get(random));
                                          }
                                    }
                                    } else if (PickError = true) {
                                          System.out.println("The card does not exist in your deck , please re-enter");
                                          Response = sc.nextLine();
                                    }
                              }
                        }      
                        else if (Response.equals("DRAW")) {
                              ResponseError = false;
                              System.out.println("You decide to draw a card , Systen warp to Draw");
                              int random = (int) (Math.random() * Deck.size());
                              Player1.add(Deck.get(random));
                              Deck.remove(Deck.get(random));
                              UseError = false;
                        } else {
                              ResponseError = true;
                              System.out.println("Error please enter \"Use\" or \"Draw\"");
                              Response = sc.nextLine().toUpperCase();
                  }
                  }
                  }
            } else {
                  System.out.println("You have no cards to use , Systen automatic warp to Draw");
                  int random = (int) (Math.random() * Deck.size());
                  Player1.add(Deck.get(random));
                  Deck.remove(Deck.get(random));
                  System.out.println("Player1 Deck : " + Player1);
            }
            Turns ++ ;
            if (Player1.size() == 0)
                  OneWin = true ;
      } else {
        	  boolean check = false;
        	  System.out.println("Player2 is going first");
        	  System.out.println("Player2 Deck : " + Player2 );
        	  for ( int i = 0 ; i == Player2.size() - 1 || check == false ; i ++ ) {
        		  if (Player2.get(i).contains(TopCardColor) || Player2.get(i).contains("Wild")) {
        			  check = true;
        		  }
        	  }
        	  if ( check == true ) {
        		  System.out.println("Use a Card or Draw Card , Enter \"Use\" if use a card or Enter \"Draw\" if draw a card");
        		  String Response = sc.nextLine().toUpperCase();
        		  Boolean ResponseError = false;
        		  while (ResponseError = true) {
        			  Boolean UseError = true;
                      while ( UseError == true) {
                            if (Response.equals("USE")) {
                                  ResponseError = false;
                                  System.out.println("Pick a card to use in your deck , your currect deck : " + Player2 );
                                  System.out.println("TopCard : " + TopCard );
                                  Response = sc.nextLine();
                                  UseError = false;
                                  Boolean PickError = true;
                                  while ( PickError == true) {
                                        if(Player2.contains(Response) && Response.contains(TopCardColor) || Player2.contains("Wild") && Response.contains("Wild")) {
                                        TopCard = Response;
                                        Player2.remove(Response);
                                        System.out.println("Card used " + Response + ", Your deck have now remains " + Player2);
                                        PickError = false;
                                        if ( Response == "Wild") {
                                              boolean ColorError = false;
                                              System.out.println("Enter new color for next round");
                                              TopCardColor = sc.nextLine().toUpperCase();
                                              if ( TopCardColor != "RED" || TopCardColor != "YELLOW" || TopCardColor != "GREEN" || TopCardColor != "BLUE" )
                                              ColorError = true;
                                              while ( ColorError == true ) {
                                              System.out.println("Please re-enter , this color doesn't not include in Uno");
                                              TopCardColor = sc.nextLine();
                                                    if ( TopCardColor == "RED" || TopCardColor == "YELLOW" || TopCardColor == "GREEN" || TopCardColor == "BLUE" )
                                                    ColorError = false;
                                              }    
                                        }      
                                        else if ( Response == "Wild +4" ) {
                                              boolean ColorError = false;
                                              for ( int i = 0 ; i < 3 ; i ++ ) {
                                                    int random = (int) (Math.random() * Deck.size());
                                                    Player1.add(Deck.get(random));
                                                    Deck.remove(Deck.get(random));
                                              }
                                              System.out.println("Enter new color for next round");
                                              TopCardColor = sc.nextLine().toUpperCase();
                                              if ( TopCardColor != "RED" || TopCardColor != "YELLOW" || TopCardColor != "GREEN" || TopCardColor != "BLUE" )
                                                   ColorError = true;
                                              while ( ColorError == true ) {
                                                    System.out.println("Please re-enter , this color doesn't not include in Uno");
                                                    TopCardColor = sc.nextLine();
                                                    if ( TopCardColor == "RED" || TopCardColor == "YELLOW" || TopCardColor == "GREEN" || TopCardColor == "BLUE" )
                                                    ColorError = false;
                                              }
                                        }
                                        else if ( Response.contains("Skip")) {
                                              Turns ++ ;
                                        }
                                        else if ( Response.contains("+2")) {
                                              for ( int i = 0 ; i < 1 ; i ++ ) {
                                                    int random = (int) (Math.random() * Deck.size());
                                                    Player1.add(Deck.get(random));
                                                    Deck.remove(Deck.get(random));
                                              }
                                        }
                                        } else if (PickError = true) {
                                              System.out.println("The card does not exist in your deck , please re-enter");
                                              Response = sc.nextLine();
                                        }
                                  }
                            }      
                            else if (Response.equals("DRAW")) {
                                  ResponseError = false;
                                  System.out.println("You decide to draw a card , Systen warp to Draw");
                                  int random = (int) (Math.random() * Deck.size());
                                  Player2.add(Deck.get(random));
                                  Deck.remove(Deck.get(random));
                                  UseError = false;
                            } else {
                                  ResponseError = true;
                                  System.out.println("Error please enter \"Use\" or \"Draw\"");
                                  Response = sc.nextLine().toUpperCase();
                            }
                      	 }
                      }
                } else {
                      System.out.println("You have no cards to use , Systen automatic warp to Draw");
                      int random = (int) (Math.random() * Deck.size());
                      Player1.add(Deck.get(random));
                      Deck.remove(Deck.get(random));
                      System.out.println("Player1 Deck : " + Player1);
                }
                Turns ++ ;
                if (Player1.size() == 0)
                      OneWin = true ;
      }
      }
      }
      else if(Mode == "AI")
            System.out.println("");

}
}