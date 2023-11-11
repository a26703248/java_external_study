package blog.howardli.java_external_study.java_8_nio;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonParseNIODemo {
    public static void main(String[] args) {
        JsonParseNIODemo csvnio = new JsonParseNIODemo();
        csvnio.demo3();
    }

    public void gsonDemo3() {
        try (
                FileReader fr = new FileReader("src/main/resources/target/demo3.json");
                JsonReader jr = new JsonReader(fr)
        ) {
            while (jr.hasNext()) {
                System.out.println(jr.nextString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void demo3() {
        try (
                FileReader fr = new FileReader("src/main/resources/data/demo2.csv");
                FileWriter fw = new FileWriter("src/main/resources/target/demo3.json");) {
            List<CSVBean> res = new CsvToBeanBuilder<CSVBean>(fr)
                    .withType(CSVBean.class).build().parse();

            new Gson().toJson(res, fw);
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
