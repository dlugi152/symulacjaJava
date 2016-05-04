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
public class Mlecz extends Roslina{
    public Mlecz()
	{
		nazwa = "Mlecz";
		sila = 0;
		znak = 'M';
                kolor=Color.YELLOW;
	}
    public void akcja()
	{
		for (int i = 0; i < 3; i++)
			mnoz();
	}
}
