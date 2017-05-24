import java.util.ArrayList;

public class Nadzorca extends Thread {

    MainForm mainForm;
    Kuchnia kuchnia;
    ArrayList<Dostawca> listaDostawcow;
    ArrayList<Thread> listaWatkow;

    int liczbaZlecen, n;
    Nadzorca(Kuchnia kuchnia,ArrayList<Dostawca> listaDostawcow,MainForm mainForm)
    {
        this.mainForm = mainForm;
        this.listaDostawcow = listaDostawcow;
        this.kuchnia = kuchnia;
        this.setDaemon(true);


    }
    public void run()
    {
        int numerWatku=0;
        while (true) {
            System.out.println("Nowe zamówienie!");

            listaWatkow = new ArrayList<>();


            for(Dostawca d : listaDostawcow)
            {
                listaWatkow.add(new Thread(d));
            }
            mainForm.getInfoLabel().setText("Produkowanie uszek");

            for (Thread w : listaWatkow) {
                w.start();
                try {

                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                numerWatku++;
            }

            mainForm.getInfoLabel().setText("Zamówienie skoñczone!");

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            mainForm.getInfoLabel().setText("Oczekiwanie na nowe zamówienie...");

            try {
                sleep(6500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}