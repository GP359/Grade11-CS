import java.util.*;
import java.util.Scanner;
public class Uno {
	public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    ArrayList <String> Deck = new ArrayList <String>();
     	for( int i = 0 ; i < 4 ; i++) {
     		String Color = "";
     		if (i == 0) 
                  Color = "Red ";
            else if ( i == 1 )
                  Color = "Yellow ";
            else if ( i == 2 )
                  Color = "Green ";
            else if ( i == 3 )
                  Color = "Blue ";
            for ( int j = 0 ; j < 12 ; j ++ ) {
                  if ( j == 0 ) {
                        Deck.add(Color + j);
                        Deck.add("Wild");
                        Deck.add("Wild +4");
                  }
                  else if( j == 10 ) {
                        Deck.add(Color + "+2");
                        Deck.add(Color + "+2");
                  }
                  else if( j == 11 ) {
                        Deck.add(Color + "Skip");
                        Deck.add(Color + "Skip");
                  }
                  else{
                        Deck.add(Color + j);
                        Deck.add(Color + j);
                  }
            }
      }
      Boolean Replay = true;
      while ( Replay == true ) {
            boolean OneWin = false ;
            boolean TwoWin = false ;
            boolean GameEnd = false;
            System.out.println("Human mode or AI mode");
            ArrayList <String> Player1 = new ArrayList <String>();
            for ( int i = 0 ; i < 7 ; i ++ ) {
                  int random = (int) (Math.random() * Deck.size());
                  Player1.add(Deck.get(random));
                  Deck.remove(Deck.get(random));
            }
            int Player1Score = 0;
            ArrayList <String> Player2 = new ArrayList <String>();
            for ( int i = 0 ; i < 7 ; i ++ ) {
                  int random = (int) (Math.random() * Deck.size());
                  Player2.add(Deck.get(random));
                  Deck.remove(Deck.get(random));
            }
            int Player2Score = 0;
            String Mode = sc.nextLine().toUpperCase().trim();
            if (Mode.equals("HUMAN")) {
                  String TopCard = "" ;
                  boolean TrueCard = false;
                  for (int random = (int) (Math.random() * Deck.size()) ; TrueCard == false ; random = (int) (Math.random() * Deck.size())){
                        if ( Deck.get(random).contains("Wild") || Deck.get(random).contains("Skip") || Deck.get(random).contains("+2"))
                              TrueCard = false ;
                        else {
                              System.out.println("Starting card : " + Deck.get(random));
                        TopCard = Deck.get(random);
                        Deck.remove(TopCard);
                        TrueCard = true ;
                        }
                  }
                  int Turns = (int) (Math.random() * 2) + 1;
                  String TopCardColor = "";
                  while ( GameEnd == false ){
                        if (TopCard.contains("Red"))
                              TopCardColor = "RED";
                        else if (TopCard.contains("Yellow"))
                              TopCardColor = "YELLOW";
                        else if (TopCard.contains("Green"))
                                TopCardColor = "GREEN";
                        else if (TopCard.contains("Blue"))
                                TopCardColor = "BLUE";
                        if (Turns % 2 == 1) {
                              Turns ++ ;
                              boolean check = false;
                              System.out.println("Player1 is going now");
                              System.out.println("Player1 Deck : " + Player1 );
                              for (String Card : Player1 ) {
                                    if (Card.toUpperCase().contains(TopCardColor) || Card.contains("Wild") || ( TopCard.endsWith( Card.substring(Card.length() - 1)) && !Card.contains("+") ) )
                                          check = true;
                                    if ( check == true )
                                          break;
                              }
                              if ( check == true ) {
                                    System.out.println("Use a Card or Draw Card , Enter \"Use\" if use a card or Enter \"Draw\" if draw a card");
                                    String Response = sc.nextLine().trim().toUpperCase();
                                    Boolean ResponseError = true;
                                    while (ResponseError == true) {
                                          Boolean UseError = true;
                                          while ( UseError == true) {
                                                if (Response.equals("USE")) {
                                                      ResponseError = false;
                                                      UseError = false;
                                                      System.out.println("Pick a card to use in your deck , your currect deck : " + Player1 );
                                                      System.out.println("TopCard : " + TopCard );
                                                      if ( TopCard.contains("Wild"))
                                                            System.out.println(" You may only use " + TopCardColor.toLowerCase() + " color cards");
                                                      Response = sc.nextLine();
                                                      Boolean PickError = true;
                                                      while ( PickError == true) {
                                                            if( (Player1.contains(Response) && Response.toUpperCase().contains(TopCardColor)) || (Player1.contains("Wild") && Response.equals("Wild")) || (Player1.contains("Wild +4") && Response.equals("Wild +4")) )
                                                                  PickError = false;
                                                            for (String Card : Player1 ) {
                                                                  if(Card.indexOf(Card.length() - 1) == (TopCard.indexOf(TopCard.length() - 1)) && !Card.contains("+") && Card.equals(Response) )
                                                                        PickError = false;
                                                            }
                                                            if(PickError == false) {
                                                                  TopCard = Response;
                                                                  Player1.remove(Response);
                                                                  if ( TopCard.toUpperCase().contains("RED"))
                                                                        TopCardColor = "RED";
                                                                  else if ( TopCardColor.contains("YELLOW"))
                                                                        TopCardColor = "YELLOW";
                                                                  else if ( TopCard.toUpperCase().contains("GREEN"))
                                                                        TopCardColor = "GREEN";
                                                                  else if ( TopCard.contains("BLUE"))
                                                                        TopCardColor = "BLUE";
                                                                  System.out.println("Card used " + Response + ", Your deck have now remains " + Player1);
                                                                  if ( Response.equals("Wild")) {
                                                                        boolean ColorError = false;
                                                                        System.out.println("Enter new color for next round");
                                                                        TopCardColor = sc.nextLine().trim().toUpperCase();
                                                                        if ( !TopCardColor.equals("RED") || !TopCardColor.equals("YELLOW") || !TopCardColor.equals("GREEN") || !TopCardColor.equals("BLUE"))
                                                                              ColorError = true;
                                                                        while ( ColorError == true ) {
                                                                              System.out.println("Please re-enter , this color doesn't not include in Uno");
                                                                              TopCardColor = sc.nextLine().trim().toUpperCase();
                                                                              if ( TopCardColor.equals("RED") || TopCardColor.equals("YELLOW") || TopCardColor.equals("GREEN") || TopCardColor.equals("BLUE") ) {
                                                                                    ColorError = false;
                                                                                    System.out.println("New color for next round is " + TopCardColor);
                                                                              }
                                                                        }    
                                                                  } else if ( Response.equals("Wild +4")) {
                                                                        boolean ColorError = false;
                                                                        for ( int i = 0 ; i != 4 ; i ++ ) {
                                                                              int random = (int) (Math.random() * Deck.size());
                                                                              Player2.add(Deck.get(random));
                                                                              Deck.remove(Deck.get(random));
                                                                        }
                                                                        System.out.println("Enter new color for next round");
                                                                        TopCardColor = sc.nextLine().trim().toUpperCase();
                                                                        if ( !TopCardColor.equals("RED") || !TopCardColor.equals("YELLOW") || !TopCardColor.equals("GREEN") || !TopCardColor.equals("BLUE") )
                                                                              ColorError = true;
                                                                        while ( ColorError == true ) {
                                                                              System.out.println("Please re-enter , this color doesn't not include in Uno");      
                                                                              TopCardColor = sc.nextLine().trim().toUpperCase();
                                                                              if ( TopCardColor.equals("RED") || TopCardColor.equals("YELLOW") || TopCardColor.equals("GREEN") || TopCardColor.equals("BLUE") ) {
                                                                                    ColorError = false;
                                                                                    System.out.println("New color for next round is : " + TopCardColor);
                                                                              }
                                                                        }
                                                                  } else if ( Response.contains("Skip")) {
                                                                        Turns ++ ;
                                                                  } else if ( Response.contains("+2")) {
                                                                        for ( int i = 0 ; i != 2 ; i ++ ) {
                                                                              int random = (int) (Math.random() * Deck.size());
                                                                              Player2.add(Deck.get(random));
                                                                              Deck.remove(Deck.get(random));
                                                                        }
                                                                  }
                                                            } else if (PickError = true) {
                                                            System.out.println("You may not use this card under this circumstances , please re-enter");
                                                            Response = sc.nextLine();
                                                            }
                                                      }
                                                } else if (Response.equals("DRAW")) {
                                                      ResponseError = false;
                                                      UseError = false;
                                                      System.out.println("You decide to draw a card , Systen warp to Draw");
                                                      int random = (int) (Math.random() * Deck.size());
                                                      Player1.add(Deck.get(random));
                                                      System.out.println("Card Drew : " + Deck.get(random));
                                                      Deck.remove(Deck.get(random));
                                                      System.out.println("Your updated deck, Player1 Deck : " + Player1 );
                                                } else {
                                                      ResponseError = true;
                                                      System.out.println("Error please enter \"Use\" or \"Draw\"");
                                                      Response = sc.nextLine().toUpperCase();
                                                }
                                          }
                                    }
                              } else {
                                    System.out.println("You have no cards to use , Systen automatic warp to Draw");
                                    int randomCard = (int) (Math.random() * Deck.size());
                                    Player1.add(Deck.get(randomCard));
                                    System.out.println("Card Drew : " + Deck.get(randomCard));
                                    System.out.println("Your updated deck, Player1 Deck : " + Player1 );
                                    for (String Card : Player1 ) {
                                          if (Card.toUpperCase().contains(TopCardColor) || Card.contains("Wild") || ( TopCard.endsWith( Card.substring(Card.length() - 1)) && !Card.contains("+") ) )
                                                check = true;
                                          if ( check == true )
                                                break;
                                    }
                                    if (check == true) {
                                          System.out.println("Option available to use drawn card immediately , Enter \"Use\" if use or \"Skip\" to skip ");
                                          String Response = sc.nextLine().trim().toUpperCase();
                                          boolean UseError = true;
                                          while ( UseError == true) {
                                                if (Response.equals("USE")) {
                                                      UseError = false;
                                                      TopCard = Deck.get(randomCard);
                                                      Player1.remove(Deck.get(randomCard));
                                                      if ( TopCard.toUpperCase().contains("RED"))
                                                            TopCardColor = "RED";
                                                      else if ( TopCardColor.contains("YELLOW"))
                                                            TopCardColor = "YELLOW";
                                                      else if ( TopCard.toUpperCase().contains("GREEN"))
                                                            TopCardColor = "GREEN";
                                                      else if ( TopCard.contains("BLUE"))
                                                            TopCardColor = "BLUE";
                                                      System.out.println("Card used " + Deck.get(randomCard) + ", Your deck have now remains " + Player1);
                                                      if ( Deck.get(randomCard).equals("Wild")) {
                                                            boolean ColorError = true;
                                                            System.out.println("Enter new color for next round");
                                                            TopCardColor = sc.nextLine().trim().toUpperCase();
                                                            if ( !TopCardColor.equals("RED") || !TopCardColor.equals("YELLOW") || !TopCardColor.equals("GREEN") || !TopCardColor.equals("BLUE"))
                                                                  ColorError = true;
                                                            while ( ColorError == true ) {
                                                            System.out.println("Please re-enter , this color doesn't not include in Uno");
                                                            TopCardColor = sc.nextLine().trim().toUpperCase();
                                                                  if ( TopCardColor.equals("RED") || TopCardColor.equals("YELLOW") || TopCardColor.equals("GREEN") || TopCardColor.equals("BLUE") ) {
                                                                        ColorError = false;
                                                                        System.out.println("New color for next round is " + TopCardColor);
                                                                  }
                                                            }          
                                                      } else if ( Deck.get(randomCard).equals("Wild +4")) {
                                                            boolean ColorError = false;
                                                            for ( int i = 0 ; i != 4 ; i ++ ) {
                                                                  int random = (int) (Math.random() * Deck.size());
                                                                  Player2.add(Deck.get(random));
                                                                  Deck.remove(Deck.get(random));
                                                                  }
                                                            System.out.println("Enter new color for next round");
                                                            TopCardColor = sc.nextLine().trim().toUpperCase();
                                                            if ( !TopCardColor.equals("RED") || !TopCardColor.equals("YELLOW") || !TopCardColor.equals("GREEN") ||  !TopCardColor.equals("BLUE") )
                                                                  ColorError = true;
                                                            while ( ColorError == true ) {
                                                                  System.out.println("Please re-enter , this color doesn't not include in Uno");
                                                                  TopCardColor = sc.nextLine().trim().toUpperCase();
                                                                  if ( TopCardColor.equals("RED") || TopCardColor.equals("YELLOW") || TopCardColor.equals("GREEN") || TopCardColor.equals("BLUE") ) {
                                                                        ColorError = false;
                                                                        System.out.println("New color for next round is : " + TopCardColor);
                                                                  }
                                                            }
                                                      } else if ( Deck.get(randomCard).contains("Skip")) {
                                                            Turns ++ ;
                                                      } else if ( Deck.get(randomCard).contains("+2")) {
                                                            for ( int i = 0 ; i != 2 ; i ++ ) {
                                                                  int random = (int) (Math.random() * Deck.size());
                                                                  Player2.add(Deck.get(random));
                                                                  Deck.remove(Deck.get(random));
                                                            }
                                                      }      
                                                } else if (Response.equals("SKIP")) {
                                                      System.out.println("You decide to skip and save the card for later on");
                                                      UseError = false;
                                                } else {
                                                      System.out.println("Error please only put \"Use\" or \"Skip\" , please re-enter");
                                                      UseError = true;
                                                }          
                                          }
                                          Deck.remove(Deck.get(randomCard));
                                          }
                                    }
                                    System.out.println(" ");
                                    System.out.println(" ");
                                    System.out.println(" ");
                                    if (Player1.size() == 0) {
                                          OneWin = true ;
                                          GameEnd = true ;
                                    }      
                        } else {
                        Turns ++ ;
                        boolean check = false;
                        System.out.println("Player2 is going now");
                        System.out.println("Player2 Deck : " + Player2 );
                        for (String Card : Player2 ) {
                              if (Card.toUpperCase().contains(TopCardColor) || Card.contains("Wild") || ( TopCard.endsWith( Card.substring(Card.length() - 1)) && !Card.contains("+") ) )
                                    check = true;
                              if ( check == true )
                                    break;
                        }
                        if ( check == true ) {
                              System.out.println("Use a Card or Draw Card , Enter \"Use\" if use a card or Enter \"Draw\" if draw a card");
                              String Response = sc.nextLine().trim().toUpperCase();
                              Boolean ResponseError = true;
                              while (ResponseError == true) {
                                    Boolean UseError = true;
                                    while ( UseError == true) {
                                          if (Response.equals("USE")) {
                                                ResponseError = false;
                                                UseError = false;
                                                System.out.println("Pick a card to use in your deck , your currect deck : " + Player2 );
                                                System.out.println("TopCard : " + TopCard );
                                                if ( TopCard.contains("Wild"))
                                                      System.out.println(" You may only use " + TopCardColor.toLowerCase() + " color cards");
                                                Response = sc.nextLine();
                                                Boolean PickError = true;
                                                while ( PickError == true) {
                                                     if( (Player2.contains(Response) && Response.toUpperCase().contains(TopCardColor)) || (Player2.contains("Wild") && Response.equals("Wild")) || (Player2.contains("Wild +4") && Response.equals("Wild +4")) )
                                                            PickError = false;
                                                      for (String Card : Player2 ) {
                                                            if(Card.indexOf(Card.length() - 1) == (TopCard.indexOf(TopCard.length() - 1)) && !Card.contains("+") && Card.equals(Response) )
                                                                  PickError = false;
                                                      }
                                                      if(PickError == false) {
                                                            TopCard = Response;
                                                            Player2.remove(Response);
                                                            if ( TopCard.toUpperCase().contains("RED"))
                                                                  TopCardColor = "RED";
                                                            else if ( TopCardColor.contains("YELLOW"))
                                                                  TopCardColor = "YELLOW";
                                                            else if ( TopCard.toUpperCase().contains("GREEN"))
                                                                  TopCardColor = "GREEN";
                                                            else if ( TopCard.contains("BLUE"))
                                                                  TopCardColor = "BLUE";
                                                            System.out.println("Card used " + Response + ", Your deck have now remains " + Player2);
                                                            if ( Response.equals("Wild")) {
                                                                  boolean ColorError = true;
                                                                  System.out.println("Enter new color for next round");
                                                                  TopCardColor = sc.nextLine().trim().toUpperCase();
                                                                  if ( !TopCardColor.equals("RED") || !TopCardColor.equals("YELLOW") || !TopCardColor.equals("GREEN") || !TopCardColor.equals("BLUE"))
                                                                        ColorError = true;
                                                                  while ( ColorError == true ) {
                                                                        System.out.println("Please re-enter , this color doesn't not include in Uno");
                                                                        TopCardColor = sc.nextLine().trim().toUpperCase();
                                                                        if ( TopCardColor.equals("RED") || TopCardColor.equals("YELLOW") || TopCardColor.equals("GREEN") || TopCardColor.equals("BLUE") ) {
                                                                              ColorError = false;
                                                                              System.out.println("New color for next round is " + TopCardColor);
                                                                        }
                                                                  }    
                                                            } else if ( Response.equals("Wild +4")) {
                                                                  boolean ColorError = false;
                                                                  for ( int i = 0 ; i != 4 ; i ++ ) {
                                                                        int random = (int) (Math.random() * Deck.size());
                                                                        Player1.add(Deck.get(random));
                                                                        Deck.remove(Deck.get(random));
                                                                  }
                                                                  System.out.println("Enter new color for next round");
                                                                  TopCardColor = sc.nextLine().trim().toUpperCase();
                                                                  if ( !TopCardColor.equals("RED") || !TopCardColor.equals("YELLOW") || !TopCardColor.equals("GREEN") ||  !TopCardColor.equals("BLUE") )
                                                                        ColorError = true;
                                                                  while ( ColorError == true ) {
                                                                        System.out.println("Please re-enter , this color doesn't not include in Uno");
                                                                        TopCardColor = sc.nextLine().trim().toUpperCase();
                                                                        if ( TopCardColor.equals("RED") || TopCardColor.equals("YELLOW") || TopCardColor.equals("GREEN") || TopCardColor.equals("BLUE") ) {
                                                                              ColorError = false;
                                                                              System.out.println("New color for next round is : " + TopCardColor);
                                                                        }
                                                                  }
                                                            } else if ( Response.contains("Skip")) {
                                                                  Turns ++ ;
                                                            } else if ( Response.contains("+2")) {
                                                                  for ( int i = 0 ; i != 2 ; i ++ ) {
                                                                        int random = (int) (Math.random() * Deck.size());
                                                                        Player1.add(Deck.get(random));
                                                                        Deck.remove(Deck.get(random));
                                                                  }
                                                            }
                                                      } else if (PickError = true) {
                                                            System.out.println("You may not use this card under this circumstances , please re-enter");
                                                            Response = sc.nextLine();
                                                      }
                                                }
                                          } else if (Response.equals("DRAW")) {
                                                ResponseError = false;
                                                UseError = false;
                                                System.out.println("You decide to draw a card , Systen warp to Draw");
                                                int random = (int) (Math.random() * Deck.size());
                                                Player2.add(Deck.get(random));
                                                System.out.println("Card Drew : " + Deck.get(random));
                                                Deck.remove(Deck.get(random));
                                                System.out.println("Your updated deck, Player2 Deck : " + Player2 );
                                          } else {
                                                ResponseError = true;
                                                System.out.println("Error please enter \"Use\" or \"Draw\"");
                                                Response = sc.nextLine().toUpperCase();
                                          }
                                    }
                              }
                        } else {
                              System.out.println("You have no cards to use , Systen automatic warp to Draw");
                              int randomCard = (int) (Math.random() * Deck.size());
                              Player2.add(Deck.get(randomCard));
                              System.out.println("Card Drew : " + Deck.get(randomCard));
                              System.out.println("Your updated deck, Player2 Deck : " + Player2 );
                              for (String Card : Player2 ) {
                                    if (Card.toUpperCase().contains(TopCardColor) || Card.contains("Wild") || ( TopCard.endsWith( Card.substring(Card.length() - 1)) && !Card.contains("+") ) )
                                          check = true;
                                    if ( check == true )
                                          break;
                              }
                              if (check == true) {
                                    System.out.println("Option available to use drawn card immediately , Enter \"Use\" if use or \"Skip\" to skip ");
                                    String Response = sc.nextLine().trim().toUpperCase();
                                    Boolean UseError = true;
                                    while ( UseError == true) {
                                          if (Response.equals("USE")) {
                                                UseError = false;
                                                TopCard = Deck.get(randomCard);
                                                Player2.remove(Deck.get(randomCard));
                                                if ( TopCard.toUpperCase().contains("RED"))
                                                      TopCardColor = "RED";
                                                else if ( TopCardColor.contains("YELLOW"))
                                                      TopCardColor = "YELLOW";
                                                else if ( TopCard.toUpperCase().contains("GREEN"))
                                                      TopCardColor = "GREEN";
                                                else if ( TopCard.contains("BLUE"))
                                                      TopCardColor = "BLUE";
                                                System.out.println("Card used " + Deck.get(randomCard) + ", Your deck have now remains " + Player2);
                                                if ( Deck.get(randomCard).equals("Wild")) {
                                                      boolean ColorError = true;
                                                      System.out.println("Enter new color for next round");
                                                      TopCardColor = sc.nextLine().trim().toUpperCase();
                                                      if ( !TopCardColor.equals("RED") || !TopCardColor.equals("YELLOW") || !TopCardColor.equals("GREEN") || !TopCardColor.equals("BLUE"))
                                                            ColorError = true;
                                                      while ( ColorError == true ) {
                                                      System.out.println("Please re-enter , this color doesn't not include in Uno");
                                                      TopCardColor = sc.nextLine().trim().toUpperCase();
                                                      if ( TopCardColor.equals("RED") || TopCardColor.equals("YELLOW") || TopCardColor.equals("GREEN") || TopCardColor.equals("BLUE") ) {
                                                            ColorError = false;
                                                            System.out.println("New color for next round is " + TopCardColor);
                                                      }
                                                      }    
                                                }      
                                                else if ( Deck.get(randomCard).equals("Wild +4")) {
                                                      boolean ColorError = false;
                                                      for ( int i = 0 ; i != 4 ; i ++ ) {
                                                            int random = (int) (Math.random() * Deck.size());
                                                            Player1.add(Deck.get(random));
                                                                  Deck.remove(Deck.get(random));
                                                            }
                                                      System.out.println("Enter new color for next round");
                                                      TopCardColor = sc.nextLine().trim().toUpperCase();
                                                      if ( !TopCardColor.equals("RED") || !TopCardColor.equals("YELLOW") || !TopCardColor.equals("GREEN") ||  !TopCardColor.equals("BLUE") )
                                                            ColorError = true;
                                                     while ( ColorError == true ) {
                                                            System.out.println("Please re-enter , this color doesn't not include in Uno");
                                                            TopCardColor = sc.nextLine().trim().toUpperCase();
                                                            if ( TopCardColor.equals("RED") || TopCardColor.equals("YELLOW") || TopCardColor.equals("GREEN") || TopCardColor.equals("BLUE") ) {
                                                                  ColorError = false;
                                                                  System.out.println("New color for next round is : " + TopCardColor);
                                                            }
                                                      }
                                                } else if ( Deck.get(randomCard).contains("Skip")) {
                                                      Turns ++ ;
                                                } else if ( Deck.get(randomCard).contains("+2")) {
                                                      for ( int i = 0 ; i != 2 ; i ++ ) {
                                                      int random = (int) (Math.random() * Deck.size());
                                                      Player1.add(Deck.get(random));
                                                      Deck.remove(Deck.get(random));
                                                      }
                                                }
                                          } else if (Response.equals("SKIP")) {
                                                System.out.println("You decide to skip and save the card for later on");
                                                UseError = false;
                                          }
                                          else {
                                                System.out.println("Error please only put \"Use\" or \"Skip\" , please re-enter");
                                                UseError = true;
                                          }          
                                    }
                                    Deck.remove(Deck.get(randomCard));
                              }
                        }
                        System.out.println(" ");
                        System.out.println(" ");
                        System.out.println(" ");
                        if (Player2.size() == 0) {
                              TwoWin = true ;
                              GameEnd = true ;

                        }
                  }
            }
      }
                  
      else if (Mode.equals("AI")) {
          String TopCard = "" ;
          boolean TrueCard = false;
          for (int random = (int) (Math.random() * Deck.size()) ; TrueCard == false ; random = (int) (Math.random() * Deck.size())){
                if ( Deck.get(random).contains("Wild") || Deck.get(random).contains("Skip") || Deck.get(random).contains("+2"))
                      TrueCard = false ;
                else {
                      System.out.println("Starting card : " + Deck.get(random));
                TopCard = Deck.get(random);
                Deck.remove(TopCard);
                TrueCard = true ;
                }
          }
          int Turns = (int) (Math.random() * 2) + 1;
          String TopCardColor = "";
          while ( GameEnd == false ){
                if (TopCard.contains("Red"))
                      TopCardColor = "RED";
                else if (TopCard.contains("Yellow"))
                      TopCardColor = "YELLOW";
                else if (TopCard.contains("Green"))
                        TopCardColor = "GREEN";
                else if (TopCard.contains("Blue"))
                        TopCardColor = "BLUE";
                if (Turns % 2 == 1) {
                      Turns ++ ;
                      boolean check = false;
                      System.out.println("Player1 is going now");
                      System.out.println("Player1 Deck : " + Player1 );
                      for (String Card : Player1 ) {
                            if (Card.toUpperCase().contains(TopCardColor) || Card.contains("Wild") || ( TopCard.endsWith( Card.substring(Card.length() - 1)) && !Card.contains("+") ) )
                                  check = true;
                            if ( check == true )
                                  break;
                      }
                      if ( check == true ) {
                            System.out.println("Use a Card or Draw Card , Enter \"Use\" if use a card or Enter \"Draw\" if draw a card");
                            String Response = sc.nextLine().trim().toUpperCase();
                            Boolean ResponseError = true;
                            while (ResponseError == true) {
                                  Boolean UseError = true;
                                  while ( UseError == true) {
                                        if (Response.equals("USE")) {
                                              ResponseError = false;
                                              UseError = false;
                                              System.out.println("Pick a card to use in your deck , your currect deck : " + Player1 );
                                              System.out.println("TopCard : " + TopCard );
                                              if ( TopCard.contains("Wild"))
                                                    System.out.println(" You may only use " + TopCardColor.toLowerCase() + " color cards");
                                              Response = sc.nextLine();
                                              Boolean PickError = true;
                                              while ( PickError == true) {
                                                    if( (Player1.contains(Response) && Response.toUpperCase().contains(TopCardColor)) || (Player1.contains("Wild") && Response.equals("Wild")) || (Player1.contains("Wild +4") && Response.equals("Wild +4")) )
                                                          PickError = false;
                                                    for (String Card : Player1 ) {
                                                          if(Card.indexOf(Card.length() - 1) == (TopCard.indexOf(TopCard.length() - 1)) && !Card.contains("+") && Card.equals(Response) )
                                                                PickError = false;
                                                    }
                                                    if(PickError == false) {
                                                          TopCard = Response;
                                                          Player1.remove(Response);
                                                          if ( TopCard.toUpperCase().contains("RED"))
                                                                TopCardColor = "RED";
                                                          else if ( TopCardColor.contains("YELLOW"))
                                                                TopCardColor = "YELLOW";
                                                          else if ( TopCard.toUpperCase().contains("GREEN"))
                                                                TopCardColor = "GREEN";
                                                          else if ( TopCard.contains("BLUE"))
                                                                TopCardColor = "BLUE";
                                                          System.out.println("Card used " + Response + ", Your deck have now remains " + Player1);
                                                          if ( Response.equals("Wild")) {
                                                                boolean ColorError = false;
                                                                System.out.println("Enter new color for next round");
                                                                TopCardColor = sc.nextLine().trim().toUpperCase();
                                                                if ( !TopCardColor.equals("RED") || !TopCardColor.equals("YELLOW") || !TopCardColor.equals("GREEN") || !TopCardColor.equals("BLUE"))
                                                                      ColorError = true;
                                                                while ( ColorError == true ) {
                                                                      System.out.println("Please re-enter , this color doesn't not include in Uno");
                                                                      TopCardColor = sc.nextLine().trim().toUpperCase();
                                                                      if ( TopCardColor.equals("RED") || TopCardColor.equals("YELLOW") || TopCardColor.equals("GREEN") || TopCardColor.equals("BLUE") ) {
                                                                            ColorError = false;
                                                                            System.out.println("New color for next round is " + TopCardColor);
                                                                      }
                                                                }    
                                                          } else if ( Response.equals("Wild +4")) {
                                                                boolean ColorError = false;
                                                                for ( int i = 0 ; i != 4 ; i ++ ) {
                                                                      int random = (int) (Math.random() * Deck.size());
                                                                      Player2.add(Deck.get(random));
                                                                      Deck.remove(Deck.get(random));
                                                                }
                                                                System.out.println("Enter new color for next round");
                                                                TopCardColor = sc.nextLine().trim().toUpperCase();
                                                                if ( !TopCardColor.equals("RED") || !TopCardColor.equals("YELLOW") || !TopCardColor.equals("GREEN") || !TopCardColor.equals("BLUE") )
                                                                      ColorError = true;
                                                                while ( ColorError == true ) {
                                                                      System.out.println("Please re-enter , this color doesn't not include in Uno");      
                                                                      TopCardColor = sc.nextLine().trim().toUpperCase();
                                                                      if ( TopCardColor.equals("RED") || TopCardColor.equals("YELLOW") || TopCardColor.equals("GREEN") || TopCardColor.equals("BLUE") ) {
                                                                            ColorError = false;
                                                                            System.out.println("New color for next round is : " + TopCardColor);
                                                                      }
                                                                }
                                                          } else if ( Response.contains("Skip")) {
                                                                Turns ++ ;
                                                          } else if ( Response.contains("+2")) {
                                                                for ( int i = 0 ; i != 2 ; i ++ ) {
                                                                      int random = (int) (Math.random() * Deck.size());
                                                                      Player2.add(Deck.get(random));
                                                                      Deck.remove(Deck.get(random));
                                                                }
                                                          }
                                                    } else if (PickError = true) {
                                                    System.out.println("You may not use this card under this circumstances , please re-enter");
                                                    Response = sc.nextLine();
                                                    }
                                              }
                                        } else if (Response.equals("DRAW")) {
                                              ResponseError = false;
                                              UseError = false;
                                              System.out.println("You decide to draw a card , Systen warp to Draw");
                                              int random = (int) (Math.random() * Deck.size());
                                              Player1.add(Deck.get(random));
                                              System.out.println("Card Drew : " + Deck.get(random));
                                              Deck.remove(Deck.get(random));
                                              System.out.println("Your updated deck, Player1 Deck : " + Player1 );
                                        } else {
                                              ResponseError = true;
                                              System.out.println("Error please enter \"Use\" or \"Draw\"");
                                              Response = sc.nextLine().toUpperCase();
                                        }
                                  }
                            }
                      } else {
                            System.out.println("You have no cards to use , Systen automatic warp to Draw");
                            int randomCard = (int) (Math.random() * Deck.size());
                            Player1.add(Deck.get(randomCard));
                            System.out.println("Card Drew : " + Deck.get(randomCard));
                            System.out.println("Your updated deck, Player1 Deck : " + Player1 );
                            for (String Card : Player1 ) {
                                  if (Card.toUpperCase().contains(TopCardColor) || Card.contains("Wild") || ( TopCard.endsWith( Card.substring(Card.length() - 1)) && !Card.contains("+") ) )
                                        check = true;
                                  if ( check == true )
                                        break;
                            }
                            if (check == true) {
                                  System.out.println("Option available to use drawn card immediately , Enter \"Use\" if use or \"Skip\" to skip ");
                                  String Response = sc.nextLine().trim().toUpperCase();
                                  boolean UseError = true;
                                  while ( UseError == true) {
                                        if (Response.equals("USE")) {
                                              UseError = false;
                                              TopCard = Deck.get(randomCard);
                                              Player1.remove(Deck.get(randomCard));
                                              if ( TopCard.toUpperCase().contains("RED"))
                                                    TopCardColor = "RED";
                                              else if ( TopCardColor.contains("YELLOW"))
                                                    TopCardColor = "YELLOW";
                                              else if ( TopCard.toUpperCase().contains("GREEN"))
                                                    TopCardColor = "GREEN";
                                              else if ( TopCard.contains("BLUE"))
                                                    TopCardColor = "BLUE";
                                              System.out.println("Card used " + Deck.get(randomCard) + ", Your deck have now remains " + Player1);
                                              if ( Deck.get(randomCard).equals("Wild")) {
                                                    boolean ColorError = true;
                                                    System.out.println("Enter new color for next round");
                                                    TopCardColor = sc.nextLine().trim().toUpperCase();
                                                    if ( !TopCardColor.equals("RED") || !TopCardColor.equals("YELLOW") || !TopCardColor.equals("GREEN") || !TopCardColor.equals("BLUE"))
                                                          ColorError = true;
                                                    while ( ColorError == true ) {
                                                    System.out.println("Please re-enter , this color doesn't not include in Uno");
                                                    TopCardColor = sc.nextLine().trim().toUpperCase();
                                                          if ( TopCardColor.equals("RED") || TopCardColor.equals("YELLOW") || TopCardColor.equals("GREEN") || TopCardColor.equals("BLUE") ) {
                                                                ColorError = false;
                                                                System.out.println("New color for next round is " + TopCardColor);
                                                          }
                                                    }          
                                              } else if ( Deck.get(randomCard).equals("Wild +4")) {
                                                    boolean ColorError = false;
                                                    for ( int i = 0 ; i != 4 ; i ++ ) {
                                                          int random = (int) (Math.random() * Deck.size());
                                                          Player2.add(Deck.get(random));
                                                          Deck.remove(Deck.get(random));
                                                          }
                                                    System.out.println("Enter new color for next round");
                                                    TopCardColor = sc.nextLine().trim().toUpperCase();
                                                    if ( !TopCardColor.equals("RED") || !TopCardColor.equals("YELLOW") || !TopCardColor.equals("GREEN") ||  !TopCardColor.equals("BLUE") )
                                                          ColorError = true;
                                                    while ( ColorError == true ) {
                                                          System.out.println("Please re-enter , this color doesn't not include in Uno");
                                                          TopCardColor = sc.nextLine().trim().toUpperCase();
                                                          if ( TopCardColor.equals("RED") || TopCardColor.equals("YELLOW") || TopCardColor.equals("GREEN") || TopCardColor.equals("BLUE") ) {
                                                                ColorError = false;
                                                                System.out.println("New color for next round is : " + TopCardColor);
                                                          }
                                                    }
                                              } else if ( Deck.get(randomCard).contains("Skip")) {
                                                    Turns ++ ;
                                              } else if ( Deck.get(randomCard).contains("+2")) {
                                                    for ( int i = 0 ; i != 2 ; i ++ ) {
                                                          int random = (int) (Math.random() * Deck.size());
                                                          Player2.add(Deck.get(random));
                                                          Deck.remove(Deck.get(random));
                                                    }
                                              }      
                                        } else if (Response.equals("SKIP")) {
                                              System.out.println("You decide to skip and save the card for later on");
                                              UseError = false;
                                        } else {
                                              System.out.println("Error please only put \"Use\" or \"Skip\" , please re-enter");
                                              UseError = true;
                                        }          
                                  }
                                  Deck.remove(Deck.get(randomCard));
                                  }
                            }
                            System.out.println(" ");
                            System.out.println(" ");
                            System.out.println(" ");
                            if (Player1.size() == 0) {
                                  OneWin = true ;
                                  GameEnd = true ;
                            }      
                } else {
                    Turns ++ ;
                    boolean check = false;
                    for (String Card : Player2 ) {
                          if (Card.toUpperCase().contains(TopCardColor) || Card.contains("Wild") || ( TopCard.endsWith( Card.substring(Card.length() - 1)) && !Card.contains("+") ) )
                                check = true;
                          if ( check == true )
                                break;
                    }
                    if (check == true) {
                    	for (String Card : Player2 ) {
                            if (Card.toUpperCase().contains(TopCardColor) || Card.contains("Wild") || ( TopCard.endsWith( Card.substring(Card.length() - 1)) && !Card.contains("+") ) ) {
                                  TopCard = Card;
                                  Player2.remove(Card);
                                  break;
                            }
                    	}
                    	System.out.println("AI used " + TopCard);
                                                        if ( TopCard.toUpperCase().contains("RED"))
                                                              TopCardColor = "RED";
                                                        else if ( TopCardColor.contains("YELLOW"))
                                                              TopCardColor = "YELLOW";
                                                        else if ( TopCard.toUpperCase().contains("GREEN"))
                                                              TopCardColor = "GREEN";
                                                        else if ( TopCard.contains("BLUE"))
                                                              TopCardColor = "BLUE";
                                                        if ( TopCard.equals("Wild")) {
                                                            int random = (int) (Math.random() * 4) + 1;
                                                            if ( random == 1)
                                                               TopCardColor = "RED";
                                                            else if ( random == 2)
                                                               TopCardColor = "YELLOW";
                                                            else if ( random == 3)
                                                               TopCardColor = "GREEN";
                                                            else if ( random == 4)
                                                               TopCardColor = "BLUE";
                                                            System.out.println("AI Picked Color :" + TopCardColor.toLowerCase());
                                                            System.out.println("New color for next round is " + TopCardColor);
                                                      }else if ( TopCard.equals("Wild +4")) {
                                                    	  for ( int i = 0 ; i != 4 ; i ++ ) {
                                                    		  int random = (int) (Math.random() * Deck.size());
                                                    		  Player1.add(Deck.get(random));
                                                    		  Deck.remove(Deck.get(random));
                                                          }
                                                    	  int random = (int) (Math.random() * 4) + 1;
                                                          if ( random == 1)
                                                        	  TopCardColor = "RED";
                                                          else if ( random == 2)
                                                              TopCardColor = "YELLOW";
                                                          else if ( random == 3)
                                                              TopCardColor = "GREEN";
                                                          else if ( random == 4)
                                                              TopCardColor = "BLUE";
                                                          System.out.println("AI added 4 cards to your deck and the new picked color is :" + TopCardColor.toLowerCase());
                                                      } else if ( TopCard.contains("Skip")) {
                                                          Turns ++ ;
                                                          System.out.println("AI Skipped You!");
                                                      } else if ( TopCard.contains("+2")) {
                                                          for ( int i = 0 ; i != 2 ; i ++ ) {
                                                        	  int random = (int) (Math.random() * Deck.size());
                                                              Player1.add(Deck.get(random));
                                                              Deck.remove(Deck.get(random));
                                                          }
                                                          System.out.println("AI added 2 Cards to your deck!");
                                                      }
                } else {
                	System.out.println("AI is out of cards and drew a card");
                      int randomCard = (int) (Math.random() * Deck.size());
                      Player2.add(Deck.get(randomCard));
                      for (String Card : Player2 ) {
                            if (Card.toUpperCase().contains(TopCardColor) || Card.contains("Wild") || ( TopCard.endsWith( Card.substring(Card.length() - 1)) && !Card.contains("+") ) ) {
                                  TopCard = Card;
                                  break;
                      		}	
                      }
                      if (check == true) {
                    	  System.out.println("AI is able to use their draw card to the round");
                    	  System.out.println("AI used " + TopCard);
                                        TopCard = Deck.get(randomCard);
                                        Player2.remove(Deck.get(randomCard));
                                        if ( TopCard.toUpperCase().contains("RED"))
                                              TopCardColor = "RED";
                                        else if ( TopCardColor.contains("YELLOW"))
                                              TopCardColor = "YELLOW";
                                        else if ( TopCard.toUpperCase().contains("GREEN"))
                                              TopCardColor = "GREEN";
                                        else if ( TopCard.contains("BLUE"))
                                              TopCardColor = "BLUE";
                                        if ( TopCard.equals("Wild")) {
                                        	int random = (int) (Math.random() * 4) + 1;
                                        	if ( random == 1)
                                              TopCardColor = "RED";
                                        	else if ( random == 2)
                                                TopCardColor = "YELLOW";
                                        	else if ( random == 3)
                                                TopCardColor = "GREEN";
                                        	else if ( random == 4)
                                                TopCardColor = "BLUE";
                                        	System.out.println("New color for next round is " + TopCardColor);
                                        }          
                                        else if (TopCard.equals("Wild +4")) {
                                        	for ( int i = 0 ; i != 4 ; i ++ ) {
                                                int random = (int) (Math.random() * Deck.size());
                                                Player1.add(Deck.get(random));
                                                Deck.remove(Deck.get(random));
                                        	}
                                        	int random = (int) (Math.random() * 4) + 1;
                                      		if ( random == 1)
                                      		  TopCardColor = "RED";
                                      		else if ( random == 2)
                                              TopCardColor = "YELLOW";
                                      		else if ( random == 3)
                                              TopCardColor = "GREEN";
                                      		else if ( random == 4)
                                              TopCardColor = "BLUE";
                                      		System.out.println("AI added 4 cards to your deck and the new picked color :" + TopCardColor.toLowerCase());
                                        } else if ( TopCard.contains("Skip")) {
                                              Turns ++ ;
                                              System.out.println("AI Skipped You!");
                                        } else if ( TopCard.contains("+2")) {
                                              for ( int i = 0 ; i != 2 ; i ++ ) {
                                              int random = (int) (Math.random() * Deck.size());
                                              Player1.add(Deck.get(random));
                                              Deck.remove(Deck.get(random));
                                              }
                                              System.out.println("AI added 2 Cards to your deck!");
                                        }          
                            	  }
                		}
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                    if (Player2.size() == 0) {
                          TwoWin = true ;
                          GameEnd = true ;
                    }
         }
    }
}
      if ( OneWin == true ) {
    	  	for ( String Card : Player2 ) {
    	  		Player1Score ++;
    	  	}
            System.out.println("Player1 won! your current score is " + Player1Score );
            System.out.println("Type \"Replay\" if re-play or \"Exit\" if exit game");
            String Response = sc.nextLine().trim().toUpperCase();
            boolean ResponseError = true;
            while (ResponseError == true) {
            	if (Response.equals("REPLAY")) {
                    Replay = true;
                    ResponseError = false ;
            		}
            		else if (Response.equals("EXIT")) {
                    Replay = false;
                    ResponseError = false;
            		}
            		else {
                        System.out.println("Error please re-enter replay or exit only");
                        Response = sc.nextLine().trim().toUpperCase();
                  }
            }
      }
      else if ( TwoWin == true ) {
    	  for ( String Card : Player1 ) {
  	  		Player1Score ++;
    	  }
          System.out.println("Player2 won! your current score is " + Player1Score );
          System.out.println("Type \"Replay\" if re-play or \"Exit\" if exit game");
          String Response = sc.nextLine().trim().toUpperCase();
          boolean ResponseError = true;
          while (ResponseError == true) {
        	    if (Response.equals("REPLAY")) {
        	    	Replay = true;
                    ResponseError = false ;
                    }
                else if (Response.equals("EXIT")) {
                    Replay = false;
                    ResponseError = false;
                }
                    else {
                    System.out.println("Error please re-enter replay or exit only");
                    Response = sc.nextLine().trim().toUpperCase();
                    }
          }
       }
   }
}
}