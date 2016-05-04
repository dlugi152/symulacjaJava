/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulacjaswiata;
import java.util.Comparator;
/**
 *
 * @author tomasz
 */
public class PorownywarkaIntow implements Comparator<Int>
{
    @Override
    public int compare(Int x, Int y)
    {
        if (x.a < y.a)
            return -1;
        if (x.a > y.a)
            return 1;
        return 0;
    }
}