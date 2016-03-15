package com.github.jmnunezizu.sparktemplate.examples.hive

import com.github.jmnunezizu.sparktemplate.HiveSparkJobFactory

object DummyHiveJob extends HiveSparkJobFactory[DummyHiveJobConfig] {

  def main(args: Array[String]): Unit = {
    import hiveContext.sql

    sql("select \"Hello from Spark Template!\"").collect().foreach(println)

    sparkEnvironment.sc.stop()
  }

  def getConfigPath(): String = "sparkTemplate"

}
