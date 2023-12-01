public class modeloVentas {
    private Integer precioLitro;
    private Double litros;
    private Double gananciaNeta;
    private Double retirarGanancia;
// contructor
    public modeloVentas(Integer precioLitro, Double litros, Double gananciaNeta, Double retirarGanancia) {
        this.precioLitro = precioLitro;
        this.litros = litros;
        this.gananciaNeta = gananciaNeta;
        this.retirarGanancia = retirarGanancia;
    }
// metodos set y get 
    public modeloVentas() {
        this.gananciaNeta = 0.0;
    }
// get que obtiene el valor de precio por litro
    public Integer getPrecioLitro() {
        return precioLitro;
    }
 //get para la cantidad de litros vendidos
    public Double getLitros() {
        return litros;
    }
// get para la ganancia neta 
    public Double getGananciaNeta() {
        return gananciaNeta;
    }
// get para retirar ganancia
    public Double getRetirarGanancia() {
        return retirarGanancia;
    }
// set que captura un valor de precio por litro
    public void setPrecioLitro(Integer precioLitro) {
        this.precioLitro = precioLitro;
    }
// set cantidad de litros vendidos
    public void setLitros(Double litros) {
        this.litros = litros;
    }
 // captura la ganancia neta
    public void setGananciaNeta(Double gananciaNeta) {
        this.gananciaNeta = gananciaNeta;
    }
// set para calcular el monto a retirar de la ganancia neta 
    public void setRetirarGanancia(Double retirarGanancia) {
        this.retirarGanancia = retirarGanancia;
    }

    public double formulaGanancia() {
       // verifica si los valores de preciolitro y litros no son nulos es decir vacios si la condicion cumple ganancia neta = precio litro * litros
        if (precioLitro != null && litros != null) {
            gananciaNeta = precioLitro * litros;
            return gananciaNeta;
        // si la condicion no cumple no se pueden calcular las ganancias y retorna un 0
        } else {
            System.out.println("No se pueden calcular ganancias. Faltan datos.");
            return 0.0;
        }
    }

    public double retirarGanancia(Double retirar, Double ganancia) {
        //  condicion si ganancia es mayor o igual a lo que desea retirar ganancias - retirar
        if (ganancia >= retirar) {
            ganancia -= retirar;
            return retirar;
       // si no cumple no se puede retirar y retorna un 0
        } else {
            System.out.println("No se puede retirar esa cantidad. La ganancia disponible es menor.");
            return 0.0;
        }
    }

}
