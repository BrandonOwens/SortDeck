import java.util.Scanner;
public class Deck
{
    public static int a[]= new int[13];
    
    public static final String[] RANKS = {
        null, "Ace", "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "Jack", "Queen", "King"};

    public static final String[] SUITS = {
        "Clubs", "Diamonds", "Hearts", "Spades"};

    public final int rank=0;

    public final int suit=0;
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
    }
   