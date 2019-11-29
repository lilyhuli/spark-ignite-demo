package cn.lilyhuli

import cn.lilyhuli.base.{Config, SparkIgniteBase}

/**
 * @title: Job
 * @projectName spark-ignite-demo
 * @description: TODO
 * @author tangd-a
 * @date 2019/11/29 10:56
 */
object Job extends SparkIgniteBase {

  def main(args: Array[String]): Unit = {
    //create spark-context and ignite-rdd with cache name
    val sc = getSparkContext(Config.IGNITE_JOB_NAME)
    val shardRdd = getSharedRdd(Config.IGNITE_CACHE_NAME, sc)

    //load sample data into rdd to be saved into ignite memory
    val file = sc.textFile(Config.TEXT_FILE_PATH)
    //ref https://stackoverflow.com/questions/34670957/on-sparks-rdd-map-swap
    val indexRdd = file.zipWithIndex().map(_.swap)

    //save key-value pairs
    shardRdd.savePairs(indexRdd)

  }

}
