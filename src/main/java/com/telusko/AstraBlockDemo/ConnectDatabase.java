package com.telusko.AstraBlockDemo;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ConnectDatabase {

    CqlSession session = null;

    public void connect()
    {
        session = CqlSession.builder()
                .withCloudSecureConnectBundle(Paths.get("<path>/secure-connect-ethereum.zip"))
                .withAuthCredentials("ID","secret")
                .build();
    }

    public List<String> getValue() {

        if(session==null)
            connect();

        ResultSet rs = session.execute("select name from ethereum.tokens");

        List<String> names = new ArrayList<>();
        for (Row r : rs) {
            names.add(r.getString("name"));
        }

            return names;
    }
}