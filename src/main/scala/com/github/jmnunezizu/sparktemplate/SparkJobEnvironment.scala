package com.github.jmnunezizu.sparktemplate

import com.github.jmnunezizu.sparktemplate.config.SparkConfig
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkContext, SparkConf}
import org.apache.spark.sql.SQLContext

trait SparkContextHolder {
  def sc: SparkContext
}

trait SqlSparkContext extends SparkContextHolder {
  val sqlContext = new SQLContext(sc)
}

trait HiveSparkContext extends SparkContextHolder {
  val hiveContext = new HiveContext(sc)
}

class SparkJobEnvironment(config: SparkConfig) extends SparkContextHolder {
  val sparkConf: SparkConf = new SparkConf()
    .setAppName(config.appName)
    .setMaster(config.master)
    .setAll(config.properties.values)

  val sc = new SparkContext(sparkConf)
}