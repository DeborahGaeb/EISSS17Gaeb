[![Dependency Status](https://david-dm.org/dnode/dredis.svg)](https://david-dm.org/dnode/dredis)
[![devDependency Status](https://david-dm.org/dnode/dredis/dev-status.svg)](https://david-dm.org/dnode/dredis#info=devDependencies)

# Example
```javascript
const client = require('dredis')('url');

await client.setJSON('key', 'value');
const value = await client.getJSON('key');
```
