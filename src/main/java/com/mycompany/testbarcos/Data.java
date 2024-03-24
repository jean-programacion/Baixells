/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testbarcos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.StringTokenizer;

public class Data {

    private int dia;

    private int mes;

    private int any;

    private static final String[] DIES_TEXT = new String[]{"diumenge", "dilluns", "dimarts", "dimecres", "dijous", "divendres",
        "dissabte"};

    private static final String[] MESOS_TEXT = new String[]{"gener", "febrer", "març", "abril", "maig", "juny",
        "juliol", "agost", "setembre", "octubre", "novembre", "desembre"};

    /**
     * Constructor por defecto Inicializa una fecha a dia 1-1-1970
     */
    public Data() {

        this.dia = 1;
        this.mes = 1;
        this.any = 1970;
    }

    /*
     * Inicializa la fecha
     *
     * @param dia de la semana
     * @param mes del año
     * @param any
     */
    public Data(int dia, int mes, int any) {
        this.dia = dia;
        this.mes = mes;
        this.any = any;
    }

    /**
     * Inicializa la fecha a partir de otra pasada en formato String dd/mm/yyyy
     *
     * Deberemos trocearlas de forma que asignemos el día més y año a cada uno
     * de los atributoe Tienes que utilizar las funciones de *String o consultar
     * la documentación oficial y hacerlo OBLIGATORIAMENTE con la clase
     * StringTokenizer. Si el formato recibido no es el correcto, creará la
     * fecha por defecto.
     *
     * @param fecha
     */
    public Data(String data) {
        StringTokenizer tokenizer = new StringTokenizer(data, "/ ");
        this.dia = Integer.parseInt(tokenizer.nextToken());
        this.mes = Integer.parseInt(tokenizer.nextToken());
        this.any = Integer.parseInt(tokenizer.nextToken());
    }

    /**
     * Modifica la fecha actual a partir de los datos pasados como argumento
     */
    public void set(int dia, int mes, int any) {
        this.dia = dia;
        this.mes = mes;
        this.any = any;
    }

