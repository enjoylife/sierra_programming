public class Card
{   
   
    /** Not used */
    private String cardName;
    
    /**used to give a value to the cards in order to decide if their a match */
    private int cardValue;
    
    /** this should be a value between -1 to 3 */
    private int status;

    public Card()
    {
        
        this.status = 1;
    }
    
    public int getValue(){
        return this.cardValue;
    }
    
    public void setValue(int v){
        this.cardValue = v;
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
