package jsoup.examples

import org.jsoup.Jsoup
import java.io._

import scala.collection.JavaConversions._
object jsoup extends App {

  val doc = Jsoup
    .connect("https://developer.lightbend.com/guides/akka-quickstart-scala/#what-hello-world-does")
    .get()
  val title = doc.title()
  val links = doc.select("a[href]")
  var cnt = 0
  val pw = new PrintWriter(new File(("Crawled Links.txt")))

  for (link <- links) {
    pw.write("\n\ntitle : " + link.text + "\nlink : " + link.attr("href"))
    println("\ntitle : " + link.text)
    println("link : " + link.attr("href"))
    cnt += 1
  }
  pw.close()
  println(s"\n--total Links are : $cnt")
}

