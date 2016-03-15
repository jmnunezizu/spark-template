package com.github.jmnunezizu.sparktemplate.examples.hive

import com.github.jmnunezizu.sparktemplate.config.{SparkConfig, SparkJobConfig}
import net.ceedubs.ficus.Ficus._
import net.ceedubs.ficus.readers.ValueReader

case class DummyHiveJobConfig(sparkConfig: SparkConfig, test: String) extends SparkJobConfig

object DummyHiveJobConfig {
  implicit val reader: ValueReader[DummyHiveJobConfig] = ValueReader.relative { config =>
    DummyHiveJobConfig(
      config.as[SparkConfig]("spark"),
      "tst"
    )
  }
}