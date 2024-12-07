import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String[] alumnos = registrarAlumnos();
        double[][] notas = registrarNota(alumnos);
        mostrarNotas(alumnos, notas);
        double mejorPromedio = mostrarMejorPromedio(alumnos, notas);
        System.out.println("El mejor promedio es: " + mejorPromedio);
        double peorPromedio = mostrarPeorPromedio(alumnos, notas);
        System.out.println("El peor promedio es: " + peorPromedio);
        promedioGrupal(alumnos, notas);
    }

    private static double mostrarMejorPromedio(String[] alumnos, double[][] notas) {
        double mejorPromedio = 0;
        String mejorAlumno = "";
        for (int i = 0; i < alumnos.length; i++) {
            double promedio = obtenerPromedio(alumnos[i], notas[i]);
            if (promedio > mejorPromedio) {
                mejorPromedio = promedio;
                mejorAlumno = alumnos[i];
            }
        }
        return mejorPromedio;
    }

    public static String[] registrarAlumnos() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese la cantidad de alumnos a registrar: ");
    int cantidadAlumnos = scanner.nextInt();
    String[] alumnos = new String[cantidadAlumnos];
    for (int i = 0; i < cantidadAlumnos; i++) {
        System.out.println("Ingrese el nombre del alumno " + (i + 1) + ": ");
        alumnos[i] = scanner.next();
    }
    return alumnos;
    }
    public static double [][] registrarNota(String[] alumnos) {
        Scanner scanner = new Scanner(System.in);
        double[][] notas = new double[alumnos.length][1];
        for (int i = 0; i < alumnos.length; i++) {
            for (int j = 0; j < 1; j++) {
                System.out.println("Ingrese la nota del alumno " + alumnos[i] + ": ");
               int nota = scanner.nextInt();
                while (nota < 0 || nota > 100) {
                    System.out.println("Ingrese una nota válida: ");
                    nota = scanner.nextInt();
                }
                notas[i][j] = nota;
            }
        }
        return notas;
    }
    public static void mostrarNotas(String[] alumnos, double[][] notas) {
        for (int i = 0; i < alumnos.length; i++) {
            System.out.println("Notas del alumno " + alumnos[i] + ": ");
            System.out.println("Nota 1: " + notas[i][0]);
        }
    }

  // sólo se tomara una nota para el promedio
    public static double obtenerPromedio(String alumno, double[] nota) {
        return  nota[0];
    }

    public static double mostrarPeorPromedio(String[] alumnos, double[][] notas) {
        double peorPromedio = 100;

        for (int i = 0; i < alumnos.length; i++) {
            double promedio = obtenerPromedio(alumnos[i], notas[i]);
            if (promedio < peorPromedio) {
                peorPromedio = promedio;
            }
        }
        return peorPromedio;
    }
    public static void promedioGrupal(String[] alumnos, double[][] notas) {
        double promediototal = 0;
        for (int i = 0; i < alumnos.length; i++) {

            double promedio = obtenerPromedio(alumnos[i], notas[i]);
            promediototal += promedio;
        }
        promediototal = promediototal / alumnos.length;
        System.out.println("El promedio grupal es: " + promediototal    );
    }
}