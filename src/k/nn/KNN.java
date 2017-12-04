/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package k.nn;

import java.util.ArrayList;

/**
 *
 * @author zap
 */
public class KNN {

    /**
     * @param args the command line arguments
     */
    private static ArrayList<Model> fact = new ArrayList<Model>();

    public static void main(String[] args) {
        // TODO code application logic here
        fact.add(new Model("muda", "sangat gemuk", "tidak"));
        fact.add(new Model("muda", "gemuk", "tidak"));
        fact.add(new Model("paruh baya", "gemuk", "tidak"));
        fact.add(new Model("paruh baya", "terlalu gemuk", "ya"));
        fact.add(new Model("tua", "terlalu gemuk", "ya"));

        Model dataTest = new Model("tua", "sangat gemuk", "");
        nearest(dataTest, fact);
    }

    public static void nearest(Model data, ArrayList<Model> fact) {
        float jarakTerdekat = 0;
        Point dataVector = konversi(data);
        ArrayList<Point> factVector = konversi(fact);
        Model dataTerdekat = new Model("","","");
        for (int counter = 0; counter < factVector.size(); counter++) {
            if(counter == 0){
                jarakTerdekat = jarak(dataVector, factVector.get(counter));
                dataTerdekat = fact.get(counter);
            }
            else{
                float jarakTemp = jarak(dataVector, factVector.get(counter));
                if(jarakTemp < jarakTerdekat){
                    jarakTerdekat = jarakTemp;
                    dataTerdekat = fact.get(counter);
                }
            }
        }
        System.out.println("Data testing : " + data.getUmur() + ", " + data.getKegemukan());
        System.out.println("Data terdekat : " + dataTerdekat.getUmur() + ", " + dataTerdekat.getKegemukan());
        System.out.println("Jarak : " + jarakTerdekat);
        System.out.println("Sehingga prediksi hasil bernilai : " + dataTerdekat.getHipertensi());
    }

    public static Point konversi(Model d) {
        Point v = new Point(0, 0);
        switch (d.getUmur()) {
            case "muda":
                v.setX(1);
                break;
            case "paruh baya":
                v.setX(2);
                break;
            case "tua":
                v.setX(3);
                break;
            default:
                break;
        }

        switch (d.getKegemukan()) {
            case "gemuk":
                v.setY(1);
                break;
            case "sangat gemuk":
                v.setY(2);
                break;
            case "terlalu gemuk":
                v.setY(3);
                break;
            default:
                break;
        }
        return v;
    }

    public static ArrayList<Point> konversi(ArrayList<Model> fact) {
        ArrayList<Point> alv = new ArrayList<Point>();
        for (Model d : fact) {
            Point v = konversi(d);
            alv.add(v);
        }
        return alv;
    }

    public static float jarak(Point v1, Point v2) {
        Point v = new Point(0, 0);
        v.setX(v2.getX() - v1.getX());
        v.setY(v2.getY() - v1.getY());
        float D = (float) (Math.pow(v.getX(), 2) + Math.pow(v.getY(), 2));
        float a = (float) Math.sqrt(D);
        return a;
    }
}
