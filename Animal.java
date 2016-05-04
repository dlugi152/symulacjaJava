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
public interface Animal 
{
    public void akcja();
    public boolean kolizjaatak(Organizm a);
    public boolean kolizjaobrona(Organizm a);
    public void mnoz();
}
