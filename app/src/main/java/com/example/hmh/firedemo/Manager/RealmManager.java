package com.example.hmh.firedemo.Manager;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by hmh on 2017/4/12.
 * realm数据库的封装
 */

public class RealmManager {

    //数据库名字
    private static final String DB_NAME = "myRealm.realm";
    private final Realm mRealm;

    public RealmManager() {
        mRealm = Realm.getInstance(new RealmConfiguration.Builder()
        .deleteRealmIfMigrationNeeded()
        .name(DB_NAME)
        .build());
    }

}
