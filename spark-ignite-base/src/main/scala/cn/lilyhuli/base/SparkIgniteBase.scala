package cn.lilyhuli.base

import org.apache.ignite.configuration.IgniteConfiguration
import org.apache.ignite.spark.{IgniteContext, IgniteRDD}
import org.apache.spark.SparkContext
import org.apache.spark.sql.SparkSession

/**
 * @title: SparkIgniteBase
 * @projectName spark-ignite-demo
 * @description: TODO 抽象
 * @author tangd-a
 * @date 2019/11/29 14:36
 */
trait SparkIgniteBase {
  //create a spark context based on the app name for spark jobs
  def getSparkContext(appName: String): SparkContext = {
    val spark  =SparkSession
      .builder
      .config("spark.serializer",Config.SPARK_KRYO_SERIALIZER)
      .appName(appName)
      .master(Config.SPARK_MASTER_URL)
      .getOrCreate()
    spark.sparkContext
  }

  //create a ignite rdd of type [Long,String] for storing key-value in ignite cache

  def getSharedRdd(cacheName:String,sc:SparkContext):IgniteRDD[Long,String] = {
    val ic = new IgniteContext(sc,()=> new IgniteConfiguration())
    ic.fromCache[Long,String](cacheName)
  }



}
