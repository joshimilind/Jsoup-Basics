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

  val body = doc.body().text()
  var cnt = 1
  val pw = new PrintWriter(new File(("Crawled Links.txt")))
//  println("\nbody : " + body)
  for (link <- links) {
    pw.write(s"\n\n ${cnt})title : " + link.text + "\nlink : " + link.attr("href"))
    println(s"\n \t ${cnt}) title : " + link.text)
    println("\t     link : " + link.attr("href"))
//    println("\nbody : " + body)
    cnt += 1
  }

  pw.close()

  val fileBodyPage = new PrintWriter(new File("body of page.txt"))
  fileBodyPage.write("\n $body")
  println("\n\n________")
  println(s"\nBody of page is :\n $body")
  println(s"\n--total Links are : $cnt")
}

