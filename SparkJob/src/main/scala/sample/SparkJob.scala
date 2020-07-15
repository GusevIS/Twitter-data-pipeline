package sample

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.execution.streaming.FileStreamSource.Timestamp
import org.apache.spark.sql.functions.{from_json, to_json, window}
import org.apache.spark.sql.streaming.{ProcessingTime, Trigger}
import org.apache.spark.sql.types._

object SparkJob {
  def main(args: Array[String]): Unit = {
    case class RsvpData (key: String, value: String)
    val spark = SparkSession
      .builder()
      .appName("TestApp")
      .getOrCreate()
    import spark.implicits._
    val jsonSchema = new StructType()
      .add("venue",
        new StructType()
          .add("venue_name", StringType)
          .add("lon", DoubleType)
          .add("lat", DoubleType)
          .add("venue_id", LongType))
      .add("visibility", StringType)
      .add("response", StringType)
      .add("guests", LongType)
      .add("member",
        new StructType()
          .add("member_id", LongType)
          .add("photo", StringType)
          .add("member_name", StringType))
      .add("rsvp_id", LongType)
      .add("mtime", LongType)
      .add("event",
        new StructType()
          .add("event_name", StringType)
          .add("event_id", StringType)
          .add("time", LongType)
          .add("event_url", StringType))
      .add("group",
        new StructType()
          .add("group_city", StringType)
          .add("group_country", StringType)
          .add("group_id", LongType)
          .add("group_lat", DoubleType)
          .add("group_long", DoubleType)
          .add("group_name", StringType)
          .add("group_state", StringType)
          .add("group_topics", DataTypes.createArrayType(
            new StructType()
              .add("topicName", StringType)
              .add("urlkey", StringType)))
          .add("group_urlname", StringType))
    val streamingInputDF = spark.readStream.format("kafka")
      .option("kafka.bootstrap.servers", "kafkaserver:9092")
      .option("subscribe", "data_test")
      //.option("startingOffsets", "earliest")
      .load()
    val personStringDF = streamingInputDF.selectExpr("CAST(value AS STRING)")
    personStringDF.printSchema()
    val streamingSelectDF = personStringDF
      .select(from_json($"value", jsonSchema).as("data")).select("data.*")
    streamingSelectDF.printSchema()
    streamingSelectDF.writeStream
      .format("console")
      .outputMode("append")
      .start()
      .awaitTermination()
  }
}