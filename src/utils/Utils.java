package utils;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Classe responsável por formatar valores para R$
 * 
 * @author João Pedro
 * @version 1.0
 * @since 22/06/2023
 * 
 */

public class Utils {
    static NumberFormat numberFormat = 
        new DecimalFormat("R$ #,##0.00", 
            new DecimalFormatSymbols(new Locale("pt", "BR")));

    public static String doubleToString(String value){
        /* Formata um valor para R$ */
        return numberFormat.format(value);
    }        
}
