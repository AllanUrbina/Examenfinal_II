public class modeloGanadero {
 private String color; //
 private String raza; //
 private Double pesoAnimal; //
   
   
    // CREAMOS NUESTRO CONSTRUCTOR

    public modeloGanadero(String color, String raza,  Double pesoAnimal) {
        this.color = color;
        this.raza = raza;
       this.pesoAnimal = pesoAnimal;
       
    }

    public modeloGanadero(){
        
    }

    // METODOS GETTER Y SETTER

    public String getColor() {
        return color;
    }

    public String getRaza() {
        return raza;
    }


    public Double getPesoAnimal() {
        return pesoAnimal;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }


    public void setPesoAnimal(Double pesoAnimal) {
        this.pesoAnimal = pesoAnimal;
    }

}