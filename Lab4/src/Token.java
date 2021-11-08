public class Token {
    public String Token;
    public Boolean IsEmail;
    public String Reason;
    public int Sentense;
    public Token(String t, Boolean e, String r, int n){
        Token=t;
        Reason=r;
        IsEmail=e;
        Sentense=n;
    }
    @Override
    public String toString() {
        return Token+", "+Reason;
    }
}
