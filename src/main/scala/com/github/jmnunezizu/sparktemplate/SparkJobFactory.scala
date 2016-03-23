package com.github.jmnunezizu.sparktemplate

import com.github.jmnunezizu.sparktemplate.config.SparkJobConfig
import com.typesafe.config.{ConfigFactory, Config}
import net.ceedubs.ficus.Ficus._
import net.ceedubs.ficus.readers.ValueReader

trait SparkJobFactory {
  val mainConfig: Config
  val sparkJobConfig: SparkJobConfig
  val sparkEnvironment: SparkJobEnvironment
}

abstract class BaseSparkJobFactory[T <: SparkJobConfig : ValueReader] extends SparkJobFactory {
  lazy val mainConfig: Config = ConfigFactory.load()
  lazy val sparkJobConfig: T = mainConfig.as[T](getConfigPath())

  val sparkEnvironment = new SparkJobEnvironment(sparkJobConfig.sparkConfig)
  val sc = sparkEnvironment.sc

  def getConfigPath(): String
}
