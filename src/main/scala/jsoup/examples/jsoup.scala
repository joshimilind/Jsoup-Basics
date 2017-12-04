package jsoup.examples

import org.jsoup.Jsoup
import java.io._

import org.jsoup.select.Elements

import scala.collection.JavaConverters._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._

object jsoup extends App {


  var links : String = ""

  def crawl(url:String, depth:Integer): Unit = {
var currentDepth = depth
    if(currentDepth > 0 ) {
      val doc = Jsoup
        .connect(url)
        .get()

      var elements: Elements = doc.select("a[href]")
      var cnt = 0

      for (element <- elements) {
        currentDepth -= 1
        cnt += 1


        links += element.attr("href")
        println("\t \nlink : " + element.attr("href"))

        //      links += element.attr("href")

      }

      crawl(links, currentDepth)


    println(s"\n________Body of page is :\n ")

    println(s"\n\n\n\n----------final $links")
    println(s"\n--total Links are : $cnt")
  }else
    {
      println("*******************else part")}

  }
  crawl("https://www.bbc.co.uk/",2)
}
