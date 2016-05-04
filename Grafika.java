/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulacjaswiata;

/**
 *
 * @author tomasz
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

class zlepole extends Exception {
    public zlepole() {
        System.out.println("Niepoprawny");
    }
}

public class Grafika extends JFrame{

    static int Szerokosc_Okienka = 800;
    static int Wysokosc_Okienka = 600;
    Swiat refSwiat;
    int x,y;
    public Grafika(Swiat refS) {
        refSwiat = refS;
        initUi();
    }
    void weryfikacja(int pomx,int pomy) throws zlepole
    {
        if (pomx>=0 && pomx<20 && pomy>=0 && pomy<20 && refSwiat.czywolne(pomx, pomy))
        {
            refSwiat.dodawaniex=pomx;
            refSwiat.dodawaniey=pomy;
            refSwiat.dodac=true;
        }
        else
        {
            refSwiat.dodac=false;
            throw new zlepole();
        }
    }

    private void initUi() {
        /*tworzenie glownej warstwy*/
        JPanel basic = new JPanel();
        basic.setLayout(new BoxLayout(basic, BoxLayout.Y_AXIS));
        add(basic);
        /*tworzenie Planszy*/
        DrawPanel plansza = new DrawPanel();
        basic.add(plansza);
        /*tworzenie warstwy bottom*/
        JPanel co_mnozyc = new JPanel();
        co_mnozyc.setLayout(new FlowLayout(FlowLayout.LEADING));
        co_mnozyc.setFocusable(false);
        JButton wilk = new JButton("Wilk");
        wilk.setFocusable(false);
        wilk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                refSwiat.dodawany=new Int(0);
            }
        });
        JButton owca = new JButton("Owca");
        owca.setFocusable(false);
      //  wilk.setSize(10, 50);
        owca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                refSwiat.dodawany=new Int(1);
            }
        });
        JButton antylopa = new JButton("Antylopa");
        antylopa.setFocusable(false);
        antylopa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                refSwiat.dodawany=new Int(2);
            }
        });
        JButton guarana = new JButton("Guarana");
        guarana.setFocusable(false);
        guarana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                refSwiat.dodawany=new Int(3);
            }
        });
        JButton lis = new JButton("Lis");
        lis.setFocusable(false);
        lis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                refSwiat.dodawany=new Int(4);
            }
        });
        JButton mlecz = new JButton("Mlecz");
        mlecz.setFocusable(false);
        mlecz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                refSwiat.dodawany=new Int(5);
            }
        });
        JButton trawa = new JButton("Trawa");
        trawa.setFocusable(false);
        trawa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                refSwiat.dodawany=new Int(6);
            }
        });
        JButton wilczejagody = new JButton("WilczeJagody");
        wilczejagody.setFocusable(false);
        wilczejagody.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                refSwiat.dodawany=new Int(7);
            }
        });
        JButton zolw = new JButton("Zolw");
        zolw.setFocusable(false);
        zolw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                refSwiat.dodawany=new Int(8);
            }
        });
        JPanel bottom = new JPanel();
        bottom.setAlignmentX(1f);
        bottom.setLayout(new BoxLayout(bottom, BoxLayout.LINE_AXIS));
        /*inicjalizacja przyciskow*/
        JButton close = new JButton("Koniec");
        close.setFocusable(false);
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        JButton Zapisz = new JButton("Zapisz");
        Zapisz.setFocusable(false);
        Zapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    refSwiat.zapiszDoPliku();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Grafika.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        JButton Wczytaj = new JButton("Wczytaj");
        Wczytaj.setFocusable(false);
        Wczytaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    refSwiat.wczytajzPliku();
                    basic.updateUI();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Grafika.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        JButton moc = new JButton("Calopalenie");
        moc.setFocusable(false);
        moc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                plansza.removeAll();
                basic.updateUI();
                refSwiat.wykonajTure(new Int(-1));
                //refSwiat.rysujSwiat();
            }
        });
        KeyListener klawa = new KeyListener()
        {
            public void keyPressed(KeyEvent e) 
            {
                int key = e.getKeyCode();
                //System.out.println("YAYfdsfgsd!");
                if(key == KeyEvent.VK_LEFT)
                {
                    plansza.removeAll();
                    basic.updateUI();
                    refSwiat.wykonajTure(new Int(1));
                }
                else if(key == KeyEvent.VK_RIGHT)
                {
                    plansza.removeAll();
                    basic.updateUI();
                    refSwiat.wykonajTure(new Int(0));
                }
                else if(key == KeyEvent.VK_UP)
                {
                    plansza.removeAll();
                    basic.updateUI();
                    refSwiat.wykonajTure(new Int(3));
                }
                else if(key == KeyEvent.VK_DOWN)
                {
                    plansza.removeAll();
                    basic.updateUI();
                    refSwiat.wykonajTure(new Int(2));
                }
            }
            public void keyReleased(KeyEvent e) 
            { 
            }
            public void keyTyped(KeyEvent e) 
            {
            }
        };
        basic.setFocusable(true);
        basic.addKeyListener(klawa);
        basic.setRequestFocusEnabled(true);
       
        
        
        basic.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
                //System.out.println(":MOUSE_RELEASED_EVENT:");
            }
            @Override
            public void mousePressed(MouseEvent e) {
                //System.out.println("----------------------------------\n:MOUSE_PRESSED_EVENT:");
            }
            @Override
            public void mouseExited(MouseEvent e) {
               // System.out.println(":MOUSE_EXITED_EVENT:");
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                //System.out.println(":MOUSE_ENTER_EVENT:");
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                x=e.getX();
                y=e.getY();
                System.out.print("Wybrano: ");
                switch (refSwiat.dodawany.a)
                {
                    case 0:
                        System.out.print("Wilk");
                        break;
                    case 1:
                        System.out.print("Antylopa");
                        break;
                    case 2:
                        System.out.print("Guarana");
                        break;
                    case 3:
                        System.out.print("Lis");
                        break;
                    case 4:
                        System.out.print("Mlecz");
                        break;
                    case 5:
                        System.out.print("Owca");
                        break;
                    case 6:
                        System.out.print("Trawa");
                        break;
                    case 7:
                        System.out.print("Wilcze Jagody");
                        break;
                    case 8:
                        System.out.print("Zolw");
                        break;
                    case 9:
                }
                int pomx=(x-25)/20;
                int pomy=(y-25)/20;
                System.out.println(pomx+" "+pomy);
                try 
                {
                    weryfikacja(pomx,pomy);
                }
                catch (zlepole w) 
                {
                    System.out.println("Klikniecie w " + x + " " + y);
                }
            }
        });
        bottom.setFocusable(false);
        bottom.add(Zapisz);
        bottom.add(Wczytaj);
        bottom.add(moc);
        bottom.add(close);
        co_mnozyc.add(wilk);
        co_mnozyc.add(antylopa);
        co_mnozyc.add(guarana);
        co_mnozyc.add(lis);
        co_mnozyc.add(mlecz);
        co_mnozyc.add(owca);
        co_mnozyc.add(trawa);
        co_mnozyc.add(wilczejagody);
        co_mnozyc.add(zolw);
        co_mnozyc.setPreferredSize(new Dimension(400, -400));
        basic.add(co_mnozyc);
        basic.add(bottom);

        setTitle("Tomasz Długokiński, Informatyka, Grupa 1");
        setSize(Szerokosc_Okienka, Wysokosc_Okienka);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class DrawPanel extends JPanel {

        private void doDrawing(Graphics g) {

            Graphics2D g2d = (Graphics2D) g;
            for (int x = 0; x < 20; x++)
                for (int y = 0; y < 20; y++){
                        g2d.setColor(Color.red);
                        g2d.drawRect(25 + x * 20, 25 + y * 20, 20, 20);
                        g2d.fillRect(25 + x * 20, 25 + y * 20, 20, 20);
                    }
                    
            for (int i=0;i<refSwiat.organizmy.size();i++)
            {
                g2d.setColor(refSwiat.organizmy.get(i).getKolor());
                g2d.drawRect(25 + refSwiat.organizmy.get(i).zwrocx() * 20, 25 + refSwiat.organizmy.get(i).zwrocy() * 20, 20, 20);
                g2d.fillRect(25 + refSwiat.organizmy.get(i).zwrocx() * 20, 25 + refSwiat.organizmy.get(i).zwrocy() * 20, 20, 20);
            }

            for (int y = 0; y < 10; y++) {
                String NazwaZwierzecia = "0";
                Color kolor = Color.BLACK;
                switch (y) {
                    case 0:
                        NazwaZwierzecia = "Wilk";
                        kolor = Color.BLACK;
                        break;
                    case 1:
                        NazwaZwierzecia = "Owca";
                        kolor = Color.WHITE;
                        break;
                    case 2:
                        NazwaZwierzecia = "Antylopa";
                        kolor = Color.ORANGE;
                        break;
                    case 3:
                        NazwaZwierzecia = "Guarana";
                        kolor = Color.MAGENTA;
                        break;
                    case 4:
                        NazwaZwierzecia = "Lis";
                        kolor = Color.CYAN;
                        break;
                    case 5:
                        NazwaZwierzecia = "Mlecz";
                        kolor = Color.YELLOW;
                        break;
                    case 6:
                        NazwaZwierzecia = "Trawa";
                        kolor = Color.GREEN;
                        break;
                    case 7:
                        NazwaZwierzecia = "WilczeJagody";
                        kolor = Color.PINK;
                        break;
                    case 8:
                        NazwaZwierzecia = "Zolw";
                        kolor = Color.LIGHT_GRAY;
                        break;
                    case 9:
                        NazwaZwierzecia = "Czlowiek";
                        kolor = Color.BLUE;
                        break;
                }
                g2d.setColor(kolor);
                g2d.drawRect(Szerokosc_Okienka - 200, 25 + y * 25, 20, 20);
                g2d.fillRect(Szerokosc_Okienka - 200, 25 + y * 25, 20, 20);
                g2d.setColor(Color.black);
                g2d.drawString(NazwaZwierzecia, Szerokosc_Okienka - 150, 40 + y * 25);
            }
            String pom="Wybrano: ";
                switch (refSwiat.dodawany.get())
                {
                    case 0:
                        pom+="Wilk";
                        break;
                    case 1:
                        pom+="Antylopa";
                        break;
                    case 2:
                        pom+="Guarana";
                        break;
                    case 3:
                        pom+="Lis";
                        break;
                    case 4:
                        pom+="Mlecz";
                        break;
                    case 5:
                        pom+="Owca";
                        break;
                    case 6:
                        pom+="Trawa";
                        break;
                    case 7:
                        pom+="Wilcze Jagody";
                        break;
                    case 8:
                        pom+="Zolw";
                        break;
                    case 9:
                }
            for (int i=0;i<refSwiat.raporty.size();i++)
            {
                g2d.drawString(refSwiat.raporty.get(i), Szerokosc_Okienka - 300, 40 + (i+10) * 25);
            }
            
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            doDrawing(g);
        }
    }

}
