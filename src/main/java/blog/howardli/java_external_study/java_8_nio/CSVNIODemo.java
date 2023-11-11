package blog.howardli.java_external_study.java_8_nio;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class CSVNIODemo {

    public static void main(String[] args) {
        CSVNIODemo csvnio = new CSVNIODemo();
        csvnio.demo4();
    }

    public void demo4() {
        try (
                FileReader fr = new FileReader("src/main/resources/data/demo2.csv");
                FileWriter fw = new FileWriter("src/main/resources/target/demo2.csv");) {
            List<CSVNIODemo.CSVBean> origin = new CsvToBeanBuilder<CSVNIODemo.CSVBean>(fr)
                    .withType(CSVNIODemo.CSVBean.class)
                    .build()
                    .parse();

            StatefulBeanToCsv<CSVNIODemo.CSVBean> sbtc = new StatefulBeanToCsvBuilder<CSVNIODemo.CSVBean>(fw)
                    .build();
            sbtc.write(origin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private class CSVBean {
        @CsvBindByPosition(position = 0)
        private String seq;

        @CsvBindByPosition(position = 1)
        private String name;

        public CSVBean() {
        }

        public CSVBean(String seq, String name) {
            this.seq = seq;
            this.name = name;
        }

        public CSVBean(String... strings) {
            this.seq = strings[0];
            this.name = strings[1];
        }

        public String getSeq() {
            return seq;
        }

        public void setSeq(String seq) {
            this.seq = seq;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
