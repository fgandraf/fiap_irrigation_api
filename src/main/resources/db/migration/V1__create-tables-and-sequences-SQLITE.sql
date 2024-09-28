--===============| USER |===============--

CREATE TABLE TBL_USER (
    USER_ID INTEGER PRIMARY KEY AUTOINCREMENT,
    ACTIVE INTEGER DEFAULT 0,
    EMAIL TEXT NOT NULL,
    NAME TEXT NOT NULL,
    PASSWORD TEXT NOT NULL,
    ROLE TEXT NOT NULL,
    FOREIGN KEY (USER_ID) REFERENCES TBL_USER(USER_ID)
);

INSERT INTO
    TBL_USER
        (USER_ID, ACTIVE, EMAIL, NAME, PASSWORD, ROLE)
    VALUES
        (1, 1, 'admin@admin.com', 'System Administrator', '$2a$10$dxlL.53a1jUX4Zee3E1scuXYLG8Zg.4qydFVlcIzSDsitcd900OKC', 'ADMIN');
        -- Password '1234abcd' after encrypt


--===============| AREA |===============--

CREATE TABLE TBL_AREA (
    AREA_ID INTEGER PRIMARY KEY AUTOINCREMENT,
    DESCRIPTION TEXT NOT NULL,
    LOCATION TEXT NOT NULL,
    AREA_SIZE TEXT NOT NULL
);

--===============| NOTIFICATION |===============--

CREATE TABLE TBL_NOTIFICATION (
    NOTIFICATION_ID INTEGER PRIMARY KEY AUTOINCREMENT,
    DESCRIPTION TEXT NOT NULL,
    TIMESTAMP DATETIME,
    SENSOR_ID INTEGER,
    FOREIGN KEY (SENSOR_ID) REFERENCES TBL_SENSOR(SENSOR_ID)
);


--===============| SENSOR |===============--

CREATE TABLE TBL_SENSOR (
    SENSOR_ID INTEGER PRIMARY KEY AUTOINCREMENT,
    LOCATION TEXT NOT NULL,
    TYPE TEXT NOT NULL,
    AREA_ID INTEGER,
    FOREIGN KEY (AREA_ID) REFERENCES TBL_AREA(AREA_ID)
);

--===============| WEATHER |===============--

CREATE TABLE TBL_WEATHER (
    WEATHER_ID INTEGER PRIMARY KEY AUTOINCREMENT,
    DESCRIPTION TEXT NOT NULL,
    HUMIDITY INTEGER,
    TEMPERATURE INTEGER,
    TIMESTAMP DATETIME,
    SENSOR_ID INTEGER,
    FOREIGN KEY (SENSOR_ID) REFERENCES TBL_SENSOR(SENSOR_ID)
);

--===============| SCHEDULE |===============--

CREATE TABLE TBL_SCHEDULE (
    SCHEDULE_ID INTEGER PRIMARY KEY AUTOINCREMENT,
    START_TIME DATETIME,
    END_TIME DATETIME
);