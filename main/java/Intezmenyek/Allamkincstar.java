package Intezmenyek;

public class Allamkincstar  //greedy
{
   private static int cimlet = 100000;
   private static int cimletekSzama = 1000000;
   public int getCimletErtek() {return cimlet;}
   public int getCimletekMaxSzama() {return cimletekSzama;}

   private String nev = "Magyar Államkincstár";
   private long allamAdossag = 310400000 * cimlet;
   private double allamAdossagGDPArany =  0.664;    //forrás: magyarnemzet.hu/gazdasag/apadoban-az-allamadossag-7787951/  2020.02.18.
   private long kibocsatottPmapAllomany;
   private long kibocsatottEmapAllomany;
   private long kibocsatottMapPluszAllomany;
   private long ertekesitettPmapAllomany;
   private long ertekesitettEmapAllomany;
   private long ertekesitettMapPluszAllomany;

   private static final Allamkincstar instance = new Allamkincstar();
   private Allamkincstar() {}

   public static Allamkincstar getInstance()
        {
            return instance;
        }

   public void AllamPapirKibocsatas_PMAP(long osszeg) { kibocsatottPmapAllomany += osszeg;}
   public void AllamPapirKibocsatas_EMAP(long osszeg) { kibocsatottEmapAllomany += osszeg; }
   public void AllamPapirKibocsatas_MAPPlusz(long osszeg) { kibocsatottMapPluszAllomany += osszeg; }
   public void AllamPapirErtekesítes_PMAP(long osszeg) { ertekesitettPmapAllomany += osszeg; }
   public void AllamPapirErtekesítes_EMAP(long osszeg) { ertekesitettEmapAllomany += osszeg; }
   public void AllamPapirErtekesítes_MAPPlusz(long osszeg) { ertekesitettMapPluszAllomany += osszeg; }

   public long getKibocsatottPmapAllomany(){return kibocsatottPmapAllomany;}
   public long getKibocsatottEmapAllomany(){return kibocsatottEmapAllomany;}
   public long getKibocsatottMapPluszAllomany(){return kibocsatottMapPluszAllomany;}
   public long getErtekesitettPMAPAllomany(){return ertekesitettPmapAllomany;}
   public long getErtekesitettEMAPAllomany(){return ertekesitettEmapAllomany;}
   public long getErtekesitettMAPPluszAllomany(){return ertekesitettMapPluszAllomany;}
   public long getEladoPMAPAllomany(){return kibocsatottPmapAllomany - ertekesitettPmapAllomany;}
   public long getEladoEMAPAllomany(){return kibocsatottEmapAllomany - ertekesitettEmapAllomany;}
   public long getEladoMAPPluszAllomany(){return kibocsatottMapPluszAllomany - ertekesitettMapPluszAllomany;}
}

