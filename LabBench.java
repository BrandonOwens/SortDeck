import java.util.Scanner;  
public class LabBench
{
    public static void main(String[]args)
    {
      Card[] cards = makeDeck();
      Card[] sorted = makeDeck();
      Object[] newDeck = new Object[53];
       for(int loop=0;loop<=12;loop++)
      {
         System.out.println(cards[loop]+", "+cards[13+loop]+", "+cards[26+loop]+", "+cards[39+loop]);
      }
      System.out.println("The deck before shuffling.");
      System.out.print("How times do you want a deck shuffled"+"\n");
      Scanner sc=new Scanner(System.in);  
      int Choice=sc.nextInt();
      Shuffle(cards,Choice);
      System.out.println("The deck after the last shuffling.");
      for(int loop=0;loop<=12;loop++)
      {
         System.out.println(cards[loop]+", "+cards[13+loop]+", "+cards[26+loop]+", "+cards[39+loop]);
      }
      newDeck =Arrange(cards);
      System.out.println("The deck after being sorted.");
        for(int loop=1;loop<=12;loop++)
      {
         System.out.println(newDeck[loop]+", "+newDeck[13+loop]+", "+newDeck[26+loop]+", "+newDeck[39+loop]);
      }
      System.out.println("Now sorting a sorted deck.");
      newDeck =Arrange(sorted);
        for(int loop=1;loop<=12;loop++)
      {
         System.out.println(newDeck[loop]+", "+newDeck[13+loop]+", "+newDeck[26+loop]+", "+newDeck[39+loop]);
      }
      System.out.print("This algorithm will make 52 swaps to a 52 card deck each time.\n");
    }
    
     /*
      * This method generates a deck of 52 cards
      */
     public static Card[] makeDeck() {
       Card[] cards = new Card[52];
       int index = 0;
       for(int suit = 0; suit <= 3; suit++) 
       {
            for(int rank = 1; rank <= 13; rank++) 
            {
                cards[index] = new Card(rank, suit);
                index++;
            }
       }
       return cards;
    }
    
        /*
        * This Method takes a deck created in the make deck method and will shuffle 
        * 10000 random selected cards from their position to another 
        * Then it will repeat that process how ever many times the user chooses
        */
    public static Object[] Shuffle (Card[] cards,int Choice) 
    {
       Card[] Hand=new Card[1];
       Hand[0]=cards[0];
       int PlaceHold=0;
       int place=0;
       int NumberofIterations=10000;   
       for(int cycle=1;cycle<=Choice;cycle++)
       {  
          for(int Shuffles=1;Shuffles<=NumberofIterations;Shuffles++)
          {
            int random = (int)(Math.random() * 51+1);
            cards[place]=cards[random];
            place=random;
            if(Shuffles==NumberofIterations)
            {
              cards[random]=Hand[0];
            }            
           }             
              }   
       return cards;
    }
    
    /* 
     * This method will recieve a deck of 52 cards
     * Then search every card for the next cromatical card and put it in a new array
     * then return a sorted deck
     */
    public static Object[] Arrange(Card[] cards){        
        Object[] newDeck = new Object[53];
        Card[] temp = new Card[1];
        int place =1;
        for(int suit=0;suit<4;suit++)
        {
            for(int value=1;value<=13;value++)
            {             
                 temp[0]= new Card(value, suit);        
                 for(int search = 0; search<=51;search++)
                 {
                     boolean equals =(temp[0].equals(cards[search]));
                     if (equals==true)
                     {
                         newDeck[place]=cards[search];
                         place++;                       
                    }                    
                  }               
            }
        }    
        System.out.print("The number of swaps was "+(place-1)+"\n");
        return newDeck;
    }
  }
