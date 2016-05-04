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
public class Lis extends Zwierze{
    public Lis()
	{
		nazwa = "Lis";
		sila = 3;
		inicjatywa = 7;
		znak = 'L';
                kolor=Color.CYAN;
	}
    public boolean czy_mozna_isc(int x, int y)
	{
		for (int i = 0; i < organizmy.size(); i++)
			if (organizmy.get(i).zwrocx() == x && organizmy.get(i).zwrocy() == y && organizmy.get(i).zwrocsile()> sila)
				return true;
		return false;
	}

    public void ruszsie()
	{
		int petla = 1,ile=0;
		while (petla==1 && ile<10)
                {
                    ile++;
                    switch (Math.abs(r.nextInt()) % 4)
                    {
			case 0:
				if (polozeniex == 19)
					break;
				if (czy_mozna_isc(polozeniex + 1, polozeniey))
                                    break;
				petla = 0;
				polozenie(polozeniex+1, polozeniey );
				break;
			case 1:
				if (polozeniex == 0)
					break;
				if (czy_mozna_isc(polozeniex - 1, polozeniey))
                                    break;
				petla = 0;
				polozenie(polozeniex-1, polozeniey );
				break;
			case 2:
				if (polozeniey == 19)
					break;
				if (czy_mozna_isc(polozeniex , polozeniey+1))
                                    break;
				petla = 0;
				polozenie(polozeniex, polozeniey + 1);
				break;
			case 3:
				if (polozeniey == 0)
					break;
				if (czy_mozna_isc(polozeniex , polozeniey-1))
                                    break;
				petla = 0;
				polozenie(polozeniex, polozeniey - 1);
				break;
                    }
                }
	}
    public void akcja()
	{
		ruszsie();
	}
}
