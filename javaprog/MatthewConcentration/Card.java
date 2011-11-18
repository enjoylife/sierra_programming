public class Card
{
    private int cardId;
    private String cardName;
    private int cardValue;
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
