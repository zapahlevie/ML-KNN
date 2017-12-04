/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k.nn;

/**
 *
 * @author zap
 */
public class Model {
    private String umur;
    private String kegemukan;
    private String hipertensi;

    public Model(String umur, String kegemukan, String hipertensi) {
        this.umur = umur;
        this.kegemukan = kegemukan;
        this.hipertensi = hipertensi;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }

    public String getKegemukan() {
        return kegemukan;
    }

    public void setKegemukan(String kegemukan) {
        this.kegemukan = kegemukan;
    }

    public String getHipertensi() {
        return hipertensi;
    }

    public void setHipertensi(String hipertensi) {
        this.hipertensi = hipertensi;
    }
    
}
