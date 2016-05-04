/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulacjaswiata;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Comparator;
import java.util.Scanner;
/**
 *
 * @author tomasz
 */
public class Swiat {
    protected List<Int> KolejkaOroganizmow = new ArrayList();
    protected List<String> raporty = new ArrayList();
    protected List<Organizm> organizmy = new ArrayList<>();
    Comparator<Int> comp = new PorownywarkaIntow();
    protected List<Int> usuniecie = new ArrayList();
    protected Int ruch_czlowieka;
    protected Int dodawany;
    protected int dodawaniex,dodawaniey;
    protected boolean dodac;
   // JFrame ramka = new JFrame();
    Random r = new Random();
    public void wykonajTure(Int ruch_czlowieka2)
    {
        ruch_czlowieka=ruch_czlowieka2;
	KolejkaOroganizmow.clear();
        if (dodac==true)
        {
            if (dodawany.get() == 0)
                organizmy.add(new Wilk());
            else if (dodawany.get() == 1)
                organizmy.add(new Owca());
            else if (dodawany.get() == 6)
                organizmy.add(new Trawa());
            else if (dodawany.get() == 3)
                organizmy.add(new Guarana());
            else if (dodawany.get() == 5)
                organizmy.add(new Mlecz());
            else if (dodawany.get() == 7)
                organizmy.add(new WilczeJagody());
            else if (dodawany.get() == 4)
                organizmy.add(new Lis());
            else if (dodawany.get() == 8)
                organizmy.add(new Zolw());
            else if (dodawany.get() == 2)
                organizmy.add(new Antylopa());
            organizmy.get(organizmy.size()-1).ustawpolozenie(dodawaniex, dodawaniey);
            dodac=false;
        }
        raporty.clear();
	for (int i = 0; i < organizmy.size(); i++)
        {
            Int pomt = new Int(i);
            KolejkaOroganizmow.add(pomt);
        }
	for (int i = 0; i < KolejkaOroganizmow.size(); i++)
            for (int j = 0; j < KolejkaOroganizmow.size() - i; j++)
		if (porownaj(organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocinicjatywe(), organizmy.get(KolejkaOroganizmow.get(j).get()).zwrocinicjatywe(),
                    organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocwiek(), organizmy.get(KolejkaOroganizmow.get(j).get()).zwrocwiek()))
                    {
                        Int pom=KolejkaOroganizmow.get(i);
                        KolejkaOroganizmow.set(i,KolejkaOroganizmow.get(j));
			KolejkaOroganizmow.set(j,pom);
                    }

	for (int i = 0; i < KolejkaOroganizmow.size(); i++)
	{
            if (organizmy.get(KolejkaOroganizmow.get(i).get()).czyzyje() == false)
                continue;
            organizmy.get(KolejkaOroganizmow.get(i).get()).skopiuj_wszystko(organizmy, usuniecie,ruch_czlowieka,raporty);
            organizmy.get(KolejkaOroganizmow.get(i).get()).akcja();
            organizmy.get(KolejkaOroganizmow.get(i).get()).ile_raportow(organizmy, usuniecie,raporty);
            organizmy.get(KolejkaOroganizmow.get(i).get()).dodajlat();
            if (organizmy.get(KolejkaOroganizmow.get(i).get()).czymnozyc())
            {
                if (organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocnazwe() == "Wilk")
                    organizmy.add(new Wilk());
                else if (organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocnazwe() == "Owca")
                    organizmy.add(new Owca());
                else if (organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocnazwe() == "Trawa")
                    organizmy.add(new Trawa());
                else if (organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocnazwe() == "Guarana")
                    organizmy.add(new Guarana());
                else if (organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocnazwe() == "Mlecz")
                    organizmy.add(new Mlecz());
                else if (organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocnazwe() == "WilczeJagody")
                    organizmy.add(new WilczeJagody());
                else if (organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocnazwe() == "Lis")
                    organizmy.add(new Lis());
                else if (organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocnazwe() == "Zolw")
                    organizmy.add(new Zolw());
                else if (organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocnazwe() == "Antylopa")
                    organizmy.add(new Antylopa());
                
                boolean czyraport = true;
                if (Math.abs(r.nextInt()) % 4 != 0 && organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocx() != 19 && czywolne(organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocx() + 1, organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocy()))
                    organizmy.get(organizmy.size()-1).ustawpolozenie(organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocx() + 1, organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocy());
                else if (Math.abs(r.nextInt()) % 4 != 0 && organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocx() != 0 && czywolne(organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocx() - 1, organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocy()))
                    organizmy.get(organizmy.size()-1).ustawpolozenie(organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocx() - 1, organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocy());
                else if (Math.abs(r.nextInt()) % 4 != 0 && organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocy() != 19 && czywolne(organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocx(), organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocy() + 1))
                    organizmy.get(organizmy.size()-1).ustawpolozenie(organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocx(), organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocy() + 1);
                else if (Math.abs(r.nextInt()) % 4 != 0 && organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocy() != 0 && czywolne(organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocx(), organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocy() - 1))
                    organizmy.get(organizmy.size()-1).ustawpolozenie(organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocx(), organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocy() - 1);
                else
                {
                    organizmy.remove(organizmy.size()-1);
                    czyraport = false;
                }
                if (czyraport==true)
                    raporty.add("Pojawia sie " + organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocnazwe()+ " w polu " + organizmy.get(organizmy.size() - 1).zwrocx() + " " + organizmy.get(organizmy.size() - 1).zwrocy());
                organizmy.get(KolejkaOroganizmow.get(i).get()).niemnoz();
            }
            int pom = czykolizja(KolejkaOroganizmow.get(i).get());
            if (pom != -1)
            {
                if (organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocnazwe() == organizmy.get(pom).zwrocnazwe())
                {
                    if (!organizmy.get(KolejkaOroganizmow.get(i).get()).czymnozyc() && !organizmy.get(pom).czymnozyc())
                        organizmy.get(KolejkaOroganizmow.get(i).get()).mnoz();
                }
                else if (organizmy.get(pom).czyzyje() && organizmy.get(KolejkaOroganizmow.get(i).get()).czyzyje())
                {
                    int pom2 = kolizja(organizmy.get(KolejkaOroganizmow.get(i).get()), organizmy.get(pom));
                    if (pom2 == 1)
                    {
                        raporty.add("zginal " + organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocnazwe()+ " przez " + organizmy.get(pom).zwrocnazwe() + " w polu " + organizmy.get(pom).zwrocx() + " " + organizmy.get(pom).zwrocy());
                        usuniecie.add(KolejkaOroganizmow.get(i));
                        organizmy.get(KolejkaOroganizmow.get(i).get()).zemzyj();
                    }
                    if (pom2 == -1)
                    {
                        raporty.add("zginal " + organizmy.get(pom).zwrocnazwe()+ " przez " + organizmy.get(KolejkaOroganizmow.get(i).get()).zwrocnazwe() + " w polu " + organizmy.get(pom).zwrocx() + " " + organizmy.get(pom).zwrocy());
                        Int pom3 = new Int(pom);
                        usuniecie.add(pom3);
                        organizmy.get(pom).zemzyj();
                    }
                }
            }
        }
        
        usuniecie.sort(comp);
        
	while (usuniecie.size()>0)
	{
            int n = usuniecie.get(usuniecie.size()-1).get();
            organizmy.remove(n);
            usuniecie.remove(usuniecie.size()-1);
	}
    }
    public boolean porownaj(int in1, int in2, int wiek1, int wiek2)
    {
	if (in1 == in2)
            return wiek1 > wiek2;
	return in1 > in2;
    }
    int czykolizja(int n)
    {
        for (int i = 0; i < organizmy.size(); i++)
            if (organizmy.get(i).zwrocx() == organizmy.get(n).zwrocx() && organizmy.get(i).zwrocy() == organizmy.get(n).zwrocy() && i != n)
		return i;
        return -1;
    }
    boolean czywolne(int x, int y)
    {
	for (int i = 0; i < organizmy.size()-1; i++)
            if (organizmy.get(i).zwrocx() == x && organizmy.get(i).zwrocy() == y)
		return false;
	return true;
    }
    int kolizja(Organizm a, Organizm b)
    {
        int wynik1,wynik2;
        if (a.kolizjaatak(b)==true)
            wynik1=1;
        else
            wynik1=0;
        if (b.kolizjaobrona(a)==true)
            wynik2=1;
        else
            wynik2=0;
        
	int pom = wynik1 * 2 + wynik2;
        if (pom == 1)
		return 1;
	if (pom == 2)
		return -1;
	return 0;
    }
    public Organizm naPozycji(int x,int y)
    {
        for (int i = 0; i < organizmy.size()-1; i++)
            if (organizmy.get(i).zwrocx() == x && organizmy.get(i).zwrocy() == y)
		return organizmy.get(i);
	return null;
    }
    public void transfer(int x, int y, Swiat S)
    {
        organizmy.add(S.naPozycji(x, y));
    }
    int stangry()
    {
        if (organizmy.size() == 1 && organizmy.get(0).zwrocnazwe() == "Czlowiek")
            return 1;
	for (int i = 0; i < organizmy.size(); i++)
            if (organizmy.get(i).zwrocnazwe() == "Czlowiek")
                return 0;
	return 2;
    }
    Swiat()
    {
        dodawany=new Int(0);
        dodac=false;
        organizmy.clear();
        organizmy.add(new Czlowiek());
	for (int i = 0; i < 2; i++)
	{
            organizmy.add(new Lis());
            organizmy.add(new Owca());
            organizmy.add(new Wilk());
            organizmy.add(new Zolw());

            organizmy.add(new Antylopa());
            organizmy.add(new Guarana());
            organizmy.add(new Trawa());
            organizmy.add(new Mlecz());
            organizmy.add(new WilczeJagody());
	}
	for (int i = 0; i < organizmy.size(); i++)
	{
            int x, y;
            while (true)
            {
		x = Math.abs(r.nextInt()) % 20;
		y = Math.abs(r.nextInt()) % 20;
		if (!czywolne(x, y))
                    continue;
		break;
            }
            organizmy.get(i).ustawpolozenie(x, y);
	}
    }
    public void zapiszDoPliku() throws FileNotFoundException 
    {
        PrintWriter zapis = new PrintWriter("Zapis.txt");
        zapis.println(organizmy.size());
        for (int i = 0; i < organizmy.size(); i++) 
        {
            zapis.println(organizmy.get(i).zwrocznak() + " "
                    + organizmy.get(i).zwrocwiek() + " "
                    + organizmy.get(i).zwrocsile() + " "
                    + organizmy.get(i).zwrocinicjatywe() + " "
                    + organizmy.get(i).zwrocx() + " "
                    + organizmy.get(i).zwrocy());
        }

        zapis.close();
    }
    public void wczytajzPliku() throws FileNotFoundException 
    {
        organizmy.clear();
        File file = new File("Zapis.txt");
        Scanner in = new Scanner(file);
        int liczba = in.nextInt();
        for (int i = 0; i < liczba; i++) {
            String typ = in.next();
            int wiek = in.nextInt();
            int sila = in.nextInt();
            int inicjatywa = in.nextInt();
            int pozX = in.nextInt();
            int pozY = in.nextInt();
            if (typ.charAt(0)=='W')
                organizmy.add(new Wilk());
            else if (typ.charAt(0)=='O')
                organizmy.add(new Owca());
            else if (typ.charAt(0)=='T')
                organizmy.add(new Trawa());
            else if (typ.charAt(0)=='G')
                organizmy.add(new Guarana());
            else if (typ.charAt(0)=='M')
                organizmy.add(new Mlecz());
            else if (typ.charAt(0)=='J')
                organizmy.add(new WilczeJagody());
            else if (typ.charAt(0)=='L')
                organizmy.add(new Lis());
            else if (typ.charAt(0)=='Z')
                organizmy.add(new Zolw());
            else if (typ.charAt(0)=='A')
                organizmy.add(new Antylopa());
            else if (typ.charAt(0)=='C')
                organizmy.add(new Czlowiek());
            organizmy.get(organizmy.size()-1).ustaw(wiek,sila,inicjatywa);
            organizmy.get(organizmy.size()-1).polozenie(pozX, pozY);
        }
    }
}
