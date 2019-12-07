public class Register
{
    private int value;
    public Register(int value)
    {
        this.value = value;
    }
    public void setValue(int value) { this.value = value; }
    public int getValue() { return this.value; }
    public void Reset() { this.value = 0; }
}
