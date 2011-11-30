public class Card
{   
    /** this is used for identification for games where their is no set value, aka concentration */
    private int cardId;
    
    /** Not used */
    private String cardName;
    
    /**used to give a value to the cards in order to decide if their a match */
    private int cardValue;
    
    /** this should be a value between -1 to 3 */
    private int status;

    public Card(int id)
    {
        this.cardId = id;
        this.status = 1;
    }
    
    public int getValue(){
        return this.cardValue;
    }
    
    public void setValue(int v){
        this.cardValue = v;
    }
    
     public int getId(){
        return this.cardId;
    }
    
    public void setId(int id){
        this.cardId = id;
    }
    
    public void setStatus(int s)
    {
        this.status = s;
    }
    
    public int getStatus()
    {
        return this.status;
    }
}
