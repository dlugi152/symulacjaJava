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
public class Zolw extends Zwierze{
    public Zolw()
	{
		nazwa = "Zolw";
		sila = 2;
		inicjatywa = 1;
		znak = 'Z';
                kolor=Color.LIGHT_GRAY;
	}
    public void akcja()
	{
		if (Math.abs(r.nextInt()) % 4 == 3)
			ruszsie();
	}
    public boolean kolizjaobrona(Organizm a)
	{
		if (a.zwrocsile() < 5)
		{
			a.akcja();
			return true;
		}
		return false;
	}
}
