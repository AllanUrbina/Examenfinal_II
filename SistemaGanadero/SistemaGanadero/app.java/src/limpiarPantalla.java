public class limpiarPantalla {
    public static void limpiar() {
        try {
            //objeto para limpiar pantalla
            new ProcessBuilder("cmd", "/c", "cls");
        } catch (Exception e) {
            /* No hacer nada */
        }
    }
}