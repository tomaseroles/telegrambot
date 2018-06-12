/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot;

/**
 *
 * @author lioalc
 */
public class Cryptocoin {
    
    private String id;
    private String nombre;
    private String simbolo;
    private double precio_usd;
    private double pc1h;
    private double pc24h;
    private double pc7d;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the simbolo
     */
    public String getSimbolo() {
        return simbolo;
    }

    /**
     * @param simbolo the simbolo to set
     */
    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    /**
     * @return the precio_usd
     */
    public double getPrecio_usd() {
        return precio_usd;
    }

    /**
     * @param precio_usd the precio_usd to set
     */
    public void setPrecio_usd(double precio_usd) {
        this.precio_usd = precio_usd;
    }

    /**
     * @return the pc1h
     */
    public double getPc1h() {
        return pc1h;
    }

    /**
     * @param pc1h the pc1h to set
     */
    public void setPc1h(double pc1h) {
        this.pc1h = pc1h;
    }

    /**
     * @return the pc24h
     */
    public double getPc24h() {
        return pc24h;
    }

    /**
     * @param pc24h the pc24h to set
     */
    public void setPc24h(double pc24h) {
        this.pc24h = pc24h;
    }

    /**
     * @return the pc7d
     */
    public double getPc7d() {
        return pc7d;
    }

    /**
     * @param pc7d the pc7d to set
     */
    public void setPc7d(double pc7d) {
        this.pc7d = pc7d;
    }
    
    
    
}
