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
public abstract class Zwierze extends Organizm{
    public void ruszsie()
    {
	int petla = 1;
	while (petla==1)
            switch (Math.abs(r.nextInt()) % 4)
            {
		case 0:
                    if (polozeniex == 19)
			break;
                    petla = 0;
                    polozenie(polozeniex+1, polozeniey );
                    break;
                case 1:
                    if (polozeniex == 0)
                        break;
                    petla = 0;
                    polozenie(polozeniex-1, polozeniey );
                    break;
		case 2:
                    if (polozeniey == 19)
                        break;
                    petla = 0;
                    polozenie(polozeniex, polozeniey+ 1);
                    break;
		case 3:
                    if (polozeniey == 0)
                        break;
                    petla = 0;
                    polozenie(polozeniex, polozeniey - 1);
                    break;
            }
    }
    @Override public void akcja()
    {
        ruszsie();
    }
    @Override public void mnoz()
    {
        potomek = 1;
    }
    public boolean kolizjaatak(Organizm a)
    {
        if (sila >= a.zwrocsile())
            return true;
        return false;
    }
    public boolean kolizjaobrona(Organizm a)
    {
        if (sila > a.zwrocsile())
            return true;
        return false;
    }
    public Zwierze()
    {
        wiek = 0;
    }
}
