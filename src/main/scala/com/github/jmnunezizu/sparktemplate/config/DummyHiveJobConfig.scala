package com.github.jmnunezizu.sparktemplate.config

import net.ceedubs.ficus.Ficus._
import net.ceedubs.ficus.readers.ValueReader

case class DummyHiveJobConfig(sparkConfig: SparkConfig)

object DummyHiveJobConfig {
  implicit val reader: ValueReader[DummyHiveJobConfig] = ValueReader.relative { config =>
    DummyHiveJobConfig(
      config.as[SparkConfig]("spark")
    )
  }
}