Flink SQL> show tables;
buy_cnt_per_hour
cumulative_uv
user_behavior
uv_per_10min

到这里是正常的。执行insert语句就开始报错,elasticsearch里面也没有创建索引，推测原因是flink没有连接到elasticsearch.
如何解决呢？

INSERT INTO buy_cnt_per_hour
SELECT HOUR(TUMBLE_START(ts, INTERVAL '1' HOUR)), COUNT(*)
FROM user_behavior
WHERE behavior = 'buy'
GROUP BY TUMBLE(ts, INTERVAL '1' HOUR);


Flink SQL> select * from buy_cnt_per_hour;
[ERROR] Could not execute SQL statement. Reason:
org.apache.flink.table.api.NoMatchingTableFactoryException: Could not find a suitable table factory for 'org.apache.flink.table.factories.TableSourceFactory' in
the classpath.

Reason: Required context properties mismatch.

The matching candidates:
org.apache.flink.table.sources.CsvAppendTableSourceFactory
Mismatched properties:
'connector.type' expects 'filesystem', but is 'elasticsearch'
'format.type' expects 'csv', but is 'json'

The following properties are requested:
connector.bulk-flush.max-actions=1
connector.document-type=user_behavior
connector.hosts=http://localhost:9200
connector.index=buy_cnt_per_hour
connector.type=elasticsearch
connector.version=7
format.type=json
schema.0.data-type=BIGINT
schema.0.name=hour_of_day
schema.1.data-type=BIGINT
schema.1.name=buy_cnt
update-mode=append

The following factories have been considered:
org.apache.flink.api.java.io.jdbc.JDBCTableSourceSinkFactory
org.apache.flink.streaming.connectors.kafka.KafkaTableSourceSinkFactory
org.apache.flink.table.sources.CsvBatchTableSourceFactory
org.apache.flink.table.sources.CsvAppendTableSourceFactory