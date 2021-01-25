/**
 * Punto de entrada a la aplicaci�n
 */
public class TestGestorFaltas {
    /**
     * Se acepta como argumento del main() el n� m�ximo de estudiantes
     * y una vez creado el gestor de faltas se muestra la informaci�n solicitada
     * (ver enunciado)
     */
    public static void main(String[] args) {
            GestorFaltas curso = new GestorFaltas(Integer.parseInt(args[0]));
            
            curso.leerDeFichero();
            System.out.println(curso.toString());
            
            curso.justificarFaltas("IRISO FLAMARIQUE", 6);
            System.out.println("Se le han justificado 6 faltas a IRISO FLAMARIQUE, Carla ");
            
            curso.ordenar();
            System.out.println("Se han ordenado de mayor a menor numero de faltas injustificadas");
            
            System.out.println(curso.toString());
            curso.anularMatricula();
            System.out.println(curso.toString());
    }

}
