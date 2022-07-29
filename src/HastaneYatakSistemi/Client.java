package HastaneYatakSistemi;

public class Client extends Thread{
    private Integer id;

    public Client(Integer id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Pool instance = Pool.getInstance();
            HastaneYatak Yatak = instance.YatakBul();

            while (Yatak==null){
                Thread.sleep(4500);
                Yatak = instance.YatakBul();
            }
            System.out.println( Yatak.PickerId+". yatak alindi");

            instance.YatakBırak(Yatak);
            System.out.println(Yatak.PickerId + ". yatak birakildi ");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
