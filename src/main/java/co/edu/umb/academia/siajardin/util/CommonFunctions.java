package co.edu.umb.academia.siajardin.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.apache.commons.codec.digest.DigestUtils;

public class CommonFunctions {

    public static int checkrangohorasmarimpl(String rangoInicial, String hora, String rangoFinal) throws Exception {
        try {
            int vresult = 0;
            int vRangoInicial = 0;
            int vHora = 0;
            int vRangoFinal = 0;
            vRangoInicial = timetonumber(rangoInicial);
            vHora = timetonumber(hora);
            vRangoFinal = timetonumber(rangoFinal);

            if (vHora >= 1200 && vRangoFinal < 360) {
                vRangoFinal += 1440;
            }
            if (vRangoInicial >= 1200 && vHora < 360 && vRangoFinal < 360) {
                vHora += 1440;
                vRangoFinal += 1440;
            }

            /**
             * si la hora es menor al rango inicial y menor al rango final y
             * menos a 6 am*
             */
            if (vRangoFinal < 1440 && vRangoFinal < vRangoInicial) {
                vRangoFinal += 1440;
                if (vHora < vRangoInicial && vHora < vRangoFinal && vHora < 360) {
                    vHora += 1440;
                }
            }

            if (vHora >= vRangoInicial && vHora <= vRangoFinal) {
                vresult = 1;
            }
            return vresult;
        } catch (Exception ex) {
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            throw new Exception(errors.toString());
        }
    }

    public static int timetonumber(String tiempo) throws Exception {
        try {
            if (tiempo.trim().length() > 0 && tiempo.trim().length() == 5) {
                final String[] split = tiempo.trim().split(Pattern.quote(":"));
                if (split.length == 2) {
                    return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
                }
            }
            return 0;
        } catch (NumberFormatException ex) {
            final StringWriter errores = new StringWriter();
            ex.printStackTrace(new PrintWriter(errores));
            throw new Exception(errores.toString());
        }
    }

    public static boolean isValidDate(String date) throws Exception {
        try {
            java.sql.Date.valueOf(date);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static boolean isValidTime(String time) throws Exception {
        try {
            return Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]").matcher(time).matches();
        } catch (Exception ex) {
            return false;
        }
    }

    public static String getNextDay(String date1, int nday) throws Exception {
        try {
            return LocalDate.parse(date1).plusDays(nday).toString();
        } catch (Exception ex) {
            StringWriter errores = new StringWriter();
            ex.printStackTrace(new PrintWriter(errores));
            throw new Exception(errores.toString());
        }
    }

    public static int getDayOftheWeek(String date) throws Exception {
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(Date.valueOf(date.trim()));
            int dayOfWeek = c.get(7) - 1;
            return dayOfWeek;
        } catch (Exception ex) {
            StringWriter errors = new StringWriter();
            ex.printStackTrace(new PrintWriter(errors));
            throw new Exception(errors.toString());
        }
    }

    /*
     *  @param fechaOrigen = fecha inicial a evaluar
     *  @param fechaComparacion = fecha contra la que se va a evaluar
     *  fechaComparacion Anterior a fechaOrigen = 1
     *  fechaComparacion Igual a fechaOrigen = 0
     *  fechaComparacion Superior a fechaOrigen = -1
     */
    public static int validateDates(String fechaOrigen, String fechaComparacion) {
        return java.sql.Date.valueOf(fechaOrigen.trim())
                .compareTo(java.sql.Date.valueOf(fechaComparacion.trim()));
    }

    public static String encryptedData(String data) {
        return DigestUtils.sha512Hex(data.trim());
    }

    public static String getRandomCode() {
        return String.valueOf(new java.util.Date().getTime());
    }


    public static String getCurrentDateTime() {
        java.util.Date now = new java.util.Date();
        SimpleDateFormat fr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return fr.format(now).trim();
    }

    public static int getRangeDays(String date1, String date2) throws Exception {
        try {
            Long days = ChronoUnit.DAYS.between(java.time.LocalDate.parse(date1), java.time.LocalDate.parse(date2));
            return days.intValue();
        } catch (NumberFormatException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public static String getCurrentDate() {
        java.util.Date now = new java.util.Date();
        SimpleDateFormat fr = new SimpleDateFormat("yyyy-MM-dd");
        return fr.format(now).trim();
    }

    public static String getCurrentTime() {
        java.util.Date now = new java.util.Date();
        SimpleDateFormat fr = new SimpleDateFormat("HH:mm:ss");
        return fr.format(now).trim();
    }

    public static String getDayofWeek(String fecha) throws Exception {
        try {
            HashMap<String, String> semana = new HashMap();
            semana.put("lunes", "Lunes");
            semana.put("martes", "Martes");
            semana.put("miércoles", "Miércoles");
            semana.put("jueves", "Jueves");
            semana.put("viernes", "Viernes");
            semana.put("sábado", "Sábado");
            semana.put("domingo", "Domingo");
            SimpleDateFormat formato = new SimpleDateFormat("EEEE", new java.util.Locale("es", "CO"));
            String result = formato.format(new SimpleDateFormat("yyyy-MM-dd").parse(fecha));
            return ((semana.containsKey(result.toLowerCase())) ? semana.get(result.toLowerCase()) : "");
        } catch (ParseException ex) {
            throw new Exception(ex.getMessage());
        }
    }

}
