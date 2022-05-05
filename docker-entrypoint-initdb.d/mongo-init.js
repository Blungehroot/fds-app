db.auth('root', 'root')

db = db.getSiblingDB('tc_monitoring');
db.createUser(
    {
        user: 'api_user',
        pwd: 'api1234',
        roles: [{ role: 'readWrite', db: 'tc_monitoring' }],
    },
);
db.createCollection('trade_company');