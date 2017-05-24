import java.awt.*;
import java.util.Arrays;

public class Kuchnia {
    int spizarnia[];
    boolean praca;
    MainForm mainForm;

    Kuchnia(MainForm mainForm) {

        this.mainForm = mainForm;

        spizarnia = new int[5];

        for (int i = 0; i < 5; i++) {
            spizarnia[i] = 0;
        }
    }

        public  synchronized void dostarcz(String towar)
    {


        if(towar.equals("m¹ka"))
        {
            while(!Arrays.equals(spizarnia,new int[]{0,0,0,0,0}))
            {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            spizarnia[0] = 1;
            System.out.println("Dostarczono i u¿yto towaru: " + towar);
            notifyAll();
        }

        if(towar.equals("woda"))
        {
            while(!Arrays.equals(spizarnia,new int[]{1,0,0,0,0}))
            {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            spizarnia[1] = 1;
            System.out.println("Dostarczono i u¿yto towaru: " + towar);
            notifyAll();
        }

        if(towar.equals("jajko"))
        {
            while(!Arrays.equals(spizarnia,new int[]{1,1,0,0,0}))
            {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            spizarnia[2] = 1;
            System.out.println("Dostarczono i u¿yto towaru: " + towar);
            notifyAll();
        }

        if(towar.equals("sól"))
        {
            while(!Arrays.equals(spizarnia,new int[]{1,1,1,0,0}))
            {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            spizarnia[3] = 1;
            System.out.println("Dostarczono i u¿yto towaru: " + towar);
            notifyAll();
        }

        if(towar.equals("kapusta z grzybami"))
        {
            while(!Arrays.equals(spizarnia,new int[]{1,1,1,1,0}))
            {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            spizarnia[4] = 1;
            System.out.println("Dostarczono i u¿yto towaru: " + towar);
            notifyAll();
        }

        if(Arrays.equals(spizarnia,new int[]{1,1,1,1,1}))
        {

            System.out.println("Kucharze zrealizowali zamówienie.");

            for (int i = 0; i < 5; i++) {
                spizarnia[i] = 0;
            }
        }

        if(spizarnia[0]==0) mainForm.getMakaLabel().setForeground(Color.black);
        else mainForm.getMakaLabel().setForeground(new Color(0,107,0));

        if(spizarnia[1]==0) mainForm.getWodaLabel().setForeground(Color.black);
        else mainForm.getWodaLabel().setForeground(new Color(0,107,0));

        if(spizarnia[2]==0) mainForm.getJajkoLabel().setForeground(Color.black);
        else mainForm.getJajkoLabel().setForeground(new Color(0,107,0));

        if(spizarnia[3]==0) mainForm.getSolLabel().setForeground(Color.black);
        else mainForm.getSolLabel().setForeground(new Color(0,107,0));

        if(spizarnia[4]==0) mainForm.getKapustaLabel().setForeground(Color.black);
        else mainForm.getKapustaLabel().setForeground(new Color(0,107,0));

    }


}

