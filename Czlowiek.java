/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulacjaswiata;

import java.awt.Color;

/**
 *
 * @author tomasz
 */
public class Czlowiek extends Zwierze{
    //kolor=Color.ORANGE;
    protected boolean calopalenie;
    protected int cooldown;
    public Czlowiek()
    {
        nazwa = "Czlowiek";
        sila = cooldown = 5;
        inicjatywa = 4;
        znak = 'C';
        kolor=Color.BLUE;
        calopalenie=false;
    }
    private void pal_wszystko()
    {
        for (int i = 0; i < organizmy.size(); i++)
            if (Math.abs(organizmy.get(i).zwrocx() - polozeniex) <= 1 && Math.abs(organizmy.get(i).zwrocy() - polozeniey) <= 1 && organizmy.get(i).zwrocnazwe()!=nazwa)
            {
                Int pom= new Int(i);
                usuniecie.add(pom);
                organizmy.get(i).zemzyj();
                raporty.add("Czlowiek \"calopali\" " + organizmy.get(i).zwrocnazwe() + " w polu " + organizmy.get(i).zwrocx() + " " + organizmy.get(i).zwrocy());
            }
	}
    public void ruszsie()
    {
        switch (ruch_czlowieka.get())
        {
            case 0:
                if (polozeniex == 19)
                    break;
                polozenie(polozeniex+1, polozeniey );
                break;
            case 1:
                if (polozeniex == 0)
                    break;
                polozenie(polozeniex-1, polozeniey );
                break;
            case 2:
                if (polozeniey == 19)
                    break;
                polozenie(polozeniex, polozeniey+ 1);
                break;
            case 3:
                if (polozeniey == 0)
                    break;
                polozenie(polozeniex, polozeniey - 1);
                break;
            case -1:
                if (cooldown == 5)
                    calopalenie = true;
                break;
        }
    }
    public void akcja()
    {
        ruszsie();
        if (cooldown == 0)
            calopalenie = false;
        if (calopalenie)
            cooldown--;
        else
            if (cooldown != 5)
                cooldown++;
        if (calopalenie)
            pal_wszystko();
    }
}
