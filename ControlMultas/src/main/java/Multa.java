/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author dev
 */
public class Multa {

    private int nAgente;
    private StringBuilder localidad;
    private int coste;
    private boolean pagado;

    public Multa(int nAgente, String localidad, int coste, boolean pagado) {
        this.nAgente = nAgente;
        setLocalidad(localidad);
        this.coste = coste;
        this.pagado = pagado;
    }

    @Override
    public String toString() {
        return "Multa{" + "nAgente=" + nAgente + ", localidad=" + localidad + ", coste=" + coste + ", pagado=" + pagado + '}';
    }
    

    public boolean isPagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public int getnAgente() {
        return nAgente;
    }

    public void setnAgente(int nAgente) {
        this.nAgente = nAgente;
    }

    public StringBuilder getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = new StringBuilder(localidad);
        this.localidad.setLength(50);
    }

    public int getCoste() {
        return coste;
    }

    public void setCoste(int coste) {
        this.coste = coste;
    }

    public static int getSize() {
        return 109;
    }

}
