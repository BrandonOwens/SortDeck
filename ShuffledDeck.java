import java.util.Scanner;  
public class ShuffledDeck
{
    
    public static int a[]= new int[13];
    
    public static void main(String[]args)
    {
      boolean answer;
      System.out.println("This Program Will Shuffle an Ordered Pack of Cards.");
      System.out.println("The amount of times you choose.");
      
      Card[] cards = makeDeck(); 
      
      for(int loop=0;loop<=12;loop++)
      {
         System.out.println(cards[loop]+", "+cards[13+loop]+", "+cards[26+loop]+", "+cards[39+loop]);
      }
      System.out.println("The deck before shuffling.");
       
      System.out.print("How times do you want a deck shuffled"+"\n");
      Scanner sc=new Scanner(System.in);  
      int Choice=sc.nextInt();
      
      System.out.print("To prove the deck has been shuffled the 7th card in the deck each time was"+"\n");
      Shuffle(cards,Choice);
    }
    public static Card[] makeDeck() {
       /*
        * This method generates a deck of 52 cards
        */
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
       int Seventh = 6;    
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
              ShuffledDeck total = new ShuffledDeck(cards);
              System.out.print(cards[Seventh]+"\n");
            }            
           }             
          if(cycle==Choice)
          {
             System.out.println("The deck after the last shuffling.");
             for(int loop=0;loop<=12;loop++)
             {
              System.out.println(cards[loop]+", "+cards[13+loop]+", "+cards[26+loop]+", "+cards[39+loop]);
             }            
          }
              }   
       return cards;
    }
        public  ShuffledDeck(Card[] cards)
        {
             int Seventh = 6;    
            for(int target =1;target<=13;target++)
            {
               if (cards[Seventh].equals(target))
               { 
                   int t=a[target];
                  a[target]=a[t];  
                  System.out.print(a[target]);
                          
               }
        }
    }
}