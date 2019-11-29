package cn.lilyhuli.spark1

import cn.lilyhuli.base.{Config, SparkIgniteBase}

/**
 * @title: Job
 * @projectName spark-ignite-demo
 * @description: TODO
 * @author tangd-a
 * @date 2019/11/29 16:16
 */
object Job extends SparkIgniteBase{
  def main(args: Array[String]): Unit = {
    //create spark-context and ignite-rdd with cache name
    val sc = getSparkContext(Config.SPARK_JOB1_NAME)
    val sharedRdd = getSharedRdd(Config.IGNITE_CACHE_NAME, sc)

    //filter only odd index from the file
    val oddLines = sharedRdd.filter(_._1 % 2 != 0)

    //print the filtered result
    oddLines.foreach(x => println(x._2))

  }
}
