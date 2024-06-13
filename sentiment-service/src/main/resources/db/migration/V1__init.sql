create table sentiment_data (
    id varchar(36) primary key unique,
    review longtext,
    sentiment varchar(20),
    language varchar(20)
)