    /**
     * Obtiene una fecha con los mismos atributos que la fecha actual
     *
     * @return
     */
    public Data clone() {
        try {
            // Crear una nueva instancia de Data con los mismos valores que el objeto actual
            return new Data(this.dia, this.mes, this.any);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Devuelve el día de la semana que representa por la Fecha actual
     *
     * @return @dia
     */
    public int getDia() {
        return this.dia;
    }

    /**
     * Devuelve el mes que representa la Fecha actual
     *
     * @return @mes
     */
    public int getMes() {
        return this.mes;
    }

    /**
     * Devuelve el año que representa la Fecha actual
     *
     * @return @mes
     */
    public int getAny() {
        return this.any;
    }

    /**
     * Muestra por pantalla la fecha en formato español dd-mm-yyyy
     */
    public void mostrarEnFormatES() {
        String fechaFormateada = String.format("%02d-%02d-%04d", dia, mes, any);
        System.out.println(fechaFormateada);
    }

    /**
     * Muestra por pantalla la fecha en formato inglés yyyy-mm-dd
     */
    public void mostrarEnFormatGB() {
        String fechaFormateada = String.format("%04d-%02d-%02d", any, mes, dia);
        System.out.println(fechaFormateada);
    }

    /**
     * Muestra por pantalla la fecha en formato texto dd-mmmm-yyyy Ej. 1 enero
     * de 1970
     */
    public void mostrarEnFormatText() {
        String fechaFormateada = String.format("%02d-" + MESOS_TEXT[mes - 1] + "-%04d", dia, any);
        System.out.println(fechaFormateada);
    }

    /**
     * Retorna un booleano indicando si la fecha del objeto es igual a la fecha
     * pasada como argumento
     *
     * @return boolean
     */
    public boolean isIgual(Data otraFecha) {
        return this.dia == otraFecha.getDia() && this.mes == otraFecha.getMes() && this.any == otraFecha.getAny();
    }

    /**
     * Retorna un String que representa el dia de la setmana en format text
     * (dilluns, dimarts, dimecres, dijous, divendres, dissabte, diumenge).
     * L'algorisme de resolució d'aquest mètode es troba al enunciat.
     *
     * @return String
     */
    public String getDiaSetmana() {

        LocalDate localDate = LocalDate.of(this.any, this.mes, this.dia);
        DayOfWeek diaSemana = localDate.getDayOfWeek();
        return DIES_TEXT[diaSemana.getValue() % 7];
    }

    /**
     * Retorna un booleà indicant si la data representada per l'objecte actual
     * és festiva. Es considerarà festiu si el dia de la setmana és dissabte o
     * diumenge
     *
     * @return boolean
     */
    public boolean isFestiu() {

        LocalDate localDate = LocalDate.of(this.any, this.mes, this.dia);
        DayOfWeek diaSemana = localDate.getDayOfWeek();
        return diaSemana == DayOfWeek.SATURDAY || diaSemana == DayOfWeek.SUNDAY;
    }

    /**
     * Retorna el número de la setmana dins de l'any actual. Es considera una
     * setmana l'interval de dates entre una data que siga dilluns i la següent
     * data en ordre cronològic que siga diumenge. També es comptabilitza com a
     * setmana tant la primera setmana de l'any com l'última (inclusivament en
     * aquells anys en què la primera i/o última setmana no conté set dies en
     * total).
     *
     * @return int dia semana
     */
    public int getNumeroSetmana() {

   // Obtener el primer día del año
    LocalDate primerDiaAny = LocalDate.of(any, 1, 1);
    
    // Obtener el día de la semana del primer día del año
    int diaSemanaPrimerDiaAny = primerDiaAny.getDayOfWeek().getValue();
    
    // Obtener el día de la semana de la fecha actual
    LocalDate fecha = LocalDate.of(any, mes, dia);
    int diaSemanaFecha = fecha.getDayOfWeek().getValue();
    
    // Calcular el número de semanas completas desde el primer día del año hasta la fecha
    long semanasCompletas = ChronoUnit.WEEKS.between(primerDiaAny, fecha);
    
    // Si la fecha es sábado y el primer día del año es lunes o si la fecha es domingo, sumar una semana más
    return (DIES_TEXT.length == 7 && (diaSemanaPrimerDiaAny == 1 || (diaSemanaPrimerDiaAny == 2 && fecha.isLeapYear()))) ? (int) semanasCompletas : (int) semanasCompletas + 1;
}

    /**
     * Retorna un nou objecte de tipus data que representa la data resultant
     * d'afegir el nombre de dies passats com a argument a la data que
     * representa l'objecte actual. Haurem de tindre en compte els dies que té
     * el mes actual i si l'any és de traspàs (bisiesto) amb la finalitat de
     * construir el nou objecte amb la data correcta. El màxim nombre de dies
     * que podrem afegir serà 30 i no podrem afegir un nombre negatiu de dies.
     *
     * @return boolean
     */
    public Data afegir(int numDias) {

        LocalDate dataActual = LocalDate.of(any, mes, dia);

        // Añadir los días especificados
        LocalDate nuevaData = dataActual.plusDays(numDias);

        // Obtener el nuevo día, mes y año
        int nuevoDia = nuevaData.getDayOfMonth();
        int nuevoMes = nuevaData.getMonthValue();
        int nuevoAny = nuevaData.getYear();

        // Retornar un nuevo objeto Data con la fecha resultante
        return new Data(nuevoDia, nuevoMes, nuevoAny);
    }

    /**
     * Retorna un nou objecte de tipus data que representa la data resultant de
     * restar el nombre de dies passats com a argument a la data que representa
     * l'objecte actual. Haurem de tindre en compte els dies que té el mes
     * actual i si l'any és de traspàs (bisiesto) amb la finalitat de construir
     * el nou objecte amb la data correcta. El màxim nombre de dies que podrem
     * restar serà 30 i no podrem restar un nombre negatiu de dies.
     *
     * @return boolean
     */
    public Data restar(int dies) {
        LocalDate localDate = LocalDate.of(this.any, this.mes, this.dia);
        LocalDate novaData = localDate.minusDays(dies);
        return new Data(novaData.getDayOfMonth(), novaData.getMonthValue(), novaData.getYear());
    }

    /**
     * Retorna un booleà indicant si la data representada per l'objecte actual
     * és correcta. No oblides comprovar que el dia es trobe dins del rang dels
     * dies que té el mes tenint en compte si l'any és de traspàs(bisiesto) o
     * no.
     *
     * @return
     */
    public boolean isCorrecta() {
        if (mes < 1 || mes > 12) {
            return false; // El mes debe estar entre 1 y 12
        }
        if (dia < 1) {
            return false;
        }
        int diasEnMes = LocalDate.of(any, mes, 1).lengthOfMonth();
        return dia <= diasEnMes;
    }

    /**
     * Retorna el mes del año en formato text (enero, febrero, marzo,...)
     *
     * @return char
     */
    private String getMesEnFormatText() {

        Month mes = LocalDate.now().getMonth();

        // Mapear los nombres de los meses
        String[] nombresMeses = {
            "enero", "febrero", "marzo", "abril", "mayo", "junio",
            "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"
        };

        // Retornar el nombre del mes actual en formato texto
        return nombresMeses[mes.getValue() - 1];

    }

    /**
     * Devuelve el número de dias transcurridos desde el 1-1-1
     *
     * @return int
     */
    private int getDiesTranscorregutsOrigen(int dia, int mes, int any) {
        LocalDate data = LocalDate.of(any, mes, dia);
        LocalDate origen = LocalDate.of(1, 1, 1);
        int diesTranscorreguts = (int) (origen.until(data).getDays());
        return diesTranscorreguts;
    }

    /**
     * Devuelve el número de dias transcurridos en el anyo que representa el
     * objeto
     *
     * @return int
     */
    private int getDiesTranscorregutsEnAny() {
        LocalDate fechaActual = LocalDate.now();

        // Obtiene el primer día del año actual
        LocalDate primerDiaAny = LocalDate.of(fechaActual.getYear(), 1, 1);

        // Calcula la diferencia en días entre la fecha actual y el primer día del año
        long diferenciaEnDias = ChronoUnit.DAYS.between(primerDiaAny, fechaActual);

        // Devuelve la diferencia en días como un entero
        return (int) diferenciaEnDias;
    }

    /**
     * Indica si el año pasado como argumento es bisiesto. Un año es bisiesto si
     * es divisible por 4 pero no es divisible entre 100 o es divisible entre 4
     * entre 100 y entre 400
     *
     * @return boolean
     */
    public static boolean isBisiesto(int any) {
        return (any % 4 == 0 && any % 100 != 0) || (any % 400 == 0);
    }

    /**
     * Calcula el número de días que tiene el @mes en el @año pasado como
     * argumento Deberás hacer uso del métodos isBisiesto
     *
     * @return int total dias mes en curso
     */
    public static int getDiesMes(int mes, int any) {

        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (isBisiesto(any)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return -1; // Mes inválido
        }
    }

    /**
     * Calcula el número total de dias que tiene el año pasado como argumento
     *
     * @return int total dias anyo en curso
     */
    public static int getDiesAny(int any) {

        if (isBisiesto(any)) {
            return 366;
        } else {
            return 365;
        }
    }
}