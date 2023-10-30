package ModeloExamen;

public class App implements Ganancia{
    private String nombre;
    private int usuarios;
    private int costo;
    private int gananciaMes;
    private int totalUsuarios;

    public App(String nombre, int usuarios, int costo) {
        this.nombre = nombre;
        this.usuarios = usuarios;
        this.costo = costo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getUsuarios() {
        return usuarios;
    }
    public void setUsuarios(int usuarios) {
        this.usuarios = usuarios;
    }
    public int getCosto() {
        return costo;
    }
    public void setCosto(int costo) {
        this.costo = costo;
    }
    @Override
    public int calculoGanancia() {
        // TODO Auto-generated method stub
        this.gananciaMes=costo*usuarios;
        return this.gananciaMes;
    }
    @Override
    public int totalUsuarios() {
        // TODO Auto-generated method stub
        this.totalUsuarios=usuarios*12;
        return totalUsuarios;
    }

    

}
