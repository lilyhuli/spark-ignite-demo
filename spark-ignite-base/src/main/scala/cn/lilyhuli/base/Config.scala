package cn.lilyhuli.base

/**
 * @title: Config
 * @projectName spark-ignite-demo
 * @description: TODO
 * @author tangd-a
 * @date 2019/11/2914:32
 */
object Config {

  val IGNITE_JOB_NAME = "Ignite-Job"
  val IGNITE_CACHE_NAME = "shared-rdd"
  val TEXT_FILE_PATH = "ignite-job/src/main/resources/data"
  val SPARK_JOB1_NAME = "Spark-Job1"
  val SPARK_JOB2_NAME = "Spark-Job2"
  val SPARK_MASTER_URL = "local[*]"
  val SPARK_KRYO_SERIALIZER = "org.apache.spark.serializer.KryoSerializer"


}
