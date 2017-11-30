package jsoup.examples

import org.jsoup.Jsoup
import java.io._
import scala.collection.JavaConversions._

object jsoup extends App {

  try {
    val doc = Jsoup
      .connect("http://www.synerzip.com/")
      .get()
    val title = doc.title()
    val links = doc.select("a[href]")
    var cnt = 0
    val body = doc.body().text()
    val pw = new PrintWriter(new File(("Crawled Links.txt")))

    for (link <- links) {
      cnt += 1
      pw.write(
        s"\n\n ${cnt})title : " + link.text + "\nlink : " + link.attr("href"))
      println(s"\n \t ${cnt}) title : " + link.text)
      println("\t     link : " + link.attr("href"))
    }

    pw.close()

    val fileBodyPage = new PrintWriter(new File("body of page.txt"))
    fileBodyPage.write("\n $body")
    println(s"\n________Body of page is :\n $body")
    println(s"\n--total Links are : $cnt")
  } catch {
    case _: Throwable =>
      println(
        "\n Something went wrong, may be web site has disabled robot.txt!")
  }
}
