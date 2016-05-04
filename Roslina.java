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
public abstract class Roslina extends Organizm
{
    public void akcja()
    {
        mnoz();
    }
    public Roslina()
    {
        inicjatywa = wiek = 0;
    }
    public boolean kolizjaobrona(Organizm a)
    {
        if (sila > a.zwrocsile())
            return true;
        return false;
    }
    public boolean kolizjaatak(Organizm a)
    {
        if (sila >= a.zwrocsile())
            return true;
        return false;
    }
    public void mnoz()
    {
        if (r.nextInt() % 10==0)
            potomek = 1;
    }
}
