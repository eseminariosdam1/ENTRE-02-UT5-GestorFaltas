/**
 * @Eneko Seminario
 * Un objeto de esta clase guarda la informaci�n de un estudiante
 *
 */
public class Estudiante {
    private final static String SEPARADOR = ",";
    private String nombre;
    private String apellidos;
    private int faltasNoJustificadas;
    private int faltasJustificadas;

    /**
     *  
     *  Inicializa los atributos a partir de la informaci�n recibida
     *  Esta informaci�n se encuentra en lineaDatos
     *  (ver enunciado) 
     *  
     */
    public Estudiante(String lineaDatos) {
         String[] informacionAlumno = lineaDatos.split(SEPARADOR);
         this.nombre = nombreCompleto(informacionAlumno[0]);
         this.apellidos = informacionAlumno[1].toUpperCase();
         this.faltasNoJustificadas = Integer.parseInt(informacionAlumno[2]);
         this.faltasJustificadas =  Integer.parseInt(informacionAlumno[3]);
         
    }

    private String nombreCompleto(String nombre)
    {
        String[] nombres = nombre.split("");
        String nombreAlumno = "";
        String inicialesNombre = "";
        for(int i = 0; i < nombres.length; i++){
            inicialesNombre =  String.valueOf(nombres[i].charAt(0));
            nombreAlumno += inicialesNombre + nombres[i].substring(0); 
            if(nombres[i] != ""){
                inicialesNombre =  String.valueOf(nombres[i].charAt(0));
                 nombreAlumno += inicialesNombre.toUpperCase() + ".";
            }
        }
        return nombreAlumno;
    }
    
    /**
     * accesor para el nombre completo
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * mutador para el nombre
     *  
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * accesor para los apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     *  mutador para los apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * accesor para el n� de faltas no justificadas
     */
    public int getFaltasNoJustificadas() {
        return faltasNoJustificadas;
    }

    /**
     * mutador para el n� de faltas no justificadas
     */
    public void setFaltasNoJustificadas(int faltasNoJustificadas) {
        this.faltasNoJustificadas = faltasNoJustificadas;
    }

    /**
     * accesor para el n� de faltas justificadas
     */
    public int getFaltasJustificadas() {
        return faltasJustificadas;
    }

    /**
     *  mutador para el n� de faltas justificadas
     */
    public void setFaltasJustificadas(int faltasJustificadas) {
        this.faltasJustificadas = faltasJustificadas;
    }

    /**
     *  se justifican n faltas que hasta el momento eran injustificadas
     *  Se asume n correcto
     */
    public void justificar(int n) {
        this.faltasNoJustificadas -= n;
        this.faltasJustificadas += n;
    }

    /**
     * Representaci�n textual del estudiante
     * (ver enunciado)
     */
    public String toString() {
        String apercibimientos = "";
        if(this.faltasNoJustificadas >= 10){
            apercibimientos += "DIEZ";
        }else if(this.faltasNoJustificadas >= 20){
            apercibimientos += "DIEZ VEINTE";
        }else if(this.faltasNoJustificadas >= 30){
             apercibimientos += "DIEZ VEINTE TREINTA";
        }else if(this.faltasNoJustificadas >= 0 || faltasNoJustificadas <10 ){
            apercibimientos += "Este alumno no esta apercibido";
        }
           String nombreConApellidos = apellidos + "," + nombre;
           String str = String.format("%-25s %-40s %-25s %-40s %-25s %-40s %-40s %-40s","Apellidos y Nombre:",nombreConApellidos,"\nFaltas No Justificadas:", faltasNoJustificadas,
           "\nFaltas Justificadas:", faltasJustificadas, "\nApercibimientos:",apercibimientos);
           return str;
    }

    public static void main(String[] args) {
        Estudiante e1 = new Estudiante("  ander ibai , Ruiz Sena , 12, 23");
        System.out.println(e1);
        System.out.println();
        Estudiante e2 = new Estudiante(
                " pedro jos� andr�s  ,  Troya Baztarrica , 42, 6 ");
        System.out.println(e2);
        System.out.println();
        Estudiante e3 = new Estudiante("  Javier  ,  Suescun  Andreu , 39, 9 ");
        System.out.println(e3);
        System.out.println();
        Estudiante e4 = new Estudiante("julen, Duque Puyal, 5, 55");
        System.out.println(e4);
        System.out.println();

        System.out.println("---------------------------------");
        e1.justificar(3);
        System.out.println(e1);
        System.out.println();

        System.out.println("---------------------------------");

        e3.justificar(12);
        System.out.println(e3);
        System.out.println();

    }

}
