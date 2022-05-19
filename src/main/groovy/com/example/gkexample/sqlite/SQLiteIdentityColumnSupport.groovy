package com.example.gkexample.sqlite

import org.hibernate.MappingException
import org.hibernate.dialect.identity.IdentityColumnSupportImpl

class SQLiteIdentityColumnSupport extends IdentityColumnSupportImpl {
    @Override
    boolean supportsIdentityColumns() {
        return true
    }

    @Override
    String getIdentitySelectString(String table, String column, int type) throws MappingException {
        return "select last_insert_rowid()";
    }

    @Override
    String getIdentityColumnString(int type) throws MappingException {
        return "integer";
    }
}
