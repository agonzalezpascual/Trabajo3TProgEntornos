package nombrepaquete

import java.io.IOException;

public class MeterDonaciones {

    public static void main(String[] args) throws IOException {
          
          ManejarFichero fich = new ManejarFichero();

          fich.introDatos("12345698F", 2, "2015-01-26", 501,false);
          fich.introDatos("98653212S", 3, "2016-02-25", 502,false);
          fich.introDatos("45689423M", 3, "2017-02-27", 556,true);
          fich.introDatos("20206520J", 3, "2017-02-28", 504,false);
          fich.introDatos("98653212S", 3, "2019-02-24", 504,false);
          fich.introDatos("20206520J", 3, "2019-02-28", 554,true);
          fich.introDatos("65432165U", 3, "2020-03-03", 553,true);
          fich.introDatos("36985214R", 3, "2020-03-05", 536,true);
          fich.introDatos("65465465T", 3, "2020-03-10", 508,false);
          fich.introDatos("45689423M", 3, "2020-03-22", 506,false);
          fich.introDatos("45689423M", 3, "2018-03-25", 555,true);
          fich.introDatos("65239856K", 1, "2020-04-14", 501,false);
          fich.introDatos("98653212S", 1, "2021-05-02", 552,true);
          fich.introDatos("12345698F", 2, "2021-05-03", 500,false);
          fich.introDatos("20206520J", 2, "2021-05-05", 666,true);
          fich.introDatos("98653212S", 2, "2021-05-08", 500,false);
          fich.introDatos("26535985L", 2, "2021-05-10", 569,true);
          fich.introDatos("32541841G", 2, "2021-05-11", 551,true);
    }
}
