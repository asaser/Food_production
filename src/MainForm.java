import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.util.ArrayList;
import java.util.Scanner;

public class MainForm {
    private JLabel makaLabel;
    private JLabel wodaLabel;
    private JLabel jajkoLabel;
    private JLabel solLabel;
    private JLabel kapustaLabel;
    private JButton wyjscieButton;
    private JLabel infoLabel;
    private JPanel mainPanel;
    private JPanel skladnikiPanel;
    private JLabel czasLabel;

    public JLabel getCzasLabel() {
        return czasLabel;
    }

    public void setCzasLabel(JLabel czasLabel) {
        this.czasLabel = czasLabel;
    }

    public JLabel getMakaLabel() {
        return makaLabel;

    }

    public void setMakaLabel(JLabel makaLabel) {
        this.makaLabel = makaLabel;
    }

    public JLabel getWodaLabel() {
        return wodaLabel;
    }

    public void setWodaLabel(JLabel wodaLabel) {
        this.wodaLabel = wodaLabel;
    }

    public JLabel getJajkoLabel() {
        return jajkoLabel;
    }

    public void setJajkoLabel(JLabel jajkoLabel) {
        this.jajkoLabel = jajkoLabel;
    }

    public JLabel getSolLabel() {
        return solLabel;
    }

    public void setSolLabel(JLabel solLabel) {
        this.solLabel = solLabel;
    }

    public JLabel getKapustaLabel() {
        return kapustaLabel;
    }

    public void setKapustaLabel(JLabel kapustaLabel) {
        this.kapustaLabel = kapustaLabel;
    }

    public JLabel getInfoLabel() {
        return infoLabel;
    }

    public void setInfoLabel(JLabel infoLabel) {
        this.infoLabel = infoLabel;
    }

    int n, czasPracy;


    public MainForm() {





        Kuchnia kuchnia = new Kuchnia(this);

        Dostawca maka = new Dostawca(kuchnia,"m¹ka");
        Dostawca woda = new Dostawca(kuchnia,"woda");
        Dostawca jajko = new Dostawca(kuchnia,"jajko");
        Dostawca sol = new Dostawca(kuchnia,"sól");
        Dostawca kapusta =  new Dostawca(kuchnia,"kapusta z grzybami");


        ArrayList<Dostawca> listaDostawcow = new ArrayList<>();

        listaDostawcow.add(maka);
        listaDostawcow.add(woda);
        listaDostawcow.add(jajko);
        listaDostawcow.add(sol);
        listaDostawcow.add(kapusta);



        Nadzorca nadzorca = new Nadzorca(kuchnia,listaDostawcow,this);
        Licznik  licznik = new Licznik(this);                          

         n = Integer.parseInt((String) JOptionPane.showInputDialog(null,
                 "Wprowad¿ liczbê zamówieñ:\n",
                 "Produkcja uszek",
                 JOptionPane.PLAIN_MESSAGE,
                 null,
                 null, "1"));

        czasPracy = n*15000 -150;


        nadzorca.start();
        licznik.start();


        wyjscieButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    public static void main(String[] args) throws InterruptedException {

        MainForm mainForm = new MainForm();

        JFrame frame = new JFrame("Produkcja uszek");
        frame.setContentPane(mainForm.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        
        try {
            Thread.sleep(mainForm.czasPracy);
            System.exit(0);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
