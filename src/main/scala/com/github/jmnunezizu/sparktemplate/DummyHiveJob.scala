package com.github.jmnunezizu.sparktemplate

import com.github.jmnunezizu.sparktemplate.config.DummyHiveJobConfig
import com.typesafe.config.ConfigFactory
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql._
import org.apache.spark.sql.hive.HiveContext
import net.ceedubs.ficus.Ficus._


object DummyHiveJob {

  def main(args: Array[String]): Unit = {
    val appConfig = ConfigFactory.load().as[DummyHiveJobConfig]("sparkTemplate")
    val sparkConf = new SparkConf()
        .setAppName(appConfig.sparkConfig.appName)
        .setMaster(appConfig.sparkConfig.master)
        .setAll(appConfig.sparkConfig.properties.values)
    val sc = new SparkContext(sparkConf)
    val hiveContext = new HiveContext(sc)

    import hiveContext.implicits._
    import hiveContext.sql

    sql("select \"Hello from Spark Template!\"").collect().foreach(println)

    sc.stop()

  }

}
