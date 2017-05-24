public class Licznik extends Thread {
    int czas;
    MainForm mainForm;

    Licznik(MainForm mainForm)
    {
        this.mainForm = mainForm;
        this.czas = 0;
        setDaemon(true);
    }

    public void run()
    {
        while(true){
            mainForm.getCzasLabel().setText("Czas: " + czas + "s");

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            czas++;
        }
    }
}
