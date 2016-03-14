package com.github.jmnunezizu.sparktemplate.config

import net.ceedubs.ficus.Ficus._
import net.ceedubs.ficus.readers.ValueReader
import scala.concurrent.duration.FiniteDuration

case class SparkConfig(
  appName: String,
  master: String,
  home: String,
  terminationTimeout: Option[Long],
  batchDuration: Option[FiniteDuration],
  properties: SparkProperties
)

object SparkConfig {
  implicit val reader: ValueReader[SparkConfig] = ValueReader.relative { config =>
    SparkConfig(
      config.as[String]("appName"),
      config.as[String]("master"),
      config.as[String]("home"),
      config.as[Option[Long]]("terminationDuration"),
      config.as[Option[FiniteDuration]]("terminationTimeout"),
      SparkProperties(config.as[Map[String, String]]("properties"))
    )
  }
}