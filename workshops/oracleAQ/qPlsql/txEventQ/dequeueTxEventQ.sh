cd $ORACLEAQ_PLSQL_TxEventQ
sqlplus /@${DB_ALIAS} @dequeueTxEventQ.sql
