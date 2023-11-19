import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;  // Importa Elements de org.jsoup.select
import java.io.IOException;

public class Main {
    public static void main(String[] args)  {
        try {
            Document doc = Jsoup.connect("https://es.wikipedia.org/wiki/Wikipedia:Portada")
                    .timeout(6000)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3")
                    .get();

            // Obtener todos los enlaces en la página
            Elements links = doc.select("a");  // No es necesario castear a (Elements)

            // Iterar sobre los enlaces e imprimir sus atributos
            for (Element link : links) {
                System.out.println("Enlace: " + link.attr("href"));
                System.out.println("Texto: " + link.text());
                System.out.println("-------------");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
