package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Objects;

public class LotteryResult {

    public static void main(String[] args) {
        String sourceUrl = "https://www.nlb.lk/results/govisetha";

        try {
            Document document = Jsoup.connect(sourceUrl).get();
            Elements results = document.select("tr");
            System.out.println(document.text());

            for (Element result : results) {
                StringBuffer winningNumber = new StringBuffer();
                String drawNo = result.select("b").text();
                String date = result.select("td").text();
                Element valueSet = Objects.requireNonNull(result.selectFirst("BB")).child(0);

                for(Element e : valueSet.children()){
                    winningNumber.append(e.text());
                }

                System.out.println(drawNo);
                System.out.println(date);
                System.out.println("Result:"+ winningNumber);


            }


        } catch (IOException | NullPointerException e) {
            System.out.println("Something went wrong.");
        }

}
}
