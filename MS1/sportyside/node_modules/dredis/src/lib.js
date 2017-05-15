'use strict';

const redis = require('redis');

module.exports = (url) => {
  const client = redis.createClient(url);

  client.setJSON = (key, value, callback) => {
    value = JSON.stringify(value);
    if (callback) {
      client.set(key, value, callback);
    } else {
      return new Promise((resolve, reject) => {
        client.set(key, value, (err) => {
          if (err) {
            reject(err);
          } else {
            resolve();
          }
        });
      });
    }
  };

  client.getJSON = (key, callback) => {
    if (callback) {
      client.get(key, (err, value) => {
        if (value) {
          try {
            value = JSON.parse(value);
          } catch (e) {
            err = e;
            value = undefined;
          }
        }
        callback(err, value);
      });
    } else {
      return new Promise((resolve, reject) => {
        client.get(key, (err, value) => {
          if (value) {
            try {
              value = JSON.parse(value);
            } catch (e) {
              err = e;
              value = undefined;
            }
          }
          if (err) {
            reject(err);
          } else {
            resolve(value);
          }
        });
      });
    }
  };

  return client;
};
