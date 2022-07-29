package HastaneYatakSistemi;

public class HastaneYatak
{
    public HastaneYatak(int pickerId)
    {
        PickerId = pickerId;
    }

    public int getPickerId() {
        return PickerId;
    }

    

    public int PickerId;
    public String CurrentLocation;
    public String Carrying;



    public void Drop()
    {
        ShowMessage("Dropped " + Carrying);
        Carrying = null;
    }

    public void ShowMessage(String msg)
    {
        System.out.println("Picker " + PickerId + ":" + msg);
    }
}
