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
public class Int 
{
    public int a;
    public Int(int n)
    {
        a=n;
    }
    public void set(int n)
    {
        a=n;
    }
    public int get()
    {
        return a;
    }
    public int comparator(Int x, Int y)
    {
        if (x.a<y.a)
            return 1;
        if (x.a>y.a)
            return -1;
        return 0;
    }
}
