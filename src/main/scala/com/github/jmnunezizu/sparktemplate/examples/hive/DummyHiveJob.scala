package com.github.jmnunezizu.sparktemplate.examples.hive

import com.github.jmnunezizu.sparktemplate.{SqlSparkContext, HiveSparkContext, BaseSparkJobFactory}

object DummyHiveJob extends BaseSparkJobFactory[DummyHiveJobConfig] with SqlSparkContext with HiveSparkContext {

  def main(args: Array[String]): Unit = {
    import hiveContext.sql

    sql("select \"Hello from Spark Template!\"").collect().foreach(println)

    sparkEnvironment.sc.stop()
  }

  def getConfigPath(): String = "sparkTemplate"

}
