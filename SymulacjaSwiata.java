/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulacjaswiata;

public class SymulacjaSwiata 
{

    public static void main(String[] args) 
    {
        
        Swiat swiatOrganizmow = new Swiat();
        Grafika okienkoProgramu = new Grafika(swiatOrganizmow);
        okienkoProgramu.setVisible(true);
        /*
        Swiat swiat = new Swiat();
	swiat.rysujSwiat();
	int stangry = 0;
	while (stangry==1)
	{
		//while (!_kbhit());
		//system("cls");
		swiat.wykonajTure();
		stangry = swiat.stangry();
	}
	//system("cls");
	//if (stangry == 1)
		//cout << "Wygrana\n";
	//else
		//cout << "Przegrana\n";*/
    }
   
}
