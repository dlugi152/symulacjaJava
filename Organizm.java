/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulacjaswiata;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
/**
 *
 * @author tomasz
 */

public abstract class Organizm implements Animal{
    protected int sila, inicjatywa, wiek;
    protected int polozeniex, polozeniey;
    protected int potomek;
    protected char znak;
    protected boolean martwy;
    protected String nazwa;
    protected Int ruch_czlowieka;
    protected Swiat swiat;
    protected List<Organizm> organizmy = new ArrayList();
    protected List<Int> usuniecie = new ArrayList();
    protected List<String> raporty = new ArrayList();
    protected int raport;
    protected Color kolor;
    
    public Random r = new Random();
    public Color getKolor() 
    {
        return kolor;
    }
    public Organizm()
    {
	martwy = false;
	potomek = 0;
	wiek = 0;
    }
    public void dodajlat()
    {
	wiek++;
    }
    public int zwrocinicjatywe()
    {
	return inicjatywa;
    }
    public void skopiuj_wszystko(List<Organizm> organizmy2, List<Int> usuniecie2, Int ruch_czlowieka2,List<String> raporty2)
    {
        organizmy = organizmy2;
        ruch_czlowieka=ruch_czlowieka2;
	usuniecie = usuniecie2;
        raporty=raporty2;
    }
    public void ile_raportow(List<Organizm> organizmy2, List<Int> usuniecie2,List<String> raporty2)
    {
	usuniecie2 = usuniecie; 
	organizmy2 = organizmy;
        raporty2=raporty;
    }
    public void polozenie(int x, int y)
    {
    	polozeniex = x;
	polozeniey = y;
    }
    public int zwrocwiek()
    {
	return wiek;
    }
    public int zwrocx()
    {
	return polozeniex;
    }
    public int zwrocy()
    {
	return polozeniey;
    }
    public int zwrocsile()
    {
	return sila;
    }
    public String zwrocnazwe()
    {
	return nazwa;
    }
    public char zwrocznak()
    {
	return znak;
    }
    public void ustaw(int wiek2,int sila2,int inicjatywa2)
    {
        wiek=wiek2;
        sila=sila2;
        inicjatywa=inicjatywa2;
    }
    public void ustawpolozenie(int x, int y)
    {
	polozeniex = x;
	polozeniey = y;
    }
    public boolean czymnozyc()
    {
	return (potomek != 0);
    }
    public void niemnoz()
    {
	potomek = 0;
    }
    public void zemzyj()
    {
	martwy = true;
    }
    public void zwiekszsile()
    {
	sila += 3;
    }
    public boolean czyzyje()
    {
	return !martwy;
    }
}
