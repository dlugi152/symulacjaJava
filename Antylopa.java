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
public class Antylopa extends Zwierze{
    public Antylopa()
	{
		nazwa = "Antylopa";
		sila = 4;
		inicjatywa = 4;
		znak = 'A';
                kolor=Color.ORANGE;
	}
    public void akcja()
	{
		ruszsie();
		ruszsie();
	}
    public boolean kolizjaobrona(Organizm a)
	{
		if (Math.abs(r.nextInt()) % 2!=0)
		{
			ruszsie();
			return true;
		}
		if (sila > a.zwrocsile())
			return true;
		return false;
	}
    public boolean kolizjaatak(Organizm a)
	{
		if (Math.abs(r.nextInt()) % 2!=0)
		{
			ruszsie();
			return true;
		}
		if (a.zwrocnazwe() == "Guarana")
			sila += 3;
		if (sila >= a.zwrocsile())
			return true;
		return false;
	}
}
