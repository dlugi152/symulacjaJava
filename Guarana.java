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
public class Guarana extends Roslina{
    public Guarana()
	{
		nazwa = "Guarana";
		sila = 0;
		znak = 'G';
                kolor=Color.MAGENTA;
	}
    public boolean kolizjaobrona(Organizm a)
	{
		a.zwiekszsile();
		if (sila > a.zwrocsile())
			return true;
		return false;
	}
}
