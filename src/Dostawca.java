public class Dostawca implements Runnable {

    Kuchnia kuchnia;


    Dostawca(Kuchnia kuchnia,String towar)
    {
        this.kuchnia = kuchnia;
        this.towar = towar;
    }

    String towar;
    @Override
    public void run() {

            kuchnia.dostarcz(towar);


    }
}
