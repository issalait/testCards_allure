package util;

public class Card {
    private String cardName;
    private String cardDescription;
    private String priority;


    public Card(String cardName, String cardDescription, String priority){
        this.cardName=cardName;
        this.cardDescription=cardDescription;
        this.priority=priority;
    }

    public String getCardName(){
        return this.cardName;
    }

    public String getCardDescription(){
        return this.cardDescription;
    }

    public String getCardPriority(){
        return this.priority;
    }
}
